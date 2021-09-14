def gv
pipeline{
    agent any
    
    parameters{
        choice (name: 'VERSION', choices :['1.1.0','1.2.0','1.3.0'], description : '')
        booleanParam (name: 'executeTests', defaultValue: true , description: ' ')
    }

    stages{
        stage ("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage ("build"){
            steps{

            script{

                gv.buildApp()
            
            }
            }
        }
        stage ("test"){
            when{
                expression{
                    params.executeTests
                }
            }
            steps{
                script{
                    gv.testApp()

                }
                
            }
        }
        stage ('deploy'){
            input{
                message "select the environment to deploy to :"
                ok "Done " 
                parameters {
                   choice (name: 'ENV1', choices :['DEV','STAGING','PRODUCTION'], description : '') 
                   choice (name: 'ENV2', choices :['DEV','STAGING','PRODUCTION'], description : '')
                }
            }
            steps{
              script{
                gv.deployApp()
                echo "Deploying to ${ENV1} "
                echo "Deploying to ${ENV2} "
            }
            }
        }
    }
}
