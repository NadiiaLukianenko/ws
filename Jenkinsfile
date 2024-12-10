pipeline {
  agent any
  stages {
    stage("build"){
      steps{
        echo 'build app'
        withGradle() {
          sh './gradlew -v'
        }
        
      }
    }
    stage("test"){
      steps{
        echo 'test app'
        sh './gradlew clean test'
      }
    }
    stage("deploy"){
      steps{
        echo 'deploy app'
        
      }
    }
  }
}
