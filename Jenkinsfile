pipeline {
  agent any
    
  tools {nodejs "node"}
    
  stages {
        
    stage('Git') {
      steps {
        git 'https://github.com/wahaj123/Jenkins-NodeJs'
      }
    }
     
    stage('Build') {
      steps {
        sh 'pwd'
        sh 'npm install'
        sh 'npm install express'
      }
    }      
     stage('Deployment') {
        steps {
            script {
                sshPublisher(publishers: [
                    sshPublisherDesc(
                        configName: 'ec2-user',
                        transfers: [
                            sshTransfer(
                                sourceFiles: "*/**",
                                execCommand: "node app.js;" 
                            )
                        ],
                        usePromotionTimestamp: false,
                        useWorkspaceInPromotion: false,
                        verbose: false
                    )]
                )
            }
        }
    }       
    // stage('Test') {
    //   steps {
    //     sh 'npm test'
    //   }
    // }cp -f test1 /home
    //app.js
  }
}