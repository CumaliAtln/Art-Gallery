package client.exhibitionInfo;

import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SelectInfoArtistout extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2739623712098118172L;
	
	JTable jt;
    JScrollPane js = new JScrollPane();
    Vector<String> columnNames = null;
    Vector<Vector<String>> rowData = null;
    Connection con = null;
    ResultSet rs;

    public SelectInfoArtistout(){

    	//æ˜¾ç¤ºçš„å±�æ€§
        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("è‰ºæœ¯å±•ç¼–å�·");
		columnNames.add("è‰ºæœ¯å®¶å��ç§°");
		columnNames.add("è‰ºæœ¯å“�å��ç§°");
		columnNames.add("å±•å�…å��ç§°");
		columnNames.add("è‰ºæœ¯å±•å��ç§°");
		columnNames.add("æ—¶é—´");
		columnNames.add("è‰ºæœ¯å“�ç±»åˆ«");
		columnNames.add("ä»·æ ¼");
        
        try{  
            rs = SelectInfoArtist.getRs();
            Vector<String> vector1 = new Vector<String>();
            vector1.add(rs.getString(1));
			vector1.add(rs.getString(2));
			vector1.add(rs.getString(3));
			vector1.add(rs.getString(4));
			vector1.add(rs.getString(5));
			vector1.add(rs.getString(6));
			vector1.add(rs.getString(7));
			vector1.add(rs.getString(8));
            rowData.add(vector1);
            while (rs.next()){
                Vector<String> vector = new Vector<String>();
                vector.add(rs.getString(1));
				vector.add(rs.getString(2));
				vector.add(rs.getString(3));
				vector.add(rs.getString(4));
				vector.add(rs.getString(5));
				vector.add(rs.getString(6));
				vector.add(rs.getString(7));
				vector.add(rs.getString(8));
                rowData.add(vector);
            }
            System.out.println("OK");
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try{
                rs.close();
                //con.close();
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
