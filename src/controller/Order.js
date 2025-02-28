const  order  = require('../model/Order')

exports.getAllOrderHorizontal1 = async (req,res) => {
    try {
        let dataStorage = await order.getAllOrderHorizontal1();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}

exports.getAllOrderHorizontal2 = async (req,res) => {
    try {
        let dataStorage = await order.getAllOrderHorizontal2();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}

exports.getAllOrderVertical_1 = async (req,res) => {
    try {
        let dataStorage = await order.getAllOrderVertical_1();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
exports.getAllOrderVertical_2 = async (req,res) => {
    try {
        let dataStorage = await order.getAllOrderVertical_2();
        res.status(200).json(dataStorage);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}