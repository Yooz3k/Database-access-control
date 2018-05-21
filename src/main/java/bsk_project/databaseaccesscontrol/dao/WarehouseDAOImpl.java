package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Warehouse;

public class WarehouseDAOImpl implements WarehouseDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Warehouse warehouse) {
        String sql = "INSERT INTO Magazyny " +
                "(Wielkosc) VALUES (?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, warehouse.getCapacity());
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
    public List<Warehouse> findAll() {
        String sql = "SELECT * FROM Magazyny";
        
        Connection conn = null;
        List<Warehouse> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Warehouse warehouse = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                warehouse = new Warehouse(
                rs.getInt("ID"),
                rs.getInt("Wielkosc")
                );
                results.add(warehouse);
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
		String sql = "DELETE FROM Magazyny WHERE ID = ?";
        
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
	public void updateById(int id, int capacity) {
		String sql = "UPDATE Magazyny SET Wielkosc = " + capacity + " WHERE ID = ?";
        
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
