#!/usr/bin/env groovy

def gv
pipeline {
    agent any
    tools {
        maven "Maven-Runner"
    }


    stages {

        stage("Initial Steps") {
            steps {
                script {
                    gv = load 'script.groovy'
                }
            }
        }

        stage('Building Jar File') {
          steps {
              script {
                gv.buildJar()
              }
          }
        }
        
        stage('Building the Artifacts') {
           steps {
                script {
                    gv.buildDockerImage()
                }
           }
        }
        
        stage('Example Build') {
           steps {
               echo "Deploying to the EC2"
               script {
                   gv.pushDockerImage()
               }
           }
        }
    }
}