#!/usr/bin/env groovy

pipeline {
    agent any
 //   parameters {
        choice(name: 'VERSION', defaultValue:'', description: 'version to deply on prod')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            when {
                experssion {
                    params.executeTests
                }
            }
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
                echo "deploying version ${params.VERSION}"
            }
        }
    }
}
