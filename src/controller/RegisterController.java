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
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import database.connectDB;
import view.LoginForm;
import view.RegisterForm;

public class RegisterController {
	private RegisterForm register;
	public RegisterController(RegisterForm registerForm) {
		this.register = registerForm;
		
		//dat placeholder "Nhập email"
		register.gettfEmail().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (register.gettfEmail().getText().equals("Nhập email")) {
                	register.gettfEmail().setText("");
                	register.gettfEmail().setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (register.gettfEmail().getText().isEmpty()) {
                	register.gettfEmail().setForeground(Color.GRAY);
                	register.gettfEmail().setText("Nhập email");
                }
            }
        });
		// Xử lý placeholder cho tfMatKhau1
		register.gettfMatKhau1().addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (new String(register.gettfMatKhau1().getPassword()).equals("Nhập mật khẩu")) {
	                    register.gettfMatKhau1().setText("");
	                    register.gettfMatKhau1().setForeground(Color.BLACK);
	                    register.gettfMatKhau1().setEchoChar('*'); // Bật chế độ ẩn mật khẩu
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (register.gettfMatKhau1().getPassword().length == 0) {
	                    register.gettfMatKhau1().setForeground(Color.GRAY);
	                    register.gettfMatKhau1().setText("Nhập mật khẩu");
	                    register.gettfMatKhau1().setEchoChar((char) 0); // Tắt chế độ ẩn mật khẩu
	                }
	            }
        });

        // Xử lý placeholder cho tfMatKhau2
        register.gettfMatKhau2().addFocusListener(new FocusListener() {
	            @Override
	            public void focusGained(FocusEvent e) {
	                if (new String(register.gettfMatKhau2().getPassword()).equals("Nhập lại mật khẩu")) {
	                    register.gettfMatKhau2().setText("");
	                    register.gettfMatKhau2().setForeground(Color.BLACK);
	                    register.gettfMatKhau2().setEchoChar('*'); // Bật chế độ ẩn mật khẩu
	                }
	            }

	            @Override
	            public void focusLost(FocusEvent e) {
	                if (register.gettfMatKhau2().getPassword().length == 0) {
	                    register.gettfMatKhau2().setForeground(Color.GRAY);
	                    register.gettfMatKhau2().setText("Nhập lại mật khẩu");
	                    register.gettfMatKhau2().setEchoChar((char) 0); // Tắt chế độ ẩn mật khẩu
	                }
	            }
        });
      //xử lý sự kiện nhấn vào checkbox hiển thị mật khẩu: bật -> dấu * chuyển thành ký tự và ngược lại
        register.getCbHienThiMatKhau().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (register.getCbHienThiMatKhau().isSelected()) {
                    register.gettfMatKhau1().setEchoChar((char) 0); // Hiển thị mật khẩu
                    register.gettfMatKhau2().setEchoChar((char) 0); // Hiển thị mật khẩu nhập lại
                } else {
                    register.gettfMatKhau1().setEchoChar('*'); // Ẩn mật khẩu
                    register.gettfMatKhau2().setEchoChar('*'); // Ẩn mật khẩu nhập lại
                }
            }
        });
		
				//xử lý event nhấn vào nút đăng ký tài khoản
        register.getbtnDangKy().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = register.gettfEmail().getText();
                String matKhau1 = String.valueOf(register.gettfMatKhau1().getPassword());
                String matKhau2 = String.valueOf(register.gettfMatKhau2().getPassword());

                // Validate email
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(register.getContenPane(), "Email không hợp lệ. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password
                if (!isValidPassword(matKhau1)) {
                    JOptionPane.showMessageDialog(register.getContenPane(), "Mật khẩu phải chứa ít nhất: 1 chữ in hoa, 1 ký tự đặc biệt và 1 số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password match
                if (!matKhau1.equals(matKhau2)) {
                    JOptionPane.showMessageDialog(register.getContenPane(), "Mật khẩu và mật khẩu xác nhận không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Kết nối đến cơ sở dữ liệu và lưu thông tin người dùng
                Connection conn = null; // Khai báo biến conn
                try {
                    connectDB db = new connectDB(); // Tạo đối tượng connectDB
                    conn = db.getConnection(); // Lấy kết nối từ đối tượng db

                    // Kiểm tra xem email đã tồn tại chưa
                    PreparedStatement checkEmailStmt = conn.prepareStatement("SELECT * FROM user WHERE UserName = ?");
                    checkEmailStmt.setString(1, email);
                    ResultSet rs = checkEmailStmt.executeQuery();
                    if (rs.next()) {
                        JOptionPane.showMessageDialog(register.getContenPane(), "Email đã tồn tại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                        return; // Email đã tồn tại
                    }

                    // Thêm người dùng mới vào cơ sở dữ liệu
                    PreparedStatement insertStmt = conn.prepareStatement("INSERT INTO user (UserName, Password) VALUES (?, ?)");
                    insertStmt.setString(1, email);
                    insertStmt.setString(2, matKhau1); // Lưu mật khẩu mà không mã hóa
                    insertStmt.executeUpdate();

                    // Hiển thị thông báo thành công
                    JOptionPane.showMessageDialog(register.getContenPane(), "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);

                    // Ẩn RegisterForm hiện tại
                    register.setVisible(false);
                    register.dispose();

                    // Tạo và hiển thị LoginForm
                    LoginForm loginForm = new LoginForm();
                    loginForm.setVisible(true);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(register.getContenPane(), "Đăng ký thất bại. Vui lòng thử lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // Đảm bảo đóng kết nối nếu nó đã được mở
                    if (conn != null) {
                        try {
                            conn.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }
                }
            }
        });
		        
		// xử lý event nhấn vào đăng nhập -> chuyển hướng đến trang đăng nhập
		        register.getlblDangNhap().addMouseListener(new MouseAdapter() {
		            @Override
		            public void mouseClicked(MouseEvent e) {
		            	if (SwingUtilities.isLeftMouseButton(e)) {   // Kiểm tra nút chuột trái  
		            		// ẩn registerform
		            		register.getContenPane().setVisible(false);
		            		register.dispose();
			                // Hiển thị LoginForm
			                LoginForm loginForm = new LoginForm();
			                loginForm.setVisible(true);
		            	}
		            }
		        });
		  

	}
	
	// Email validation
    private boolean isValidEmail(String email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        return pattern.matcher(email).matches();
    }

    // Password validation
    private boolean isValidPassword(String password) {
    	//xác thực tính hợp lệ của mật khẩu (ít nhất 1 chữ hoa, 1 ký tự đặc biệt, 1 số và dài ít nhất 8 ký tự)
        String passwordRegex = "(?=.*[A-Z])(?=.*[0-9])(?=.*[^_=!#$%&()*+,-.:/'?@]).{8,}";
        return password.matches(passwordRegex);
    }
    
    public void hienThiMatKhau(boolean hienThi) {
        if (hienThi) {
        	register.gettfMatKhau1().setEchoChar((char) 0);
            register.gettfMatKhau2().setEchoChar((char) 0);
        } else {
            if (new String(register.gettfMatKhau1().getPassword()).equals("Nhập mật khẩu")) {
            	register.gettfMatKhau1().setEchoChar((char) 0);
            } else {
            	register.gettfMatKhau1().setEchoChar('*');
            }

            if (new String(register.gettfMatKhau2().getPassword()).equals("Nhập lại mật khẩu")) {
            	register.gettfMatKhau2().setEchoChar((char) 0);
            } else {
            	register.gettfMatKhau2().setEchoChar('*');
            }
        }
    }
}
