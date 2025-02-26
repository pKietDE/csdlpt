const  storage  = require('../model/Storage')
const handler = require('../helper/handle_data');


exports.getAllStorageHorizontal1 = async (req,res) => {
    try {
        let dataStorage = await storage.getAllStorageHorizontal1();
        
        const sanitizedCustomers = dataStorage.map(e => ({...e, DIACHI: handler.replaceText(e.DIACHI)}))
        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}

exports.getAllStorageHorizontal2 = async (req,res) => {
    try {
        let dataStorage = await storage.getAllStorageHorizontal2();
        
        const sanitizedCustomers = dataStorage.map(e => ({...e, DIACHI: handler.replaceText(e.DIACHI)}))
        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}