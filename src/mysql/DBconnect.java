/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Calendar;

/**
 *
 * @author verow
 */
public class DBconnect {
    private Connection conn;
    private Statement st;
    private ResultSet rs;
    
    public DBconnect(){
        String url = "jdbc:mysql://localhost:3306/";
        String dbName = "kamar_pasien";
        String driver = "com.mysql.cj.jdbc.Driver";
        String userName = "root";
        String password = "";
        
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url + dbName, userName, password);
            st = (Statement) conn.createStatement();
            System.out.println("Koneksi Sukses");
        } catch(Exception ex) {
            System.out.println("ErrorConnection: " + ex);
        }
    }
    
    public int getCountBank(){
        int rowCount = 0;
        try {
            String q = "SELECT count(*) as jum FROM data_kamar";
            rs = st.executeQuery(q);
            rs.next();
            rowCount = rs.getInt("jum");
        } catch (Exception ex){
            System.out.println("ErrorGetCount: " + ex);
        }
        return rowCount;
    }
    
    public Object[][] getDataBank(){
        Object[][] row = new Object[1000][3];
        try{
            String query = "SELECT * FROM data_kamar";
            rs = st.executeQuery(query);
            int i = 0;
            while(rs.next()){
                row[i][0] = rs.getString("kode_pasien");
                row[i][1] = rs.getString("nama_pasien");
                row[i][2] = rs.getString("kamar");
                i++;
            }
        } catch(Exception ex){
            System.out.println("ErrorGetData: " + ex);
        }
        return row;
    }
    
    public void setDataBank(String kode, String nama, String kamar){
        try{
            String q = "SELECT max(id) as maks from data_kamar";
            rs = st.executeQuery(q);
            rs.next();
            int rowCount = rs.getInt("maks");
            rowCount = rowCount+1;
        
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp lastUpdate = new java.sql.Timestamp(calendar.getTime().getTime());
            
            String query = " INSERT INTO data_kamar"
                    + "(id, kode_pasien, nama_pasien, kamar, last_update, user_update)"
                    + " values (?, ?, ?, ?, ?, ?)";
            
            PreparedStatement preparedStmt = 
                    (PreparedStatement) conn.prepareStatement(query);
            
            preparedStmt.setInt(1, rowCount);
            preparedStmt.setString(2, kode);
            preparedStmt.setString(3, nama);
            preparedStmt.setString(4, kamar);
            preparedStmt.setTimestamp(5, lastUpdate);
            preparedStmt.setInt(6, 1);
            
            preparedStmt.execute();
        } catch(Exception ex){
            System.out.println("ErrorSetData: " + ex);
        }
    }
    
    public void deleteBank(int kd){
        try {
            String query = " DELETE FROM data_kamar WHERE kode_pasien = ?";
            PreparedStatement preparedStmt = 
                    (PreparedStatement) conn.prepareStatement(query);
            preparedStmt.setInt(1, kd);
            preparedStmt.execute();
            preparedStmt.close();
        } catch(Exception ex){
            System.out.println("ErrorDelete: " + ex);
        }
    }
    
    public void updateBank(String kode, String nama, String kamar){
        try {
            Calendar calendar = Calendar.getInstance();
            java.sql.Timestamp lastUpdate = 
                    new java.sql.Timestamp(calendar.getTime().getTime());
            
            String query = " UPDATE data_kamar set "
                    + "nama_pasien = ?, kamar = ?, last_update = ? WHERE kode_pasien = ?";
            
            PreparedStatement preparedStmt = 
                    (PreparedStatement) conn.prepareStatement(query);
            
            preparedStmt.setString(1, nama);
            preparedStmt.setString(2, kamar);
            preparedStmt.setTimestamp(3, lastUpdate);
            preparedStmt.setString(4, kode);
            preparedStmt.execute();
            preparedStmt.close();
        } catch(Exception ex){
            System.out.println("ErrorUpdate: " + ex);
        }
    }
    
    
}
