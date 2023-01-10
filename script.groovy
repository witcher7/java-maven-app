def incrementVersion () {
    echo "incrementing app version......"
    sh 'mvn build-helper:parse-version versions:set \
    -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
    versions:commit'
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    def version = matcher[0][1]
    env.IMAGE_NAME = "$version-$BUILD_NUMBER"
}

def buildJar () {
    echo "building the application....."
    sh 'mvn clean package'
}

def buildImage () {
    echo "building the docker image......"
    withCredentials([usernamePassword(credentialsId: 'docker-hub',passwordVariable: 'PASS',usernameVariable:'USER')]){
        sh "docker build -t yasser1133/demo-app:${IMAGE_NAME} ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push yasser1133/demo-app:${IMAGE_NAME}'
    }
}

def deployApp () {
     echo 'deploying the applicayion ........'
}

def commitVersionUpdate () {
    withCredentials([usernamePassword(credentialsId: 'last-gitlab', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'

        sh 'git status'
        sh 'git branch'
        sh 'git config --list'

        sh "git remote set-url origin https://${USER}:${PASS}@gitlab.com/yassermagdy430/java-maven-app.git"
        sh 'git add .'
        sh 'git commit -m "ci: version update"'
        sh 'git push origin HEAD:jenkins-jobs'
    }
}

return this
