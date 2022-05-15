#!/usr/bin/env groovy


library identifier: 'Jenkins-Shared-Library@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
     remote: 'https://gitlab.com/Erfan-Motallebi/pipeline-shared-library.git',
     credentialsId: 'Gitlab-ID'
    ]
)
def gv

pipeline {
  agent any
    tools {
        maven "Maven-Runner"
        
    }
  stages {
    stage("init") {
      steps {
            echo "Initializing the preparations"
            script {
                gv = load 'script.groovy'
            }
      }
    }

    stage("Build Jar") {
        steps {
            echo "Building the Maven Project"
            buildJar()
        }
    }

    stage("build Docker Images") {
        steps {
          echo "Building the MVN Project"
            buildDockerImage "erfanrider", "java-apps:1.7.0"
            dockerLogin()
            dockerPush "erfanrider", "java-apps:1.7.0"
         }
    }
    
    stage("deploy") {
      steps {
        echo "Deploying the apps in an multibranch triggering way"
        script {
          gv.deploy()
      }
      }
    }
  }
}