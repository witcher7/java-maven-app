def gvScript

pipeline {
  agent any
  tools {
    maven 'Maven-Runner'
  }
  stages {
      stage("init") {
        steps {
          script {
          gvScript = load 'script.groovy'
          }
        }
      }

      stage('Build Jar') {
        steps {
                script {
                gvScript.buildJar()          
                }
            }
      }
      stage("Build Image") {
        steps {
            script {
            gvScript.buildImage()          
            }
        }
      }

      stage("deploy") {
        steps {
          script {
          gvScript.deploy()
          }
        }
      }
  }
}
