def gv

pipeline {
    agent any
    
    parameters {
        string(name: 'ENVIRONMENT', defaultValue: 'production', description: 'The environment to deploy to')
        choice(name: 'ENVIRONMENT_TYPE', choices: ['production', 'development', 'testing'], description: 'Select the environment type')
    }
    
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    gv.buildJar()
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker_hub_repo', 
                        passwordVariable: 'PASSWORD', usernameVariable: 'USERNAME')]) {
                        sh 'docker build -t sabryelhasanin/demo-app:jma-2.0 .'
                        sh "echo $PASSWORD | docker login -u $USERNAME --password-stdin"
                        sh 'docker push sabryelhasanin/demo-app:jma-2.0'
                    }
                }
            }
        }
        

        stage("deploy") {
            when {
                expression {
                    params.ENVIRONMENT == 'production'
                }
            }
            steps {
                script {
                    echo "deploying"
                    gv.deployApp()
                }
            }
        }
    }   
}
