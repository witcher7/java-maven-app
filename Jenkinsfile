def gv
pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage('build jar') {
            steps {
                script{
                     gv.buildApp()
                }
            }
        }

        stage('build docker image') {
            steps {
                script{
                     gv.buildDocker()
                }
            }
        }
        
        stage('test') {
            steps {
                script{
                    gv.testApp()
                }
            }
        }
        
        stage('deploy') {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    }
}