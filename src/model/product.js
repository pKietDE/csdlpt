const { sql, poolPromise} = require('../config/database')

const Product = {
    getAllProductsHorizontal1: async () => {
    try{
        const pool = await poolPromise; // * Lấy kết nối đã có sẵn
        const result = await pool.query("SELECT * FROM SANPHAM1")
        return result.recordset;
    }catch(error) {
        console.error(' Lỗi truy vấn getAllProducts:', error);
        throw error;
    }
       
    },
    getAllProductsHorizontal2: async () => {
        try{
            const pool = await poolPromise; // * Lấy kết nối đã có sẵn
            const result = await pool.query("SELECT * FROM SANPHAM2")
            return result.recordset;
        }catch(error) {
            console.error(' Lỗi truy vấn getAllProducts:', error);
            throw error;
        }
           
        },
    getAllProductsVertical_1: async() => {
        try{
            const pool = await poolPromise;
            const result = await pool.query("SELECT * FROM SANPHAM_DOC_1")
            return result.recordset;
        }catch(error){
            console.error('Lỗi truy vấn getAllProductVertical:', error);
            throw error;
        }
    },
    getAllProductsVertical_2: async() => {
        try{
            const pool = await poolPromise;
            const result = await pool.query("SELECT * FROM SANPHAM_DOC_2")
            return result.recordset;
        }catch(error){
            console.error('Lỗi truy vấn getAllProductVertical:', error);
            throw error;
        }
    }
};

module.exports = { Product }