## How to Run

Copy `.env.example` to `.env`. Fill in the credentials in the environment variables or use this default credentials
```bash
MYSQL_HOST=chagiya-soap-db
MYSQL_PORT=3306
MYSQL_ROOT_PASSWORD=chagiya
MYSQL_DATABASE=chagiya
MYSQL_USER=chagiya
MYSQL_PASSWORD=chagiya
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
      <ser:log>
         <message>Your Test Message Here</message>
      </ser:log>
   </soapenv:Body>
</soapenv:Envelope>

```

Go to header, delete `Content-Type: application/xml`. Add `Content-Type: text/xml`