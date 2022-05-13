pipeline {
    agent any

    stages{
        stage('build image') {
            steps{
                echo "Initializing for a build stage"
            }
        }
        stage('test image') {
            steps{
                echo "Initializing for a test stage"
            }
        }

        stage('deploy image') {
            steps{
                echo(message: 'Initialzing for a deploy stage')
            }
        }
    }
}