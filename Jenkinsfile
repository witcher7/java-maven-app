def gvScript

pipeline {
  agent any
  tools {
    maven 'Maven-Runner'
  }
  stages {
      stage("init") {
        steps {
          gvScript = load 'script.groovy'
        }
      }

      stage('Build Jar') {
        steps {
                gvScript.buildJar()          
            }
      }
          stage("Build Image") {
            steps {
                gvScript.buildImage()          
            }
          }

          stage("deploy") {
            steps {
              gvScript.deploy()
            }
          }
  }
}
