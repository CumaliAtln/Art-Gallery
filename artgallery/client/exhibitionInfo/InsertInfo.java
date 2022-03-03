package artgallery.client.exhibitionInfo;


import entity.ExhibitionInformation;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

/*
æ·»åŠ è‰ºæœ¯å±•ä¿¡æ�¯
 */
public class InsertInfo extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3776206036386887579L;
	JTextField jtf1, jtf2, jtf3, jtf4, jtf5, jtf6 = null;
	JLabel jl1, jl2, jl3, jl4, jl5, jl6, jl7, jl8, jl9 = null;
	JPanel jp1, jp2, jp3, jp4, jp5, jp6, jp7, jp8 = null;
	JButton jb1, jb2;

	public InsertInfo() {

		jl1 = new JLabel(" ä¿¡æ�¯ç¼–å�·ï¼š");
		jl2 = new JLabel(" è‰ºæœ¯å®¶ç¼–å�·ï¼š");
		jl3 = new JLabel(" è‰ºæœ¯å“�ç¼–å�·ï¼š");
		jl4 = new JLabel(" å±•å�…ç¼–å�·ï¼š");
		jl5 = new JLabel(" è‰ºæœ¯å±•ç¼–å�·ï¼š");
		jl6 = new JLabel(" æ—¶é—´ï¼š");
		jl7 = new JLabel("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");

		jb1 = new JButton("å�‘å¸ƒ");
		jb1.addActionListener(this);

		jtf1 = new JTextField(6);
		jtf2 = new JTextField(6);
		jtf3 = new JTextField(6);
		jtf4 = new JTextField(6);
		jtf5 = new JTextField(6);
		jtf6 = new JTextField(6);

		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		jp4 = new JPanel();
		jp5 = new JPanel();
		jp6 = new JPanel();
		jp7 = new JPanel();
		jp8 = new JPanel();

		jp1.add(jl7);

		jp2.add(jl1);
		jp2.add(jtf1);
		jp2.add(jl2);
		jp2.add(jtf2);

		jp3.add(jl3);
		jp3.add(jtf3);
		jp3.add(jl4);
		jp3.add(jtf4);

		jp4.add(jl5);
		jp4.add(jtf5);
		jp4.add(jl6);
		jp4.add(jtf6);

		jp5.add(jb1);

		this.add(jp1);
		this.add(jp2);
		this.add(jp3);
		this.add(jp4);
		this.add(jp5);

		this.setVisible(true);
		this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		this.setLayout(new GridLayout(6, 4));
		this.setBounds(700, 300, 752, 471);
	}

	// å±•å�…ç¼–å�·éªŒè¯�
	public int verifyHno() {
		Connection con = null;
		ResultSet rs;
		int result = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Hall where Hno = ?");
			ps.setString(1, jtf6.getText());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// è‰ºæœ¯å®¶ç¼–å�·éªŒè¯�
	public int verifyAno() {
		Connection con = null;
		ResultSet rs;
		int result = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Artist where Ano = ?");
			ps.setString(1, jtf3.getText());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	// è‰ºæœ¯å“�ç¼–å�·éªŒè¯�
	public int verifyAWno() {
		Connection con = null;
		ResultSet rs;
		int result = 0;
		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from Artwork where AWno = ?");
			ps.setString(1, jtf4.getText());
			rs = ps.executeQuery();
			if (rs.next()) {
				result = 1;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public void insertinformation() {
		Connection con = null;
//		int result = 0;
		try {
			con = DatabaseConnection.getConnection();
			String sql = "insert into ExhibitionInfo values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ExhibitionInformation ei = new ExhibitionInformation();

			if (!jtf1.getText().isEmpty() && !jtf2.getText().isEmpty() && !jtf3.getText().isEmpty()
					&& !jtf4.getText().isEmpty() && !jtf5.getText().isEmpty() && !jtf6.getText().isEmpty()) {
				if ((verifyAno() == 1) && (verifyHno() == 1) && (verifyAWno() == 1)) {
					ei.setEi_no(jtf1.getText());
					ei.setA_no(jtf2.getText());
					ei.setAw_no(jtf3.getText());
					ei.setE_no(jtf4.getText());
					ei.setE_no(jtf5.getText());
					ei.setEi_time(jtf6.getText());

					ps.setString(1, ei.getEi_no());
					ps.setString(2, ei.getA_no());
					ps.setString(3, ei.getAw_no());
					ps.setString(4, ei.getH_no());
					ps.setString(5, ei.getE_no());
					ps.setString(6, ei.getEi_time());
//					result = ps.executeUpdate();
					JOptionPane.showMessageDialog(null, "å�‘å¸ƒæˆ�åŠŸ", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
					System.out.println("æ�’å…¥æ•°æ�®æˆ�åŠŸ");
					clear();
				} else {
					JOptionPane.showMessageDialog(null, "å�‘å¸ƒå¤±è´¥", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
					System.out.println("æ�’å…¥æ•°æ�®å¤±è´¥");
					clear();
				}
			} else {
				JOptionPane.showMessageDialog(null, "è¯·è¾“å…¥å®Œæ•´ä¿¡æ�¯", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void clear() {
		jtf1.setText("");
		jtf2.setText("");
		jtf3.setText("");
		jtf4.setText("");
		jtf5.setText("");
		jtf6.setText("");

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "å�‘å¸ƒ") {
			insertinformation();
		}
	}
}
