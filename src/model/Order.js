const { sql, poolPromise} = require('../config/database')

const Order = {
    getAllOrderHorizontal1: async () => {
    try{
        const pool = await poolPromise; // * Lấy kết nối đã có sẵn
        const result = await pool.query("SELECT * FROM HOADON1")
        return result.recordset;
    }catch(error) {
        console.error(' Lỗi truy vấn getAllProducts:', error);
        throw error;
    }
       
    },
    getAllOrderHorizontal2: async () => {
        try{
            const pool = await poolPromise; // * Lấy kết nối đã có sẵn
            const result = await pool.query("SELECT * FROM HOADON2")
            return result.recordset;
        }catch(error) {
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }
           
    },
    getAllOrderVertical_1: async () => {
        try{
            const pool = await poolPromise; // * Lấy kết nối đã có sẵn
            const result = await pool.query("SELECT * FROM HOADON_DOC_1")
            return result.recordset;
        }catch(error) {
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }
            
    },
    getAllOrderVertical_2: async () => {
        try{
            const pool = await poolPromise; // * Lấy kết nối đã có sẵn
            const result = await pool.query("SELECT * FROM HOADON_DOC_2")
            return result.recordset;
        }catch(error) {
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }
            
    },
};

module.exports = Order