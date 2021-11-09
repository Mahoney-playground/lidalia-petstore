# Lidalia Pet Store

This is a private example of trying to do Everything Right™ for a web
application.

Basic principles:
* Multi-env - can spin up a new env remotely trivially
* Same locally as remote
* Users are identified & authorised
* Everything is monitored & alerted
* On deployment new hashed css / js is added, old is still available

## System diagram

```plantuml
@startuml
node browser {
  component petstore.lidalia.co.uk
}

node services {
  component perms.petstore.lidalia.co.uk
  component static.petstore.lidalia.co.uk
  component service1.petstore.lidalia.co.uk
  component service2.petstore.lidalia.co.uk
  component db.service1.petstore.lidalia.co.uk
  component cache.petstore.lidalia.co.uk
  component queue.petstore.lidalia.co.uk
  component monitoring.petstore.lidalia.co.uk
}

component "http://remoteservice.com" as remote_service

petstore.lidalia.co.uk --> static.petstore.lidalia.co.uk
petstore.lidalia.co.uk --> service1.petstore.lidalia.co.uk
petstore.lidalia.co.uk --> service2.petstore.lidalia.co.uk

service1.petstore.lidalia.co.uk --> service2.petstore.lidalia.co.uk

service1.petstore.lidalia.co.uk --> db.service1.petstore.lidalia.co.uk
service1.petstore.lidalia.co.uk --> cache.petstore.lidalia.co.uk
service1.petstore.lidalia.co.uk --> queue.petstore.lidalia.co.uk

service2.petstore.lidalia.co.uk --> queue.petstore.lidalia.co.uk
service2.petstore.lidalia.co.uk --> cache.petstore.lidalia.co.uk

service1.petstore.lidalia.co.uk --> remote_service
@enduml
```
