pipeline {
    agent any
    tools {
        maven  'maven'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    echo "building the docker image .."
                    withCredentials([usernamePassword(credentialsId: 'Docker_hub', usernameVariable: 'user', passwordVariable: 'pass')])
                            {
                                sh "docker build -t ahmedabed/demo-app:1.1.1 ."
                                sh "echo $pass | docker login -u $user --password-stdin"
                                sh "docker push ahmedabed/demo-app:1.1.1"
                            }
                }
            }
        }
        stage("deploy app "){
            steps {
                script {
                    def shellCmd = "bash ./script.sh"
                    sshagent(['ec2-user']) {
                        sh "scp script.sh ec2-user@3.64.26.65:/home/ec2-user"
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@3.64.26.65 ${shellCmd}"
                    }
                }
            }
        }
    }
}

