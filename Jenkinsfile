pipeline {
    agent any
    tools {
        maven 'maven-3.9.5'
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
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')]){
                        sh 'docker build -t ldchnsd/demo-app:jma-2.0 .'
                        sh "echo $PWD | docker login -u $USER --password-stdin"
                        sh 'docker push ldchnsd/demo-app:jma-2.0'
                    }
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                }
            }
        }
    }   
}