## How to Test the Program
Set up Java SDK (8 or higher) and maven as prerequisites.

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

4. Merge these to the myapp/pom.xml. Do not delete the pre-existing junit dependency. The particular code is written using Java 1.8 syntax, so the properties section is necessary. It seems Maven defaults to Java 1.6.

```xml
  <properties>
    <maven.compiler.target>1.8</maven.compiler.target>
    <maven.compiler.source>1.8</maven.compiler.source>
  </properties>
  <repositories>
    <repository>
      <id>maven-restlet</id>
      <name>Public online Restlet repository</name>
      <url>https://maven.restlet.talend.com</url>
    </repository>
  </repositories>
...
  <dependencies>
    ...
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20200518</version>
    </dependency>
    <dependency>
        <groupId>org.restlet.jse</groupId>
        <artifactId>org.restlet.ext.json</artifactId>
        <version>2.3.12</version>
    </dependency>
    <dependency>
      <groupId>org.restlet.jse</groupId>
      <artifactId>org.restlet</artifactId>
      <version>2.3.12</version>
    </dependency>
    <dependency>
      <groupId>org.restlet.jse</groupId>
      <artifactId>org.restlet.ext.simple</artifactId>
      <version>2.3.12</version>
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
```

7. Open another terminal and execute test.sh.
```sh
$ ./test.sh
Hello Taro
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
Starting the Simple [HTTP/1.1] server on port 5000
```
