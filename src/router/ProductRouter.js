const express = require('express');
const productController = require('../controller/ProductController');
const router = express.Router();

router.get('/',productController.getAllProductsHorizontal);
router.get('/doc/manh1',productController.getAllProductsVertical_1);
router.get('/doc/manh2',productController.getAllProductsVertical_2);



module.exports = router;