

pipeline {
  agent any

  stages {
    stage("init") {
      steps {
        echo "Initializing the preparations"
      }
    }

    stage("test") {
      steps {
        echo "Testing the apps"    
      }
    }
    stage("build") {
      when {
        expression {
          BRANCH_NAME == 'master'
        }
      }
      steps {
        echo "Building the apps"        
      }
    }
    
    stage("deploy") {
      when {
        expression {
          BRANCH_NAME == 'master'
        }
      }
      steps {
        echo "Deploying the apps"
      }
    }
  }
}