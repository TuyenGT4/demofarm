package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import view.ForgotPasswordForm;
import view.LoginForm;
import view.RegisterForm;

public class ForgotPasswordController {
	private ForgotPasswordForm forgotPassword;
	
	public ForgotPasswordController(ForgotPasswordForm view) {
		this.forgotPassword = view;
		
		//Đặt placeholder "Nhập email"
		forgotPassword.gettfEmail().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (forgotPassword.gettfEmail().getText().equals("Nhập email")) {
                	forgotPassword.gettfEmail().setText("");
                	forgotPassword.gettfEmail().setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (forgotPassword.gettfEmail().getText().isEmpty()) {
                	forgotPassword.gettfEmail().setForeground(Color.GRAY);
                	forgotPassword.gettfEmail().setText("Nhập email");
                }
            }
        });
		//placeholder cho tfMatKhau1
		forgotPassword.gettfMatKhau1().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(forgotPassword.gettfMatKhau1().getPassword()).equals("Nhập mật khẩu mới")) {
                	forgotPassword.gettfMatKhau1().setText("");
                	forgotPassword.gettfMatKhau1().setForeground(Color.BLACK);
                	forgotPassword.gettfMatKhau1().setEchoChar('*'); // Bật chế độ ẩn mật khẩu
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (forgotPassword.gettfMatKhau1().getPassword().length == 0) {
                	forgotPassword.gettfMatKhau1().setForeground(Color.GRAY);
                	forgotPassword.gettfMatKhau1().setText("Nhập mật khẩu mới");
                	forgotPassword.gettfMatKhau1().setEchoChar((char) 0); // Tắt chế độ ẩn mật khẩu
                }
            }
		});
		
		//placeholder cho tfMatKhau2
		forgotPassword.gettfMatKhau2().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if (new String(forgotPassword.gettfMatKhau2().getPassword()).equals("Nhập lại mật khẩu")) {
                	forgotPassword.gettfMatKhau2().setText("");
                	forgotPassword.gettfMatKhau2().setForeground(Color.BLACK);
                	forgotPassword.gettfMatKhau2().setEchoChar('*'); // Bật chế độ ẩn mật khẩu
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (forgotPassword.gettfMatKhau2().getPassword().length == 0) {
                	forgotPassword.gettfMatKhau2().setForeground(Color.GRAY);
                	forgotPassword.gettfMatKhau2().setText("Nhập lại mật khẩu");
                	forgotPassword.gettfMatKhau2().setEchoChar((char) 0); // Tắt chế độ ẩn mật khẩu
                }
            }
		});
	    //xử lý sự kiện nhấn vào checkbox hiển thị mật khẩu: bật -> dấu * chuyển thành ký tự và ngược lại
		forgotPassword.getCbHienThiMatKhau().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (forgotPassword.getCbHienThiMatKhau().isSelected()) {
                	forgotPassword.gettfMatKhau1().setEchoChar((char) 0); // Hiển thị mật khẩu
                	forgotPassword.gettfMatKhau2().setEchoChar((char) 0); // Hiển thị mật khẩu nhập lại
                } else {
                	forgotPassword.gettfMatKhau1().setEchoChar('*'); // Ẩn mật khẩu
                	forgotPassword.gettfMatKhau2().setEchoChar('*'); // Ẩn mật khẩu nhập lại
                }
            }
        });
		//xử lý event nhấn vào nút Khôi phục
		forgotPassword.getbtnKhoiPhuc().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = forgotPassword.gettfEmail().getText();
                String matKhau1 = String.valueOf(forgotPassword.gettfMatKhau1().getPassword());
                String matKhau2 = String.valueOf(forgotPassword.gettfMatKhau2().getPassword());
                
                // Validate email
                if (!isValidEmail(email)) {
                    JOptionPane.showMessageDialog(forgotPassword.getContenPane(), "Email không hợp lệ. Vui lòng kiểm tra lại.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password
                if (!isValidPassword(matKhau1)) {
                    JOptionPane.showMessageDialog(forgotPassword.getContenPane(), "Mật khẩu phải chứa ít nhất: 1 chữ in hoa, 1 ký tự đặc biệt và 1 số.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Validate password match
                if (!matKhau1.equals(matKhau2)) {
                    JOptionPane.showMessageDialog(forgotPassword.getContenPane(), "Mật khẩu và mật khẩu xác nhận không khớp.", "Lỗi", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Show success message
                JOptionPane.showMessageDialog(forgotPassword.getContenPane(), "Đăng ký thành công!", "Thành công", JOptionPane.INFORMATION_MESSAGE);
            
                // Ẩn ForgotForm hiện tại
                forgotPassword.setVisible(false);
                forgotPassword.dispose();

                // Tạo và hiển thị LoginForm
                LoginForm loginForm = new LoginForm();
                loginForm.setVisible(true);
            }
        });	
		
		forgotPassword.getlblDangNhap().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (SwingUtilities.isLeftMouseButton(e)) {   // Kiểm tra nút chuột trái  
            		// ẩn forgotform
            		forgotPassword.getContenPane().setVisible(false);
            		forgotPassword.dispose();
	
	                // Hiển thị LoginForm
	                LoginForm loginForm = new LoginForm();
	                loginForm.setVisible(true);
            	}
            }
        });
		
		forgotPassword.getlblDangKy().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	if (SwingUtilities.isLeftMouseButton(e)) {   // Kiểm tra nút chuột trái  
            		// ẩn forgotform
            		forgotPassword.getContenPane().setVisible(false);
            		forgotPassword.dispose();
	
	                // Hiển thị RegisterForm
            		RegisterForm registerForm = new RegisterForm();
            		registerForm.setVisible(true);
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
}
