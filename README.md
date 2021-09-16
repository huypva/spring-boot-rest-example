The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-rest-client
│   ├── Dockerfile
│   ...
├── spring-boot-rest-server
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
### Start project in local

- Install infrastructure

- Build project
```shell script
$ ./mvnw clean package
```

- Start spring-boot-rest-server
```shell script
$ cd spring-boot-rest-server
$ ../mvnw spring-boot:run
...
2021-09-15 10:12:52.770  INFO 2968 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-09-15 10:12:52.886  INFO 2968 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8082 (http) with context path ''
2021-09-15 10:12:52.888  INFO 2968 --- [           main] i.c.s.RestServerApplication              : Started RestServerApplication in 1.402 seconds (JVM running for 1.697)
```

- Start spring-boot-rest-client
```shell script
$ cd spring-boot-rest-client
$ ../mvnw spring-boot:run
...
2021-09-15 10:14:05.773  INFO 3079 --- [           main] o.s.s.concurrent.ThreadPoolTaskExecutor  : Initializing ExecutorService 'applicationTaskExecutor'
2021-09-15 10:14:06.025  INFO 3079 --- [           main] o.s.b.w.embedded.tomcat.TomcatWebServer  : Tomcat started on port(s): 8081 (http) with context path ''
2021-09-15 10:14:06.029  INFO 3079 --- [           main] i.c.s.RestClientApplication              : Started RestClientApplication in 2.075 seconds (JVM running for 2.391)
```

### Start project in docker 

- Start project
```shell script
$ docker-compose up -d
```

- Stop project
```shell script
$ docker-compose down
```

## Run testing

### Send request to spring-boot-rest-client

```shell script
$ curl -X GET http://localhost:8081/helloword
Hello world!%
```

View log in spring-boot-rest-client
```shell script
...
2021-09-15 10:15:04.343  INFO 3079 --- [nio-8081-exec-1] i.c.s.entrypoint.Controller              : Greeting(id=0, message=Hello GetMapping!)
2021-09-15 10:15:04.354  INFO 3079 --- [nio-8081-exec-1] i.c.s.entrypoint.Controller              : Greeting(id=1, message=Hello PathVariable!)
2021-09-15 10:15:04.360  INFO 3079 --- [nio-8081-exec-1] i.c.s.entrypoint.Controller              : Greeting(id=1, message=Hello RequestParam!)
2021-09-15 10:15:04.406  INFO 3079 --- [nio-8081-exec-1] i.c.s.entrypoint.Controller              : Greeting(id=1, message=Hello RequestBody!)
```

### Some request to spring-boot-rest-client

- Send get request
```shell script
$ curl -X GET http://localhost:8082/api/get-mapping
{"id":0,"message":"Hello GetMapping!"}
```

- Send post request with path variable
```shell script
$ curl -X GET http://localhost:8082/api/path-variable/1
{"id":1,"message":"Hello PathVariable!"}
```

- Send post request with request param
```shell script
$ curl -X GET http://localhost:8082/api/request-param?user_id=1
{"id":1,"message":"Hello RequestParam!"}
```

- Send post request with request body
```shell script
$ curl -X POST http://localhost:8082/api/request-body -H "Content-Type: application/json" -d '{"user_id":"1"}' 
{"id":1,"message":"Hello RequestBody!"}
```

## Contribute

## Reference
- https://www.baeldung.com/spring-cloud-openfeign