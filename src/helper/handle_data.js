class HandleData  {
     replaceText(text) {
        if (typeof text !== 'string') return text; // Kiểm tra nếu không phải string thì bỏ qua
        return text.replace(/\r\n/g, "")  // Xóa ký tự xuống dòng Windows
                   .replace(/\r/g, "")    // Xóa ký tự xuống dòng đơn lẻ
                   .replace(/\n/g, "")   // Xóa ký tự xuống dòng Linux
    }


}

module.exports = new HandleData()



