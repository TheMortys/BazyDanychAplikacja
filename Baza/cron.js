'use strict'
const cron = require('node-cron')
const sequelize = require('./lib/database/sequelize')

cron.schedule('0 0 * * *', () => {
  sequelize.query('CALL przeliczLokaty()')
})
