pipeline {
    agent none
    tools {
        maven "maven-3.6"
    }
    stages {
        stage('build jar') {
            steps {
                script {
                    echo "Building the application..."
                    sh "maven package"
                }
            }
        }
        stage('build iamge') {
            steps {
                script {
                    echo "Building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                        sh "docker build -t ldchnsd/demo-app:jma-2.0 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push ldchnsd/demo-app:jma-2.0"
                    }
                }
            }
        }
        stage('deploy') {
            steps {
                script {
                    echo "Deploying the application..."
                }
            }
        }
    }
}
