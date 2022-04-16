 def gv


pipeline{
    stages{
        stage('init'){
            steps{
                script{
                    echo "init stage"
                }
            }
        } // init stage
        stage('build jar'){
            steps{
                script{
                   echo "build jar stage"
                }
            }
        } // build
        stage('build image'){
            steps{
                script{
                    echo "build image stage"
                }
            }                
        }
        stage('test'){
            steps{
                script{
                   echo "test stage"     
                }
            }
        } // test
        stage('deploy'){
           steps{
               script{
                  echo "deploy stage"  
               }
           }
        } //deploy
    }//stages
}// pipeline

