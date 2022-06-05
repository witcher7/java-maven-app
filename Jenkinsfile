pipeline {
    agent any

    tools {
      maven 'Maven'
    }

    stages {

        stage('Build Jar') {
            steps {
                script {
                   echo 'Building Jar Application ....'
                   sh 'mvn package'
            }
          }
        }

        stage('Build Image') {
            steps {
               script {
                   withCredentials  ([ usernamePassword(credentialsId: 'DockerHub_Credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
                      sh 'docker build -t 139646/java-maven-app:1.0 .'
                      sh "echo $PASSWORD | docker login -u $USER --password-stdin"
                      sh 'docker push 139646/java-maven-app:1.0'
                      echo "Image pushed Successfully ..... "
                    }
               }
            }
        }
    }
}
