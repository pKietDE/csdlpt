const express = require('express');
const orderController = require('../controller/Order');
const router = express.Router();

router.get('/',orderController.getAllStorage);



module.exports = router;