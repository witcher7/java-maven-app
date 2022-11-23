def Build_Jar() {
    echo 'Building Jar Application ....'
    sh 'mvn package'
}

def Build_Image() {
    withCredentials  ([ usernamePassword(credentialsId: 'DockerHub_Credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
        sh 'docker build -t 139646/java-maven-app:2.0 .'
        sh "echo $PASSWORD | docker login -u $USER --password-stdin"
        sh 'docker push 139646/java-maven-app:2.0'
        echo "Image pushed Successfully ..... "
    }
}

return this
