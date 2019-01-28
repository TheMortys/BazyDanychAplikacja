'use strict'
const Sequelize = require('sequelize')
const sequelize = require('../sequelize')

const pozyczka = sequelize.define('pozyczka', {
  id: {
    type: Sequelize.UUID,
    primaryKey: true,
    autoIncrement: true
  },
  kwota: Sequelize.FLOAT,
  oprocentowanie: Sequelize.FLOAT,
  terminSplaty: {
    type: Sequelize.DATE,
    field: 'Termin_spłaty'
  },
  dataUtworzenia: {
    type: Sequelize.DATE,
    field: 'Data_utworzenia'
  },
  kontoId: Sequelize.INTEGER
}, {
  timestamps: false,
  tableName: 'Pożyczka'
})

module.exports = pozyczka
