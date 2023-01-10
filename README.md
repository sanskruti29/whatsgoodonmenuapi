# whatsgoodonmenuapi

API for <https://whatsgoodonmenu.com>

## Gradle Build (Entry point for the project)

```SpringBoot
./gradlew build
```

## Run the application

```SpringBoot
./gradlew bootRun
```

## Acutator provided endpoints

```bash
curl localhost:8080/actuator/health
```

## Run with debug messages for spring framework

```SpringBoot
./gradlew bootRun -Pargs=--logging.level.org.springframework=DEBUG
```

./gradlew bootRun -Pargs=--spring.profiles.active=prod

## Kubernetes

```Kubernetes
kubectl apply -f k8s/menu-api-whatsgoodonmenu-cert.yaml
kubectl apply -f k8s/menu-api-backend-service.yaml
kubectl describe service menu-api-backend
kubectl describe managedcertificate whatsgoodonmenuapimanagedcert
kubectl get pods
kubectl logs menu-api-app-65474bf5c-6wf9w
```

## Spring Boot build image

After making any changes, choose version in build.gradle, update docker push command and update deployment yaml. Execute to build the image and push it:

```SpringBoot/bash
./gradlew bootBuildImage  
docker push gcr.io/all-projects-292200/menu-api:0.0.14-SNAPSHOT  
kubectl apply -f k8s/menu-api-deployment.yaml  
kubectl describe deployment menu-api-app
kubectl get deployment menu-api-app
watch 'kubectl get pods & kubectl top pods'
```

## Start MongoDB on local

```MongoDB/bash
sudo mongod --config /usr/local/etc/mongod.conf
```

## For local production

Step 1: start mongoDB

```MongoDB/bash
sudo mongod --config /usr/local/etc/mongod.conf
```

Step 2: start backend application

```SpringBoot/bash
./gradlew bootRun
```

Step 3: start frontend application

```Javascript/bash
npm start
```

## Check Database

```MongoDB
mongo
```

```MongoDB
show databases
```

```MongoDB
use MenuApi
```

```MongoDB
show collections [user,visitor]
```

```MongoDB
db.[collections].find()
```

## DB access

```MongoDB
kubectl exec -it mongo-0 -c mongo bash
mongo
show databases
use MenuApi
show collections
db.visitor.find()
db.visitor.remove({ip: "73.70.114.196"})
```

## Check if build is happening

```GoogleCloud/bash
gcloud builds list --ongoing
```


kubectl scale deployment menu-api-app --replicas=0