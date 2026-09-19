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
                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/eureka-server:$IMAGE_TAG" -t "$DOCKERHUB_CREDENTIALS_USR/eureka-server:latest" eureka-server'

                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/product-service:$IMAGE_TAG" -t "$DOCKERHUB_CREDENTIALS_USR/product-service:latest" product-service'

                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:$IMAGE_TAG" -t "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:latest" order-processing-service'

                sh 'docker build -t "$DOCKERHUB_CREDENTIALS_USR/payment-service:$IMAGE_TAG" -t "$DOCKERHUB_CREDENTIALS_USR/payment-service:latest" payment-service'
            }
        }

        stage('Docker Hub Login') {
            steps {
                sh '''
                    echo "$DOCKERHUB_CREDENTIALS_PSW" |
                    docker login -u "$DOCKERHUB_CREDENTIALS_USR" --password-stdin
                '''
            }
        }

        stage('Docker Push') {
            steps {
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/eureka-server:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/eureka-server:latest"'

                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/product-service:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/product-service:latest"'

                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/order-processing-service:latest"'

                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/payment-service:$IMAGE_TAG"'
                sh 'docker push "$DOCKERHUB_CREDENTIALS_USR/payment-service:latest"'
            }
        }

        stage('Deploy to EC2') {
            steps {
                sh '''
                    echo "Pulling latest images..."
                    docker compose pull

                    echo "Starting application..."
                    docker compose up -d

                    echo "Running containers:"
                    docker compose ps
                '''
            }
        }
    }

    post {
        always {
            sh 'docker logout || true'
        }

        success {
            echo 'Build, push and deployment completed successfully.'
        }

        failure {
            echo 'Pipeline failed.'
        }
    }
}