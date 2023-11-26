pipeline {
    agent any
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    // If you have specific commands to build the JAR, add them here
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    // If you have specific commands to build the Docker image, add them here
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3080:3080 -d vjnolan/react-nodejs:1.0'
                    sshagent(['ec2-server key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@51.20.131.44 ${dockerCmd}"
                    }
                    // If you have deployment steps or commands, add them here
                }
            }
        }
    }   
}
