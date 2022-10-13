pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh 'mvn clean test -DskipTests=true'
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn clean test -Dconfig="${CONFIG}" -DsuiteXml="${SUITE}"'
            }
        }
    }
    post {
        always {
            archiveArtifacts artifacts: 'target/logs/*', allowEmptyArchive: true
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}
