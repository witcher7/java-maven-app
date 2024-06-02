#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage('build') {
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
        stage('test') {
            steps {
                script {
                    gv.testApp()
                }
            }
        }
        stage('deploy') {
            input{
                message "select env to deploy to"
                ok "done"
                parameters {
                    choice(name: 'Env1', choices: ['dev', 'staguing', 'produc'], description: '')
                    choice(name: 'Env2', choices: ['dev', 'staguing', 'produc'], description: '')
                }
            }
            steps {
                script {
                    gv.deployApp()
                    echo "deplyed to ${Env1}"
                    echo "deplyed to ${Env2}"
                }
            }
        }
    }
}
