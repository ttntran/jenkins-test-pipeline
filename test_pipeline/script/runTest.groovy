
node {
    def a = "$HOME/a"
    def b = "$HOME/b"
    parallel singleImage: {
        stage('Stage 1') {
                funcA("Hello Tran!!!!!!")
	    }
        }, multipleImage: {
	    stage('Stage 2') {
                funcA("World")
	    }
        }
 }

def funcA(String option) {
        withEnv(["OPTION=${option}"]) {
                sh '''echo $OPTION >> /tmp/log'''
	}
}

