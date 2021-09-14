The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-rest
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
$ cd spring-boot-rest
$ ../mvnw spring-boot:run
...
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

- Send get request
```shell script
$ curl http://localhost:8081/api/get-mapping
{"id":0,"message":"Hello GetMapping!"}
```

- Send post request with path variable
```shell script
$ curl -X POST http://localhost:8081/api/path-variable/1
{"id":1,"message":"Hello PathVariable!"}
```

- Send post request with request param
```shell script
$ curl -X POST http://localhost:8081/api/request-param?user_id=1
{"id":1,"message":"Hello RequestParam!"}
```

- Send post request with request body
```shell script
$ curl -H "Content-Type: application/json" -X POST -d '{"user_id":"1"}' \http://localhost:8081/api/request-body
{"id":1,"message":"Hello RequestBody!"}
```

## Contribute

## Reference