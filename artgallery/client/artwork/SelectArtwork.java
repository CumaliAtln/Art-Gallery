/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.client.artwork;

/**
 *
 * @author tr
 */

import client.trade.BuyArtWorks;
import function.DatabaseConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectArtwork extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5579901699753711581L;

	JTable jt;
	JScrollPane js = new JScrollPane();
	Vector<String> columnNames = null;
	Vector<Vector<String>> rowData = null;
	Connection con = null;
	ResultSet rs;

	JButton jb;
	JPanel jp;

	public SelectArtwork() {

		columnNames = new Vector<String>();
		rowData = new Vector<Vector<String>>();
		columnNames.add("è‰ºæœ¯å“�ç¼–å�·");
		columnNames.add("å��ç§°");
		columnNames.add("ç±»åˆ«");
		columnNames.add("å”®ä»·");
		columnNames.add("æ˜¯å�¦å·²å‡ºå”®");

		try {
			con = DatabaseConnection.getConnection();
			PreparedStatement ps;
			ps = con.prepareStatement("select * from Artwork");
			rs = ps.executeQuery();
			while (rs.next()) {
				Vector<String> vector = new Vector<String>();
				vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				rowData.add(vector);
			}
			System.out.println("OK");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		jt = new JTable(rowData, columnNames);
		js = new JScrollPane(jt);

		jb = new JButton("è´­ä¹°");
		jb.addActionListener(this);
		jp = new JPanel();
		jp.add(jb);
		jp.setLocation(100, 100);

		this.add(js);
		this.add(jp);
		this.setTitle("æŸ¥è¯¢");
		this.setLayout(new GridLayout(2, 2));

		this.setBounds(630, 300, 850, 500);
		this.setVisible(true);
		this.setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand() == "è´­ä¹°") {
			new BuyArtWorks();
			dispose();
		}
	}
}

