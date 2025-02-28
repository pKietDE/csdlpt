const express = require('express');
const orderController = require('../controller/Order');
const router = express.Router();

router.get('/ngang/1',orderController.getAllOrderHorizontal1);
router.get('/ngang/2',orderController.getAllOrderHorizontal2);
router.get('/doc/1',orderController.getAllOrderVertical_1);
router.get('/doc/2',orderController.getAllOrderVertical_2);



module.exports = router;