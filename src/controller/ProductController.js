const { Product } = require('../model/product')

exports.getAllProducts = async (req,res) => {
    try {
        const product = await Product.getAllProducts();
        res.status(200).json(product);
      } catch (error) {
        res.status(500).json({ error: 'Database error' });
      }
}