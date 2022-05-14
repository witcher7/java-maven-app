def gv

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
    step {
          echo "Building the MVN Project"
          script {
              gv.buildJar()
          }
    }

    step {
            echo "Building the dockers images"
            script {
                gv.buildImage()
            }
    }

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
        script {
            gv.deploy()
        }
      }
    }
  }
}