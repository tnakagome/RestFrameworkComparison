## How to Test the Script
1. Set up ruby and gem. I have used [brew](https://brew.sh/) to install them on my Mac. You may also use the version that comes with the OS. I have not tested it though.
```sh
$ brew install ruby
```
For Linux, use a package manager like apt or yum to install the ruby interpreter.

2. Install [sinatra](http://sinatrarb.com/intro.html), [rackup](https://github.com/rack/rackup), and [puma](https://puma.io/).
```sh
$ gem install sinatra rackup puma
```

3. Create a directory and myapp.rb inside it, or you can copy the file from this git folder.
```sh
$ mkdir myapp
$ cd myapp
$ vi myapp.rb
```

4. Run the program.
```sh
% ./myapp.rb 
== Sinatra (v4.2.1) has taken the stage on 18080 for development with backup from Puma
Puma starting in single mode...
* Puma version: 8.0.2 ("Into the Arena")
* Ruby version: ruby 4.0.7 (2026-09-15 revision 229531a6cf) +PRISM [arm64-darwin25]
*  Min threads: 0
*  Max threads: 5
*  Environment: development
*          PID: 20760
* Listening on http://127.0.0.1:18080
* Listening on http://[::1]:18080
Use Ctrl-C to stop
```
5. Open another terminal and run the test script.
```sh
$ ./test.sh
Hello Taro!
```
Then the acess log appears on the other terminal running Sinatra.
```sh
::1 - - [21/Sep/2026:13:21:32 +0900] "POST /hello HTTP/1.1" 200 11 0.0016
```