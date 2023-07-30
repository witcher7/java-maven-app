pipeline {
    agent any
    tools {
            maven 'maven-3.9'
    }
    stages {
        stage("Build jar")   {
                steps { 
                        script {
                           echo "building the application"
                           sh 'mvn package'
                        }
                }
        }
        stage("Build image")   {
                steps { 
                        script {
                           echo "building the docker image"
                           withCredentials([usernamePassword(credentialsId:'dockerhub-repo', passwordVariable: 'PASS', usernameVaraible: 'USER')]) {
                           sh 'docker build -t sandeep9vangala/sample-jave-maven:jma-2.0 .'
                           sh "echo $PASS | docker login -u $USER --password-stdin"
                           sh 'docker push sandeep9vangala/sample-jave-maven:jma-2.0'
                           } 
                        }
                }
        }
        stage("deploy") { 
             steps {
                    script { 
                          echo "deploying the application"
                    }
            }
        }
    }
}
