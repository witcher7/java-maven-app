pipeline {
    agent any
    environment {
        DOCKER_TTY = 'true'
    }
    tools {
        maven 'maven-3.9.1'
    }
    stages {
        stage("build jar") {
            steps {
                echo "building application..."
                sh 'mvn package'
            }
        }
        stage("build image") {
            steps {
                echo "building the docker image..."
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t conceptum925/my-repo:jma-2.0 .'
                    sh "docker login -u $USER -p $PASS"
                    sh 'docker push conceptum925/my-repo:jma-2.0'
                }
            }
        }
        stage("deploy") {
            steps {
                echo "deploying the application..."
            }
        }
    }
}
