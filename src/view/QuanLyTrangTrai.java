package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Font;
import javax.swing.table.DefaultTableModel;

import java.awt.Color;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class QuanLyTrangTrai extends JPanel {

	private static final long serialVersionUID = 1L;


	/**
	 * Create the panel.
	 */
	public QuanLyTrangTrai() {
		setLayout(null);
		
		 panel = new JPanel();
		panel.setBounds(0, 0, 578, 431);
		add(panel);
		panel.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 578, 432);
		panel.add(tabbedPane);
		
		 plBangThongTin = new JPanel();
		tabbedPane.addTab("Bảng thông tin", null, plBangThongTin, null);
		plBangThongTin.setLayout(null);
		
		plTimKiem = new JPanel();
		plTimKiem.setBounds(10, 11, 553, 45);
		plBangThongTin.add(plTimKiem);
		plTimKiem.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(38, 11, 96, 23);
		plTimKiem.add(textField);
		textField.setColumns(10);
		
		combobDienTich = new JComboBox();
		combobDienTich.setBounds(176, 11, 112, 23);
		plTimKiem.add(combobDienTich);
		
		btnTimKiem = new JButton("New button");
		btnTimKiem.setBounds(334, 11, 89, 23);
		plTimKiem.add(btnTimKiem);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 67, 553, 282);
		plBangThongTin.add(scrollPane_1);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Mã trang trại", "Tên trang trại", "Diện tích (mét vuông)", "Người phụ trách"
			}
		) {
			Class[] columnTypes = new Class[] {
				Integer.class, String.class, Float.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrollPane_1.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 360, 553, 33);
		plBangThongTin.add(panel_1);
		
		JButton btnThem_1 = new JButton("Thêm");
		btnThem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnThem_1);
		
		JButton btnSua_1 = new JButton("Sửa");
		panel_1.add(btnSua_1);
		
		JButton btnXoa_1 = new JButton("Xóa");
		panel_1.add(btnXoa_1);
		
		 plThongTinChiTiet = new JPanel();
		tabbedPane.addTab("New tab", null, plThongTinChiTiet, null);
		plThongTinChiTiet.setLayout(null);
		
		 lblMaTrangTrai = new JLabel("Mã trang trại");
		lblMaTrangTrai.setBounds(44, 22, 84, 14);
		plThongTinChiTiet.add(lblMaTrangTrai);
		
		textMaTrangTrai = new JTextField();
		textMaTrangTrai.setBounds(138, 19, 96, 20);
		plThongTinChiTiet.add(textMaTrangTrai);
		textMaTrangTrai.setColumns(10);
		
		 scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 198, 574, 206);
		plThongTinChiTiet.add(scrollPane);
		
		tableThongTinChiTiet = new JTable();
		tableThongTinChiTiet.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 trang tr\u1EA1i", "T\u00EAn trang tr\u1EA1i", "Di\u1EC7n t\u00EDch", "V\u1ED1n", "Doanh thu"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, Float.class, String.class, Float.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		tableThongTinChiTiet.setFont(new Font("Times New Roman", Font.PLAIN, 11));
		scrollPane.setViewportView(tableThongTinChiTiet);
		
		 plTuyChon = new JPanel();
		plTuyChon.setBackground(new Color(251, 251, 251));
		plTuyChon.setBounds(10, 154, 554, 33);
		plThongTinChiTiet.add(plTuyChon);
		
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
		
		textTenTrangTrai = new JTextField();
		textTenTrangTrai.setBounds(138, 50, 96, 20);
		plThongTinChiTiet.add(textTenTrangTrai);
		textTenTrangTrai.setColumns(10);
		
		textDienTich = new JTextField();
		textDienTich.setBounds(138, 81, 96, 20);
		plThongTinChiTiet.add(textDienTich);
		textDienTich.setColumns(10);
		
		textVon = new JTextField();
		textVon.setBounds(405, 19, 96, 20);
		plThongTinChiTiet.add(textVon);
		textVon.setColumns(10);
		
		textDoanhThu = new JTextField();
		textDoanhThu.setBounds(405, 50, 96, 20);
		plThongTinChiTiet.add(textDoanhThu);
		textDoanhThu.setColumns(10);
		
		 lblTenTrangTrai = new JLabel("Tên trang trại");
		lblTenTrangTrai.setBounds(44, 53, 49, 14);
		plThongTinChiTiet.add(lblTenTrangTrai);
		
		 lblDienTich = new JLabel("Diện tích");
		lblDienTich.setBounds(44, 84, 49, 14);
		plThongTinChiTiet.add(lblDienTich);
		
		 lblVon = new JLabel("Vốn");
		lblVon.setBounds(330, 22, 49, 14);
		plThongTinChiTiet.add(lblVon);
		
		 lblDoanhThu = new JLabel("Doanh thu");
		lblDoanhThu.setBounds(330, 53, 49, 14);
		plThongTinChiTiet.add(lblDoanhThu);
		
		

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
	public JButton getBtnTimKiem() {
		return btnTimKiem;
	}
	public void setBtnTimKiem(JButton btnTimKiem) {
		this.btnTimKiem = btnTimKiem;
	}
	public JPanel getPlTuyChon() {
		return plTuyChon;
	}
	public void setPlTuyChon(JPanel plTuyChon) {
		this.plTuyChon = plTuyChon;
	}
	public JPanel getPlBangThongTin() {
		return plBangThongTin;
	}
	public void setPlBangThongTin(JPanel plBangThongTin) {
		this.plBangThongTin = plBangThongTin;
	}
	public JPanel getPanel() {
		return panel;
	}
	public void setPanel(JPanel panel) {
		this.panel = panel;
	}
	public JPanel getPlThongTinChiTiet() {
		return plThongTinChiTiet;
	}
	public void setPlThongTinChiTiet(JPanel plThongTinChiTiet) {
		this.plThongTinChiTiet = plThongTinChiTiet;
	}
	public JScrollPane getScrollPane() {
		return scrollPane;
	}
	public void setScrollPane(JScrollPane scrollPane) {
		this.scrollPane = scrollPane;
	}

	public JTextField getTextDoanhThu() {
		return textDoanhThu;
	}
	public void setTextDoanhThu(JTextField textDoanhThu) {
		this.textDoanhThu = textDoanhThu;
	}
	public JTextField getTextVon() {
		return textVon;
	}
	public void setTextVon(JTextField textVon) {
		this.textVon = textVon;
	}
	public JTextField getTextDienTich() {
		return textDienTich;
	}
	public void setTextDienTich(JTextField textDienTich) {
		this.textDienTich = textDienTich;
	}
	public JTextField getTextTenTrangTrai() {
		return textTenTrangTrai;
	}
	public void setTextTenTrangTrai(JTextField textTenTrangTrai) {
		this.textTenTrangTrai = textTenTrangTrai;
	}
	public JTextField getTextMaTrangTrai() {
		return textMaTrangTrai;
	}
	public void setTextMaTrangTrai(JTextField textMaTrangTrai) {
		this.textMaTrangTrai = textMaTrangTrai;
	}
	public JTable getTableThongTinChiTiet() {
		return tableThongTinChiTiet;
	}
	public void setTableThongTinChiTiet(JTable tableThongTinChiTiet) {
		this.tableThongTinChiTiet = tableThongTinChiTiet;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	private JLabel lblDoanhThu, lblVon, lblDienTich, lblTenTrangTrai, lblMaTrangTrai;
	private JButton btnThem, btnSua, btnXoa, btnLuu, btnLamMoi;
	private JPanel plTuyChon, plBangThongTin, panel, plThongTinChiTiet;
	private JScrollPane scrollPane;
	private JTextField textDoanhThu, textVon, textDienTich, textTenTrangTrai, textMaTrangTrai;
	private JTable tableThongTinChiTiet;
	private JPanel plTimKiem;
	private JTextField textField;
	private JComboBox combobDienTich;
	private JButton btnTimKiem;
	private JTable table;
}
