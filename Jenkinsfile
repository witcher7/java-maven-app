def gv

pipeline {
  agent any
  stages {
    stage("init") {
      steps {
            echo "Initializing the preparations"
      }
    }
    stage("build") {
//       when {
//         expression {
//           BRANCH_NAME == 'master'
//         }
//       }
        steps {
          echo "Building the MVN Project in an integrated manner"
         }
    }
    
    stage("deploy") {
//       when {
//         expression {
//           BRANCH_NAME == 'master'
//         }
//       }
      steps {
        echo "Deploying the apps in an integrated manner "
      }
    }
  }
}