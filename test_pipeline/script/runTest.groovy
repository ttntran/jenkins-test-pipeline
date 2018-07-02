def a = "$HOME/a"
def b = "$HOME/b"
def funcA(option) {
	withEnv([OPTION=$option]) {
		sh "echo $OPTION >> /tmp/log"
	}
}
node {
    parallel singleImage: {
        stage('Stage 1') {
                funcA(b)
	    }
        }, multipleImage: {
	    stage('Stage 2') {
                funcA(a)
	    }
        }
 }
