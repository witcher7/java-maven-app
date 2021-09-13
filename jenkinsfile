pipeline {
    agent any
    stages {
        stage('second build') {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }
        stage('second test') {
            steps {
                script {
                    echo "Testing the application..."
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
