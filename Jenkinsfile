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
    // stage('SSH transfer') {
    //     steps{
    //         script {
    //             sshPublisher(
    //                 continueOnError: false, failOnError: true,
    //                 publishers: [
    //                     sshPublisherDesc(
    //                         configName: "${env.ec2-user}",
    //                         verbose: true,
    //                         transfers: [
    //                             sshTransfer(
    //                                 sourceFiles: "/var/lib/jenkins/workspace/Nodejs-pipelines/app.js",
    //                                 execCommand: "cd nodejs,cp -f app.js "
    //                                 )
    //                             ] 
    //                     )
    //                 ]
    //             )
    //         }
    //     }
    // };    
     stage('Deployment') {
        steps {
            script {
                sshPublisher(publishers: [
                    sshPublisherDesc(
                        configName: "${env.ec2-user}",
                        transfers: [
                            sshTransfer(
                                sourceFiles: "/var/lib/jenkins/workspace/Nodejs-pipelines/app.js",
                                execCommand: "cd nodejs,cp -f app.js "
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