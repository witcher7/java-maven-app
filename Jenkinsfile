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
            steps {
                echo 'building Docker Image'
                withCredentials ([usernamePassword(credentailsId:'DockerHub-credentials',passwordVariable :'PASS',usernameVariable: 'USER')])
                sh 'docker build -t chetanpatil06/java-maven:1.1 .'
                sh  "echo $PASS| docker login -u $USER --password-stdin"
                sh "docker push chetanpatil06/java-maven:1.1"
            }
        }
        stage("deploy"){
            steps {
                echo 'deploying the application'
            }
        }
    }
}
