#!/usr/bin/env groovy

@Library('Jenkins-shared-library')
def gv
tools {
    mvn "Maven-Runner"
}
pipeline {
  agent any
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
            buildDockerImage()
         }
    }
    
    stage("deploy") {
      steps {
        echo "Deploying the apps"
        script {
          gv.deploy()

      }
    }
  }
}