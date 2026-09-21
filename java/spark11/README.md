## How to Test the Program
Set up java SDK (17 or higher) and maven as prerequisites.

1. Create a maven project. This will generate a simple Java code.
```sh
$ mvn archetype:generate -DgroupId=Spark11Sample -DartifactId=myapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
...
$ find . -type f
./myapp/pom.xml
./myapp/src/test/java/Spark11Sample/AppTest.java
./myapp/src/main/java/Spark11Sample/App.java

```
If maven ends up in error, try renaming the pom.xml that you have downloaded from git to something else and run the same maven command again.

2. Edit myapp/src/main/java/Spark11Sample/App.java and replace the code with the one in this git folder.

3. Merge these to the myapp/pom.xml.

```xml
    <properties>
      <maven.compiler.target>17</maven.compiler.target>
      <maven.compiler.source>17</maven.compiler.source>
    </properties>
    <dependencies>
      <dependency>
        <groupId>org.zoomba-lang</groupId>
        <artifactId>spark-core</artifactId>
        <version>3.0.5</version>
      </dependency>
      <dependency>
        <groupId>org.json</groupId>
        <artifactId>json</artifactId>
        <version>20260814</version>
      </dependency>
      <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13.2</version>
        <scope>test</scope>
      </dependency>
  </dependencies>
```

4. Build the program.
```sh
$ cd myapp
$ mvn compile package
```

5.  Run the program.
```sh
$ mvn exec:java -Dexec.mainClass=Spark11Sample.App
```
The program will listen on port 18080 and continue to run in the foreground. (Press CTRL-C when you want to stop the program.)

6. Open another terminal and execute the test.sh.
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
Then you should be able to run it using the java command.
```sh
$ java Spark11Sample.App
```
