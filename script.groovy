def buildJar(){
    echo "building jar"
    sh 'mvn package'
}

def buildImage(){
    echo "build and push docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PWD')]){
        sh 'docker build -t ldchnsd/demo-app:jma-2.0 .'
        sh "echo $PWD | docker login -u $USER --password-stdin"
        sh 'docker push ldchnsd/demo-app:jma-2.0'
    }
}

def deployApp(){
    echo "deploying the application"
}

return this