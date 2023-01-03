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
- Download Logstash and config logstash-simple.conf
```text
input { 
    file {
        type => "users-ws-log"
        path => "/home/yeahbutstill/IdeaProjects/Spring-Boot-Microservices-and-Spring-Cloud-Build-Deploy/PhotoAppApiUsers/users-ws.log"
    }

    file {
        type => "albums-ws-log"
        path => "/home/yeahbutstill/IdeaProjects/Spring-Boot-Microservices-and-Spring-Cloud-Build-Deploy/PhotoAppApiAlbums/albums-ws.log"
    }
}

output {
    if [type] == "users-ws-log" {
        elasticsearch {
            hosts => ["https://localhost:9200"]
            index => "users-ws-%{+YYYY.MM.dd}"
            user => "elastic"
            password => "xlVt2ZP-SW7oDl4LHUt6"
            cacert => "/home/yeahbutstill/Documents/spring-boot-microservices-and-spring-cloud-build-deploy-config/EKL/elasticsearch-8.2.2/config/certs/http_ca.crt"
        }
    } else if [type] == "albums-ws-log" {
        elasticsearch {
            hosts => ["https://localhost:9200"]
            index => "albums-ws-%{+YYYY.MM.dd}"
            user => "elastic"
            password => "xlVt2ZP-SW7oDl4LHUt6"
            cacert => "/home/yeahbutstill/Documents/spring-boot-microservices-and-spring-cloud-build-deploy-config/EKL/elasticsearch-8.2.2/config/certs/http_ca.crt"
        }
    }

    stdout { codec => rubydebug }
    }

```
- Download Elasticsearch (https://localhost:9200/)

```text
✅ Elasticsearch security features have been automatically configured!
✅ Authentication is enabled and cluster connections are encrypted.

ℹ️  Password for the elastic user (reset with `bin/elasticsearch-reset-password -u elastic`):
  xlVt2ZP-SW7oDl4LHUt6

ℹ️  HTTP CA certificate SHA-256 fingerprint:
  ba9e18d33fed27de33efd1b0f6558d4eb22876d6d6205c7bb41f902ab3475170

ℹ️  Configure Kibana to use this cluster:
• Run Kibana and click the configuration link in the terminal when Kibana starts.
• Copy the following enrollment token and paste it into Kibana in your browser (valid for the next 30 minutes):
  eyJ2ZXIiOiI4LjIuMiIsImFkciI6WyIxMC4xLjYxLjY0OjkyMDAiXSwiZmdyIjoiYmE5ZTE4ZDMzZmVkMjdkZTMzZWZkMWIwZjY1NThkNGViMjI4NzZkNmQ2MjA1YzdiYjQxZjkwMmFiMzQ3NTE3MCIsImtleSI6IkpxcDJjNFVCYWtUT0M4RmYtblZKOlFGNVY4RGZ6UW51SG5wdk1Hb2ZoWGcifQ==

ℹ️  Configure other nodes to join this cluster:
• On this node:
  ⁃ Create an enrollment token with `bin/elasticsearch-create-enrollment-token -s node`.
  ⁃ Uncomment the transport.host setting at the end of config/elasticsearch.yml.
  ⁃ Restart Elasticsearch.
• On other nodes:
  ⁃ Start Elasticsearch with `bin/elasticsearch --enrollment-token <token>`, using the enrollment token that you generated.

```

- Download Kibana

enrollment token
```shell
bin/elasticsearch-create-enrollment-token --scope kibana
```

## Refrensi
- https://www.appsdeveloperblog.com/restful-web-services/restful-web-services-with-spring-mvc/
- https://www.appsdeveloperblog.com/microservices-and-spring-cloud-tutorials-for-beginners/
- https://www.appsdeveloperblog.com/category/oauth2/