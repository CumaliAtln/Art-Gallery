package client.HallReserve;

import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DeleteReserve extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6796897621259538149L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public int n;

    public DeleteReserve(){
        jb1 = new JButton("ç¡®å®š");
        //jb2 = new JButton("è¿”å›�");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jt1 = new JTextField(8);
        jl1 = new JLabel("é¢„çº¦ç¼–å�·");
        jl2 = new JLabel("å±•å�…é¢„çº¦ç³»ç»Ÿ");

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

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from Reserve where RNO = ?");
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
            PreparedStatement ps = con.prepareStatement("delete from Reserve where RNO = ?");
            ps.setString(1,jt1.getText());
            ps.executeUpdate();
            //n = JOptionPane.showConfirmDialog(null, "ç¡®è®¤åˆ é™¤", "æ ‡é¢˜",JOptionPane.YES_NO_OPTION);//è¿”å›�çš„æ˜¯æŒ‰é’®
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
                delete();
            }else {
                JOptionPane.showMessageDialog(null,"è¯¥ç¼–å�·ä¸�å­˜åœ¨ï¼Œè¯·é‡�æ–°è¾“å…¥","æ��ç¤ºæ¶ˆæ�¯",JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
            }
        }
    }
}
