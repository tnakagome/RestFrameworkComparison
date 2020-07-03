## How to Test the Script
1. Set up ruby and gem. I have used [brew](https://brew.sh/) to install them on my Mac. You may also use the version that comes with the OS. I have not tested it though.
```sh
$ brew install ruby
```
For Linux, use a package manager like apt or yum to install the ruby interpreter.

2. Install [sinatra](http://sinatrarb.com/intro.html).
```sh
$ gem install sinatra
```

3. Create a directory and myapp.rb inside it, or you can copy the file from this git folder.
```sh
$ mkdir myapp
$ cd myapp
$ vi myapp.rb
```

4. Run the program.
```sh
$ ruby myapp.rb 
/usr/local/lib/ruby/gems/2.7.0/gems/sinatra-2.0.8.1/lib/sinatra/base.rb:1526: warning: Using the last argument as keyword parameters is deprecated; maybe ** should be added to the call
/usr/local/lib/ruby/gems/2.7.0/gems/rack-2.2.2/lib/rack/handler/webrick.rb:26: warning: The called method `run' is defined here
[2020-06-07 10:50:17] INFO  WEBrick 1.6.0
[2020-06-07 10:50:17] INFO  ruby 2.7.1 (2020-03-31) [x86_64-darwin19]
== Sinatra (v2.0.8.1) has taken the stage on 5000 for development with backup from WEBrick
[2020-06-07 10:50:17] INFO  WEBrick::HTTPServer#start: pid=31757 port=5000
```
5. Open another terminal and run the test script.
```sh
$ ./test.sh
Hello Taro!
```
