pipeline{
	agent any
	tools{
		maven 'MyMaven'
	}
	stages{
		stage("checkout"){
			steps{
				checkout scm
				echo "Files checkout done from github"
			}
		}
		stage("Build"){
			steps{
				echo "Building Done"
			}			
		}
		stage("Test"){
			steps{
				sh 'mvn test'
				echo "Testing Done"
			}			
		}
		stage('Generate Reports') {
	    	steps {
		        // Publish TestNG results
		        junit '**/test-output/testng-results.xml' // Publish TestNG results
		        publishHTML(target: [
		            reportName: 'TestNG Report',
		            reportDir: 'reports',
		            reportFiles: 'jenkins-report.html', // Main HTML report for TestNG
		            alwaysLinkToLastBuild: true,
		            keepAll: true
		        ])
    		}
		}
	}
}