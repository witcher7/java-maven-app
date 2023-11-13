pipeline {
    agent any
    tools {
        maven "maven-3.9.5"
    }
    
    stages {
        
        stage("test") {
            steps {
                script {
                   echo "Testing the application..."
                   echo "Testing the integration ......"
                   echo "Testing the integration ............"
                }
            }
        }
        stage("build") {
            steps {
                script {
                   echo "Building the application..."
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                   echo "Deploying the application..."
                }

            }
        }
    }   
}
