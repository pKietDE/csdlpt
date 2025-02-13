const express = require('express')
const router = express.Router()
const customerController = require('../controller/CustomerController')

router.get('/', customerController.getAllCustomer);

module.exports = router