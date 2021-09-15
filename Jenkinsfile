def gv 
pipeline {
    agent any
    
    stages {
        stage("test") {
            steps {
                script {
                   echo "testing the application..."
                   echo "Executing pipeline for branch : $BRANCH_NAME "
                }
            }
        }
        stage("build ") {
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "Building the application..." 
                }
            }
        }
        
        stage('deploy') {
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "deploying the application..."
                }
            }
        }
    }
}
