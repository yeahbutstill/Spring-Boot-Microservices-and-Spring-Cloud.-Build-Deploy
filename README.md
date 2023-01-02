# Spring-Boot-Microservices-and-Spring-Cloud-Build-Deploy

## Download and Install RabbitMQ
```shell
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.11-management
```

## Download and Install Postgres
```shell
docker run --rm \
--name photo_app-db \
-e POSTGRES_DB=photo_app \
-e POSTGRES_USER=sergey \
-e POSTGRES_PASSWORD=sergey \
-e PGDATA=/var/lib/postgresql/data/pgdata \
-v "$PWD/photo_app-data:/var/lib/postgresql/data" \
-p 5432:5432 \
postgres:15
```

## Login postgres
```shell
psql -h 127.0.0.1 -U sergey photo_app
```


## Download and add JCE to JRE
if you using java 8
```text
https://www.oracle.com/java/technologies/javase-jce8-downloads.html
```
unzip and paste to path:
```text
/home/yeahbutstill/.sdkman/candidates/java/8.0.352-tem/jre/lib/security/
```

## Generate keystore for asymetric encryption
https://docs.oracle.com/javase/8/docs/technotes/guides/security/StandardNames.html

but this olg algo
```shell
keytool -genkeypair -alias apiEncryptionKey -keyalg RSA \
-dname "CN=Sergey Kargopolov,OU=API Development,O=appsdeveloperblog.com,L=Ottawa,S=ON,C=CA" \
-keypass 1q2w3e4r -keystore apiEncryptionKey.jks -storepass 1q2w3e4r
```

run this to clear warning, it is recommended to migrate to PKCS12 which is an industry standard format using
```shell
keytool -importkeystore -srckeystore apiEncryptionKey.jks -destkeystore apiEncryptionKey.jks -deststoretype pkcs12
```
## To distributed tracing with sleuth and zipkin
```shell
docker run -d -p 9411:9411 openzipkin/zipkin
```
http://localhost:9411/zipkin/

## Aggregating log files with ELK stack
https://www.elastic.co/downloads/
- Download Logstash
- Download Elasticsearch

## Refrensi
- https://www.appsdeveloperblog.com/restful-web-services/restful-web-services-with-spring-mvc/
- https://www.appsdeveloperblog.com/microservices-and-spring-cloud-tutorials-for-beginners/
- https://www.appsdeveloperblog.com/category/oauth2/