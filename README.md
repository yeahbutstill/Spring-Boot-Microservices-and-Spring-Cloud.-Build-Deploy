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
