package client.trade;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteTrade extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6966931113394085856L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public DeleteTrade(){
        jb1 = new JButton("ç¡®å®š");
        //jb2 = new JButton("è¿”å›�");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jt1 = new JTextField(8);
        jl1 = new JLabel("è´­ä¹°è®¢å�•ç¼–å�·");
        jl2 = new JLabel("è‰ºæœ¯å“�é‡‡è´­ç³»ç»Ÿ");

        jb1.addActionListener(this);
        //jb2.addActionListener(this);

        jp1.add(jl2);
        jp2.add(jl1);
        jp2.add(jt1);
        jp3.add(jb1);
        //jp3.add(jb2);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setBounds(700,300,600,400);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
        this.setLayout(new GridLayout(6,4));
    }

    
 // è®¾ç½®è¯¥è‰ºæœ¯å“�çš„çŠ¶æ€�
 	public void nosold() {
 		Connection con = null;
 		try {
 			con = DatabaseConnection.getConnection();
 			String sql = "update ArtWork set AWsold = '0' where AWno = (select AWno from TradeInfo where TIno = ?)";
 			PreparedStatement ps = con.prepareStatement(sql);
 			ps.setString(1, jt1.getText());
 			ps.executeUpdate();
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}
 	}
 	
    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from TradeInfo where TIno = ?");
            ps.setString(1,jt1.getText());
            rs = ps.executeQuery();
            if (rs.next()){
                result = 1;
                
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    public void delete(){
        Connection con = null;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from TradeInfo where TIno = ?");
            ps.setString(1,jt1.getText());
            ps.executeUpdate();
            System.out.println("æ•°æ�®åˆ é™¤æˆ�åŠŸ");
            JOptionPane.showMessageDialog(null,"å�–æ¶ˆæˆ�åŠŸ","æ��ç¤ºæ¶ˆæ�¯",JOptionPane.WARNING_MESSAGE);
            
            jt1.setText("");
            con.close();
            System.out.println("æ•°æ�®åº“å…³é—­æˆ�åŠŸ");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "ç¡®å®š"){
            if (verify() == 1) {
            	nosold();
                delete();
            }else {
                JOptionPane.showMessageDialog(null,"è¯¥è®¢å�•ç¼–å�·ä¸�å­˜åœ¨ï¼Œè¯·é‡�æ–°è¾“å…¥","æ��ç¤ºæ¶ˆæ�¯",JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
            }
        }
    }
}
