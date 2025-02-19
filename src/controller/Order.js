const  order  = require('../model/Order')

exports.getAllStorage = async (req,res) => {
    try {
        let dataStorage = await order.getAllOrder();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}