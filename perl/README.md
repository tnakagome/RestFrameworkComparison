## How to Test the Script
You must have perl and cpan working. For MacOS, I have installed them from [brew](https://brew.sh/). For Linux, a package manager like apt or yum should do the job.

1. Follow the instructions in the [Mojolicious page](https://mojolicious.org/) to set up Mojolicious.
2. Create myapp.pl or copy the file from this git folder. Make sure that the first line points to the correct perl interpreter.
```sh
$ vi myapp.pl
```
3. Run the program.
```sh
$ chmod +x myapp.pl
$ ./myapp.pl deamon
[2026-09-21 13:01:26.23671] [18145] [info] Listening at "http://*:18080"
Web application available at http://127.0.0.1:18080
```
4. Open another terminal and run test.sh
```sh
$ ./test.sh
Hello Taro
```
5. Mojolicious framework will show the access log in the terminal.
```sh
[2026-09-21 13:01:30.26557] [18145] [trace] [N61YdRf7oRUM] POST "/hello"
[2026-09-21 13:01:30.26583] [18145] [trace] [N61YdRf7oRUM] Routing to a callback
[2026-09-21 13:01:30.26603] [18145] [trace] [N61YdRf7oRUM] 200 OK (0.000448s, 2232.143/s)
```
