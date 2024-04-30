pipeline {
    agent none
     stage('test') {
            steps {
                script {
                    echo "Testing the appliation........."
                    echo "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
    stages{ 
        stage('build') {
            when {
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "building the application...."
                }
            }
        }
       
        stage("deploy") {
             when {
                expression{
                    BRANCH_NAME == 'master'
                }
            }
            steps {
                script {
                    echo "deploying the application......."
                }
            }
        }
    }
      
}