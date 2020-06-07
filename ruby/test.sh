#!/bin/sh

PORT=4567

curl -X POST -H "Content-Type: application/json" -d '{"name":"Taro"}' http://localhost:${PORT}/hello
