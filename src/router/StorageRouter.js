const express = require('express')
const router = express.Router()
const storageController = require('../controller/StorageController')


router.get('/', storageController.getAllStorage)


module.exports = router