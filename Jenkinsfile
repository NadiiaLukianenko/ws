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
      }
    }
    stage("deploy"){
      steps{
        echo 'deploy app'
        
      }
    }
  }
}
