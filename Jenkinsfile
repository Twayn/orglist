pipeline {
    agent any

    stages {
        stage('Checkout from SCM') {
            steps {
                echo 'Checkout..'
                git branch: 'master',
                    credentialsId: 'b42b8605-6d70-4b2d-8101-ace7e3362763',
                    url: 'https://github.com/Twayn/orglist.git'
            }
        }
        stage('Docker build') {
            steps {
                echo 'Docker building...'
                bat "docker build -t twayn/orglist ."
            }
        }
        stage('Docker push') {
            steps {
                echo 'Docker stopping previous...'
                bat "docker push twayn/orglist:latest"
            }
        }
        stage('Kubernetes remove previous') {
            steps {
                echo 'Kubernetes removing previous...'
                bat "kubectl delete -f kubernetes/orglist.yaml"
            }
        }
        stage('Kubernetes create deployment & service') {
            steps {
                echo 'Kubernetes creating deployment & service....'
                bat "kubectl apply -f kubernetes/app.yaml"
            }
        }
    }
}