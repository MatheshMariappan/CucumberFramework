node
{
  stage ('SCM Checkout')
  {
    git 'https://github.com/MatheshMariappan/CucumberFramework.git'
  }
  
  stage ('Compile-and-package')
  {
    def mvnHome = tool name: 'Maven 3.5.0', type: 'maven'
    sh "${mvnHome}/bin/mvn package"
  }
}
