pipeline {

    agent none
    
    stages {
        stage('test'){
            steps {
                script {
                    echo "testing the application"
                    echo "Eecuting pipeline for branch $BRANCH_NAME"
                }
            }

        }
         
         stage('build') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
             steps {
                script {
                   echo "Building the application..."
                }
            }
        }

         

         stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
             
             steps {
                script {
                    echo "Deploying the application..."
                }
                 
             }
         }
    }
}

