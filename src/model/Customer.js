const { sql, poolPromise } = require('../config/database')


const Customer = {
    getAllCustomerHorizontal1: async () => {
        try {
            const pool = await poolPromise 
            const result = await pool.query("SELECT * FROM KHACHHANG1")
            return  result.recordset
        }catch (error){
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }

    },
    getAllCustomerHorizontal1: async () => {
        try {
            const pool = await poolPromise 
            const result = await pool.query("SELECT * FROM KHACHHANG2")
            return  result.recordset
        }catch (error){
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }

    }
}

module.exports = { Customer }
