#!/bin/sh

PORT=55555

curl -X POST -H "Content-Type: application/json" -d '{"name":"Taro"}' http://localhost:${PORT}/hello
