#!/bin/bash

# using official maven:latest image from dockerhub run 
# spring-boot app in current working directory
# using current users maven repository cache

# mounts your maven cache over the root's home in the container
# 	-v ~/.m2:/root/.m2 \

# mounts the root of the project, your current working dir (where your pom.xml is), over /apps
#	-v $PWD:/apps \

# -w 
docker run -it \
	-p 127.0.0.1:8080:8080 \
	-v ~/.m2:/root/.m2 \
	-v $PWD:/apps \
	--workdir /apps \
	--expose 8080 \
	maven:latest \
	mvn spring-boot:run 



