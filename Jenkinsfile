#!/usr/bin/env groovy

def gv

pipeline {
    agent any
    tools {
        maven 'Maven'
    }
    stages {

        stage ('init') {
            steps {
                script{
                    gv = load "script.groovy"
                }
            }
        }
        
        stage('build app') {
            steps {
                script {
                    gv.buildJar()
                }
            }
        }
        stage('build image') {
            steps {
                script {
                     gv.buildImage()
                    }
                }
            }
        
        stage('deploy app') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
        
    }
    

