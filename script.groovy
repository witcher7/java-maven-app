def buildJar(){
                    echo "building the application..."
                    sh 'mvn clean package'
                }
def buildImage(){
                    echo "building the docker image..."
                    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh "docker build -t chetanpatil06/java-maven:1.2 ."
                        sh "echo $PASS | docker login -u $USER --password-stdin"
                        sh "docker push chetanpatil06/java-maven:1.2"
                    }
                    
def deployApp(){
    echo 'deploying the application'
}

return this 
