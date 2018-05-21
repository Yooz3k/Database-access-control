package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Producer;

public class ProducerDAOImpl implements ProducerDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Producer producer) {
        String sql = "INSERT INTO Producenci " +
                "(Nazwa, Kraj) VALUES (?, ?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, producer.getName());
            ps.setString(2, producer.getCountry());
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
    public List<Producer> findAll() {
        String sql = "SELECT * FROM Producenci";
        
        Connection conn = null;
        List<Producer> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Producer producer = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                producer = new Producer(
                rs.getInt("ID"),
                rs.getString("Nazwa"),
                rs.getString("Kraj")
                );
                results.add(producer);
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
		String sql = "DELETE FROM Producenci WHERE ID = ?";
        
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
	public void updateById(int id, String name, String country) {
		String sql = "UPDATE Producenci SET Nazwa = '" + name + 
					"', Kraj = '" + country + "' WHERE ID = ?";
        
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
