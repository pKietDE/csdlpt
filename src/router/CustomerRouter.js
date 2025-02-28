const express = require('express')
const router = express.Router()
const customerController = require('../controller/CustomerController')

router.get('/ngang/1', customerController.getAllCustomerHorizontal1);
router.get('/ngang/2', customerController.getAllCustomerHorizontal2);
router.get('/doc/1', customerController.getAllCustomerVertical_1);
router.get('/doc/2', customerController.getAllCustomerVertical_2);

module.exports= router