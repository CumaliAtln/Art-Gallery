import javax.swing.*;

import function.DatabaseConnection;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/*
åˆ é™¤è‰ºæœ¯å±•ä¿¡æ�¯
 */
public class DeleteInfo extends JFrame implements ActionListener {
   
	/**
	 * 
	 */
	private static final long serialVersionUID = -5691386351618361094L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JTextField jt1;
    JLabel jl1,jl2;

    public DeleteInfo(){
        jb1 = new JButton("ç¡®å®š");
        //jb2 = new JButton("è¿”å›�");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jt1 = new JTextField(8);
        jl1 = new JLabel("è‰ºæœ¯å±•ç¼–å�·");
        jl2 = new JLabel("è‰ºæœ¯å±•ä¿¡æ�¯ç³»ç»Ÿ");

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
        this.setBounds(712,320,600,400);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
        this.setLayout(new GridLayout(6,4));
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement("select * from ExhibitionInfo where EIno = ?");
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
            if (!jt1.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("delete from ExhibitionInfo where EIno = ?");
                ps.setString(1, jt1.getText());
                ps.executeUpdate();
                System.out.println("æ•°æ�®åˆ é™¤æˆ�åŠŸ");
                JOptionPane.showMessageDialog(null, "åˆ é™¤æˆ�åŠŸ", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
                jt1.setText("");
                con.close();
                System.out.println("æ•°æ�®åº“å…³é—­æˆ�åŠŸ");
            }else {
                JOptionPane.showMessageDialog(null, "è¯·è¾“å…¥å®Œæ•´ä¿¡æ�¯", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);

            }
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