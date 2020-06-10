# whatsgoodonmenuapi
API for https://whatsgoodonmenu.com

# Gradle Build (Entry point for the project)
```
./gradlew build
```
# Run the application
```
./gradlew bootRun
```

# Acutator provided endpoints
```
curl localhost:8080/actuator/health
```

# Run with debug messages for spring framework
```
./gradlew bootRun -Pargs=--logging.level.org.springframework=DEBUG
```

./gradlew bootRun -Pargs=--spring.profiles.active=prod

# Kubernetes:
```
kubectl apply -f k8s/menu-api-whatsgoodonmenu-cert.yaml
kubectl apply -f k8s/menu-api-backend-service.yaml
kubectl describe managedcertificate whatsgoodonmenuapimanagedcert
kubectl get pods
kubectl logs menu-api-app-65474bf5c-6wf9w 
```

# Spring Boot build image:
After making any changes, choose version in build.gradle, update docker push command and update deployment yaml. Execute to build the image and push it:
```
./gradlew bootBuildImage
docker push gcr.io/kubegcp-256806/menu-api:0.0.4-SNAPSHOT
kubectl apply -f k8s/menu-api-deployment.yaml
```

# Start MongoDB on local:
```
sudo mongod --config /usr/local/etc/mongod.conf
```

# For local production:

Step 1: start mongoDB
```
sudo mongod --config /usr/local/etc/mongod.conf
```

Step 2: start backend application
```
./gradlew bootRun
```

Step 3: start frontend application
```
npm install
```