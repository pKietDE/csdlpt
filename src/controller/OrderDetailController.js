const  orderDetail  = require('../model/Detail')

exports.getAllOrderDetailHorizontal1 = async (req,res) => {
    try {
        let dataStorage = await orderDetail.getAllOrderDetailHorizontal1();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getAllOrderDetailHorizontal2 = async (req,res) => {
    try {
        let dataStorage = await orderDetail.getAllOrderDetailHorizontal2();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}