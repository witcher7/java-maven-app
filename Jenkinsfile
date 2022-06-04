def gv

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

        stage("Groovy Init") {
            steps {
                script {
                    //Define the file of groovy script
                    gv = load "script.groovy"
                }
            }
        }
        
        stage("Env Var") {
            steps {
                script {
                    echo "env.BRANCH_NAME"
                    echo "Test_Env_is: ${Test_ENV}"
                }
            }
        }

        stage("Parameter Boolean") {
            steps {

                script {
                    echo "Parameter Boolean is true ${params.executeTest}"
                }
            }
        }
        stage("Parameter Choice") {
            steps {

                script {
                    echo "Param choice is true ${params.Version}"
                }
            }
        }

        stage("Test Groovy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }   
}
