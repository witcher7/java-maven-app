pipeline {
    agent any
    environment {
        NEW_VERSION = "snapshot-2"
    }
    stages{
        stage('build image') {
            
            steps{
                echo "Initializing for a test"
                echo env.JOB_NAME
            }
        }

        stage('test image') {
            steps{
                echo "Initializing for a test stage"
                echo "${NEW_VERSION}" 
            }
        }

        stage('deploy image') {
            steps{
                echo "Initializing for a  deploy stage"
                echo BRANCH_NAME
            }
        }
    }
}