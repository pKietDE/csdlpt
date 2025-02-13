const  storage  = require('../model/Storage')
const handler = require('../helper/handle_data');


exports.getAllStorage = async (req,res) => {
    try {
        let dataStorage = await storage.getAllStorage();
        
        const sanitizedCustomers = dataStorage.map(e => ({...e, DIACHI: handler.replaceText(e.DIACHI)}))
        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}