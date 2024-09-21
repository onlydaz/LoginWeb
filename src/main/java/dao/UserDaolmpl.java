package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.UserModel;
import sql.DBConnectionSQLSever;

public class UserDaolmpl implements IUserDao {
	
	public Connection conn = null;
	public PreparedStatement ps = null;
	public ResultSet rs = null;
	
	@Override
	public List<UserModel> findAll() {
		String sql = "SELECT * FROM users";
    	List<UserModel> list = new ArrayList<>();
    	
		try {
			conn = new DBConnectionSQLSever().getConnection();
	        ps = conn.prepareStatement(sql);
	        rs = ps.executeQuery();
	        while (rs.next()) {
	            list.add(new UserModel(
	                rs.getInt("id"),
	                rs.getString("username"),
	                rs.getString("password"),
	                rs.getString("images"),
	                rs.getString("fullname"),
	                rs.getString("email"),  
	                rs.getString("phone"),
	                rs.getInt("roleid"),
	                rs.getDate("createDate")));
	            return list;
		}
		} catch (Exception e) {e.printStackTrace(); }
		return null;
	}

	@Override
	public UserModel findById(int id) {
		String sql = "SELECT * FROM users WHERE id = ?";
	    UserModel user = null;
	    
	    try {
	    	conn = new DBConnectionSQLSever().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            user = new UserModel();
	            user.setId(rs.getInt("id"));
	            user.setUsername(rs.getString("username"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setFullname(rs.getString("fullname"));
	            user.setEmail(rs.getString("email"));
	            user.setPhone(rs.getString("phone"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setCreateDate(rs.getDate("createDate"));
	        }
	    } catch (Exception e) {
			e.printStackTrace();
		} finally {
	        try {
	            if (rs != null) rs.close();
	            if (ps != null) ps.close();
	            if (conn != null) conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    return user;
	}

	@Override
	public void insert(UserModel user) {
		String sql = "INSERT INTO users (id, username, password, images, fullname, email, phone, roleid, createDate) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";		
		try {
			conn = new DBConnectionSQLSever().getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setInt(1, user.getId());
			ps.setString(2, user.getUsername()); 
			ps.setString(3,user.getPassword()); 
			ps.setString(4,user.getImages());
			ps.setString(5, user.getFullname());
			
			ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			}
		
		
	}

	@Override
	public UserModel findByUserName(String username) {
		String sql = "SELECT * FROM users WHERE username = ?";
	    try {
	        conn = new DBConnectionSQLSever().getConnection();
	        ps = conn.prepareStatement(sql);
	        ps.setString(1, username);
	        rs = ps.executeQuery();
	        
	        if (rs.next()) {
	            UserModel user = new UserModel();
	            user.setId(rs.getInt("id"));
	            user.setEmail(rs.getString("email"));
	            user.setUsername(rs.getString("username"));
	            user.setFullname(rs.getString("fullname"));
	            user.setPassword(rs.getString("password"));
	            user.setImages(rs.getString("images"));
	            user.setRoleid(rs.getInt("roleid"));
	            user.setPhone(rs.getString("phone"));
	            user.setCreateDate(rs.getDate("createDate"));
	            return user;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	// Hàm main để kiểm tra
    public static void main(String[] args) {
        UserDaolmpl userDao = new UserDaolmpl();
        String testUsername = "duydat";
        UserModel user = userDao.findByUserName(testUsername);

        if (user != null) {
            System.out.println("Tìm thấy người dùng:");
            System.out.println("ID: " + user.getId());
            System.out.println("Username: " + user.getUsername());
            System.out.println("Password: " + user.getPassword());
            System.out.println("Full Name: " + user.getFullname());
            System.out.println("Email: " + user.getEmail());
            System.out.println("Phone: " + user.getPhone());
            System.out.println("Role ID: " + user.getRoleid());
            System.out.println("Create Date: " + user.getCreateDate());
        } else {
            System.out.println("Không tìm thấy người dùng với username: " + testUsername);
        }
    }
}
