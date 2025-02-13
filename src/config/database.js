const sql = require('mssql');

const config = {
  user: 'server_1',
  password: 'server1@',
  server: 'DESKTOP-C01JCR6',
  database: 'CSDLPTTH01_BT1',
  options: {
    encrypt: false,
    trustServerCertificate: true
  }
};

// * Kết nối SQL Server ngay khi file được chạy
const poolPromise = sql.connect(config)
  .then(pool => {
    console.log(' Kết nối SQL Server thành công!');
    return pool;
  })
  .catch(err => {
    console.error(' Lỗi kết nối SQL Server:', err);
    process.exit(1); // Dừng chương trình nếu lỗi
  });

module.exports = { sql, poolPromise };
