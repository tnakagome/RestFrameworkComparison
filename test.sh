#!/bin/sh

PORT=5000

curl -X POST -H "Content-Type: application/json" -d '{"name":"Taro"}' http://localhost:${PORT}/hello
