#!/usr/bin/env groovy

library identifier: 'jenkins-jobs@master', retriever: modernSCM(
        [$class: 'GitSCMSource',
         remote: 'https://gitlab.com/wenghong1227/java-maven-app.git',
         credentialsId: 'gitlab-credentials'
        ]
)

pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    environment {
        IMAGE_NAME = 'wh1227/demo-app:jma-3.0'
    }
    stages {
        stage('build app') {
            steps {
                script {
                    echo "Building the application..."
                    buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "Building docker image..."
                    buildImage(env.IMAGE_NAME)
                    dockerLogin()
                    dockerPush(env.IMAGE_NAME)
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo 'deploying docker image to EC2...'
                    // def dockerCmd = "docker run -p 8080:8080 -d $(IMAGE_NAME)"
                    sshagent(['ec2-server-key']) {
                        sh "scp docker-compose.yaml ec2-user@18.138.103.152:/home/ec2-user"
                        def dockerComposeCmd = "docker-compose -f docker-compose.yaml up"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@18.138.103.152 ${dockerCmd}"
                    }
                }
            }
        }
    }
}


/*pipeline {
    agent none
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3080:3080 wh1227/react-nodejs:1.0'
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyCheking=no ec2-user@18.138.103.152 ${dockerCmd}"
                    }
                }
            }
        }
    }
}
*/
