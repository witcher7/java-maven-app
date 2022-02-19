def buildJar() {
    echo "building the application..."
    sh 'mvn package'
} 
def testApp() {
    echo "testing the application"
}
def buildImage() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker_credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t pattaclope/java-mvn-app:1.1.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push pattaclope/java-mvn-app:1.1.0"
    }
} 

def deployApp() {
    echo 'deploying the application...'
} 

return this
