package view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;



public class QuanLyCayTrong extends JPanel {

	private static final long serialVersionUID = 1L;
	

	/**
	 * Create the panel.
	 */
	public QuanLyCayTrong() {
		setLayout(null);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 578, 432);
		add(tabbedPane);
		
		plBangThongTin = new JPanel();
		tabbedPane.addTab("Bảng thông tin", null, plBangThongTin, null);
		plBangThongTin.setLayout(null);
		
		JPanel plTimKiem = new JPanel();
		plTimKiem.setBounds(10, 11, 553, 44);
		plBangThongTin.add(plTimKiem);
		plTimKiem.setLayout(null);
		textTenCayTrong.setBounds(10, 11, 96, 22);
		plTimKiem.add(textTenCayTrong);
		textTenCayTrong.setColumns(10);
		
		JComboBox combobMaTrangTrai = new JComboBox();
		combobMaTrangTrai.setBounds(132, 11, 96, 22);
		plTimKiem.add(combobMaTrangTrai);
		
		combobTrangThai = new JComboBox();
		combobTrangThai.setBounds(253, 11, 96, 22);
		plTimKiem.add(combobTrangThai);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(367, 11, 89, 23);
		plTimKiem.add(btnNewButton);
		
		plThongTin = new JPanel();
		tabbedPane.addTab("Thông tin chi tiết", null, plThongTin, null);
		plThongTin.setLayout(null);
		
		tfMaCayTrong = new JTextField();
		tfMaCayTrong.setBounds(115, 11, 96, 20);
		plThongTin.add(tfMaCayTrong);
		tfMaCayTrong.setColumns(10);
		
		tfMaTrangTrai = new JTextField();
		tfMaTrangTrai.setBounds(417, 11, 96, 20);
		plThongTin.add(tfMaTrangTrai);
		tfMaTrangTrai.setColumns(10);
		
		 lblMaCayTrong = new JLabel("Mã cây trồng");
		 lblMaCayTrong.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		 lblMaCayTrong.setBounds(10, 14, 68, 14);
		 plThongTin.add(lblMaCayTrong);
		 
		  lblMaTrangTrai = new JLabel("Mã trang trại");
		  lblMaTrangTrai.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblMaTrangTrai.setBounds(308, 14, 78, 14);
		  plThongTin.add(lblMaTrangTrai);
		  
		  tfTenCayTrong = new JTextField();
		  tfTenCayTrong.setBounds(115, 42, 96, 20);
		  plThongTin.add(tfTenCayTrong);
		  tfTenCayTrong.setColumns(10);
		  
		  lblTenCayTrong = new JLabel("Tên cây trồng");
		  lblTenCayTrong.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblTenCayTrong.setBounds(10, 45, 68, 14);
		  plThongTin.add(lblTenCayTrong);
		  
		  lblTenTrangTrai = new JLabel("Tên trang trại");
		  lblTenTrangTrai.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblTenTrangTrai.setBounds(308, 45, 78, 14);
		  plThongTin.add(lblTenTrangTrai);
		  
		  tfTenTrangTrai = new JTextField();
		  tfTenTrangTrai.setBounds(417, 42, 96, 20);
		  tfTenTrangTrai.setColumns(10);
		  plThongTin.add(tfTenTrangTrai);
		  
		  tfSLCayTrong = new JTextField();
		  tfSLCayTrong.setBounds(115, 73, 96, 20);
		  plThongTin.add(tfSLCayTrong);
		  tfSLCayTrong.setColumns(10);
		  
		  lblSLCayTrong = new JLabel("Số lượng cây trồng");
		  lblSLCayTrong.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		  lblSLCayTrong.setBounds(10, 76, 96, 13);
		  plThongTin.add(lblSLCayTrong);
		  
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
	                    "Mã cây trồng", "Tên cây trồng", "Mã trang trại", "Tên trang trại", "Số lượng cây trồng", "Tình trạng sức khỏe", "Giá chăm sóc(vnd)", "Sản lượng thu được(kg)"
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
	private JTable table;
	private JTabbedPane tabbedPane;
	private JPanel plBangThongTin, plThongTin, plTuyChon;
	private JScrollPane scrollPane;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnLamMoi;
	private JTextField tfMaCayTrong, tfMaTrangTrai, tfTenCayTrong, tfTenTrangTrai, tfSLCayTrong, tfTinhTrangSucKhoe, tfGiaChamNuoi, tfSLThuDuoc;
	private JLabel lblMaCayTrong, lblMaTrangTrai, lblTenCayTrong, lblTenTrangTrai, lblSLCayTrong, lblTinhTrangSucKhoe, lblGiaChamNuoi, lblSLThuDuoc ;
	private final JTextField textTenCayTrong = new JTextField();
	private JComboBox combobTrangThai;



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

	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
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
	public JTextField getTfMaCayTrong() {
		return tfMaCayTrong;
	}
	public void setTfMaCayTrong(JTextField tfMaCayTrong) {
		this.tfMaCayTrong = tfMaCayTrong;
	}
	public JTextField getTfMaTrangTrai() {
		return tfMaTrangTrai;
	}
	public void setTfMaTrangTrai(JTextField tfMaTrangTrai) {
		this.tfMaTrangTrai = tfMaTrangTrai;
	}
	public JTextField getTfTenCayTrong() {
		return tfTenCayTrong;
	}
	public void setTfTenCayTrong(JTextField tfTenCayTrong) {
		this.tfTenCayTrong = tfTenCayTrong;
	}
	public JTextField getTfTenTrangTrai() {
		return tfTenTrangTrai;
	}
	public void setTfTenTrangTrai(JTextField tfTenTrangTrai) {
		this.tfTenTrangTrai = tfTenTrangTrai;
	}
	public JTextField getTfSLCayTrong() {
		return tfSLCayTrong;
	}
	public void setTfSLCayTrong(JTextField tfSLCayTrong) {
		this.tfSLCayTrong = tfSLCayTrong;
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
	public JLabel getLblMaCayTrong() {
		return lblMaCayTrong;
	}
	public void setLblMaCayTrong(JLabel lblMaCayTrong) {
		this.lblMaCayTrong = lblMaCayTrong;
	}
	public JLabel getLblMaTrangTrai() {
		return lblMaTrangTrai;
	}
	public void setLblMaTrangTrai(JLabel lblMaTrangTrai) {
		this.lblMaTrangTrai = lblMaTrangTrai;
	}
	public JLabel getLblTenCayTrong() {
		return lblTenCayTrong;
	}
	public void setLblTenCayTrong(JLabel lblTenCayTrong) {
		this.lblTenCayTrong = lblTenCayTrong;
	}
	public JLabel getLblTenTrangTrai() {
		return lblTenTrangTrai;
	}
	public void setLblTenTrangTrai(JLabel lblTenTrangTrai) {
		this.lblTenTrangTrai = lblTenTrangTrai;
	}
	public JLabel getLblSLCayTrong() {
		return lblSLCayTrong;
	}
	public void setLblSLCayTrong(JLabel lblSLCayTrong) {
		this.lblSLCayTrong = lblSLCayTrong;
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
