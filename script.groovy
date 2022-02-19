def buildJar() {
    echo "building the application..."
    sh 'mvn clean'
    sh 'mvn package'
} 
def testApp() {
    echo "testing the application"
}
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker_credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t pattaclope/java-mvn-app:${IMAGE_NAME} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push pattaclope/java-mvn-app:${IMAGE_NAME}"
    }
} 

def deployApp() {
    echo 'deploying the application with DOUKOU...'
} 

return this
