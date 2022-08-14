pipeline {
    agent none
    stages {
        stage('build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('test') {
            steps {
                script {
                    echo "Testing the application..."
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3080:3080 wh1227/react-nodejs:1.0'
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyCheking=no ec2-user@18.138.103.152 ${dockerCmd}"
                    }
                }
            }
        }
    }
}

