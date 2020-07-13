pipeline {
    agent any
    tools { 
        maven 'MAVEN_HOME-3.6.3' 
    }
     // global env variables
    environment {
        EMAIL_RECIPIENTS = 'sonali.kanse021@gmail.com'
        DOCKER_PUSH = 'docker-registry.cdacmumbai.in:5000/discoveryserver.jar'
        DOCKER_PUSH1 = 'docker-registry.cdacmumbai.in:5000/hrd_emp_be.jar'
        DOCKER_PUSH2 = 'docker-registry.cdacmumbai.in:5000/hrd_emp_fe.jar'
    }
    stages {
        stage ('Initialization') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                
                ''' 
                //zAP Setup and Initialization
                script {
                    startZap(host: "localhost", port: 8090, timeout:500, zapHome: "/home/ecgc-cicd/Downloads/ZAP_2.7.0/",allowedHosts:['github.com']) // Start ZAP at /opt/zaproxy/zap.sh, allowing scans on github.com
                }
            }
        }

        stage ('Checkouts') {
            steps {
                //QA Test
                git 'https://github.com/NupurParalkar/ECGCQADemo'
                 //MS Code
                 git 'https://github.com/Sonali-K/ECGC-CI_CD'
            }
        }
        stage("Build"){
            steps{
                sh "mvn -f discoveryserver/pom.xml compile" 
                sh "mvn -f hrd_emp_be/pom.xml compile"
                sh "mvn -f hrd_emp_fe/pom.xml compile"
               
            }
        }
        
          stage('Code Analysis') {
      steps {
        script {
          // requires SonarQube Scanner 2.8+
          scannerHome = tool 'SonarQubeScanner'
        }
        withSonarQubeEnv('sonarqube') {
          sh 'mvn -f discoveryserver/pom.xml clean package sonar:sonar'
        }
      }
    }

  stage('Unit Testing') {
            steps{
              script {
                   sh "mvn -f hrd_emp_be/pom.xml clean test"
                     echo 'TestNG Report'
                      
                        }
                         step([$class : 'Publisher', reportFilenamePattern : 'hrd_emp_be/test-output/testng-results.xml'])   
                          }
                   }

      
       stage('Containerazation') {
            steps {
                echo "-=- packaging project -=-"
                sh "mvn -f discoveryserver/pom.xml package"
                sh "mvn -f hrd_emp_be/pom.xml package"
                sh "mvn -f hrd_emp_fe/pom.xml package"
                sh "docker-compose build"

            }
        }
 
     stage('Functional Testing') {
            steps{
                git 'https://github.com/NupurParalkar/ECGCQADemo'

              script {
                   sh "mvn clean test"
                     echo 'TestNG Report'
                      
                        }
                         step([$class : 'Publisher', reportFilenamePattern : '**/testng-results.xml'])   
                          }
                   }
     stage('Performance Testing') {
            steps{

              script {
sh "cd /home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/ sh jmeter.sh -Jjmeter.save.saveservice.output_format=xml -n -t /home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/HRDemo.jmx -l /home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/report.jtl"
                     echo 'TestNG Report'
                    // perfReport '/home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/report.jtl'
                      
                        }
                     }
                   }
       
        stage('Security Testing') {
            steps {
                script {
                    //sh "mvn verify -Dhttp.proxyHost=http://10.212.0.72:8082/ -Dhttp.proxyPort=8082 -Dhttps.proxyHost=http://10.212.0.72:8082/ -Dhttps.proxyPort=8082" // Proxy tests through ZAP
                    runZapCrawler(host: "http://10.212.0.72:8082/")
                }
                
            }
        }
        
        stage('Upload Images '){
             steps{
          withCredentials([string(credentialsId: 'DockerRegistryID', variable: 'DockerRegistryID')]) {
    // some block
                 // sh "docker login -u cdac -p ${DockerRegistryID}"
           }

            sh  "docker push $DOCKER_PUSH"
             sh  " docker push $DOCKER_PUSH1"
             sh  "docker push $DOCKER_PUSH2"
         }           
     }


    }
    
    
    post {
        // Always runs. And it runs before any of the other post conditions.
        always {
        
            script{
                                 perfReport '/home/ecgc-cicd/Downloads/Jemeter/apache-jmeter-5.3/bin/report.jtl'

            }
            script {
                archiveZap(failAllAlerts: 0, failHighAlerts: 0, failMediumAlerts: 0, failLowAlerts: 0)
            }

            
            // Let's wipe out the workspace before we finish!
             deleteDir()
        }
        success {
            sendEmail("Successful");
        }
        unstable {
            sendEmail("Unstable");
        }
        failure {
            sendEmail("Failed");
        }
    }

}

def developmentArtifactVersion = ''
def releasedVersion = ''
// get change log to be send over the mail
@NonCPS
def getChangeString() {
    MAX_MSG_LEN = 100
    def changeString = ""

    echo "Gathering SCM changes"
    def changeLogSets = currentBuild.changeSets
    for (int i = 0; i < changeLogSets.size(); i++) {
        def entries = changeLogSets[i].items
        for (int j = 0; j < entries.length; j++) {
            def entry = entries[j]
            truncated_msg = entry.msg.take(MAX_MSG_LEN)
            changeString += " - ${truncated_msg} [${entry.author}]\n"
        }
    }

    if (!changeString) {
        changeString = " - No new changes"
    }
    return changeString
}

def sendEmail(status) {
    mail(
            to: "$EMAIL_RECIPIENTS",
            subject: "Build $BUILD_NUMBER - " + status + " (${currentBuild.fullDisplayName})",
            body: "Changes:\n " + getChangeString() + "\n\n Check console output at: $BUILD_URL/console" + "\n")
}


