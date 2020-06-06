## How to Test the Script

**Node packages are intentionally removed from this directory as there are too many. They will be created by installing the express framework.**

1. Install npm. For MacOS,
```sh
$ brew install npm
```
2. Create a working directory and cd into it.
```sh
$ mkdir myapp
$ cd myapp
```
3. Execute 'npm init' to create your app package. Follow the instruction in the [express page](https://expressjs.com/en/starter/installing.html) to create your npm package.
```sh
$ npm init
...
```
4. Install express. This command will download all necessary node packages into current directory.
```sh
$ npm install express --no-save
...
$ ls
node_modules/ package.json
```
5. Create myapp.js or copy the content from this git folder.
```sh
$ vi myapp.js
```
6. Create test.sh or copy the content from this git folder.
```sh
$ vi test.sh
```
7. Run the program.
```sh
$ node myapp.js
```
8. Open another terminal, move into the myapp dir, and run the test script.
```sh
$ cd myapp
$ ./test.sh
Hello Taro
```
