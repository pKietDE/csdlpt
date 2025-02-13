const handler = require('../helper/handle_data');
const { Customer } = require('../model/Customer');



exports.getAllCustomer = async (req, res) => {
    try {
        let customers = await Customer.getAllCustomer();
        

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
