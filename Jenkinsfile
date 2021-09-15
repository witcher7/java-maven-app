pipeline {
    agent any
    tools{
        maven 'maven-3.8'
    }
    stages {
        stage("build jar ") {
            steps {
                script {
                    echo "Building the application..."
                    sh 'mvn package' 
                }
            }
        }
        stage("build image ") {
            steps {
                script {
                    echo "Building the docker image ..."
                    withCredentials([
                        usernamePassword(credentialsId:'docker-hub-repo',usernameVariable:USER, passwordVariable:PWD)
                    ]){
                        sh 'docker build -t ziedcloud2020/my-repo:jma-2.0 .'
                        sh "echo $PWD | docker login -u $USER --password-stdin "
                        sh 'docker push ziedcloud2020/my-repo:jma-2.0'

                    }
                }
            }
        }
        
        stage('second deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
