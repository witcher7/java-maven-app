#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools { 
        maven 'maven 3.8.4'
    }
 
    stages {
        stage("init") {
            steps {
                script {
                   gv = load "script.groovy"
                }
            }
        }
         stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME=='master'
                }
            }
            steps {
                script {
                    gv.buildJar()
                    gv.buildImage()
                }
            }
        }
       
        stage("deploy") {
              when {
                expression {
                    BRANCH_NAME=='master'
                }
            }
            steps {
                script {
                    env.ENV = input message: "Select the environment to deploy to", ok: "Done", parameters: [choice(name: 'ONE', choices: ['dev', 'staging', 'prod'], description: '')]

                    gv.deployApp()
                    echo "Deploying to ${ENV} with DOUKOU / KHALIL la la doukou  ou "
                }
            }
        }
    }
}
