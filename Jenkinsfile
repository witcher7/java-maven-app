pipeline {
    agent any

    environment {
        Test_ENV= 'test_1'
    }

    parameters{  
       booleanParam(name: 'executeTest', defaultValue: true, description: 'this is to execute tests') 
       choice(name: 'Version', choices: ['1.0.0', '1.0.1', '1.1.0'], description: 'there are version choices')  
   }


    stages {
        stage("Env Var") {
            steps {
                script {
                    echo "env.BRANCH_NAME"
                    echo "Test_Env_is: ${Test_ENV}"
                }
            }
        }
        stage("Credentials") {
            steps {
                script {
                    withCredentials{[
                       usernamePassword(credentials: 'test_credentials', usernameVariable: User_Name, passwordVariable: Passwd)     
                  ]}
                }
            }
        }
        stage("Parameter Boolean") {
            steps {

                when {
                  expression {
                     params.executeTest == true
                  }
                }
                script {
                    echo "Parameter Boolean is true ${params.executeTest}"
                }
            }
        }
        stage("Parameter Choice") {
            steps {

                when {
                    expression {
                        params.Version == '1.0.1'
                    }
                }
                script {
                    echo "Param choice is true ${params.Version}"
                }
            }
        }
    }   
}
