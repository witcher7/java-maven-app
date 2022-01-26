def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 


def buildApp(){
    echo "building the app..."
}
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker_hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t khurrambilal/my-app:jma-2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push khurrambilal/my-app:jma-2.0'
    }
} 


def testApp(){
    echo "Test step with version ${params.VERSION}"
}
def deployApp() {
    echo 'deploying the application...'
} 

return this

