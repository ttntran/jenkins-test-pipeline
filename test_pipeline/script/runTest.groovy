
node {
    def a = "$HOME/a"
    def b = "$HOME/b"
    parallel singleImage: {
        stage('Stage 1') {
                funcA(a)
	    }
        }, multipleImage: {
	    stage('Stage 2') {
                funcA("Hello!!!!!!!@@@")
	    }
        }
 }

def funcA(String option) {
        withEnv(["OPTION=${option}"]) {
                sh '''echo $OPTION >> /tmp/log'''
	}
}

