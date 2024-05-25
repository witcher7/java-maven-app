def buildApp()
{
    echo "builing the application"
}
def testApp()
{
    echo "Testing the application"
}
def deployApp()
{
    echo "deploying the application"
    echo "deploying the application version ${params.VERSION}"

}
return this