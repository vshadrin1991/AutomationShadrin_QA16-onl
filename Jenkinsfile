pipeline {
    agent any
    tools {
        maven "MAVEN"
    }
    stages {
        stage('Build') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn -DskipTests=true clean install"
            }
        }
        stage('Run tests') {
            steps {
                sh 'mvn clean test -Dconfig="moodpanda" -DsuiteXml="Lecture_13"'
            }
        }
    }
    post {
        always {
            allure includeProperties: false, jdk: '', results: [[path: 'target/allure-results']]
        }
    }
}
