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
                    buildImage(env.IMAGE_NAME)
                    pushImage(env.IMAGE_NAME)
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying docker image to EC2 ..."

                    def shellCmd = "bash ./server-cms.sh ${IMAGE_NAME}"

                    sshagent(['ec2-server-key']) { 
                        sh "scp server-cms.sh ec2-user@13.239.5.252:/home/ec2-user"
                        sh "scp docker-compose.yaml ec2-user@13.239.5.252:/home/ec2-user" 
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.239.5.252 ${shellCmd}"
                    }
                }
            }
        }
    }   
}
