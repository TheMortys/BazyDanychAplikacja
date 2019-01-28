'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')

const transakcja = sequelize.define('transakcja', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  data: Sequelize.DATE,
  kwota: Sequelize.FLOAT,
  docelowyNrKonta: {
    type: Sequelize.INTEGER,
    field: 'Docelowy_nr_konta'
  },
  tytul: {
    type: Sequelize.STRING,
    field: 'Tytuł'
  },
  kategoria: Sequelize.STRING,
  kontoId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Transakcja'
})

module.exports = transakcja
