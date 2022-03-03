/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.agSystem;

/**
 *
 * @author tr
 */

import artgallery.function.DatabaseConnection;

import javax.swing.*;

//import client.Hall.UpdateHall;

import java.sql.*;

/*
é‡‡ç”¨å�•ä¾‹æ¨¡å¼�
 */

public class UserVerify {

	Connection ct;
	PreparedStatement ps;
	ResultSet rs;
	String user, pwd;

	String a, b, c, d, ee, f;

	public UserVerify() {
	}

	// æ³¨å†Œç”¨æˆ·çš„æ–¹æ³•
	public void UserRegis(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("insert into user values(?,?)");
			ps.setString(1, a);
			ps.setString(2, b);

			// æ‰§è¡Œ
			int i = ps.executeUpdate();
			if (i == 1) {
				JOptionPane.showMessageDialog(null, "æ³¨å†Œæˆ�åŠŸ", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
				System.out.println("æ³¨å†Œæˆ�åŠŸ");
			} else {
				JOptionPane.showMessageDialog(null, "æ³¨å†Œå¤±è´¥", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// ç®¡ç�†å‘˜ç™»å½•éªŒè¯�æ–¹æ³•
	public void verifyRootWithSQL(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=? and Spwd=?");
			ps.setString(1, a);
			ps.setString(2, b);

			// ResultSetç»“æ�œé›†,æŠŠResultSetç�†è§£æˆ�è¿”å›�ä¸€å¼ è¡¨è¡Œçš„ç»“æ�œé›†
			rs = ps.executeQuery();

			if (rs.next()) {
				user = rs.getString(1);
				pwd = rs.getString(2);
				JOptionPane.showMessageDialog(null, "ç™»å½•æˆ�åŠŸï¼�ï¼�ï¼�", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
				System.out.println("ç™»å½•æˆ�åŠŸ");
				new AdminRoot();
				SystemMain m = new SystemMain();
				m.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��æˆ–è€…å¯†ç �é”™è¯¯ï¼Œè¯·é‡�æ–°è¾“å…¥ï¼�", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// å®¢æˆ·ç™»å½•éªŒè¯�æ–¹æ³•
	public void verifyUserWithSQL(String a, String b) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=? and Spwd=?");
			ps.setString(1, a);
			ps.setString(2, b);

			// ResultSetç»“æ�œé›†,æŠŠResultSetç�†è§£æˆ�è¿”å›�ä¸€å¼ è¡¨è¡Œçš„ç»“æ�œé›†
			rs = ps.executeQuery();

			if (rs.next()) {
				user = rs.getString(1);
				pwd = rs.getString(2);
				JOptionPane.showMessageDialog(null, "ç™»å½•æˆ�åŠŸï¼�ï¼�ï¼�", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
				System.out.println("ç™»å½•æˆ�åŠŸ");
				new User();
				SystemMain m = new SystemMain();
				m.dispose();
			} else {
				JOptionPane.showMessageDialog(null, "ç”¨æˆ·å��æˆ–è€…å¯†ç �é”™è¯¯ï¼Œè¯·é‡�æ–°è¾“å…¥ï¼�", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// æ³¨å†ŒéªŒè¯�æ–¹æ³•ï¼Œåˆ¤æ–­ç”¨æˆ·å��æ˜¯å�¦å·²ç»�å­˜åœ¨
	public void verifyRegisterWithSQL(String a) {
		try {
			ct = DatabaseConnection.getConnection();
			ps = ct.prepareStatement("select * from user where Sacc=?");
			ps.setString(1, a);

			rs = ps.executeQuery();
			if (rs.next()) {
				JOptionPane.showMessageDialog(null, "è¯¥ç”¨æˆ·å��å·²ç»�å­˜åœ¨", "æ��ç¤ºä¿¡æ�¯", JOptionPane.WARNING_MESSAGE);
			} else {
				this.UserRegis(RegistRoot.jtf1.getText(), RegistRoot.jtf2.getText());
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}