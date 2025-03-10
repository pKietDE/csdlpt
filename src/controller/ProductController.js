const { Product } = require('../model/product')

exports.getAllProductsHorizontal1 = async (req,res) => {
    try {
        const product = await Product.getAllProductsHorizontal1();
        res.status(200).json(product);
      } catch (error) {
        res.status(500).json({ error: 'Database error' });
      }
}

exports.getAllProductsHorizontal2 = async (req,res) => {
  try {
      const product = await Product.getAllProductsHorizontal2();
      res.status(200).json(product);
    } catch (error) {
      res.status(500).json({ error: 'Database error' });
    }
}

exports.getAllProductsVertical_1 = async (req,res) => {
    try {
        const product = await Product.getAllProductsVertical_1();
        res.status(200).json(product);
      } catch (error) {
        res.status(500).json({ error: 'Database error' });
      }
}
exports.getAllProductsVertical_2 = async (req,res) => {
  try {
      const product = await Product.getAllProductsVertical_2();
      res.status(200).json(product);
    } catch (error) {
      res.status(500).json({ error: 'Database error' });
    }
}