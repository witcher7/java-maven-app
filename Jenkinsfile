#!/usr/bin/env groovy
@Library('jenkins-shared-library')

def groovy

pipeline {
    agent any

    tools {
      maven 'Maven'
    }

    stages {
        
        stage('Increment App Version') {
            steps {
                script {
                    echo "Incrementing Application Version....."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'       //here we get the version of app from pom.xml 
                    def version = matcher[0][1]
                    env.IMAGE_NAME= "$version-$BUILD_NUMBER"                           //here we add build_number to image anme
                }
            }
        }
        stage ('Init Groovy') {
            steps {
                script {
                    groovy = load "script.groovy"
                }
            }
        }
        stage('Build Jar') {
            steps {
                script {
                   build_jar()
            }
          }
        }

        stage('Build Image') {
            steps {
               script {
                   build_image( "139646/java-maven-app:$IMAGE_NAME")     //Using IMAGE_NAME to use the version of the app + build_number 
               }
            }
        }
    }
}
