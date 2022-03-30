def gv
pipeline {
    agent: any
    tools{
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

        stage('build image') {
            steps {
                script{
                     gv.buildApp()
                     sh 'mvn package'
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
                    
                }
            }
        }
    }
}