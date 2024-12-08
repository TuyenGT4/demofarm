package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connectDB {

	 private static final String URL = "jdbc:mysql://localhost:3306/farm?useSSL=false&serverTimezone=UTC";
	    private static final String USERNAME = "root";
	    private static final String PASSWORD = "";

	    public Connection getConnection() throws SQLException {
	        Connection connection = null;
	        try {
	            // Đăng ký driver MySQL
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            // Tạo kết nối
	            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
	            System.out.println("Kết nối đến cơ sở dữ liệu thành công!");
	        } catch (ClassNotFoundException e) {
	            System.err.println("Driver không tìm thấy: " + e.getMessage());
	        } catch (SQLException e) {
	            System.err.println("Lỗi kết nối: " + e.getMessage());
	            throw e; // Ném lại ngoại lệ để xử lý ở nơi khác nếu cần
	        }
	        return connection;
	    }
}


