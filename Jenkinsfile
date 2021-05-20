node  {
    def Author = 'vignesh'

    stage('Clean WS') {
        sh 'echo "Cleaning WorkSpace"'
        cleanWs();

    }
    stage('Declartive Checkout'){
        checkout scm;
    }
    stage('Compile') {
        withMaven(jdk: 'jdk8', maven:'Maven3') {
            sh 'mvn compile'
        }
    }
    
     stage('Package') {
        withMaven(jdk: 'jdk8', maven:'Maven3') {
            sh 'mvn package'
        }
    }  
    
    stage('Who Completed') {
        sh "echo ${Author}"
    }

}
