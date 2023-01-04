# Spring Kafka template / Sandbox

Simple setup to run Kafka producer and consumer for my own local testing and blueprint for PoCs.

> This is supposed to be only template for me, so it is really _Hello Kafka_. Nothing fancy :upside_down_face:.

## Docker Compose Environment

In **docker** folder is docker compose file with predefined Kafka environemnt.

Kafka and Zookeeper with simple broker configuration and AKHQ for easy monitoring/maintaining Kafka (https://akhq.io/).

```
cd docker
docker-compose start
```

After runnning running docker compose file, validate running container. It should looks like this:

```
docker ps
CONTAINER ID   IMAGE          COMMAND                  CREATED          STATUS                      PORTS                                                                     NAMES
b2e3619c686f   90679c5be303   "/opt/bitnami/script…"   14 minutes ago   Up 14 minutes               2888/tcp, 3888/tcp, 0.0.0.0:2181->2181/tcp, :::2181->2181/tcp, 8080/tcp   docker_zookeeper_1
ca4e1081fac3   56b50d6ec729   "docker-entrypoint.s…"   14 minutes ago   Up 14 minutes               0.0.0.0:8090->8080/tcp, :::8090->8080/tcp                                 docker_akhq_1
3cdc63ccd46c   f7ba77fe7527   "/opt/bitnami/script…"   14 minutes ago   Up 14 minutes               0.0.0.0:9092->9092/tcp, :::9092->9092/tcp                                 docker_kafka_1
```

Navigate to http://localhost:8090/ for AKHQ.

Kafka is available and ready to use on `localhost:9092`.

## Simple producer/consumer simulation

In **code** folder are two basic Spring Boot services: Producer and Consumer.
Producer runs on port 8881 and consumer 8882.

**_Producer_** is listening on path `kafka/send` for GET and POST.

To send message with static content:

```
curl -XGET localhost:8881/kafka/send
```

To send custom message:

```
curl -X POST localhost:8881/kafka/send -d "My custom message"
```

**_Consumer_**
Getting latest received message on consumer:

```
curl -XGET localhost:8882/kafka/latest
```
