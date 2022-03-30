pipeline {
    agent any
    tools{
        maven 'Maven'
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials('server-credentials')
    }

    stages {
        stage('build') {
            steps {
                echo 'building the application...'
                sh "mvn install"
            }
        }
        
        stage('test') {
            steps {
                echo 'testing the application...'
            }
        }
        
        stage('deploy') {
            steps {
                echo 'deploying the application...'
            }
        }
    }
}