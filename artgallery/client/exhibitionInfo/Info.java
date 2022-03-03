package client.exhibitionInfo;

import DeleteInfo;
import client.HallReserve.SelectReserveAll;

import client.ticket.SelectTicketAll;
import client.trade.SelectArtworksAll;

import javax.swing.*;

import agSystem.AdminRoot;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Info extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 7864382819018546499L;
	
	JPanel jp1, jp2 ,jp3,jp4 = null;
    JButton jb1, jb2, jb3,jb4,jb5,jb6,jb7,jb8 = null;
    ResultSet rs;
    Statement st;

    public Info() {
        Font font = new Font("alias", Font.PLAIN, 22);

        //åŠ è½½å›¾ç‰‡
        ImageIcon icon = new ImageIcon("lfg_main.jpg");
        Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);
//
//        //å°†å›¾ç‰‡æ”¾å…¥labelä¸­
        JLabel label = new JLabel(icon);
//
//        //è®¾ç½®labelçš„å¤§å°�
        label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());
//
//        //è�·å�–çª—å�£çš„ç¬¬äºŒå±‚ï¼Œå°†labelæ”¾å…¥
        this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));
//
//        //è�·å�–frameçš„é¡¶å±‚å®¹å™¨,å¹¶è®¾ç½®ä¸ºé€�æ˜�
        JPanel j = (JPanel) this.getContentPane();
        j.setOpaque(false);

        JPanel jp5 = new JPanel();
        JLabel jl1 = new JLabel("   ");

        jb1 = new JButton("æŸ¥è¯¢è‰ºæœ¯å±•ä¿¡æ�¯");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb8 = new JButton("æŸ¥è¯¢è‰ºæœ¯å®¶è‰ºæœ¯å±•ä¿¡æ�¯");
        jb8.setBackground(Color.WHITE);
        jb8.setFont(font);
        jb2 = new JButton("å�‘å¸ƒè‰ºæœ¯å±•ä¿¡æ�¯");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb3 = new JButton("åˆ é™¤è‰ºæœ¯å±•ä¿¡æ�¯");
        jb3.setBackground(Color.WHITE);
        jb3.setFont(font);
        jb4 = new JButton("è¿”å›�");
        jb4.setBackground(Color.WHITE);
        jb4.setFont(font);
        jb5 = new JButton("è´­ç¥¨ä¿¡æ�¯æŸ¥è¯¢");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);
        jb6 = new JButton("è‰ºæœ¯å“�é‡‡è´­ä¿¡æ�¯æŸ¥è¯¢");
        jb6.setBackground(Color.WHITE);
        jb6.setFont(font);
        jb7 = new JButton("å±•å�…é¢„å®šä¿¡æ�¯æŸ¥è¯¢");
        jb7.setBackground(Color.WHITE);
        jb7.setFont(font);

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);
        jb7.addActionListener(this);
        jb8.addActionListener(this);


        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();

        jp1.add(jb1);
        jp1.add(jb8);
        jp1.add(jb2);
        jp2.add(jb3);
        jp2.add(jb5);
        jp4.add(jb6);
        jp4.add(jb7);
        jp3.add(jb4);
        jp5.add(jl1);


        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);
        jp5.setOpaque(false);

        this.add(jp5);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);
        this.add(jp3);

        this.setVisible(true);
//        this.setResizable(false);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
        this.setLayout(new GridLayout(5, 4));
        this.setBounds(675, 270, icon.getIconWidth(), icon.getIconHeight());
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "è¿”å›�") {
            new AdminRoot();
            dispose();

        } else if (e.getActionCommand() == "æŸ¥è¯¢è‰ºæœ¯å±•ä¿¡æ�¯") {
            new SelectInfo();
        } else if (e.getActionCommand() == "å�‘å¸ƒè‰ºæœ¯å±•ä¿¡æ�¯") {
            //this.dispose();
            new InsertInfo();
        }else if(e.getActionCommand() == "åˆ é™¤è‰ºæœ¯å±•ä¿¡æ�¯"){
            //this.dispose();
            new DeleteInfo();
        }else if (e.getActionCommand() == "è´­ç¥¨ä¿¡æ�¯æŸ¥è¯¢"){
            //this.dispose();
            new SelectTicketAll();
        }else if (e.getActionCommand() == "è‰ºæœ¯å“�é‡‡è´­ä¿¡æ�¯æŸ¥è¯¢"){
            new SelectArtworksAll();
        }
        else if (e.getActionCommand() == "å±•å�…é¢„å®šä¿¡æ�¯æŸ¥è¯¢"){
            new SelectReserveAll();
        }else if (e.getActionCommand() == "æŸ¥è¯¢è‰ºæœ¯å®¶è‰ºæœ¯å±•ä¿¡æ�¯"){
            new SelectInfoArtist();
        }
    }
}
