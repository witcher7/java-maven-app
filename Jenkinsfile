pipeline {
    agent any
    
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
                ECHO env.BUILD_NUMBER
            }
        }

        stage('deploy image') {
            steps{
                echo "Initializing for a  deploy stage"
                echo env.BRANCH_NAME
            }
        }
    }
}