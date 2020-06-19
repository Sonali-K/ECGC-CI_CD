pipeline {
    agent any

    stages {
        stage('Compile') {
            steps {
                sh "mvn -https://github.com/Sonali-K/ECGC-CI_CD/blob/master/discoveryserver/pom.xml compile"
      echo "Running Stage First"

            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }
}
