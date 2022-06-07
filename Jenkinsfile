pipeline {
    agent any

    tools {
      maven 'Maven'
    }

    stages {
        
        stage('Increment App Version') {
            steps {
                script {
                    echo "Incrementing Application Version....."
                    sh 'mvn build-helper:parse-version versions:set \
                        -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                        versions:commit'
                    def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'       //here we get the version of app from pom.xml 
                    def version = matcher[0][1]
                    env.IMAGE_NAME= "$version-$BUILD_NUMBER"                           //here we add build_number to image anme
                }
            }
        }
        
        stage('Build Jar') {
            steps {
                script {
                   echo "Building Jar Application ...."
                   sh 'mvn clean package'   //to remove older versions jar files
            }
          }
        }

        stage('Build Image') {
            steps {
               script {
                    withCredentials  ([ usernamePassword(credentialsId: 'DockerHub_Credentials', usernameVariable: 'USER', passwordVariable: 'PASSWORD')]) {
                         sh "docker build -t ${IMAGE_NAME} ."
                         sh "echo $PASSWORD | docker login -u $USER --password-stdin"
                         sh "docker push ${IMAGE_NAME}"
                         echo "Image ${IMAGE_NAME}  pushed Successfully ..... "
    }                                                                                          //Using IMAGE_NAME to use the version of the app + build_number 
               }
            }
        }
    }
}
