
pipeline {
  tools {
    maven 'Maven-Runner'
  }
  stages {
      stage('Build Jar') {
        steps {
          echo "====++++Building the Maven Project++++===="
          sh 'mvn package'
        }
      }
          stage("Build Image") {
            steps {
              echo "====++++Building Images++++===="
            withCredentials([
              usernamePassword(credentialsId: '	Docker-ID', usernameVariable: 'DOCKER_USER', passwordVariable: 'DOCKER_PASS')
            ]) {
              sh '''
                docker build --tag erfanrider/java-apps:1.2.0 .
                echo ${DOCKER_PASS} | docker login -u ${DOCKER_USER} --password-stdin
                docker push erfanrider/java-apps:1.2.0
              '''
            }
            }
          }
      }

          stage("deploy") {
            steps {
              sh '''
              echo "Done with Deploying"
              echo "Please Check the Private Docker Registry"
            '''
            }
          }
}
