/*library identifier:'jenkins-shared-library@main', retriever:modernSCM(
    [$class: 'GitSCMSource',
     remote: 'https://gitlab.com/maiziz/jenkins-shared-library.git',
     credentialsId: 'gitlab'
    ]
)*/

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage('increment version') {
                    steps {
                        script {
                            echo 'incrementing app version...'
                            sh 'mvn build-helper:parse-version versions:set \
                                -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                                versions:commit'
                            def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                            def version = matcher[0][1]
                            env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                        }
                    }
                }
                stage('build app') {
                    steps {
                        script {
                            echo "building the application..."
                            sh 'mvn clean package'
                        }
                    }
                }
                stage('build image') {
                    steps {
                        script {
                            echo "building the docker image..."
                            withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                                sh "docker build -t aymendocker99/demo-app:${IMAGE_NAME} ."
                                sh "echo $PASS | docker login -u $USER --password-stdin"
                                sh "docker push aymendocker99/demo-app:${IMAGE_NAME}"
                            }
                        }
                    }
                }
                stage('deploy') {
                    steps {
                        script {
                            echo 'deploying docker image to EC2...'
                        }
                    }
                }

                stage("commit version update"){
                    steps{
                        script{
                            withCredentials([string(credentialsId: 'gitlab-token', variable: 'GITLAB_TOKEN')]){

                                sh 'git config --global user.email "jenkins@example.com"'
                                sh 'git config --global user.name "jenkins"'
                                sh "git remote set-url origin https://${GITLAB_TOKEN}@gitlab.com/aymenmaiziz/javaMavenApp.git"
                                sh "git add ."
                                sh 'git commit -m "ci: version update" '
                                sh "git push origin HEAD:jenkins-jobs "
                            }

                        }
                    }
                }
    }
}
