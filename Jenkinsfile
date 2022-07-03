#!/usr/bin/env groovy
@Library('jenkins_shared_library')
def gv

pipeline {
    agent any
    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage("build jar") {
            steps {
                script {
                    echo "building jar"
                    buildjar()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building image"
                    dockerbuild()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    echo "deploying"
                    //gv.deployApp()
                }
            }
        }
    }   
}
