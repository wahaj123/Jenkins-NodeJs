const express = require('express')
const app = express()
const port = 3000

app.get('/', (req, res) => {
  res.send('Hello World!')
})

app.listen(port, () => {
  console.log(`Example app listening at http://localhost:${port}`)
})
mkdir nodejs
cd nodejs
aws s3 cp s3://wahaj-webserver/app.js /home/ec2-user/nodejs
npm install express

s3://wahaj-webserver/app.js