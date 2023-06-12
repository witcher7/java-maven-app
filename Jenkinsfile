#!/usr/bin/env groovy

library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://gitlab.com/learning4563322/jenkins-learning.git',
         credentialsId: 'jenkins-gitlab'
        ]
)


pipeline {
    agent any
    tools {
        maven "Maven"
    }
    environment {
        IMAGE_NAME = "ldchnsd/demo-app:java-maven-1.0"
    }

    stages {
        
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    buildImage($IMAGE_NAME)
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockerCmd = "docker run -d -p 8080:8080 $IMAGE_NAME"
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.239.5.252 ${dockerCmd}"
                    }
                }

            }
        }
    }   
}
