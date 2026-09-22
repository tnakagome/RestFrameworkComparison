## How to Test the Program
Set up Java SDK (17 or higher) and maven as prerequisites.

1. Create a maven project. This will generate a simple Java code.

```sh
$ mvn archetype:generate -DgroupId=RestletSample -DartifactId=myapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
...
$ find . -type f
./myapp/pom.xml
./myapp/src/test/java/RestletSample/AppTest.java
./myapp/src/main/java/RestletSample/App.java
$
```
If maven ends up in error, try renaming the pom.xml that you have downloaded from github to something else and run the same maven command again.

2. Edit myapp/src/main/java/RestletSample/App.java and replace the code with the one in this github folder.

3. Copy Greeting.java into myapp/src/main/java/RestletSample/Greeting.java

4. Merge these to the myapp/pom.xml. Do not delete the pre-existing junit dependency.

```xml
  <properties>
    <maven.compiler.target>17</maven.compiler.target>
    <maven.compiler.source>17</maven.compiler.source>
  </properties>
  <dependencies>
    ...
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20260814</version>
    </dependency>
    <dependency>
      <groupId>org.restlet</groupId>
      <artifactId>org.restlet</artifactId>
      <version>2.6.0</version>
    </dependency>
    <dependency>
      <groupId>org.restlet</groupId>
      <artifactId>org.restlet.ext.json</artifactId>
      <version>2.6.0</version>
    </dependency>
    ...
  <dependencies>
```

5. Build the program.
``` sh
$ cd myapp
$ mvn compile package
```

6. Run the program.
```sh
$ mvn exec:java -Dexec.mainClass=RestletSample.App
...
[INFO] --- exec:3.6.4:java (default-cli) @ myapp ---
Sep 22, 2026 11:40:38 AM org.restlet.engine.connector.NetServerHelper start
INFO: Starting the internal [HTTP/1.1] server on port 18080
Sep 22, 2026 11:40:38 AM org.restlet.Application start
INFO: Starting RestletSample.App application
```

7. Open another terminal and execute test.sh.
```sh
$ ./test.sh
Hello Taro
```
You can also test the program using telnet. This one uses the GET method, unlike the above shell script that uses the POST method with body. Greeting.java supports  both methods.
```sh
$ telnet localhost 18080
Trying ::1...
Connected to localhost.
Escape character is '^]'.
GET /hi/Taro HTTP/1.1
Host: localhost
Connection: close

HTTP/1.1 200 OK
Server: Restlet-Framework/2.6.0
Date: Tue, 22 Sep 2026 02:42:17 GMT
Content-type: text/plain
Vary: Accept-Charset, Accept-Encoding, Accept-Language, Accept
Content-length: 11
Accept-ranges: bytes

Hello Taro!
```

## Tip
How to generate classpath in case you want to execute it from outside Maven.
```sh
$ mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
```
This will generate a string in cp.txt containing all necessary jars separated by colon. You can then export the content as CLASSPATH environment variable as below.
```sh
$ export CLASSPATH=`cat cp.txt`:`pwd`/target/myapp-1.0-SNAPSHOT.jar
```
Then you should be able to run the program using the java command.
```sh
$ java RestletSample.App
Starting the internal [HTTP/1.1] server on port 18080
Starting RestletSample.App application
```
