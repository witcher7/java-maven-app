pipeline {
    agent any
   
    stages {

        stage ('Test') {
            steps {
                script {
                   echo "Testing the App" 
                   echo "Branch: $BRANCH_NAME"
                }
            }
        }

        stage ('Build') {
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                   echo "Building the App" 
                   echo "Branch: $BRANCH_NAME" 
                }
            }
        }

    }
}
