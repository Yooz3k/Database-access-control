package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Supplier;

public class SupplierDAOImpl implements SupplierDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Supplier supplier) {
        String sql = "INSERT INTO Dostawcy " +
                "(Nazwa, Miasto, Telefon, DataRozpoczeciaWspolpracy) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getCity());
            ps.setString(3, supplier.getPhoneNumber());
            ps.setDate(4, supplier.getCooperationStartDate());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
    /*
    @Override
    public Producer findById(int id) {
        String sql = "SELECT * FROM Producenci WHERE id = ?";
        
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Producer producer = null;
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                producer = new Producer(
                rs.getInt("ID"),
                rs.getString("Nazwa"),
                rs.getString("Kraj")
                );
            }
            rs.close();
            ps.close();
            return producer;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }
    */
    @Override
    public List<Supplier> findAll() {
        String sql = "SELECT * FROM Dostawcy";
        
        Connection conn = null;
        List<Supplier> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Supplier supplier = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                supplier = new Supplier(
                rs.getInt("ID"),
                rs.getString("Nazwa"),
                rs.getString("Miasto"),
                rs.getString("Telefon"),
                rs.getDate("DataRozpoczeciaWspolpracy")
                );
                results.add(supplier);
            }
            rs.close();
            ps.close();
            return results;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
    }

	@Override
	public void deleteById(int id) {
		String sql = "DELETE FROM Dostawcy WHERE ID = ?";
        
        Connection conn = null;
        
        try {
        	conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }
	}

	@Override
	public void updateById(int id, String name, String city, String phoneNumber, Date cooperationStartDate) {
		String sql = "UPDATE Dostawcy SET Nazwa = '" + name + "', Miasto = '" + city +  "', Telefon = '" + 
				phoneNumber + "', DataRozpoczeciaWspolpracy = '" + cooperationStartDate + "' WHERE ID = ?";
        
        Connection conn = null;
        
        try {
        	conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {}
            }
        }		
	}
}
