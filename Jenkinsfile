#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven "Maven"
    }
    
    stages {
        stage("build app") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "build and push docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')]){
                        sh 'docker build -t ldchnsd/demo-app:jma-2.0 .'
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh 'docker push ldchnsd/demo-app:jma-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying docker image to EC2..."
                }

            }
        }
    }   
}
