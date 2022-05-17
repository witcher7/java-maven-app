

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
           		withCredentials([ 
           				usernamePassword(credentialsId: "Docker-ID", usernameVariable: 'DOCKER_ID', passwordVariable: 'DOCKER_PASS')
           		 ]) {
           		     echo "Getting ready log into private docker registry . . ."
           		     sh "docker build --tag erfanrider/java-app:1.1.0 ."
           		     sh "echo \"$DOCKER_PASS\" | docker login -u \"$DOCKER_ID\" --password-stdin"
           		     sh 'docker push erfanrider/java-app:1.1.0' 
           		     
           		 }

           }
        }
        
        stage('Example Build') {
           steps {
               echo "Deploying to the EC2"
           }
        }
    }
}