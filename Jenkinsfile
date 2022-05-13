def gv

pipeline {
    agent any
    parameters{
        choice(name: "VERSION", choices: ["1.2", "1.2.1"], description: "Version Control")
    }
    environment {
        NEW_VERSION = "snapshot-2"
        DOCKER_ACCESS = credentials("Github-ID")
    }
    stages{
        stage('build image') {
            steps{
                echo "Initializing for a test"
                echo env.JOB_NAME
                script {
                gv = load "scriptTest.groovy"
                }
            }
        }

        stage('test image') {
            input{
                message "Please Select an <Env>"
                ok "All Selected"
                parameters{
                    choice(name: "ENV", choices: ["Dev", "Test", "Deploy", "Build"], description: "Envoirnment Selection")
                }

            }
            
            steps{                
                echo "Initializing for a test stage"
                echo "${NEW_VERSION}" 
                script {
                 gv.test()
                }
                echo "${ENV}"
            }
        }

        stage('deploy image') {
            
            steps{
                script {
            env.ENV = input(message: 'Select a Version', ok: 'Version selected.', parameters: [choice(name: "Dep_Version", choices: ["1", "2"], description: "Version Selection")])
            }
                echo "Initializing for a  deploy stage"
                echo "${params.VERSION}"
                echo "${ENV}"

            }
        }
    }
}