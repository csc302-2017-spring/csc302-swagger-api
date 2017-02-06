# Applicant API example

If you visit the online swagger editor at http://editor.swagger.io/#/ you can upload our definition into the online editor (Use webapp's File->Import File.. menu item.)

Then, provided the file validates, you can generate several different flavours of client and server stubs from the API definition. 

For instance, if you choose the menu item Generate_Server->Node.js, it will download a file to your computer called nodejs-server-server-generated.zip.

unzip this, follow the README, and you will be running Node.js that has routes for the endpoints of the API -- ready for you to actually implement the server.


unzip the downloaded server, cd into the unpacked dir, and run Node:

npm start

and you should see:

```
$ npm start

> dcs-applicants@1.0.0 prestart /Users/mzaleski/Downloads/nodejs-server-server
> npm install


> dcs-applicants@1.0.0 start /Users/mzaleski/Downloads/nodejs-server-server
> node index.js


Your server is listening on port 8080 (http://localhost:8080)
Swagger-ui is available on http://localhost:8080/docs
```

Then, browse to the URL you see and you will see a slightly different API viewer than on swagger public website.

Note: the local URL above is embedded in the swagger YAML.

Similarly, you could generate code to run a Java Spring server (actually SpringBoot, there are sub-flavours of Spring that swagger appears not to support yet).

Running this one is a bit tricker, the instructions are missing from the README. This worked for me:

```
mvn install
java -jar target/swagger-spring-1.0.0.jar
```
Also, I could read the project into eclipse by "File->import" then choosing to import "Existing Maven Projects". Then you navigate to the to the generated spring-server directory containing the pom.xml file. (This was the eclipse recipe for all the CSC301 individual assignments)


