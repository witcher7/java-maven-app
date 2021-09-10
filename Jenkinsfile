pipeline {
    agent any
    tools {
        maven 'maven-3.6'
    }
    stages {
        stage("build jar") {
            steps {
                script {
                    echo "building jar..."
                    sh 'mvn package'
                    //gv.buildJar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASSWORD', usernameVariable: 'USER')]){
                        sh 'docker build -t mdemin/java-maven-app:1.2 .'
                        sh "echo ${PASSWORD} | docker login -u ${USER} --password-stdin"
                        sh 'docker push mdemin/java-maven-app:1.2'
                    }
                    //gv.buildImage()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
