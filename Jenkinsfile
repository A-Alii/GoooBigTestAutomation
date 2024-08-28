pipeline {
    agent any
    
    environment {
        MAVEN_HOME = tool 'Maven' // Use your Maven installation name
        JAVA_HOME = tool 'JDK11'  // Use your JDK installation name
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/A-Alii/GoooBigTestAutomation.git'
            }
        }

        stage('Install Dependencies') {
            steps {
                sh "${MAVEN_HOME}/bin/mvn clean install"
            }
        }

        stage('Run Tests') {
            steps {
                script {
                    def deviceName = input message: 'Enter Device Name:', parameters: [string(defaultValue: 'emulator-5554', description: 'Device Name', name: 'DEVICE_NAME')]
                    def platformVersion = input message: 'Enter Platform Version:', parameters: [string(defaultValue: '11.0', description: 'Android Version', name: 'PLATFORM_VERSION')]
                    def platformName = 'Android'

                    sh "${MAVEN_HOME}/bin/mvn test -DdeviceName=${deviceName} -DplatformVersion=${platformVersion} -DplatformName=${platformName}"
                }
            }
        }

        stage('Generate Report') {
            steps {
                // If you have Allure or any other reporting tool, integrate it here
                // For example, to generate an Allure report:
                sh "${MAVEN_HOME}/bin/mvn allure:report"
                allure includeProperties: false, jdk: '', reportBuildPolicy: 'ALWAYS', results: [[path: 'target/allure-results']]
            }
        }
    }

    post {
        always {
            junit 'target/surefire-reports/*.xml' // Adjust the path to your test reports
            archiveArtifacts artifacts: '**/target/*.jar', allowEmptyArchive: true
        }
        failure {
            mail to: 'your-email@example.com',
                 subject: "Failed Pipeline: ${currentBuild.fullDisplayName}",
                 body: "Something is wrong with ${env.BUILD_URL}"
        }
    }
}
