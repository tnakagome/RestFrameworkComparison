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
[2020-06-07 11:17:35.43446] [32338] [info] Listening at "http://*:5000"
Server available at http://127.0.0.1:5000
```
4. Open another terminal and run test.sh
```sh
$ ./test.sh
Hello Taro
```
5. Mojolicious framework will show the access log in the terminal.
```sh
[2020-06-07 11:17:42.00306] [32338] [debug] [u8tbxFkf] POST "/hello"
[2020-06-07 11:17:42.00362] [32338] [debug] [u8tbxFkf] Routing to a callback
[2020-06-07 11:17:42.00431] [32338] [debug] [u8tbxFkf] 200 OK (0.001236s, 809.061/s)
```
