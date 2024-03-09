Poc de client com autenticação no Keycloack

Executar no terminal para criar o KeyCloak no docker local
````
docker run -p 8080:8080 -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin quay.io/keycloak/keycloak:24.0.1 start-dev
````

Suficiente para se comunicar por coockie session id
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-client</artifactId>
</dependency>

spring:
  security:
    oauth2:
      client:
        registration:
          keycloak:
            client-id: poc-client
            client-secret: 3TXHxyPAIdmxvknMvBY1vpijvlefPxlh
            scope: openid
        provider:
          keycloak:
            issuer-uri: http://localhost:8080/realms/realm_poc            
```
Para comunicação via JWT
```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-oauth2-resource-server</artifactId>
</dependency>

spring:
  security:
    oauth2:      
      resourceserver:
        jwt:
          issuer-uri: http://localhost:8080/realms/realm_poc
```
Configuração de client para importação poc-client.json
