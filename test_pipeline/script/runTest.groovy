
def funcA(option) {
        temp = "$option"
	withEnv([OPTION=$temp]) {
		sh "echo $OPTION >> /tmp/log"
	}
}
node {
    def a = "$HOME/a"
    def b = "$HOME/b"
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
