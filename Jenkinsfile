pipeline {
	agent any
	stages {
		stage ("build") {
			withMaven(maven: 'maven_3_6_3') {
				sh 'mvn clean install'
			}
		}
	}
}
