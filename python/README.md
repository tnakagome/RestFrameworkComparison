## How to Test the Script
I have used the python command that comes with MacOS. The version is 2.7.16. For Linux, use a package manager like apt or yum to install python in case you do not have one. I used 2.7.12 that came with Ubuntu 16.04. You also need the pip command.

1. Follow the [instruction](https://flask.palletsprojects.com/en/1.1.x/installation/) on the Flask website to install Flask framework. It is up to you whether to use venv. I do not.
2. Create a directory and myapp.py inside it, or you can copy the file from this git folder.
```sh
$ mkdir myapp
$ cd myapp
$ vi myapp.py
```
3. Run the program.
```sh
$ chmod +x myapp.py
$ ./myapp.py 
 * Serving Flask app "myapp" (lazy loading)
 * Environment: production
   WARNING: Do not use the development server in a production environment.
   Use a production WSGI server instead.
 * Debug mode: on
 * Running on http://0.0.0.0:5000/ (Press CTRL+C to quit)
 * Restarting with stat
 * Debugger is active!
 * Debugger PIN: 392-403-575
```
4. Open another terminal, go into the same myapp directory, and run the test script.
```sh
$ ./test.sh
Hello Taro
```
5. The Flask framework will print access log to the terminal where it is running.
```sh
$ ./myapp.py 
127.0.0.1 - - [06/Jun/2020 19:52:06] "POST /hello HTTP/1.1" 200 -
```
