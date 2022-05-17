
def buildJar() {
    echo "Building the Maven Project"
    sh 'mvn clean package'
}


def buildDockerImage() {
    echo "Building the Docker Image"

        echo "Getting ready log into private docker registry . . ."
        sh "docker build --tag erfanrider/java-app:1.1.0 ."

    }

def pushDockerImage() {
    echo "Pushing the Docker image built in the previous section"
    withCredentials([
            usernamePassword(credentialsId: "Docker-ID", usernameVariable: 'DOCKER_ID', passwordVariable: 'DOCKER_PASS')
    ]) {
        sh "echo \"$DOCKER_PASS\" | docker login -u \"$DOCKER_ID\" --password-stdin"
        sh 'docker push erfanrider/java-app:1.1.0'
    }
}

return this