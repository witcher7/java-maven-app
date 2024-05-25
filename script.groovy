def build_Jar()
{
    echo " building the application"
    sh "mvn package"
}

def buildImage()
{
    echo " building the docker  image..."
    withCredentials([usernamePassword(credentialsId:'docker-hub-repo', usernameVariable:'USER' ,passwordVariable: 'PASS')])
    {
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker build -t bharatmundra/demo-app:1.5.1 . "
        sh "docker push bharatmundra/demo-app:1.5.1 "
    }
             
}

def deployApp()
{
    echo "deploying the application"
    echo "deploying the application version ${params.VERSION}"

}
return this