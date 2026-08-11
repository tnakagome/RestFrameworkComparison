## How to Test the Program
Set up a JDK (17 or higher) and maven as prerequisites.

1. Create a maven project. This will generate a simple Java code and project files.

``` sh
$ mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.5 -DgroupId=SpringBootSample -DgroupId=SpringBootSample -DartifactId=myapp -Dmaven.compiler.source=17 -Dmaven.compiler.target=17 -DinteractiveMode=false

$ find myapp/ -type f
myapp/pom.xml
myapp/.mvn/maven.config
myapp/.mvn/jvm.config
myapp/src/test/java/SpringBootSample/AppTest.java
myapp/src/main/java/SpringBootSample/App.java
```

If maven ends up in error, try renaming the pom.xml that you have downloaded from github to something else and run the same maven command again.

2. Edit myapp/src/main/java/SpringBootSample/App.java and replace the code with the one in this github folder.

3. Copy Greeting.java and GreetingController.java into myapp/src/main/java/SpringBootSample/ folder.

4. Merge these into the myapp/pom.xml. Do not delete the pre-existing junit dependency. 

```xml
  <parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>4.0.2</version>
  </parent>
...
  <dependencies>
...
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
```

5. Build the program.
``` sh
$ cd myapp
$ mvn compile package
```

6. Run the program.
```sh
$ mvn spring-boot:run
```
The log will be written to the terminal.

7. Open another terminal and run the test script.
```sh
$ ./test.sh 
Hello, Taro!
```
To test the GET capability, use telnet:
```sh
$ telnet localhost 55555
Trying ::1...
Connected to localhost.
Escape character is '^]'.
GET /hi/Taro HTTP/1.1
Host: localhost

HTTP/1.1 200 
Content-Type: text/plain;charset=UTF-8
Content-Length: 12
Date: Tue, 03 Feb 2026 10:39:37 GMT

Hello, Taro!
```

## Tip
How to generate classpath in case you want to execute it from outside Maven.
```sh
$ mvn dependency:build-classpath -Dmdep.outputFile=cp.txt
```
This will generate a string in cp.txt containing all necessary jars separated by colon. You can then export the content as CLASSPATH environment variable as below.
```sh
$ export CLASSPATH=`cat cp.txt`:${PWD}/target/myapp-1.0-SNAPSHOT.jar
```
Then you should be able to run the program using the java command.
```text
$ java SpringBootSample.App

  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/

 :: Spring Boot ::                (v4.0.2)

2026-02-03T19:50:34.772+09:00  INFO 33160 --- [           main] SpringBootSample.App                     : Starting App v1.0-SNAPSHOT using Java 17.0.11 with PID 33160 (/Users/...
2026-02-03T19:50:34.773+09:00  INFO 33160 --- [           main] SpringBootSample.App                     : No active profile set, falling back to 1 default profile: "default"
...
```