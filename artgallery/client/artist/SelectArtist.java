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

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

public class SelectArtist extends JFrame{

    /**
	 * 
	 */
	private static final long serialVersionUID = 2442551114083693386L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectArtist(){

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("è‰ºæœ¯å®¶ç¼–å�·");
        columnNames.add("å§“å��");
        columnNames.add("èº«ä»½è¯�å�·");
        columnNames.add("è�Œä¸š");
        columnNames.add("å·¥ä½œå�•ä½�");
        columnNames.add("æ‰‹æœºå�·");


        try{
            con = DatabaseConnection.getConnection();
            PreparedStatement ps;
            ps = con.prepareStatement("select * from Artist");
            rs = ps.executeQuery();
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
                vector.add(rs.getString(2));
                vector.add(rs.getString(3));
                vector.add(rs.getString(4));
                vector.add(rs.getString(5));
                vector.add(rs.getString(6));
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
        this.setLayout(new GridLayout(1,2));

        this.setBounds(630,300,850,500);

        this.setVisible(true);
        //this.setResizable(false);
    }
}
