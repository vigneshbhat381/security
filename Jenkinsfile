pipeline{
    agent any
    options { 
        quietPeriod(30) 
     }
   
    triggers {
        pollSCM('* * * * *')
    }
    tools{
        maven  'm3'
        jdk 'jdk11'
    }

    stages {
        stage('Clean Ws') {
            steps{
                cleanWs()
            }
        }
        stage('Git CheckoutOut'){
            steps{
                checkout scm
            }
        }
       stage ('Maven Package'){
            steps{
                sh 'mvn package'
            }
        }
       stage('Build Docker Image') {
             steps {
                 sh 'docker login -u vigneshbhat12 -p "Vignesh18!"' 
                 sh 'docker build -t vignesh/my_app:1.0.0 .'
                 
             }
        }
        
         stage('Push Docker Image'){
             steps {
                
                 sh 'docker push vignesh/my_app:1.0.0'
             }
         }
         

}

}
