def gv
pipeline {
    agent any
    tools {
        maven 'maven3'
    }
    stages {

        stage('test') {
            steps {
                script{
                    echo "Testing the appication..."
                    ech "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }

        stage("build"){
            when{
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps{
                script{
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
                script{
                    echo "Deploying the application..."
                }
            }
        }
    }
}
