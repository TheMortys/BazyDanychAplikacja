'use strict'
const express = require('express')
const bodyParser = require('body-parser')

const passport = require('passport')

const app = express()

const authRoutes = require('./lib/express/routes/auth')
const klientRoutes = require('./lib/express/routes/klient')
const pracownikRoutes = require('./lib/express/routes/pracownik')

app.use(passport.initialize())
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
  extended: false
}))

app.use('/auth', authRoutes)
app.use('/klient', klientRoutes)
app.use('/pracownik', pracownikRoutes)

// catch 404 and forward to error handler
app.use((req, res, next) => {
  let err = new Error('Not Found')
  err.status = 404
  next(err)
})

app.use((err, req, res, next) => {
  res.status(err.status || 500)
  let response = {
    message: err.message
  }
  if (app.get('env') === 'development') response.error = err
  res.send(response)
})

let server = app.listen(3000, () => {
  console.log('App listening on port 3000!')
})

process.on('SIGINT', () => {
  console.info('SIGINT signal received.')
  server.close((err) => {
    if (err) console.log(err)
    process.exit(1)
  })
})

module.exports = app
