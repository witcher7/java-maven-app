#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
        maven  'maven'
        docker 'docker'
    }
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    echo "building the application"
                      sh 'mvn package'

                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image .."
    withCredentials([usernamePassword(credentialsId: 'Docker_hub', usernameVariable: 'user',        passwordVariable: 'pass')]) 
            {   sh 'docker build -t ahmedabed/demo-app:test .'
                sh "echo $pass | docker login -u $user --password-stdin"
                sh 'docker push ahmedabed/demo-app:test'
                }

                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
