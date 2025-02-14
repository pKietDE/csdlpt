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
    
    public DefaultTableModel addTableModel( DefaultTableModel tableModel, 
        ArrayList<ArrayList<String>> d,
        String tenCot[]){
         if( tableModel == null){
         tableModel = new DefaultTableModel(tenCot, 0);
         }
         for(int i=0;i<d.size();i++){
         Object o[] =new Object[tenCot.length];
         for(int j=0;j<d.get(i).size();j++){
         o[j] = d.get(i).get(j);
         }
         tableModel.addRow(o); 
         }
         return tableModel;
    }
    
    public void getDataSanPham( File f, DefaultTableModel tableModel, JTable tblResult, 
        JTextArea txtError, String tenCot[]){
         if( f == null ){ return; }
         ArrayList<String> aIP = new ArrayList();
         try{
         BufferedReader bf = new BufferedReader(new FileReader(f));
         while( bf.ready() ){
         aIP.add( bf.readLine() );
         }
         bf.close();
         }catch(Exception e){
         e.printStackTrace();
         }
         for(int i=0; i < aIP.size(); i++){
         String url="http://" + aIP.get(i) + ":3000/sanpham";
         DataModel db = new DataModel(); 
         try{
         ArrayList<ArrayList<String>> a = db.get(url);
         DefaultTableModel b = db.addTableModel(tableModel, a,tenCot);
         tblResult.setModel(b);
         break;
         }
         catch(ConnectException e1){
         String s = txtError.getText();
         s+="\n";
         s+=url+" Down";
         txtError.setText(s);
         }
         catch(IOException | InterruptedException | JSONException e2){
         e2.printStackTrace();
            }
        }
    }
    public void getDataKhachHang( File f, DefaultTableModel tableModel, JTable tblResult, 
        JTextArea txtError, String tenCot[]){
         if( f == null ){ return; }
         ArrayList<String> aIP = new ArrayList();
         try{
         BufferedReader bf = new BufferedReader(new FileReader(f));
         while( bf.ready() ){
         aIP.add( bf.readLine() );
         }
         bf.close();
         }catch(Exception e){
         e.printStackTrace();
         }
         for(int i=0; i < aIP.size(); i++){
         String url="http://" + aIP.get(i) + ":3000/khachhang";
         DataModel db = new DataModel(); 
         try{
         ArrayList<ArrayList<String>> a = db.get(url);
         DefaultTableModel b = db.addTableModel(tableModel, a,tenCot);
         tblResult.setModel(b);
         break;
         }
         catch(ConnectException e1){
         String s = txtError.getText();
         s+="\n";
         s+=url+" Down";
         txtError.setText(s);
         }
         catch(IOException | InterruptedException | JSONException e2){
         e2.printStackTrace();
            }
        }
    }

    public void getDataKhoHang( File f, DefaultTableModel tableModel, JTable tblResult, 
        JTextArea txtError, String tenCot[]){
         if( f == null ){ return; }
         ArrayList<String> aIP = new ArrayList();
         try{
         BufferedReader bf = new BufferedReader(new FileReader(f));
         while( bf.ready() ){
         aIP.add( bf.readLine() );
         }
         bf.close();
         }catch(Exception e){
         e.printStackTrace();
         }
         for(int i=0; i < aIP.size(); i++){
         String url="http://" + aIP.get(i) + ":3000/khohang";
         DataModel db = new DataModel(); 
         try{
         ArrayList<ArrayList<String>> a = db.get(url);
         DefaultTableModel b = db.addTableModel(tableModel, a,tenCot);
         tblResult.setModel(b);
         break;
         }
         catch(ConnectException e1){
         String s = txtError.getText();
         s+="\n";
         s+=url+" Down";
         txtError.setText(s);
         }
         catch(IOException | InterruptedException | JSONException e2){
         e2.printStackTrace();
            }
        }
    }
    public void getDataHoaDon( File f, DefaultTableModel tableModel, JTable tblResult, 
        JTextArea txtError, String tenCot[]){
         if( f == null ){ return; }
         ArrayList<String> aIP = new ArrayList();
         try{
         BufferedReader bf = new BufferedReader(new FileReader(f));
         while( bf.ready() ){
         aIP.add( bf.readLine() );
         }
         bf.close();
         }catch(Exception e){
         e.printStackTrace();
         }
         for(int i=0; i < aIP.size(); i++){
         String url="http://" + aIP.get(i) + ":3000/hoadon";
         DataModel db = new DataModel(); 
         try{
         ArrayList<ArrayList<String>> a = db.get(url);
         DefaultTableModel b = db.addTableModel(tableModel, a,tenCot);
         tblResult.setModel(b);
         break;
         }
         catch(ConnectException e1){
         String s = txtError.getText();
         s+="\n";
         s+=url+" Down";
         txtError.setText(s);
         }
         catch(IOException | InterruptedException | JSONException e2){
         e2.printStackTrace();
            }
        }
    }
    
    public void getDataChiTietHoaDon( File f, DefaultTableModel tableModel, JTable tblResult, 
        JTextArea txtError, String tenCot[]){
         if( f == null ){ return; }
         ArrayList<String> aIP = new ArrayList();
         try{
         BufferedReader bf = new BufferedReader(new FileReader(f));
         while( bf.ready() ){
         aIP.add( bf.readLine() );
         }
         bf.close();
         }catch(Exception e){
         e.printStackTrace();
         }
         for(int i=0; i < aIP.size(); i++){
         String url="http://" + aIP.get(i) + ":3000/chitiethoadon";
         DataModel db = new DataModel(); 
         try{
         ArrayList<ArrayList<String>> a = db.get(url);
         DefaultTableModel b = db.addTableModel(tableModel, a,tenCot);
         tblResult.setModel(b);
         break;
         }
         catch(ConnectException e1){
         String s = txtError.getText();
         s+="\n";
         s+=url+" Down";
         txtError.setText(s);
         }
         catch(IOException | InterruptedException | JSONException e2){
         e2.printStackTrace();
            }
        }
    }
}
