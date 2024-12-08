package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyVatNuoi extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public QuanLyVatNuoi() {
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 578, 432);
		add(tabbedPane);
		
		plBangThongTin = new JPanel();
		tabbedPane.addTab("Bảng thông tin", null, plBangThongTin, null);
		plBangThongTin.setLayout(null);
		
		scrollPaneBangThongTin = new JScrollPane();
		scrollPaneBangThongTin.setBounds(0, 157, 573, 247);
		plBangThongTin.add(scrollPaneBangThongTin);
		
		lblTimKiemTheoTen = new JLabel("Chọn loại vật nuôi");
        lblTimKiemTheoTen.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        lblTimKiemTheoTen.setBounds(81, 43, 147, 17);
        plBangThongTin.add(lblTimKiemTheoTen);
		
		comboBox = new JComboBox<>();
        comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        comboBox.setModel(new DefaultComboBoxModel(new String[] {"---Chọn loại---", "Khác"}));
        comboBox.setBounds(206, 40, 131, 22);
        plBangThongTin.add(comboBox);
		
        btnTimKiem = new JButton("Tìm kiếm");
        btnTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 11));
        btnTimKiem.setBounds(386, 40, 89, 23);
        plBangThongTin.add(btnTimKiem);
        
		tableBangThongTin = new JTable();
		tableBangThongTin.setModel(new DefaultTableModel(
				new Object[][] {
			    },
			    new String[] {
			        "Mã vật nuôi", "Tên vật nuôi", "Mã trang trại", "Tên trang trại", "Số lượng vật nuôi", "Tình trạng sức khỏe", "Giá chăm nuôi(vnd)", "Sản lượng thu được(kg)"
			    }
			) {
			    Class[] columnTypes = new Class[] {
			        String.class, String.class, String.class, String.class, Integer.class, String.class, Float.class, Float.class
			    };
			    public Class getColumnClass(int columnIndex) {
			        return columnTypes[columnIndex];
			    }
			});
		scrollPaneBangThongTin.setViewportView(tableBangThongTin);
		
		plThongTin = new JPanel();
		tabbedPane.addTab("Thông tin chi tiết", null, plThongTin, null);
		plThongTin.setLayout(null);
		
		tfMaVatNuoi = new JTextField();
		tfMaVatNuoi.setBounds(115, 11, 96, 20);
		plThongTin.add(tfMaVatNuoi);
		tfMaVatNuoi.setColumns(10);
		
		tfMaTrangTrai = new JTextField();
		tfMaTrangTrai.setBounds(417, 11, 96, 20);
		plThongTin.add(tfMaTrangTrai);
		tfMaTrangTrai.setColumns(10);
		
		 lblMaVatNuoi = new JLabel("Mã vật nuôi");
		 lblMaVatNuoi.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		 lblMaVatNuoi.setBounds(10, 14, 68, 14);
		 plThongTin.add(lblMaVatNuoi);
		 
		  lblMaTrangTrai = new JLabel("Mã trang trại");
		  lblMaTrangTrai.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblMaTrangTrai.setBounds(308, 14, 78, 14);
		  plThongTin.add(lblMaTrangTrai);
		  
		  tfTenVatNuoi = new JTextField();
		  tfTenVatNuoi.setBounds(115, 42, 96, 20);
		  plThongTin.add(tfTenVatNuoi);
		  tfTenVatNuoi.setColumns(10);
		  
		  lblTenVatNuoi = new JLabel("Tên vật nuôi");
		  lblTenVatNuoi.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblTenVatNuoi.setBounds(10, 45, 68, 14);
		  plThongTin.add(lblTenVatNuoi);
		  
		  lblTenTrangTrai = new JLabel("Tên trang trại");
		  lblTenTrangTrai.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblTenTrangTrai.setBounds(308, 45, 78, 14);
		  plThongTin.add(lblTenTrangTrai);
		  
		  tfTenTrangTrai = new JTextField();
		  tfTenTrangTrai.setBounds(417, 42, 96, 20);
		  plThongTin.add(tfTenTrangTrai);
		  tfTenTrangTrai.setColumns(10);
		  
		  tfSLVatNuoi = new JTextField();
		  tfSLVatNuoi.setBounds(115, 73, 96, 20);
		  plThongTin.add(tfSLVatNuoi);
		  tfSLVatNuoi.setColumns(10);
		  
		  lblSLVatNuoi = new JLabel("Số lượng vật nuôi");
		  lblSLVatNuoi.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblSLVatNuoi.setBounds(10, 76, 96, 13);
		  plThongTin.add(lblSLVatNuoi);
		  
		  tfTinhTrangSucKhoe = new JTextField();
		  tfTinhTrangSucKhoe.setBounds(115, 104, 96, 20);
		  plThongTin.add(tfTinhTrangSucKhoe);
		  tfTinhTrangSucKhoe.setColumns(10);
		  
		  lblTinhTrangSucKhoe = new JLabel("Tình trạng sức khỏe");
		  lblTinhTrangSucKhoe.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblTinhTrangSucKhoe.setBounds(10, 107, 96, 14);
		  plThongTin.add(lblTinhTrangSucKhoe);
		  
		  tfGiaChamNuoi = new JTextField();
		  tfGiaChamNuoi.setBounds(417, 73, 96, 20);
		  plThongTin.add(tfGiaChamNuoi);
		  tfGiaChamNuoi.setColumns(10);
		  
		  tfSLThuDuoc = new JTextField();
		  tfSLThuDuoc.setBounds(417, 104, 96, 20);
		  plThongTin.add(tfSLThuDuoc);
		  tfSLThuDuoc.setColumns(10);
		  
		  lblGiaChamNuoi = new JLabel("Giá chăm nuôi");
		  lblGiaChamNuoi.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblGiaChamNuoi.setBounds(308, 76, 99, 14);
		  plThongTin.add(lblGiaChamNuoi);
		  
		  lblSLThuDuoc = new JLabel("Sản lượng thu được");
		  lblSLThuDuoc.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblSLThuDuoc.setBounds(308, 107, 99, 14);
		  plThongTin.add(lblSLThuDuoc);
		  
		  plTuyChon = new JPanel();
		  plTuyChon.setBounds(10, 147, 554, 33);
		  plThongTin.add(plTuyChon);
		  plTuyChon.setBackground(new Color(251, 251, 251));
		  
		  btnThem = new JButton("Thêm");
		  plTuyChon.add(btnThem);
		   
		  btnSua = new JButton("Sửa");
		  plTuyChon.add(btnSua);
		    
		  btnXoa = new JButton("Xóa");
		  plTuyChon.add(btnXoa);
		     
		  btnLuu = new JButton("Lưu");
		  plTuyChon.add(btnLuu);
		      
		  btnLamMoi = new JButton("Làm mới");
		  plTuyChon.add(btnLamMoi);
		  
		  scrollPane = new JScrollPane();
	      scrollPane.setBounds(0, 198, 574, 206);
	      plThongTin.add(scrollPane);
	        
	      table = new JTable();
	      table.setModel(new DefaultTableModel(
	    		  new Object[][] {
	  		    },
	  		    new String[] {
	  		        "Mã vật nuôi", "Tên vật nuôi", "Mã trang trại", "Tên trang trại", "Số lượng vật nuôi", "Tình trạng sức khỏe", "Giá chăm nuôi(vnd)", "Sản lượng thu được(kg)"
	  		    }
	  		) {
	  		    Class[] columnTypes = new Class[] {
	  		        String.class, String.class, String.class, String.class, Integer.class, String.class, Float.class, Float.class
	  		    };
	  		    public Class getColumnClass(int columnIndex) {
	  		        return columnTypes[columnIndex];
	  		    }
	  		});
	        scrollPane.setViewportView(table);
	        
	       
	}
	private JTable tableBangThongTin, table;
	private JTabbedPane tabbedPane;
	private JPanel plBangThongTin, plThongTin, plTuyChon;
	private JScrollPane scrollPaneBangThongTin, scrollPane;
	private JComboBox<String> comboBox;
	private JLabel lblTimKiemTheoTen;
	private JButton btnTimKiem, btnThem, btnSua, btnXoa, btnLuu, btnLamMoi;
	private JTextField tfMaVatNuoi, tfMaTrangTrai, tfTenVatNuoi, tfTenTrangTrai, tfSLVatNuoi, tfTinhTrangSucKhoe, tfGiaChamNuoi, tfSLThuDuoc;
	private JLabel lblMaVatNuoi, lblMaTrangTrai, lblTenVatNuoi, lblTenTrangTrai, lblSLVatNuoi, lblTinhTrangSucKhoe, lblGiaChamNuoi, lblSLThuDuoc ;

	public JTable getTableBangThongTin() {
		return tableBangThongTin;
	}
	public void setTableBangThongTin(JTable tableBangThongTin) {
		this.tableBangThongTin = tableBangThongTin;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}
	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}
	public JPanel getPlBangThongTin() {
		return plBangThongTin;
	}
	public void setPlBangThongTin(JPanel plBangThongTin) {
		this.plBangThongTin = plBangThongTin;
	}
	public JPanel getPlThongTin() {
		return plThongTin;
	}
	public void setPlThongTin(JPanel plThongTin) {
		this.plThongTin = plThongTin;
	}
	public JPanel getPlTuyChon() {
		return plTuyChon;
	}
	public void setPlTuyChon(JPanel plTuyChon) {
		this.plTuyChon = plTuyChon;
	}
	public JScrollPane getScrollPaneBangThongTin() {
		return scrollPaneBangThongTin;
	}
	public void setScrollPaneBangThongTin(JScrollPane scrollPaneBangThongTin) {
		this.scrollPaneBangThongTin = scrollPaneBangThongTin;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}
	public JComboBox<String> getComboBox() {
		return comboBox;
	}
	public void setComboBox(JComboBox<String> comboBox) {
		this.comboBox = comboBox;
	}
	public JLabel getLblTimKiemTheoTen() {
		return lblTimKiemTheoTen;
	}
	public void setLblTimKiemTheoTen(JLabel lblTimKiemTheoTen) {
		this.lblTimKiemTheoTen = lblTimKiemTheoTen;
	}
	public JButton getBtnTimKiem() {
		return btnTimKiem;
	}
	public void setBtnTimKiem(JButton btnTimKiem) {
		this.btnTimKiem = btnTimKiem;
	}
	public JButton getBtnThem() {
		return btnThem;
	}
	public void setBtnThem(JButton btnThem) {
		this.btnThem = btnThem;
	}
	public JButton getBtnSua() {
		return btnSua;
	}
	public void setBtnSua(JButton btnSua) {
		this.btnSua = btnSua;
	}
	public JButton getBtnXoa() {
		return btnXoa;
	}
	public void setBtnXoa(JButton btnXoa) {
		this.btnXoa = btnXoa;
	}
	public JButton getBtnLuu() {
		return btnLuu;
	}
	public void setBtnLuu(JButton btnLuu) {
		this.btnLuu = btnLuu;
	}
	public JButton getBtnLamMoi() {
		return btnLamMoi;
	}
	public void setBtnLamMoi(JButton btnLamMoi) {
		this.btnLamMoi = btnLamMoi;
	}
	public JTextField getTfMaVatNuoi() {
		return tfMaVatNuoi;
	}
	public void setTfMaVatNuoi(JTextField tfMaVatNuoi) {
		this.tfMaVatNuoi = tfMaVatNuoi;
	}
	public JTextField getTfMaTrangTrai() {
		return tfMaTrangTrai;
	}
	public void setTfMaTrangTrai(JTextField tfMaTrangTrai) {
		this.tfMaTrangTrai = tfMaTrangTrai;
	}
	public JTextField getTfTenVatNuoi() {
		return tfTenVatNuoi;
	}
	public void setTfTenVatNuoi(JTextField tfTenVatNuoi) {
		this.tfTenVatNuoi = tfTenVatNuoi;
	}
	public JTextField getTfTenTrangTrai() {
		return tfTenTrangTrai;
	}
	public void setTfTenTrangTrai(JTextField tfTenTrangTrai) {
		this.tfTenTrangTrai = tfTenTrangTrai;
	}
	public JTextField getTfSLVatNuoi() {
		return tfSLVatNuoi;
	}
	public void setTfSLVatNuoi(JTextField tfSLVatNuoi) {
		this.tfSLVatNuoi = tfSLVatNuoi;
	}
	public JTextField getTfTinhTrangSucKhoe() {
		return tfTinhTrangSucKhoe;
	}
	public void setTfTinhTrangSucKhoe(JTextField tfTinhTrangSucKhoe) {
		this.tfTinhTrangSucKhoe = tfTinhTrangSucKhoe;
	}
	public JTextField getTfGiaChamNuoi() {
		return tfGiaChamNuoi;
	}
	public void setTfGiaChamNuoi(JTextField tfGiaChamNuoi) {
		this.tfGiaChamNuoi = tfGiaChamNuoi;
	}
	public JTextField getTfSLThuDuoc() {
		return tfSLThuDuoc;
	}
	public void setTfSLThuDuoc(JTextField tfSLThuDuoc) {
		this.tfSLThuDuoc = tfSLThuDuoc;
	}
	public JLabel getLblMaVatNuoi() {
		return lblMaVatNuoi;
	}
	public void setLblMaVatNuoi(JLabel lblMaVatNuoi) {
		this.lblMaVatNuoi = lblMaVatNuoi;
	}
	public JLabel getLblMaTrangTrai() {
		return lblMaTrangTrai;
	}
	public void setLblMaTrangTrai(JLabel lblMaTrangTrai) {
		this.lblMaTrangTrai = lblMaTrangTrai;
	}
	public JLabel getLblTenVatNuoi() {
		return lblTenVatNuoi;
	}
	public void setLblTenVatNuoi(JLabel lblTenVatNuoi) {
		this.lblTenVatNuoi = lblTenVatNuoi;
	}
	public JLabel getLblTenTrangTrai() {
		return lblTenTrangTrai;
	}
	public void setLblTenTrangTrai(JLabel lblTenTrangTrai) {
		this.lblTenTrangTrai = lblTenTrangTrai;
	}
	public JLabel getLblSLVatNuoi() {
		return lblSLVatNuoi;
	}
	public void setLblSLVatNuoi(JLabel lblSLVatNuoi) {
		this.lblSLVatNuoi = lblSLVatNuoi;
	}
	public JLabel getLblTinhTrangSucKhoe() {
		return lblTinhTrangSucKhoe;
	}
	public void setLblTinhTrangSucKhoe(JLabel lblTinhTrangSucKhoe) {
		this.lblTinhTrangSucKhoe = lblTinhTrangSucKhoe;
	}
	public JLabel getLblGiaChamNuoi() {
		return lblGiaChamNuoi;
	}
	public void setLblGiaChamNuoi(JLabel lblGiaChamNuoi) {
		this.lblGiaChamNuoi = lblGiaChamNuoi;
	}
	public JLabel getLblSLThuDuoc() {
		return lblSLThuDuoc;
	}
	public void setLblSLThuDuoc(JLabel lblSLThuDuoc) {
		this.lblSLThuDuoc = lblSLThuDuoc;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}


