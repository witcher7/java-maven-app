#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 4040:8080 -d judedba/java-maven-app:jma-2.3'
                    sshagent(['ec2-user-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@52.14.96.230 ${dockerCmd}"   
                   }
                }
            }
        }
    }
}
