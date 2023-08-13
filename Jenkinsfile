pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git url: 'https://github.com/QA-RajYadav/nagpTestDevOps.git'
		            echo "Code Checked-out Successfully!!";
            }
        }
        
        stage('Package') {
            steps {
                bat 'mvn package'    
		            echo "Maven Package Goal Executed Successfully!";
            }
        }
        
        stage('JUNit Reports') {
            steps {
                    junit 'target/surefire-reports/*.xml'
		                echo "Publishing JUnit reports"
            }
        }
        
//         stage('Jacoco Reports') {
//             steps {
//                   jacoco()
//                   echo "Publishing Jacoco Code Coverage Reports";
//             }
//         }

	stage('SonarQube analysis') {
            steps {
		// Change this as per your Jenkins Configuration
                withSonarQubeEnv('SonarQubeServer') {
                    bat 'mvn package sonar:sonar'
                }
            }
        }

	stage("Quality Gate") {
                steps {
                  timeout(time: 6000, unit: 'SECONDS') {
                    def qg = waitForQualityGate()
                        if (qg.status != 'OK') {
                          error "Pipeline aborted due to quality gate failure: ${qg.status}"
                        }
                  }
                }
              }
            }
    post {
        
        success {
            echo 'This will run only if successful'
        }
        failure {
            echo 'This will run only if failed'
        }
    
    }
}
