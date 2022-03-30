def gv
pipeline {
    agent any
    tools {
        maven: 'Maven'
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
                     sh 'mvn package'
                }
            }
        }

        stage('build docker image') {
            steps {
                script{
                     gv.buildDocker()
                     withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]){
                         sh 'docker build -t amine0648280049/demo_app:2.0 .'
                         sh "echo $PASS | docker login -u $USER --password-stdin"
                         sh 'docker push amine0648280049/demo_app:2.0'
                     }
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