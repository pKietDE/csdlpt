package baikiemtragiuaky;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.ConnectException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.JTextArea;

public class DataModel {

    public ArrayList<ArrayList<String>> get(String url) throws JSONException, IOException, InterruptedException {
        ArrayList<ArrayList<String>> datalist = new ArrayList<>();

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));

        // Kiểm tra nếu response body rỗng
        if (response.body().isEmpty()) {
            return datalist;
        }

        // Parse JSON từ API
        JSONArray jsonArray = new JSONArray(response.body());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            ArrayList<String> row = new ArrayList<>();

            // Duyệt qua tất cả key của object thay vì dùng key cứng
            Iterator<String> keys = obj.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                row.add(obj.get(key).toString()); // Thêm giá trị vào danh sách
            }

            datalist.add(row);
        }
        return datalist;
    }

    public ArrayList<ArrayList<String>> get(String url, String[] tenCot) throws JSONException, IOException, InterruptedException {
        ArrayList<ArrayList<String>> datalist = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
        System.out.println("Response from API (" + url + "): " + response.body());
        if (response.body().isEmpty()) {
            return datalist;
        }

        JSONArray jsonArray = new JSONArray(response.body());
        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            ArrayList<String> row = new ArrayList<>();

            // Thêm dữ liệu theo thứ tự cột được chỉ định
            for (String colName : tenCot) {
                row.add(obj.optString(colName, ""));
            }

            datalist.add(row);
        }
        return datalist;
    }

    public DefaultTableModel addTableModel(DefaultTableModel tableModel,
            ArrayList<ArrayList<String>> d,
            String tenCot[]) {
        if (tableModel == null) {
            tableModel = new DefaultTableModel(tenCot, 0);
        }
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

    public void getDataSanPham(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/sanpham/ngang/" + manh;
            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getDataSanPhamManh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/sanpham/doc/" + manh;
            System.out.print(url);

            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
    public void getDataKhachHangManh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khachhang/doc/" + manh;
            System.out.print(url);

            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
    public void getDataKhoHangManh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khohang/doc/" + manh;
            System.out.print(url);

            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
    public void getDataHoaDonManh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/hoadon/doc/" + manh;
            System.out.print(url);

            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
    public void getDataCTHoaDonManh(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/chitiethoadon/doc/" + manh;
            System.out.print(url);

            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getDataKhachHang(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khachhang/ngang/" + manh;
            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getDataKhoHang(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khohang/ngang/" + manh;
            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getDataHoaDon(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/hoadon/ngang/" + manh;
            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getDataChiTietHoaDon(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/chitiethoadon/ngang/" + manh;
            DataModel db = new DataModel();
            try {
                ArrayList<ArrayList<String>> a = db.get(url, tenCot);
                DefaultTableModel b = db.addTableModel(tableModel, a, tenCot);
                tblResult.setModel(b);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (IOException | InterruptedException | JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

public ArrayList<ArrayList<String>> ket(ArrayList<ArrayList<String>> a, ArrayList<ArrayList<String>> b) {
    ArrayList<ArrayList<String>> result = new ArrayList<>();
    
    // Tạo một HashMap để lưu trữ dữ liệu từ danh sách thứ hai (b) theo MASANPHAM
    HashMap<String, ArrayList<String>> mapB = new HashMap<>();
    for (ArrayList<String> itemB : b) {
        if (!itemB.isEmpty()) {
            mapB.put(itemB.get(0), itemB); // Lấy MASANPHAM làm key
        }
    }
    
    // Kết hợp dữ liệu từ danh sách a với dữ liệu tương ứng từ danh sách b
    for (ArrayList<String> itemA : a) {
        if (!itemA.isEmpty()) {
            String maSP = itemA.get(0); // Lấy MASANPHAM từ danh sách a
            
            ArrayList<String> combined = new ArrayList<>();
            
            // Thêm tất cả dữ liệu từ danh sách a
            combined.addAll(itemA);
            
            // Thêm dữ liệu từ danh sách b (ngoại trừ MASANPHAM vì đã có từ a)
            if (mapB.containsKey(maSP)) {
                ArrayList<String> itemB = mapB.get(maSP);
                for (int i = 1; i < itemB.size(); i++) {
                    combined.add(itemB.get(i));
                }
            }
            
            // Loại bỏ các cột rỗng (nếu muốn)
            ArrayList<String> finalCombined = new ArrayList<>();
            for (String value : combined) {
                if (value != null && !value.trim().isEmpty()) {
                    finalCombined.add(value);
                }
            }
            
            result.add(finalCombined);
        }
    }
    
    System.out.println("Dữ liệu sau khi kết hợp: " + result);
    return result;
}

    public ArrayList<ArrayList<String>> getManhSanPham(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return null;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> a = null;
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/sanpham/doc/" + manh;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;

    }
        public ArrayList<ArrayList<String>> getManhKhachHang(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return null;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> a = null;
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khachhang/doc/" + manh;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;

    }
        public ArrayList<ArrayList<String>> getManhKhoHang(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return null;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> a = null;
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/khohang/doc/" + manh;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;

    }
        public ArrayList<ArrayList<String>> getManhHoaDon(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return null;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> a = null;
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/hoadon/doc/" + manh;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;

    }
        public ArrayList<ArrayList<String>> getManhCTHoaDon(File f, DefaultTableModel tableModel, JTable tblResult,
            JTextArea txtError, String tenCot[], String manh) {
        if (f == null) {
            return null;
        }
        ArrayList<String> aIP = new ArrayList();
        try {
            BufferedReader bf = new BufferedReader(new FileReader(f));
            while (bf.ready()) {
                aIP.add(bf.readLine());
            }
            bf.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<ArrayList<String>> a = null;
        for (int i = 0; i < aIP.size(); i++) {
            String url = "http://" + aIP.get(i) + ":3000/chitiethoadon/doc/" + manh;
            DataModel db = new DataModel();
            try {
                a = db.get(url, tenCot);
                break;
            } catch (ConnectException e1) {
                String s = txtError.getText();
                s += "\n";
                s += url + " Down";
                txtError.setText(s);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return a;

    }

    public DefaultTableModel getTableModel(String[] tenCot, ArrayList<ArrayList<String>> d) {
        DefaultTableModel tableModel = new DefaultTableModel(tenCot, 0);
        for (int i = 0; i < d.size(); i++) {
            Object o[] = new Object[tenCot.length];
            for (int j = 0; j < d.get(i).size(); j++) {
                o[j] = d.get(i).get(j);
            }
            tableModel.addRow(o);
        }
        return tableModel;
    }

}
