dev buildApp() {
    echo 'building the application...'
}

dev testApp() {
    echo 'testing the application...'
}

dev deployApp() {
    echo 'deploying the application...'
    echo "deploying version is ${params.VERSION}"
}

return this
