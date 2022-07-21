def buildApp() {
    echo 'building the application...'
}

def testApp() {
    echo 'building it to test ......'
}

def deployApp() {
    echo 'building for deployment ......'
    // echo "deployin version ${params.VERSION}"
}

return this
