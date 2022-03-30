def buildApp(){
    echo 'building the application...'
}

def buildDocker(){
    echo 'building the docker image...'
}

def testApp(){
    echo 'testing the application...'
}

def deployApp(){
    echo 'deploying the application...'
    echo "deploying version $params.VERSION"
}

return this