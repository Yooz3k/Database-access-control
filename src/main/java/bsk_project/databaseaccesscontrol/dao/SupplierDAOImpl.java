package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Supplier;

public class SupplierDAOImpl extends BaseDAO implements SupplierDAO {
	
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
	public void update(Supplier supplier) {
		String sql = "UPDATE Dostawcy SET Nazwa = '" + supplier.getName() +
				"', Miasto = '" + supplier.getCity() +  "', Telefon = '" + 
				supplier.getPhoneNumber() + "', DataRozpoczeciaWspolpracy = '" +
				supplier.getCooperationStartDate() + "' WHERE ID = ?";
        
        Connection conn = null;
        
        try {
        	conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, supplier.getSupplierId());
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
	public Supplier find(int id) {
		String sql = "SELECT * FROM Dostawcy WHERE ID = ?";
        
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Supplier result = null;
            ResultSet rs = ps.executeQuery();
            result = new Supplier(
            		 rs.getInt("ID"),
                     rs.getString("Nazwa"),
                     rs.getString("Miasto"),
                     rs.getString("Telefon"),
                     rs.getDate("DataRozpoczeciaWspolpracy")
            );
            rs.close();
            ps.close();
            return result;
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
