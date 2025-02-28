const express = require('express')
const router = express.Router()
const storageController = require('../controller/StorageController')


router.get('/ngang/1', storageController.getAllStorageHorizontal1)
router.get('/ngang/2', storageController.getAllStorageHorizontal1)
router.get('/doc/1', storageController.getAllStorageVertical_1)
router.get('/doc/2', storageController.getAllStorageVertical_2)


module.exports = router