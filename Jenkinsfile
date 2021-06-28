pipeline {
	agent any
	stages {
		stage ("install") {
			steps {
				bat "mvn install -f "SpringbootUnitTesting"
			}
		}
		stage ("test") {
			steps {
				bat "mvn test -f "SpringbootUnitTesting"
			}
		}
		stage ("package") {
			steps {
				bat "mvn package -f "SpringbootUnitTesting"
			}
		}

	}
}