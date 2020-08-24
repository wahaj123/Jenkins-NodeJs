pipeline {
  // agent any
  agent {label 'Jenkins-slave'}  
  tools {nodejs "node"}
    
  stages {
        
    stage('Git') {
      steps {
        script {
           // The below will clone your repo and will be checked out to master branch by default.
           git credentialsId: 'wahaj123', url: 'https://github.com/wahaj123/Jenkins-NodeJs'
           // Do a ls -lart to view all the files are cloned. It will be clonned. This is just for you to be sure about it.
           sh "ls -lart ./*" 
           // List all branches in your repo. 
           sh "git branch -a"
          }
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