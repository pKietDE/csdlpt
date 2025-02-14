const express = require('express');
const orderDetailController = require('../controller/OrderDetailController');
const router = express.Router();

router.get('/',orderDetailController.getAllOrderDetail);



module.exports = router;