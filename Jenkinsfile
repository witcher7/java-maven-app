CODE_CHANGES = getGi

pipeline {
    agent any
    
    stages{
        stage('build image') {
            
            steps{
                echo "Initializing for a build stage"
            }
        }

        stage('test image') {
            when{
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps{
                echo "Initializing for a test stage"
            }
        }

        stage('deploy image') {
            steps{
                
            }
        }
    }
}