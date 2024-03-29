# REST Framework Comparison
If you can freely choose a language and framework when implementing a REST server application that deals with JSON body, what would you choose? This is a collection of working codes in various languages with frameworks tested on MacOS and Linux (Ubuntu).

They all work stand-alone. Integration with other frameworks is not necessary.

Note that these are just codes. Depending on the language, Java in particular, you may need a lot more than the codes, like project and build files. Other languages usually require installation of additional packages like the framework to be used.

So which one do you like?

## Testing
The test script posts a JSON text to the REST server like this.
```ShellScript
#!/bin/sh

PORT=5000

curl -X POST -H "Content-Type: application/json" -d '{"name":"Taro"}' http://localhost:${PORT}/hello
```
Then the server parses the JSON body and returns a greeting in plain text.
```text
Hello Taro
```

# Codes
It is quite amazing that the amount of codes as little as these, and without huge configuration files, can run fully functioning web servers serving dynamic web contents. My first exposure to such a system was when I used Apache httpd-1.3.x with Perl CGI in Y2K. It was much messier back then. :)

Here we go.

## [Java](java/spark)
#### Framework: [Spark](http://sparkjava.com/)
```Java
package SparkSample;

import static spark.Spark.*;
import org.json.JSONObject;

public class App {
    public static void main(String[] args) {
	port(5000);
        post("/hello", (req, res) -> {
        	JSONObject body = new JSONObject(req.body());
        	return "Hello " + body.getString("name");
        });
    }
}
```

## [JavaScript](js)
#### Framework: [express](https://expressjs.com/)
```JavaScript
const express = require('express')
const bodyParser = require('body-parser');
const app = express()
const port = 5000

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post('/hello', (req, res) => res.send('Hello ' + req.body.name))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
```
## [Perl](perl)
#### Framework: [Mojolicious](https://mojolicious.org/)
```Perl
use Mojolicious::Lite;

post '/hello' => sub {
    my $c = shift;
    my $hash = $c->req->json;
    $c->render(text => 'Hello ' . $hash->{name}, format=>'txt');
};

my $port   = 5000;
my $daemon = Mojo::Server::Daemon->new(
  app    => app,
  listen => ["http://*:$port"]
);
$daemon->run;
```
## [Python](python)
#### Framework: [Flask](https://palletsprojects.com/p/flask/)
```Python
from flask import Flask, request
app = Flask(__name__)

@app.route('/hello', methods=['POST'])
def hello():
    data = request.get_json()
    return "Hello " + data['name']

app.run(host='0.0.0.0', port=5000, debug=True)
```

## [Ruby](ruby)
#### Framework: [Sinatra](http://sinatrarb.com/)
```Ruby
require 'sinatra'

set :port, 5000

post '/hello' do
  request.body.rewind
  data = JSON.parse request.body.read
  "Hello #{data['name']}!"
end
```

## More Frameworks

[Restlet](java/restlet)

This is a Java REST framework by [Talend](https://restlet.talend.com/). While it requires a little more codes than Spark even for a small example like this, an external configuration file is not necessary. It has a build-in web server, so integraion with another framework is not required.
