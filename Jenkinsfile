pipeline{
	agent any
	stages{
		stage('git repo & clean'){
			steps{
				bat "rmdir /s /q SpringbootUnitTesting"
				bat "git clone https://github.com/Rajasekhar2011/sb-unittesting.git"
				bat "mvn clean -f SpringbootUnitTesting"
			}
		}
		stage("install"){
			steps{
				bat "mvn install -f "SpringbootUnitTesting"
			}
		}
		stage("test"){
			steps{
				bat "mvn test -f "SpringbootUnitTesting"
			}
		}
		stage("package"){
			steps{
				bat "mvn package -f "SpringbootUnitTesting"
			}
		}

	}
}
