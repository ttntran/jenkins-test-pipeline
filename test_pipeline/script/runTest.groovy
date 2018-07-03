
node {
    def a = "$HOME/a"
    def b = "$HOME/b"
    parallel singleImage: {
        stage('Stage 1') {
                funcA("hello")
	    }
        }, multipleImage: {
	    stage('Stage 2') {
                funcA("world")
	    }
        }
 }

def funcA(String option) {
        withEnv([OPTION=${option}]) {
                sh '''echo $OPTION >> /tmp/log'''
	}
}

