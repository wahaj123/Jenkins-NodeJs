pipeline {
  agent any
    
  tools {nodejs "node"}
    
  stages {
        
    stage('Git') {
      steps {
        git branch: 'master',
            credentialsId: 'git-access',
            url: 'https://github.com/wahaj123/Jenkins-NodeJs'
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
                                sourceFiles: "app.js",
                                execCommand: "npm install; npm install express; export BUILD_ID=dontKillMe; nohup node app.js & " 
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
  }
}