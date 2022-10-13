pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    stages {
        stage('Build') {
            steps {
                sh "mvn -DskipTests=true clean install"
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn clean test -Dconfig="${CONFIG}" -DsuiteXml="${SUITE}"'
            }
        }
        stage('Copy artifacts') {
            steps {
                archiveArtifacts artifacts: 'target/logs/*', allowEmptyArchive: true
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}
