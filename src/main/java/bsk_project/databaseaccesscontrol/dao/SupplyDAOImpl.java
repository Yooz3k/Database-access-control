package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Supply;

public class SupplyDAOImpl extends BaseDAO implements SupplyDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Supply supply) {
        String sql = "INSERT INTO Dostawy " +
                "(NumerPrzewozowy, DataOdbioru, GodzinaOdbioru, ID_Dostawcy, ID_Magazyniera, "
                + "ID_Magazynu) VALUES (?, ?, ?, ?, ?, ?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, supply.getShippingNumber());
            ps.setDate(2, supply.getShippingDate());
            ps.setTime(3, supply.getShippingTime());
            ps.setInt(4, supply.getSupplierId());
            ps.setInt(5, supply.getWarehousemanId());
            ps.setInt(6, supply.getWarehouseId());
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
    public List<Supply> findAll() {
        String sql = "SELECT * FROM Dostawy";
        
        Connection conn = null;
        List<Supply> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Supply supply = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                supply = new Supply(
                rs.getInt("ID"),
                rs.getString("NumerPrzewozowy"),
                rs.getDate("DataOdbioru"),
                rs.getTime("GodzinaOdbioru"),
                rs.getInt("ID_Dostawcy"),
                rs.getInt("ID_Magazyniera"),
                rs.getInt("ID_Magazynu")
                );
                results.add(supply);
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
		String sql = "DELETE FROM Dostawy WHERE ID = ?";
        
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
	public void update(Supply supply) {
		String sql = "UPDATE Dostawy SET NumerPrzewozowy = '" +
				supply.getShippingNumber() + "', DataOdbioru = '" +
				supply.getShippingDate() +  "', GodzinaOdbioru = '" +
				supply.getShippingTime() + "', ID_Dostawcy = '" +
				supply.getSupplierId() + "', ID_Magazyniera = '" +
				supply.getWarehousemanId() + "', ID_Magazynu = '" +
				supply.getWarehouseId() + "' WHERE ID = ?";
        
        Connection conn = null;
        
        try {
        	conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, supply.getSupplyId());
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
	public Supply find(int id) {
		String sql = "SELECT * FROM Dostawy WHERE ID = ?";
        
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            Supply result = null;
            ResultSet rs = ps.executeQuery();
            result = new Supply(
            		rs.getInt("ID"),
                    rs.getString("NumerPrzewozowy"),
                    rs.getDate("DataOdbioru"),
                    rs.getTime("GodzinaOdbioru"),
                    rs.getInt("ID_Dostawcy"),
                    rs.getInt("ID_Magazyniera"),
                    rs.getInt("ID_Magazynu")
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
