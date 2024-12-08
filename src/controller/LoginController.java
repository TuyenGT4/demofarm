package controller;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import database.connectDB;
import view.ForgotPasswordForm;
import view.LoginForm;
import view.RegisterForm;

public class LoginController {
	private LoginForm view;
	private Connection conn;
	
	public LoginController(LoginForm view) {
		this.view = view;
		
		//thêm placeholder cho tf email
		view.gettfEmail().addFocusListener(new FocusListener() {
		    @Override
		    public void focusGained(FocusEvent e) {
		        if (view.gettfEmail().getText().equals("Nhập email")) {
		        	view.gettfEmail().setText("");
		        	view.gettfEmail().setForeground(Color.BLACK); // Đổi màu chữ khi người dùng nhập
		        }
		    }

		    @Override
		    public void focusLost(FocusEvent e) {
		        if (view.gettfEmail().getText().isEmpty()) {
		        	view.gettfEmail().setForeground(Color.GRAY);
		        	view.gettfEmail().setText("Nhập email"); // Hiển thị lại placeholder nếu trống
		        }
		    }
		});
		
		//thêm placeholder cho pf mật khẩu
		view.gettfMatKhau().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(view.gettfMatKhau().getPassword()).equals("Nhập mật khẩu")) { // Use getPassword()
                	view.gettfMatKhau().setText("");
                	view.gettfMatKhau().setForeground(Color.BLACK);
                	view.gettfMatKhau().setEchoChar('*'); // Bật chế độ ẩn mật khẩu
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (view.gettfMatKhau().getPassword().length == 0) { 
                	view.gettfMatKhau().setForeground(Color.GRAY);
                	view.gettfMatKhau().setText("Nhập mật khẩu");
                	view.gettfMatKhau().setEchoChar((char) 0); // Tắt chế độ ẩn mật khẩu
                }
            }
        });
		
		//xử lý sự kiện nhấn vào checkbox hiển thị mật khẩu: bật -> dấu * chuyển thành ký tự và ngược lại
		view.getcbHienThiMatKhau().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (view.getcbHienThiMatKhau().isSelected()) {
                    view.gettfMatKhau().setEchoChar((char) 0); // Hiển thị mật khẩu
                } else {
                    if (new String(view.gettfMatKhau().getPassword()).equals("Nhập mật khẩu")) { // Use getPassword()
                    	view.gettfMatKhau().setEchoChar((char) 0); // Tắt chế độ ẩn cho placeholder
                    } else {
                    	view.gettfMatKhau().setEchoChar('*'); // Ẩn mật khẩu
                    }
                }
            }
        });
		
		
		// xử lý sự kiện nhấn vào đăng ký -> chuyển hướng đến trang đăng ký
		view.getlblDangKy().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (SwingUtilities.isLeftMouseButton(e)) { // Kiểm tra nút chuột trái
	                // ẩn loginform
	            	view.setVisible(false);
	            	view.dispose();
	                
	
	                // Hiển thị Registerform
	                RegisterForm registerForm = new RegisterForm();
	                registerForm.setVisible(true);
            	}
            }
        });
		
		// xử lý sự kiện nhấn vào quên mật khẩu -> chuyển hướng đến trang quên mật khẩu
		view.getlblQuenMatKhau().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) { // Kiểm tra nút chuột trái
	                // ẩn loginform
	            	view.setVisible(false);
	            	view.dispose();
	                
	
	                // Hiển thị ForgotPasswordForm
	                ForgotPasswordForm forgotpasswordForm = new ForgotPasswordForm();
	                forgotpasswordForm.setVisible(true);
            	}
			}
		});
		view.getbtnDangNhap().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String email = view.gettfEmail().getText();
                String password = new String(view.gettfMatKhau().getPassword());

                if (validateLogin(email, password)) {
                    JOptionPane.showMessageDialog(view, "Đăng nhập thành công!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    // Chuyển hướng đến trang chính hoặc thực hiện các tác vụ khác
                } else {
                    JOptionPane.showMessageDialog(view, "Thông tin đăng nhập không chính xác!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
	}
	private boolean validateLogin(String email, String password) {
	    conn = null; // Khai báo biến conn ở đây
	    try {
	        connectDB db = new connectDB(); // Tạo đối tượng connectDB
	        try {
				conn = db.getConnection();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} // Lấy kết nối từ đối tượng db
	        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM user WHERE UserName = ? AND Password = ?");
	        stmt.setString(1, email);
	        stmt.setString(2, password);
	        ResultSet rs = stmt.executeQuery();
	        return rs.next(); // Trả về true nếu tìm thấy bản ghi, false nếu không
	    } catch (SQLException e) {
	        e.printStackTrace();
	        return false;
	    } finally {
	        // Đảm bảo đóng kết nối nếu nó đã được mở
	        if (conn != null) {
	            try {
	                conn.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}
}
