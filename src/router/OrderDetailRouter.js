const express = require('express');
const orderDetailController = require('../controller/OrderDetailController');
const router = express.Router();

router.get('/ngang/1',orderDetailController.getAllOrderDetailHorizontal1);
router.get('/ngang/2',orderDetailController.getAllOrderDetailHorizontal2);
router.get('/doc/1',orderDetailController.getAllOrderDetailVertical_1);
router.get('/doc/2',orderDetailController.getAllOrderDetailVertical_2);



module.exports = router;