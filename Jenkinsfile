pipeline {
    agent any

    options {
        disableConcurrentBuilds()
        timeout(time: 20, unit: 'MINUTES')
        timestamps()
    }

    environment {
        DOCKERHUB_CREDENTIALS = credentials('dockerhub-cred')
        IMAGE_TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {
            steps {
                echo 'Checking out source code from GitHub...'
                checkout scm
            }
        }

        stage('Maven Build') {
            steps {
                echo 'Building all Spring Boot services...'

                sh 'mvn -f eureka-server/pom.xml clean package -DskipTests'
                sh 'mvn -f product-service/pom.xml clean package -DskipTests'
                sh 'mvn -f order-processing-service/pom.xml clean package -DskipTests'
                sh 'mvn -f payment-service/pom.xml clean package -DskipTests'
            }
        }

        stage('Docker Build') {
            steps {
                echo "Building Docker images with tag ${IMAGE_TAG}..."

                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/eureka-server:$IMAGE_TAG" eureka-server'
                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/product-service:$IMAGE_TAG" product-service'
                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:$IMAGE_TAG" order-processing-service'
                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/payment-service:$IMAGE_TAG" payment-service'
            }
        }

        stage('Docker Hub Login') {
            steps {
                echo 'Logging in to Docker Hub...'

                sh '''
                    echo "$DOCKERHUB_CREDENTIALS_PSW" | \
                    docker login \
                    -u "$DOCKERHUB_CREDENTIALS_USR" \
                    --password-stdin
                '''
            }
        }

        stage('Docker Push') {
            steps {
                echo 'Pushing images to Docker Hub...'

                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/eureka-server:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/product-service:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/payment-service:$IMAGE_TAG"'
            }
        }
    }

    post {
        always {
            sh 'docker logout || true'
        }

        success {
            echo 'Build and Docker image push completed successfully.'
        }

        failure {
            echo 'Pipeline failed. Check the failed stage in Console Output.'
        }
    }
}