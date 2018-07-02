node {
    a="$HOME/a"
    parallel singleImage: {
        stage('Stage 1') {
	        echo 'Hello World: ${env.AR}'
	        echo "env.ARTIFACT_VERSIO : ${env.ARTIFACT_VERSION}"
	        echo "env.MULTIPLE_IMAGES: ${env.MULTIPLE_IMAGES}"
	        env1 = env.ARTIFACT_VERSION
	        env2 = env.MULTIPLE_IMAGES
	        withEnv(["env1=$env.ARTIFACT_VERSION",
	        "env2=$env.MULTIPLE_IMAGES",
                "A=$a"]) {
	            sh '''echo env1: ${env1}, env2: ${env2} >> /tmp/log
                          echo $A
                    '''
	        }
	    }
        }, multipleImage: {
	    stage('Stage 2') {
		echo "Stage 2"
	    }
        }
 }
