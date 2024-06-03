#!/usr/bin/env groovy
def gv
pipeline {
    agent any
    tools {
        maven 'maven_nana_3.9.6'
    }
    stages {

        stage('BuildJar') {
            steps {
                script {
                    echo "building the Jar..."
                    sh 'mvn package'
                }
            }
        }
        
        stage('BuildIMAGE') {
            steps {
                script {
                    echo "building the docker Image..."
                    withCredentials([usernamPassword(credentialsId: 'docker_hub_repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'docker build -t bnnyo/bnnyorepo:aman7.4 .'
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh 'docker push bnnyo/bnnyorepo:aman7.4'
                    }
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