pipeline{
    agent none
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages {
      stage('build'){
          steps {
              echo "build this app"
          }
      }

      stage('test'){
          when {
            expression {
                params.executeTests
            }
          }
          steps {
              echo "test this app"
          }
      }

      stage('deploy'){
          steps {
              echo "deploy this app"
              echo "deploy version ${params.VERSION}"
          }
      }
    }
}

