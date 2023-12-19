#!/usr/bin/env groovy

pipeline {
    agent any
    stages {
        stage('build app') {
            steps {
               script {
                   echo "building the application..."
               }
            }
        }
        stage('build image') {
            steps {
                script {
                    echo "building the docker image..."
                }
            }
        }
        stage('deploy') {
            environment{
                aws_access_key_id = credentails("aws_secret_key")
                aws_secret_access_key = credentails("aws_key_id")
    

            }

            steps {
                script {
                   echo 'deploying docker image...'
                   withKubeConfig([credentialsId: 'config_file', serverUrl: 'https://8C915E34307A8F98D294499F3A4721AC.gr7.us-east-1.eks.amazonaws.com'])
                    sh "kubectl create deployment nginx-deployment --image=nginx"

                   }
                }
            }
        }
    }
}
