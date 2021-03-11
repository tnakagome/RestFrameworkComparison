## How to Test the Program
Set up java SDK (8 or higher) and maven as prerequisites.

1. Create a maven project. This will generate a simple Java code.
```sh
$ mvn archetype:generate -DgroupId=SparkSample -DartifactId=myapp -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false
...
$ find . -type f
./myapp/pom.xml
./myapp/src/test/java/myapp/AppTest.java
./myapp/src/main/java/myapp/App.java

```
If maven ends up in error, try renaming the pom.xml that you have downloaded from git to something else and run the same maven command again.

2. Edit myapp/src/main/java/SparkSample/App.java and replace the code with the one in this git folder.

3. Merge these to the myapp/pom.xml. Do not delete the pre-existing junit dependency. The particular code is written using Java 1.8 syntax, so the properties section is necessary. It seems Maven defaults to Java 1.6.

```xml
    <properties>
      <maven.compiler.target>1.8</maven.compiler.target>
      <maven.compiler.source>1.8</maven.compiler.source>
    </properties>
    <dependencies>
    <dependency>
      <groupId>com.sparkjava</groupId>
      <artifactId>spark-core</artifactId>
      <version>2.8.0</version>
    </dependency>
    <dependency>
      <groupId>org.json</groupId>
      <artifactId>json</artifactId>
      <version>20200518</version>
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
$ mvn exec:java -Dexec.mainClass=SparkSample.App
```
The program will listen on port 5000 and continue to run in the foreground. (Press CTRL-C when you want to stop the program.)

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
$ java SparkSample.App
```
