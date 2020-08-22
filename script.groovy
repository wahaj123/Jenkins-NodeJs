
steps{
            script {
                sshPublisher(
                    continueOnError: false, failOnError: true,
                    publishers: [
                        sshPublisherDesc(
                            configName: "${env.ec2-user}",
                            verbose: true,
                            transfers: [
                                sshTransfer(
                                    sourceFiles: "/var/lib/jenkins/workspace/Nodejs-pipelines/app.js",
                                    execCommand: "cd nodejs,cp -f app.js "
                                    )
                                ] 
                        )
                    ]
                )
            }
        }