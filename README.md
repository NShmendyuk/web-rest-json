# web-rest-json
Simple web project with rest api
![](https://github.com/Nshmendyuk/web-west-json/workflows/Java%20CI/badge.svg)
___
Простое Java Spring приложение, показывающее работу REST API
## Getting Started
Склонируйте и перейдите в каталог с проектом

    git clone https://github.com/NShmendyuk/web-rest-json
    cd web-rest-json

Соберите проект через систему сборки maven и запустите скомпилированный проект

    mvn compile
    mvn exec:java -Dexec.mainClass="ru.webitmo.restapi.RestapiApplication"

## API Endpoints
Примеры запросов к REST API:

GET, PUT и PATCH запросы без созданного объекта:
![GET noentity](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/noentity/postman_GET_noentity.png)

![PUT noentity](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/noentity/postman_PUT_noentity.png)

![PATCH noentity](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/noentity/postman_PATCH_noentity.png)

POST запрос - создание объекта:
![POST](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/created/postman_POST_created.png)

![GET created](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/created/postman_GET_created.png)

PUT запрос - замена объекта:
![PUT](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/replaced/postman_PUT_replaced.png)

![GET replaced](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/replaced/postman_GET_replaced.png)

PATCH запрос - замена объекта:
![PATCH](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/updated/postman_PATCH_updated.png)

![GET updated](https://github.com/NShmendyuk/web-rest-json/blob/develop/img/updated/postman_GET_updated.png)

## Built with
 - [JDK 11](https://www.oracle.com/ru/java/technologies/javase-jdk11-downloads.html) - Среда разработки
 - [Spring Boot](https://spring.io/projects/spring-boot) - Web Framework
 - [Maven](https://maven.apache.org/download.cgi) - Система сборки
