/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package artgallery.client.artist;

/**
 *
 * @author tr
 */
package client.artist;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import function.DatabaseConnection;

public class SelectArtistNameout extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2001005362956966446L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectArtistNameout(){

    	//æ˜¾ç¤ºçš„å±�æ€§
        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("è‰ºæœ¯å®¶ç¼–å�·");
        columnNames.add("å§“å��");
        
        columnNames.add("è�Œä¸š");
        columnNames.add("å·¥ä½œå�•ä½�");
        


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select Ano,Aname,Amajor,Aworkplace from artist where Aname = ?");
            ps.setString(1,SelectArtistName.jt1.getText()); //å°†å‰�ä¸€ä¸ªå¡«å…¥çš„å†…å®¹ç›´æ�¥å�–è¿‡æ�¥
            rs = ps.executeQuery();
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                rowData.add(vector);
            }
            System.out.println("OK");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                con.close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }

        jt = new JTable(rowData,columnNames);
        js = new JScrollPane(jt);

        this.add(js);
        this.setTitle("æŸ¥è¯¢");
        this.setLayout(new GridLayout(2,2));
        this.setBounds(644,300,850,500);
        this.setVisible(true);
        //this.setResizable(false);
    }
}
