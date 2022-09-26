pipeline {
    // master executor should be set to 0
    agent any
    stages {
        stage('Build Jar') {
            steps {
                //sh
                bat "mvn clean package -DskipTests"
            }
        }
        stage('Build Image') {
            steps {
                //sh
                bat "docker build -t=intercityashwin/selenium-docker ."
            }
        }
        stage('Push Image') {
            steps {
			    withCredentials([usernamePassword(credentialsId: 'dockerhub', passwordVariable: 'pass', usernameVariable: 'user')]) {
                    //sh
			        bat "docker login --username=${user} --password=${pass}"
			        bat "docker push intercityashwin/selenium-docker:latest"
			    }
            }
        }
        stage('Start Grid') {
            steps {
                    bat "docker-compose up -d hub chrome firefox"
                }
        }
        stage('Run Test') {
            steps {
                    bat "docker-compose up search-module"
                }
            }
        }
        post{
            always{
                archiveArifacts artifacts: 'output/**'
                bat "docker-compose down"
            }
        }
}