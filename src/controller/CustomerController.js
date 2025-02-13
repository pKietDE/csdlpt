const { Customer } = require('../model/Customer');

function handleData(text) {
    if (typeof text !== 'string') return text; // Kiểm tra nếu không phải string thì bỏ qua
    return text.replace(/\r\n/g, " ")  // Xóa ký tự xuống dòng Windows
               .replace(/\r/g, " ")    // Xóa ký tự xuống dòng đơn lẻ
               .replace(/\n/g, " ");   // Xóa ký tự xuống dòng Linux
}

exports.getAllCustomer = async (req, res) => {
    try {
        let customers = await Customer.getAllCustomer();
        

        // Lọc dữ liệu, chỉ thay thế trong các trường cần thiết
        const sanitizedCustomers = customers.map(c => ({
            ...c,
            TENKH: handleData(c.TENKH),
            DIACHI: handleData(c.DIACHI),
            SODIENTHOAI: handleData(c.SODIENTHOAI),
            LOAIKHACHHANG: handleData(c.LOAIKHACHHANG)
        }));

        res.status(200).json(sanitizedCustomers);
    } catch (e) {
        console.error(e);
        res.status(500).json({ error: `Database error: ${e.message}` });
    }
};
