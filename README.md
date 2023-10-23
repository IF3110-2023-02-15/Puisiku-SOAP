## How to Run

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