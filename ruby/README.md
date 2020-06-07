## How to Test the Script
1. Set up ruby and gem. I have used [brew](https://brew.sh/) to install them on my Mac. You may also use the version that comes with the OS. I have not tested it though.
```sh
$ brew install ruby
```

2. Install [sinatra](http://sinatrarb.com/intro.html).
```sh
$ gem install sinatra
```

3. Create a directory and myapp.rb inside it, or you can copy the file from this git folder.
```sh
$ mkdir myapp
$ cd myapp
$vi myapp.rb
```

4. Run the program.
```sh
$ ruby myapp.rb
uby/gems/2.7.0/gems/sinatra-2.0.8.1/lib/sinatra/base.rb:1526: warning: Using the last argument as keyword parameters is deprecated; maybe ** should be added to the call
/usr/local/lib/ruby/gems/2.7.0/gems/rack-2.2.2/lib/rack/handler/webrick.rb:26: warning: The called method `run' is defined here
[2020-06-07 10:41:54] INFO  WEBrick 1.6.0
[2020-06-07 10:41:54] INFO  ruby 2.7.1 (2020-03-31) [x86_64-darwin19]
== Sinatra (v2.0.8.1) has taken the stage on 4567 for development with backup from WEBrick
[2020-06-07 10:41:54] INFO  WEBrick::HTTPServer#start: pid=31563 port=4567
```
5. Open another terminal and run the test script.
```sh
$ cd myapp
$ ./test.sh
Hello Taro!
```
