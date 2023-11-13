pipeline {
    agent any
    tools {
        maven "maven-3.9.5"
    }
    
    stages {
        
        stage("test") {
            steps {
                script {
                   echo "Testing the application..."
                   echo "Executing pipeline on branch: $BRANCH_NAME"
                   echo "Testing the integration ......"
                }
            }
        }
        stage("build") {
            when {
                expression {
                    BRANCH_NAME == "master"
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
                    BRANCH_NAME == "master"
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
