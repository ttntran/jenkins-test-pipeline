
node {
    def a = "$HOME/a"
    def b = "$HOME/b"
    def funcA(option) {
    	withEnv([OPTION=$option]) {
                sh "echo $OPTION >> /tmp/log"
        }
    }
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
