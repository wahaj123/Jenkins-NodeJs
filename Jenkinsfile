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
        sh 'nohup node app.js &'
      }
    }  
    
            
    // stage('Test') {
    //   steps {
    //     sh 'npm test'
    //   }
    // }cp -f test1 /home
  }
}