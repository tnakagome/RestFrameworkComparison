## About

This example does not use IntelliJ IDEA. All functionality is written in one kt file.

## How to Test the Program

Install JDK (17 or higher) and gradle as prerequisites.

1. Open a terminal. Create a working directrory and execute the following command in it.
```
$ gradle init
Select type of build to generate:
  1: Application
  2: Library
  3: Gradle plugin
  4: Basic (build structure only)
Enter selection (default: Application) [1..4] 4

Project name (default: test): 

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 1

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no] 

$ mkdir -p src/main/kotlin
```
It will generate several files.

2. Copy the KtorSample.kt into `src/main/kotlin`.

3. Overwrite the build.gradle.kts with the one in this repo.

4. Build and run it.
```
$ ./gradlew run
Calculating task graph as no cached configuration is available for tasks: run

> Task :run
SLF4J(W): No SLF4J providers were found.
SLF4J(W): Defaulting to no-operation (NOP) logger implementation
SLF4J(W): See https://www.slf4j.org/codes.html#noProviders for further details.
│████████████▌··│ 83% EXECUTING [18s]
```
5. Open another terminal and run the test script.
```
$ ../../../test.sh
Hello, Taro
```
To test the GET capability, use telnet:
```
$ telnet localhost 18080
Trying ::1...
Connected to localhost.
Escape character is '^]'.
GET /hi/Taro HTTP/1.0

HTTP/1.0 200 OK
Content-Length: 12
Content-Type: text/plain; charset=UTF-8

Hello, Taro!
```

## Note
In the `KtorSample.kt`, the section between lines 26 and 41:
```
        install(StatusPages) {
            ...
        }
```
is not really required. It is for debugging. When something happens in the server app, the stack trace will be sent to the client side.