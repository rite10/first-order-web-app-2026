pipeline {
    agent any

    stages {
        stage('Jenkins Test') {
            steps {
                echo 'Jenkinsfile successfully loaded from GitHub'
                sh 'java -version'
                sh 'mvn -version'
                sh 'git --version'
                sh 'docker --version'
                sh 'docker compose version'
            }
        }
    }
}