/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package bookstore.model;

import bookstore.util.OrderStatesEnum;
import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Pocsai Zsolt
 */
public class OrderDAOImpl implements OrderDAO {
    Connection dbConn;
    
    public OrderDAOImpl(Connection conn) {
        dbConn = conn;
    }
    
    @Override
    public ArrayList<Order> getAllOrders() {
        ArrayList<Order> orders = new ArrayList<>();
        Statement stm;
        String sql;
        ResultSet rs;
        
        sql = "SELECT * FROM rendeles";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while(rs.next()) {
                orders.add(
                    new Order(rs.getInt("rendelesszam"),
                            rs.getString("megrendelo"),
                            rs.getString("telefonszam"),
                            rs.getString("email"),
                            rs.getString("szallitasi_cim"),
                            rs.getDate("rendeles_datuma"),
                            OrderStatesEnum.valueOf(rs.getString("allapot")))
                );
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return orders;
    }
    
    @Override
    public int addOrder(Order order) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "INSERT INTO rendeles VALUES (" +
                "'" + order.getOrderNumber() + "', " +
                "'" + order.getCustomerName() + "', " +
                "'" + order.getPhoneNumber() + "', " +
                "'" + order.getEmailAddress() + "', " +
                "'" + order.getDeliveryAddress() + "', " +
                "SYSDATE, " +
                "'" + order.getState() + "')";
         
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int setStateOfOrder(int orderNumber, String state) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "UPDATE rendeles SET " +
                "allapot='" + state + "' " +
                "WHERE rendelesszam='" + orderNumber + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
    @Override
    public int deleteOrder(int orderNumber) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "DELETE FROM rendeles WHERE rendelesszam='" + orderNumber + "'";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch(SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
    
//------------------------------------------------------------------------------
    
    @Override
    public ArrayList<OrderItem> getAllOrderItems() {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Statement stm;
        ResultSet rs;
        String sql;
        
        sql = "SELECT * FROM rendeles_tetel";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                orderItems.add(
                    new OrderItem(
                        rs.getInt("rendelesszam"),
                        rs.getLong("isbn"),
                        rs.getInt("mennyiseg"))
                );
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return orderItems;
    }
    
    @Override
    public ArrayList<OrderItem> getOrderItems(int orderNumber) {
        ArrayList<OrderItem> orderItems = new ArrayList<>();
        Statement stm;
        ResultSet rs;
        String sql;
        
        sql = "SELECT * FROM rendeles_tetel WHERE " +
                "rendelesszam='" + orderNumber + "'";
        
        try {
            stm = dbConn.createStatement();
            rs = stm.executeQuery(sql);
            while (rs.next()) {
                orderItems.add(
                    new OrderItem(
                        rs.getInt("rendelesszam"),
                        rs.getInt("isbn"),
                        rs.getInt("mennyiseg"))
                );
            }
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return orderItems;
    }
    
    @Override
    public int addOrderItem(OrderItem orderItem) {
        Statement stm;
        String sql;
        int result = 0;
        
        sql = "INSERT INTO rendeles_tetel VALUES (" + 
                "'" + orderItem.getOrderNumber() + "', " +
                "'" + orderItem.getIsbn() + "', " +
                "'" + orderItem.getAmountOfItem() + "')";
        
        try {
            stm = dbConn.createStatement();
            result = stm.executeUpdate(sql);
            stm.close();
        } catch (SQLException e) {
            System.err.println(e);
        }
        
        return result;
    }
}
