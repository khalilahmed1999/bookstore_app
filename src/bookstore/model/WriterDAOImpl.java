/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookstore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pocsai Zsolt
 */
public class WriterDAOImpl implements WriterDAO {
    private Connection dbConn;
    
    public WriterDAOImpl(Connection conn) {
        dbConn = conn;
    }
    
    @Override
    public ArrayList<Writer> getWritersWithSoldBooks() {
        ArrayList<Writer> writers = new ArrayList<>();
        Writer tempWriter;
        Statement stm;
        ResultSet rs;
        String sql;
        
        sql = "SELECT szerzo, SUM(mennyiseg) AS darab " +
                "FROM szerzoje LEFT JOIN rendeles_tetel " +
                "ON szerzoje.isbn = rendeles_tetel.isbn " +
                "GROUP BY szerzo";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                tempWriter = new Writer(rs.getString("szerzo"));
                tempWriter.setNumberOfSoldBooks(rs.getInt("darab"));
                writers.add(tempWriter);
            }
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return writers;
    }
    
    @Override 
    public ArrayList<Writer> getAllWriter() {
        ArrayList<Writer> writers = new ArrayList<>();
        Statement stm;
        ResultSet rs;
        String sql;
        
        sql = "SELECT * FROM iro";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                writers.add(new Writer(rs.getString("nev")));
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return writers;
    }
    
    @Override
    public ArrayList<SumOfSoldBookByWriter> getListOfSoldBooksByWriter() {
        ArrayList<SumOfSoldBookByWriter> datas = new ArrayList<>();
        Statement stm;
        String sql;
        ResultSet rs;
        
        sql = "SELECT nev, tbl1.cim AS konyvcim, tbl2.eladott AS eladott_konyv " +
                "FROM iro " +
                "LEFT JOIN " + 
                "(SELECT szerzo, cim, konyv.isbn AS t_isbn " +
                "FROM szerzoje, konyv WHERE szerzoje.isbn = konyv.isbn) tbl1 " +
                "ON nev = szerzo " + 
                "LEFT JOIN " +
                "(SELECT isbn, sum(mennyiseg) AS eladott " +
                "FROM rendeles_tetel GROUP BY isbn) tbl2 " +
                "ON tbl1.t_isbn = tbl2.isbn ORDER BY nev";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                datas.add(new SumOfSoldBookByWriter(rs.getString("nev"), 
                        rs.getString("konyvcim"), rs.getInt("eladott_konyv")));
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println("Error at: getListOfSoldBooksByWriter()");
            System.err.println(sql);
            System.err.println(e);
        }
        return datas;
    }
}
