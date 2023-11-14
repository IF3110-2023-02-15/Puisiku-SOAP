## How to Run

Copy `.env.example` to `.env`. Fill in the credentials in the environment variables or use this default credentials
```bash
MYSQL_HOST=puisiku-soap-db
MYSQL_PORT=3306
MYSQL_ROOT_PASSWORD=puisiku
MYSQL_DATABASE=puisiku
MYSQL_USER=puisiku
MYSQL_PASSWORD=puisiku

PHP_API_KEY=fromphp
REST_API_KEY=fromrest
```

`docker-compose up -d --build`

Service will be served on `localhost:8888/logging`

To check the WSDL, go to `localhost:8000/logging?wsdl`

To test the endpoint using postman:

use method `POST`, on localhost:8888/logging

on Body, raw xml, use this Envelope
```bash
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/" xmlns:ser="http://services.chagiya.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:checkSubscription>
         <email>joli@lol.com</email>
      </ser:checkSubscription>
   </soapenv:Body>
</soapenv:Envelope>

```

Go to header, delete `Content-Type: application/xml`. Add `Content-Type: text/xml`



localhost:8888/subcription

Body -> Raw -> Type (xml)

