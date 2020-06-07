const express = require('express')
const bodyParser = require('body-parser');
const app = express()
const port = 5000

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: true }));

app.post('/hello', (req, res) => res.send('Hello ' + req.body.name))

app.listen(port, () => console.log(`Example app listening on port ${port}!`))
