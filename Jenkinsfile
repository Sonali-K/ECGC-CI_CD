pipeline {
    agent any
    tools { 
        maven 'MAVEN_HOME-3.6.3' 
    }
     // global env variables
    environment {
        EMAIL_RECIPIENTS = 'sonali.kanse021@gmail.com'
    }
    stages {
        stage ('Initialize') {
            steps {
                sh '''
                    echo "PATH = ${PATH}"
                ''' 
            }
        }
        stage ('Git Checkout') {
            steps {
                 git 'https://github.com/Sonali-K/ECGC-CI_CD'
            }
        }
        stage("Maven Build"){
            steps{
                sh "mvn -f discoveryserver/pom.xml compile" 
                sh "mvn -f hrd_emp_be/pom.xml compile"
                sh "mvn -f hrd_emp_fe/pom.xml compile"
               
            }
        } 
       stage('SonarQube analysis') {
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
  stage('Unit Test TestNG Report') {
            steps{
              script {
                   sh "mvn -f hrd_emp_be/pom.xml clean test"
                     echo 'TestNG Report'  
                        }
                         step([$class : 'Publisher', reportFilenamePattern : 'hrd_emp_be/test-output/testng-results.xml'])   
                          }
                   }
       stage('Packaging And Build Docker Images') {
            steps {
                echo "-=- packaging project -=-"
                sh "mvn -f discoveryserver/pom.xml package"
                sh "mvn -f hrd_emp_be/pom.xml package"
                sh "mvn -f hrd_emp_fe/pom.xml package"
                sh "docker-compose build"
            }
        }
    stage('Push Docker Images'){
             steps{
          withCredentials([string(credentialsId: 'DockerRegistryID', variable: 'DockerRegistryID')]) {
    
                 // sh "docker login -u cdac -p ${DockerRegistryID}"
           }
            sh  "docker push docker-registry.cdacmumbai.in:5000/discoveryserver:0.0.1-SNAPSHOT.jar"
            sh  " docker push  docker-registry.cdacmumbai.in:5000/hrd_emp_be:0.0.1-SNAPSHOT.jar"
           sh  "docker push  docker-registry.cdacmumbai.in:5000/hrd_emp_fe:0.0.1-SNAPSHOT.jar"
         }           
     }
    stage ('Git Checkout1') {
            steps {
                 git 'https://github.com/NupurParalkar/ECGCQADemo'
            }
        }
     stage('QA Test Report') {
            steps{
              script {
                  // sh "mvn clean test"
                     echo 'TestNG Report'     
                        }
                         step([$class : 'Publisher', reportFilenamePattern : '**/testng-results.xml'])   
                          }
                   }
    stage('ZAP Setup and Initialization') {
            steps {
                script {
                    startZap(host: "localhost", port: 8090, timeout:500, zapHome: "/home/ecgc-cicd/Downloads/ZAP_2.7.0/",allowedHosts:['github.com']) // Start ZAP at /home/ecgc-cicd/Downloads/ZAP_2.7.0/zap.sh, allowing scans on github.com
                }
            }
        }
        stage('ZAP Scanning') {
            steps {
                script {
                     // Proxy tests through ZAP
                    runZapCrawler(host: "http://10.212.0.72:8082/")
                }
            }
        }
    }
    post {
        // Always runs. And it runs before any of the other post conditions.
        always {
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
            body: "Changes:\n " + getChangeString() + "\n\n Check console output at: $BUILD_URL console" + "\n")
}
