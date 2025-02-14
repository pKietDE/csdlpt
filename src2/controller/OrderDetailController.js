const  orderDetail  = require('../model/Detail')

exports.getAllOrderDetail = async (req,res) => {
    try {
        let dataStorage = await orderDetail.getAllOrderDetail();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}