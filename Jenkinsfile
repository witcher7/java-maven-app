#!/usr/bin/env groovy
def gv

pipeline {
    agent any
    tools {
        maven  'maven'
    }
    stages {
        stage("increment version")
                {
                    steps {
                        script {
                            echo "incrementing app version ..."
                            sh 'mvn build-helper:parse-version version:set \
                            -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                            versions:commit'
                            def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                            def version = matcher[0][1]
                            env.IMAGE_NAME = "$version-$BUILD_NUMBER"
                        }
                    }
                }

        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    sh 'mvn clean package'
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    echo "building the docker image .."
                    withCredentials([usernamePassword(credentialsId: 'Docker_hub', usernameVariable: 'user', passwordVariable: 'pass')])
                            {
                                sh "docker build -t ahmedabed/demo-app:$IMAGE_NAME ."
                                sh "echo $pass | docker login -u $user --password-stdin"
                                sh "docker push ahmedabed/demo-app:$IMAGE_NAME"
                            }
                }
            }
        }
    }

}

