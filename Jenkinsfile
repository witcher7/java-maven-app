library identifier:'jenkins-shared-library@main', retriever:modernSCM(
    [$class: 'GitSCMSource',
     remote: 'https://gitlab.com/maiziz/jenkins-shared-library.git',
     credentialsId: 'gitlab'
    ]
)
def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage("increment version"){
            steps{
                script {
                    echo 'incrementing the version ...'
                    sh  'mvn build-helper:parse-version versions:set  \
                         -DnewVersion = \\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                          versions:commit '
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    env.IMAGE_NAME = "$version-$BUILD_NUMBER"

                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    buildJar()
                }
            }
        }
        stage("build and push image") {
            steps {
                script {
                    buildImage "aymendocker99/java-maven-app:$IMAGE_NAME"
                    dockerLogin()
                    dockerPush "aymendocker99/java-maven-app:$IMAGE_NAME"
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
