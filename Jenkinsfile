#!/usr/bin/env groovy

pipeline {
    agent any
    tools {
        maven "maven-3.9.5"
    }
    
    stages {
        stage("increment app version") {
            steps {
                script {
                    echo "incrementing the application version..."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.newIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"

                }
            }
        }
        stage("build app") {
            steps {
                script {
                    echo "building the application......"
                    sh 'mvn clean package'
                }
            }
        }
        stage("build docker image") {
            steps {
                script {
                    echo "build and push docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')]){
                        sh "docker build -t ldchnsd/demo-app:${IMAGE_NAME} ."
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh "docker push ldchnsd/demo-app:${IMAGE_NAME}"
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying docker image to EC2......"
                    echo "deploying docker image to EC2......"
                }

            }
        }
    }   
}
