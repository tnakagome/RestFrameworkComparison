## How to Test the Script
You must have perl and cpan working. I have installed them from [brew](https://brew.sh/).

1. Follow the instructions in the [Mojolicious page](https://mojolicious.org/) to set up Mojolicious.
2. Create myapp.pl or copy the file from this git folder.
```sh
$ vi myapp.pl
```
3. Run the program.
```sh
$ chmod +x myapp.pl
$ ./myapp.pl deamon
[2020-06-06 19:10:57.15360] [26130] [info] Listening at "http://*:3000"
Server available at http://127.0.0.1:3000
```
4. Open another terminal and run test.sh
```sh
$ ./test.sh
Hello Taro
```
5. Mojolicious framework will show the access log in the terminal.
```sh
[2020-06-06 19:11:25.73942] [26130] [debug] [tNmWX7q9] POST "/hello"
[2020-06-06 19:11:25.73965] [26130] [debug] [tNmWX7q9] Routing to a callback
[2020-06-06 19:11:25.73992] [26130] [debug] [tNmWX7q9] 200 OK (0.000489s, 2044.990/s)
```
