'use strict'
const Sequelize = require('sequelize')
const config = require('./config/config-local.json')
let sequelize = new Sequelize(config.database, config.username, config.password, config)

module.exports = sequelize
