#!/usr/bin/python -d

from flask import Flask, request
app = Flask(__name__)

@app.route('/hello', methods=['POST'])
def hello():
    data = request.get_json()
    return "Hello " + data['name']

app.run(host='0.0.0.0', port=5000, debug=True)
