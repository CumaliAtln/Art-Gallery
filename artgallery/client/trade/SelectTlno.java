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

public class SelectTIno extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 6765732200341327722L;
	
	JButton jb1,jb2;
    JPanel jp1,jp2,jp3;
    JLabel jl1,jl2;
    public static JTextField jt1;

    public SelectTIno(){
        jb1 = new JButton("ç¡®å®š");

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();

        jl1 = new JLabel("è‰ºæœ¯å“�é‡‡è´­è®¢å�•æŸ¥è¯¢ç³»ç»Ÿ");
        jl2 = new JLabel("è´­ä¹°è®¢å�•ç¼–å�·");

        jt1 = new JTextField(8);

        jb1.addActionListener(this);

        jp1.add(jl1);
        jp2.add(jl2);
        jp2.add(jt1);

        jp3.add(jb1);

        this.add(jp1);
        this.add(jp2);
        this.add(jp3);

        this.setVisible(true);
        this.setLayout(new GridLayout(3,1));
        this.setBounds(720,350,510,280);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
    }

    public int verify(){
        Connection con = null;
        ResultSet rs;
        int result = 0;
        try {
            if (!jt1.getText().isEmpty()) {
                con = DatabaseConnection.getConnection();
                PreparedStatement ps = con.prepareStatement("select * from TradeInfo where TIno = ?");
                ps.setString(1, jt1.getText());
                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "è¯¥ç¼–å�·å­˜åœ¨", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
                    result = 1;
                } else {
                    JOptionPane.showMessageDialog(null, "è¯¥ç¼–å�·ä¸�å­˜åœ¨ï¼Œè¯·é‡�æ–°è¾“å…¥", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "è¯·è¾“å…¥å®Œæ•´ä¿¡æ�¯", "æ��ç¤ºæ¶ˆæ�¯", JOptionPane.WARNING_MESSAGE);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "ç¡®å®š") {
            if (verify() == 1) {
                new SelectArtworks();
                dispose();

            }else {
                jt1.setText("");
            }
        }
    }
}
