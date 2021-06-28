pipeline {
	agent any
	stages {
		stage ("install") {
			steps {
				"mvn install"
			}
		}
		stage ("test") {
			steps {
				 "mvn test"
			}
		}
		stage ("package") {
			steps {
				 "mvn package"
			}
		}

	}
}