pipeline {
	agent any
	stages {
		stage ("install") {
			steps {
				bat "mvn install"
			}
		}
		stage ("test") {
			steps {
				bat "mvn test"
			}
		}
		stage ("package") {
			steps {
				bat "mvn package"
			}
		}

	}
}