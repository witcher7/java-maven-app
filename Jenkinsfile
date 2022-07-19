pipeline {
    agent any
    tools {
        maven 'maven'
    }
    stages
            {
                stage("increment version") {
                    steps {
                        script {
                            echo 'increment app version ...'
                            sh 'mvn build-helper:parse-version versions:set \
                            -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.nextMinorVersion}.\\\${parsedVersion.incrementalVersion} \
                            versions:commit'
                            def matcher = readFile('pom.xml') =~ '<version>(.+)<version>'
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
                                        sh "docker build -t $IMAGE_NAME ."
                                        sh "echo $pass | docker login -u $user --password-stdin"
                                        sh "docker push $IMAGE_NAME"
                                    }
                        }
                    }
                }
                stage("deploy app ") {
                    steps {
                        script {
                            def shellCmd = "bash ./script.sh ${IMAGE_NAME}"
                            sshagent(['ec2-user']) {
                                sh "scp script.sh ec2-user@3.64.26.65:/home/ec2-user"
                                sh "scp docker-compose.yaml ec2-user@3.64.26.65:/home/ec2-user"
                                sh "ssh -o StrictHostKeyChecking=no ec2-user@3.64.26.65 ${shellCmd}"
                            }
                        }
                    }
                }
                stage("commit version update") {
                    steps {
                        script {
                            withCredentials([usernamePassword(credentialsId: 'Gitlab', passwordVariable: 'PASS', usernamePassword: 'USER')])
                            sh "git remote set-url origin https://${USER}:${PASS}@gitlab.com/ahmedabed/java-maven-app.git"
                            sh 'git add .'
                            sh 'git commit -m "ci: version bump" '
                            sh 'git push origin HEAD:jenkins-jobs'
                        }
                    }
                }
            }
}

