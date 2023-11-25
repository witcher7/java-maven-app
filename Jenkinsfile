def gv

pipeline {
    agent any
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
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -p 3080:3080 -d vjnolan/react-nodejs:1.0'
                   sshagent(['ec2-server key']) {
                       sh "ssh -o StrictHostKeyChecking=no ec2-user@51.20.131.44 ${dockercmd}"
                      }
                    //gv.deployApp()
                }
            }
        }
    }   
}
