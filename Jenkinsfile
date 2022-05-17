

pipeline {
    agent any
    
    stages {
    
        stage('test') {
          steps {
              echo "Testing the Maven app"
          } 
        }
        
        stage('Building the Artifacts') {
           steps {
               echo "Building the apps"
           }
        }
        
        stage('Example Build') {
           steps {
               echo "Deploying to the EC2"
           }
        }
    }
}