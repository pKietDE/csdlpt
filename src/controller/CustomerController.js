const handler = require('../helper/handle_data');
const { Customer } = require('../model/Customer');



exports.getAllCustomerHorizontal1 = async (req, res) => {
    try {
        let customers = await Customer.getAllCustomerHorizontal1();
        

        // Lọc dữ liệu, chỉ thay thế trong các trường cần thiết
        const sanitizedCustomers = customers.map(c => ({
            ...c,
            DIACHI: handler.replaceText(c.DIACHI),
        }));

        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
};
exports.getAllCustomerHorizontal2 = async (req, res) => {
    try {
        let customers = await Customer.getAllCustomerHorizontal2();
        

        // Lọc dữ liệu, chỉ thay thế trong các trường cần thiết
        const sanitizedCustomers = customers.map(c => ({
            ...c,
            DIACHI: handler.replaceText(c.DIACHI),
        }));

        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
};
exports.getAllCustomerVertical_1 = async (req,res) => {
    try {
        let customers = await Customer.getAllCustomerVertical_1();
        

        // Lọc dữ liệu, chỉ thay thế trong các trường cần thiết
        const sanitizedCustomers = customers.map(c => ({
            ...c,
            DIACHI: handler.replaceText(c.DIACHI),
        }));

        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
};
exports.getAllCustomerVertical_2 = async (req,res) => {
    try {
        let customers = await Customer.getAllCustomerVertical_2();
        

        // Lọc dữ liệu, chỉ thay thế trong các trường cần thiết
        const sanitizedCustomers = customers.map(c => ({
            ...c,
            DIACHI: handler.replaceText(c.DIACHI),
        }));

        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
}
