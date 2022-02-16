mvn clean package -> target backend-1.1.jar
check Dockerfile

// local docker setup
docker pull mysql
docker images
docker run -d -p3306:3306 --net spring-net --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=youtube mysql
docker logs mysqldb

docker build --tag=backend:1 .
docker images
docker run -p80:5000 --net spring-net --name backend backend:1

// when lightsail instance is created install docker
sudo -i
sudo yum updated -y
sudo yum install docker
sudo service docker start

// create network
docker network create spring-net
docker network ls

// install and run mysql
docker pull mysql
docker images
docker run -d -p3306:3306 --net spring-net --name mysqldb -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=youtube mysql
docker ps -a
docker logs mysqldb

// pull image from docker hub registry
docker pull 99fotopl/backend:1
docker images
docker run -d -p80:5000 --net spring-net --name backend 99fotopl/backend:1

http://3.65.207.25/swagger-ui/index.html

// when we want to make updated
sudo -i

// remove instance
docker ps -a
docker stop CONTAINER_ID
docker rm CONTAINER_ID

// remove image
docker images
docker rmi IMAGE_ID

// pull image from repo
docker pull 99fotopl/backend:1
docker run -d -p80:5000 --net spring-net --name backend 99fotopl/backend:1

http://3.65.207.25/swagger-ui/index.html

It runs only on $5 lightsail instance.