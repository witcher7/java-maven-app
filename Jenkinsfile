pipeline{
    agent any
    tools{
        maven 'maven-3.9.4'
    }
    stages{
        stage("build jar"){
            steps{
                echo "building jar"
                sh 'mvn package'
            }
        }
        stage("build docker image"){
            steps{
                script{
                echo "building docker image"
                withCredentials([usernamePassword(credentialsId: '261f44e4-2696-4ca2-9064-e7aa4345b39a',usernameVariable: 'USER', passwordVariable: 'PWD')]){
                    sh 'docker build -t koushik617/demo-app:tagname .'
                    sh "docker login -u ${USER} -p ${PWD}"
                    sh 'docker push koushik617/demo-app:tagname'
                }
                }
            }
        }
        
    }
}
