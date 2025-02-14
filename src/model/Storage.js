const { sql, poolPromise } = require('../config/database')

const Storage = {
    getAllStorage : async () => {
        try{
            const pool = await poolPromise; // * Lấy kết nối đã có sẵn
            const result = await pool.query("SELECT * FROM KHOHANG1")
            return result.recordset;
        }catch(error) {
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }
    }
}



module.exports = Storage