package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Part;

public class PartDAOImpl extends BaseDAO implements PartDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Part part) {
        String sql = "INSERT INTO Czesci " +
                "(NumerKatalogowy, Nazwa, StanMagazynowy, CenaDetaliczna, Kategoria, "
                + "ID_Magazynu, ID_Producenta) VALUES (?, ?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, part.getStockNumber());
            ps.setString(2, part.getName());
            ps.setInt(3, part.getAmount());
            ps.setDouble(4, part.getPrice());
            ps.setString(5, part.getCategory());
            ps.setInt(6, part.getWarehouseId());
            ps.setInt(7, part.getProducerId());
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
    public List<Part> findAll() {
        String sql = "SELECT * FROM Czesci";
        
        Connection conn = null;
        List<Part> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Part part = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                part = new Part(
                rs.getInt("ID"),
                rs.getString("NumerKatalogowy"),
                rs.getString("Nazwa"),
                rs.getInt("StanMagazynowy"),
                rs.getDouble("CenaDetaliczna"),
                rs.getString("Kategoria"),
                rs.getInt("ID_Magazynu"),
                rs.getInt("ID_Producenta")
                );
                results.add(part);
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
		String sql = "DELETE FROM Czesci WHERE ID = ?";
		
		System.out.println("Usuwane ID: " + id);
        
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
	public void update(Part part) {
		String sql = "UPDATE Czesci SET NumerKatalogowy = '" + part.getStockNumber() + 
				"', Nazwa = '" + part.getName() +  
				"', StanMagazynowy = '" + part.getAmount() + 
				"', CenaDetaliczna = '" + part.getPrice() + 
				"', Kategoria = '" + part.getCategory() + "' WHERE ID = ?";
        
        Connection conn = null;
        
        //Part updatedPart = find(part.getPartId());
        try {
        	conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, part.getPartId());
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
	public Part find(int id) {
		String sql = "SELECT * FROM Czesci WHERE ID = ?";
        
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Part result = null;
            ResultSet rs = ps.executeQuery();
            result = new Part(
            		rs.getInt("ID"),
            		rs.getString("NumerKatalogowy"),
            		rs.getString("Nazwa"),
            		rs.getInt("StanMagazynowy"),
            		rs.getDouble("CenaDetaliczna"),
            		rs.getString("Kategoria"),
            		rs.getInt("ID_Magazynu"),
            		rs.getInt("ID_Producenta")
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
