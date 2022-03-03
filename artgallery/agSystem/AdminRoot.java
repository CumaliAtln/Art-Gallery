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

import client.Hall.Hall;
import artgallery.client.artist.Artist;
import artgallery.client.artwork.Artwork;
import artgallery.client.exhibition.Exhibition;
import client.exhibitionInfo.Info;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
ç®¡ç�†å‘˜ä¸»ç•Œé�¢
 */

public class AdminRoot extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = -6227226956418602689L;
	
	JButton jb1, jb2, jb3 ,jb4,jb5,jb6;
    JPanel jp1,jp2,jp3,jp4,jp5;
    JLabel jl1;

    public AdminRoot(){

        Font font = new Font("alias", Font.PLAIN, 22);
        Font font1 = new Font("alias", Font.PLAIN, 30);


        //åŠ è½½å›¾ç‰‡
        ImageIcon icon=new ImageIcon("manage.jpg");
        Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);

    //å°†å›¾ç‰‡æ”¾å…¥labelä¸­
        JLabel label=new JLabel(icon);

      //è®¾ç½®labelçš„å¤§å°�
        label.setBounds(0,0,icon.getIconWidth(),icon.getIconHeight());
//
//        //è�·å�–çª—å�£çš„ç¬¬äºŒå±‚ï¼Œå°†labelæ”¾å…¥
        this.getLayeredPane().add(label,Integer.valueOf(Integer.MIN_VALUE));
//
//        //è�·å�–frameçš„é¡¶å±‚å®¹å™¨,å¹¶è®¾ç½®ä¸ºé€�æ˜�
        JPanel j=(JPanel)this.getContentPane();
        j.setOpaque(false);

        jb1 = new JButton("è‰ºæœ¯å±•ä¿¡æ�¯ç®¡ç�†");
        jb1.setBackground(Color.WHITE);
        jb1.setFont(font);
        jb2 = new JButton("è‰ºæœ¯å®¶ç®¡ç�†");
        jb2.setBackground(Color.WHITE);
        jb2.setFont(font);
        jb3 = new JButton("å±•å�…ç®¡ç�†");
        jb3.setBackground(Color.WHITE);
        jb3.setFont(font);
        jb4 = new JButton("è‰ºæœ¯å“�ç®¡ç�†");
        jb4.setBackground(Color.WHITE);
        jb4.setFont(font);
        jb5 = new JButton("é€€å‡ºåˆ°ä¸»ç•Œé�¢");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);
        jb6 = new JButton("è‰ºæœ¯å±•ç®¡ç�†");
        jb6.setBackground(Color.WHITE);
        jb6.setFont(font);

        jl1 = new JLabel("ç®¡ç�†å‘˜è�œå�•");
        jl1.setFont(font1);
        jl1.setForeground(new Color(255,255,0));

        jb1.addActionListener(this);
        jb2.addActionListener(this);
        jb3.addActionListener(this);
        jb4.addActionListener(this);
        jb5.addActionListener(this);
        jb6.addActionListener(this);

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();


        jp1.add(jb1);
        jp1.add(jb2);
        jp1.add(jb6);
        jp2.add(jb3);
        jp2.add(jb4);
        jp4.add(jb5);
        jp3.add(jl1);

        jp1.setOpaque(false);
        jp2.setOpaque(false);
        jp3.setOpaque(false);
        jp4.setOpaque(false);

        this.add(jp3);
        this.add(jp1);
        this.add(jp2);
        this.add(jp4);

        this.setVisible(true);
        this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
        this.setLayout(new GridLayout(4, 1));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setBounds(530, 200, icon.getIconWidth(), icon.getIconHeight());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand() == "é€€å‡ºåˆ°ä¸»ç•Œé�¢"){
        	this.dispose();
           // new SystemMain();
        }else if (e.getActionCommand() == "è‰ºæœ¯å±•ä¿¡æ�¯ç®¡ç�†"){
            new Info();
            this.dispose();
        }else if (e.getActionCommand() == "è‰ºæœ¯å®¶ç®¡ç�†"){
            new Artist();
            this.dispose();
        }else if (e.getActionCommand() == "è‰ºæœ¯å“�ç®¡ç�†"){
            new Artwork();
            this.dispose();
        }else if (e.getActionCommand() == "å±•å�…ç®¡ç�†"){
            new Hall();
            this.dispose();
        }else if (e.getActionCommand() == "è‰ºæœ¯å±•ç®¡ç�†"){
            new Exhibition();
            this.dispose();
        }
    }
}
