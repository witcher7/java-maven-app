pipeline {
    agent any
    tools {
        maven 'my-maven'
    }
    stages {
        stage('Build jar') {
            steps {
                script {
                    echo "Build Jar file"
                    sh 'maven package'
                }
        }
    }

        stage('Build docker image') {

            steps {
                echo "Building docker image"
            }

            steps {
                script {
                    withCredentials([usernamePassword(credentialsId:'Docker-Hub', PasswordVariable: 'PASS', usernameVariable: 'USER')])
                        sh 'docker build -t niwaapp:v1.0'
                        sh 'docker tag niwaapp:v1.0 niwantha94/niwanthaapp:v1.0'
                        sh 'echo $PASS | docker login -u USER --pasword-stdin'
                        sh 'docker push niwantha94/niwanthaapp:v1.0'
                        sh 'docker logout' 
                }
        }
    }

        stage('Deploy to dockerhub') {
            steps {
                script {
                    sh 'echo "Hello World"'
                }
        }
    }
}
}
