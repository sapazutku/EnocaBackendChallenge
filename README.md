## How to Run
### Prerequisites
- Java 17
- Maven
- create `application.properties`
- PostgreSQL

### application.properties
```
spring.datasource.url=jdbc:postgresql://localhost:{port}/postgres
spring.datasource.username=postgres
spring.datasource.password=postgres
spring.jpa.hibernate.ddl-auto=update
```

### Docker
```
docker-compose up --build
```

### Maven
```
mvn clean install

mvn spring-boot:run
```

## Example Request
https://www.postman.com/utkusapaz/workspace/enoca
### Company
POST `/companies/create`
```
{
    "name": "New Company",
    "contact":{
        "email":"company@gmail.com",
        "phone":"123456",
        "address":"IST"
    }
}
```

PUT `/companies/update/1`
```
{
    "name": "New Company",
    "contact":{
        "email":"company.sapaz@gmail.com",
        "phone":"",
        "address":"IST"
    }
}
```

DELETE `/companies/delete/1`

GET `/companies/1`

POST Add Employee To Company `/companies/1/employees/1`


### Employee

POST `/employees/create`
```
{
    "name":"u",
    "surname":"s",
    "age":"..",
    "salary":"123",
    "contact":{
        "email":"u",
        "phone":"...",
        "address":"...."
    },
    "companyId":"1"
}
```

PUT Update Employee `/employees/update/1`
```
{
    "name":"u",
    "surname":"s",
    "age":"..",
    "salary":"123",
    "contact":{
        "email":"u",
        "phone":"...",
        "address":"...."
    },
    "companyId":"1"
}
```

DELETE /employees/delete/1

GET Employee by Id `/employees/1`

GET All Employees  `/employees`

GET Employee by Name `/employees/search?name=utku`