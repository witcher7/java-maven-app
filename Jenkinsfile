#!/usr/bin/env groovy
def gv

pipeline {
    agent none
    parameters {
        choice(name:'VERSION',choices ['1.1.0','1.1.2','1.3.0'],description :'')
        booleanParam(name:'execute tests', defaultValue: true , description:'')
    }
    stages {
        stage('init'){
            steps{
                script{
                    gv = load "script.groovy"
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
                    echo "Deploying the application..."
                }
            }
        }
    }
}
