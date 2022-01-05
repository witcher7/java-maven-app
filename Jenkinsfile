#!/usr/bin/env groovy

pipeline{
    agent any 
    stages{
        stage("test"){
            steps{
                script{
                    echo "Testing the application..."
                }
            }
        }
        stage("build"){
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps{
                script{
                    def dockerCmd = 'docker run -p 3080:3080 -d michaelburak/demo-app:1.0'
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictkHostKeyChecking=no ec2-user@3.86.240.76 ${dockerCmd}"
                }
                }
            }
        }
        stage("deploy"){
            when {
                expression {
                    BRANCH_NAME == 'master'
                }
            }
            steps{
                script{
                    echo "Deploying the application..."
                    }
                }
            }       
    }
}
