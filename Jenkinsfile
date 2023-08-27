def gv
pipeline{
    agent any
    stages{
        stage("init"){
            stpes{
                script{
                    gv = load "script.groovy"
                }
            }
        }
        stage("build")
        {
            steps{
                gv.build()
            }
        }
    }
}
