package bsk_project.databaseaccesscontrol.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import bsk_project.databaseaccesscontrol.model.Warehouseman;

public class WarehousemanDAOImpl extends BaseDAO implements WarehousemanDAO {
	
    private DataSource dataSource;
    
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    @Override
    public void insert(Warehouseman warehouseman) {
        String sql = "INSERT INTO Magazynierzy " +
                "(PESEL, Narodowosc, ImieNazwisko, DataZatrudnienia) VALUES (?, ?, ?, ?)";
        Connection conn = null;
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, warehouseman.getPesel());
            ps.setString(2, warehouseman.getNationality());
            ps.setString(3, warehouseman.getFullName());
            ps.setDate(4, warehouseman.getEmploymentDate());
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
    public List<Warehouseman> findAll() {
        String sql = "SELECT * FROM Magazynierzy";
        
        Connection conn = null;
        List<Warehouseman> results = new ArrayList<>();
        
        try {
            conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            Warehouseman warehouseman = null;
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                warehouseman = new Warehouseman(
                rs.getInt("ID"),
                rs.getString("PESEL"),
                rs.getString("Narodowosc"),
                rs.getString("ImieNazwisko"),
                rs.getDate("DataZatrudnienia")
                );
                results.add(warehouseman);
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
		String sql = "DELETE FROM Magazynierzy WHERE ID = ?";
        
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
	public void updateById(int id, String pesel, String nationality, String fullName, Date employmentDate) {
		String sql = "UPDATE Magazynierzy SET PESEL = '" + pesel + "', Narodowosc = '" + nationality +  
			"', ImieNazwisko = '" + fullName + "', DataZatrudnienia = '" + employmentDate + "' WHERE ID = ?";
        
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
