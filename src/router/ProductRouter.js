const express = require('express');
const productController = require('../controller/ProductController');
const router = express.Router();

router.get('/ngang/1',productController.getAllProductsHorizontal1);
router.get('/ngang/2',productController.getAllProductsHorizontal2);
router.get('/doc/manh1',productController.getAllProductsVertical_1);
router.get('/doc/manh2',productController.getAllProductsVertical_2);



module.exports = router;