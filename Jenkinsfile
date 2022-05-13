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
                echo env.BUILD_NUMBER
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