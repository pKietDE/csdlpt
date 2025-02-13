const express = require('express'); // Cần sử dụng Express để xử lý HTTP request
const app = express(); // Tạo ứng dụng Express
const productRouter = require('./router/ProductRouter') 
const customerRouter = require('./router/CustomerRouter') 
const storageRouter = require('./router/StorageRouter')
const port = '3000';


app.get('/', (req, res) => {
  res.send('Server is running!');
});
app.use(express.json());

app.use('/sanpham',productRouter)
app.use('/khachhang', customerRouter)
app.use('/khohang', storageRouter)
  

// Lắng nghe trên cổng 3000
app.listen(port, '0.0.0.0',() => {
  console.log(`Server running at http://localhost:${port}}`);
});