package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import model.Material;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

public class MaterialDao extends JdbcDaoSupport {
	
	
	
	public List find(){
		System.out.println("find");
		
		String sql="select * from jiaocai";
		
		return super.getJdbcTemplate().query(sql, new RowMapper<Material>() {   
		    public Material mapRow(ResultSet rs, int num) throws SQLException { 
		    	System.out.println("how many row");
		    	System.out.println(rs.getRow());
		        Material m = new Material();  
		        m.setId(rs.getInt("id"));;   
		        return m;  
		    }  
		});
		
	}
	
}
