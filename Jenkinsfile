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
                withCredentials([usernamePassword(credentialsId: '72c0db7f-cafd-4332-93de-f08a58b4f06f',usernameVariable: 'USER', passwordVariable: 'PWD')]){
                    sh 'docker build -t koushik617/demo-app:tagname .'
                    sh "docker login -u ${USER} -p ${PWD}"
                    sh 'docker push koushik617/demo-app:tagname'
                }
                }
            }
        }
        
    }
}
