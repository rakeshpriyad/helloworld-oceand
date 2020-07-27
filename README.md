1 Create connfig map using
kubectl apply -f mysql-configmap.yml

kubectl get configmap
2. Create credentials
kubectl apply -f mysqldb-credentials.yml
kubectl get secrets

3. kubectl apply -f mysqldb-root-credentials.yml
kubectl get secrets



4. deploy mysql
kubectl apply -f mysql-deployment.yml
kubectl get deployments

5. create container from images using docker command

rkp/helloworld
docker build -t helloworld:1.0 .
docker image tag helloworld:1.0 rkp/helloworld


6. Deploy spring boot application
kubectl apply -f helloworld-deployment.yml
kubectl get deployments
kubectl get pods
kubectl logs  <pod id>


 get ip of minikube
minikube ip

http://192.168.99.105:30163/user/all



minikube docker-env

SET DOCKER_TLS_VERIFY=1

SET DOCKER_HOST=tcp://192.168.99.101:2376

SET DOCKER_CERT_PATH=C:\Users\Acer\.minikube\certs

SET MINIKUBE_ACTIVE_DOCKERD=minikube
REM @FOR /f "tokens=*" %i IN ('minikube -p minikube docker-env') DO @%i



docker login --username=rakeshpriyad

docker images


docker tag f4c71de80e10 rakeshpriyad/helloworld:1.0

docker push rakeshpriyad/helloworld

