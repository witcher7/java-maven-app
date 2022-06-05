def groovy

pipeline {
    agent any

    tools {
      maven 'Maven'
    }

    stages {

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
                   groovy.Build_Jar()
            }
          }
        }

        stage('Build Image') {
            steps {
               script {
                   groovy.Build_Image()
               }
            }
        }
    }
}
