def buildApp(){
    echo 'building the application...'
    sh 'mvn package'
}

def buildDocker(){
    echo 'building the docker image...'
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable:'USER')]){
                         sh 'docker build -t amine0648280049/demo_app:3.0 .'
                         sh "echo $PASS | docker login -u $USER --password-stdin"
                         sh 'docker push amine0648280049/demo_app:3.0'
                     }
}

def testApp(){
    echo 'testing the application...'
}

def deployApp(){
    echo 'deploying the application...'
    echo "deploying version $params.VERSION"
}

return this