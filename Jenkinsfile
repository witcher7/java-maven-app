pipeline {
    agent any 
    tools {
        maven 'maven'
    }
    stages {
        stage("build jar"){
            steps {
                echo 'building the application'
                sh "mvn package"
            }
        }
        stage("build image"){
            steps script {
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'DockerHub-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t chetanpatil06/java-maven:1.2 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push chetanpatil06/java-maven:1.2"
                    }

        }
        stage("deploy"){
            steps {
                echo 'deploying the application'
            }
        }
    }
}
