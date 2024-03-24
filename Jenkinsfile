def gv 

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }
    stages("init")
        steps {
            script {
                gv = load "script.groovy"
            }
        }
        
        
    stages {
        stage('build') {
            steps {
               script {
                  gv.buildApp()
               }
            }
        }
        stage("test") {
            when {
                expression {
                    params.executeTests
                }
                script {
                  gv.testApp()
               }
            }
            steps {
                
        }
        stage("deploy") {
            steps {
              script {
                  gv.deployApp()
               }  
        }
    }
}
