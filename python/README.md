## How to Test the Script
I have installed Python 3.14.6 using homebrew on my Mac. For Linux, use a package manager like apt or yum to install python in case you do not have one. You also need the pip command.

1. Create a directory and myapp.py inside it, or you can copy the file from this git folder.
```sh
$ mkdir myapp
$ cd myapp
$ vi myapp.py
```
2. Follow the [instruction](https://flask.palletsprojects.com/en/1.1.x/installation/) on the Flask website to install Flask framework. `venv` is recommended.
```sh
$ python3 -m venv .venv

$ source .venv/bin/activate
(.venv)
$ pip install flask
Collecting flask
  Downloading flask-3.1.3-py3-none-any.whl.metadata (3.2 kB)
...
```
3. Run the program.
```sh
$ chmod +x myapp.py
% ./myapp.py
 * Serving Flask app 'myapp'
 * Debug mode: on
WARNING: This is a development server. Do not use it in a production deployment. Use a production WSGI server instead.
 * Running on all addresses (0.0.0.0)
 * Running on http://127.0.0.1:18080
 * Running on http://192.168.10.104:18080
Press CTRL+C to quit
 * Restarting with stat
 * Debugger is active!
 * Debugger PIN: 108-172-237
```
4. Open another terminal, go into the parent directory above `myapp`, and run the test script.
```sh
$ ./test.sh
Hello Taro
```
5. The Flask framework will print access log to the terminal where it is running.
```sh
127.0.0.1 - - [21/Sep/2026 16:21:14] "POST /hello HTTP/1.1" 200 -
```
