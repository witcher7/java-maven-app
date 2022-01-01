#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven 'maven-3.8.4'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t nanajanashia/demo-app:jma-2.0 .'
                        sh 'echo $PASS | docker login -u $USER --password-stdin'
                        sh 'docker push nanajanashia/demo-app:jma-2.0  '
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
