 def gv
CODE_CHANGES = getGitChanges()

pipeline{

    agent any
    parameters{
        string(name: 'VERSION', defaultValue: '', description: 'version to deploy to prod')
        choice(name: 'VERSION', choices:['1.1.0','1.2.0','1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: ' tests execute')
    }


    tools {
        maven 'maven-3.6'
        // gradle
        // jdk
    }
    environment {
        NEW_VERSION = '1.3.0'
        SERVER_CREDENTIALS = credentials ('server-credentials')
    }    

    stages{
        stage('init'){
            steps{
                script{
                    echo "init stage"
                }
            }
        } // init stage
        stage('build'){
            steps{
                script{
                    echo "init stage"
                    echo " building version ${NEW_VERSION)"
                }
            }
        } // init stage

        stage('test'){
            steps{
                script{
                   when  {
                       expression {
                           params.executeTests == true
                       }
                   }
                   echo "test stage"     
                }
            }
        } // test
        stage('deploy'){
           steps{
               script{
                  echo "deploy stage" 
                  echo "deploy version ${params.VERSION}"
               }
           }
        } //deploy
    }//stages
    post{
        always {
            // sending an email for success
        }
        success{

        }
        failure {

        }



    }


}// pipeline

