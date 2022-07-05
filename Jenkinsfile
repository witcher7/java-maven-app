#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
        maven  'maven'
    }
    stages {
        stage("increment version")
                {
                    steps {
                        script {
                            echo "incrementing app version ..."
                           
                        }
                    }
                }

        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    echo "building the docker image .."
                    withCredentials([usernamePassword(credentialsId: 'Docker_hub', usernameVariable: 'user', passwordVariable: 'pass')])
                            {
                                sh "docker build -t ahmedabed/demo-app:1.1.1 ."
                                sh "echo $pass | docker login -u $user --password-stdin"
                                sh "docker push ahmedabed/demo-app:1.1.1"
                            }
                }
            }
        }
    }

}

