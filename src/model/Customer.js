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
    getAllCustomerHorizontal2: async () => {
        try {
            const pool = await poolPromise 
            const result = await pool.query("SELECT * FROM KHACHHANG2")
            return  result.recordset
        }catch (error){
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }

    },   
    getAllCustomerVertical_1: async() => {
        try{
            const pool = await poolPromise;
            const result = await pool.query("SELECT * FROM KHACHHANG_DOC_1")
            return result.recordset;
        }catch(error){
            console.error('Lỗi truy vấn getAllProductVertical:', error);
            throw error;
        }
    },
    getAllCustomerVertical_2: async() => {
        try{
            const pool = await poolPromise;
            const result = await pool.query("SELECT * FROM KHACHHANG_DOC_2")
            return result.recordset;
        }catch(error){
            console.error('Lỗi truy vấn getAllProductVertical:', error);
            throw error;
        }
    }
}

module.exports = { Customer }
