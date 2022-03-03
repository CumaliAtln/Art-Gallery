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

import client.Hall.SelectHall;
import client.HallReserve.*;
import artgallery.client.artist.SelectArtist;
import artgallery.client.artist.SelectArtistName;
import artgallery.client.artwork.SelectArtwork;
import client.exhibitionInfo.SelectInfo;
import client.exhibitionInfo.SelectInfoArtist;
import artgallery.client.artwork.SelectArtworkKind;
import artgallery.client.artwork.SelectArtworkPrice;
import artgallery.client.ticket.BuyTicket;
import artgallery.client.ticket.DeleteTicket;
import artgallery.client.ticket.SelectTno;
import client.trade.BuyArtWorks;
import client.trade.DeleteTrade;
import client.trade.SelectTIno;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
å®¢æˆ·ä¸»ç•Œé�¢
 */

public class User extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4508697313736701899L;
	JMenuBar jMenuBar;
	JMenu jm1, jm2, jm3, jm4, jm5, jm6,jm7;
	JMenuItem jmIt1, jmIt2, jmIt3, jmIt4, jmIt5, jmIt6, jmIt7, jmIt8, jmIt9, jmIt10, jmIt11, jmIt12, jmIt13, jmIt14,
			jmIt15, jmIt18, jmIt16, jmIt17,jmIt19;
	JPanel jp1;
	JLabel jl1;
	JButton jb5;
    JPanel jp5;

	public User() {

		// åŠ è½½å›¾ç‰‡
		ImageIcon icon = new ImageIcon("client1.jpg");
		Image icon2 =  Toolkit.getDefaultToolkit().getImage("huabi.jpg");
		this.setIconImage(icon2);

		// å°†å›¾ç‰‡æ”¾å…¥labelä¸­
		JLabel label = new JLabel(icon);

		// è®¾ç½®labelçš„å¤§å°�
		label.setBounds(0, 0, icon.getIconWidth(), icon.getIconHeight());

		// è�·å�–çª—å�£çš„ç¬¬äºŒå±‚ï¼Œå°†labelæ”¾å…¥
		this.getLayeredPane().add(label, Integer.valueOf(Integer.MIN_VALUE));

		// è�·å�–frameçš„é¡¶å±‚å®¹å™¨,å¹¶è®¾ç½®ä¸ºé€�æ˜�
		JPanel j = (JPanel) this.getContentPane();
		j.setOpaque(false);
		
		Font font = new Font("alias", Font.PLAIN, 22);
		jb5 = new JButton("é€€å‡ºåˆ°ä¸»ç•Œé�¢");
        jb5.setBackground(Color.WHITE);
        jb5.setFont(font);
        
		jMenuBar = new JMenuBar();
		jm1 = new JMenu("å±•å�…é¢„çº¦");
		jm1.addSeparator();
		jm2 = new JMenu("è‰ºæœ¯å±•é—¨ç¥¨");
		jm2.addSeparator();
		jm3 = new JMenu("è‰ºæœ¯å“�è´­ä¹°");
		jm3.addSeparator();
		jm4 = new JMenu("è‰ºæœ¯å±•ä¿¡æ�¯æŸ¥è¯¢");
		jm4.addSeparator();
		jm5 = new JMenu("è‰ºæœ¯å®¶ä¿¡æ�¯æŸ¥è¯¢");
		jm5.addSeparator();
		jm6 = new JMenu("è‰ºæœ¯å“�ä¿¡æ�¯æŸ¥è¯¢");
		jm6.addSeparator();
		jm7 = new JMenu("é€€å‡º");

		jmIt5 = new JMenuItem("é¢„å®šé—¨ç¥¨");
		jmIt6 = new JMenuItem("æŸ¥è¯¢é—¨ç¥¨");
		jmIt7 = new JMenuItem("å�–æ¶ˆè®¢å�•");

		jmIt1 = new JMenuItem("é¢„çº¦å±•å�…");
		jmIt2 = new JMenuItem("æŸ¥è¯¢é¢„çº¦ä¿¡æ�¯");
		jmIt3 = new JMenuItem("å�–æ¶ˆé¢„çº¦");
		jmIt14 = new JMenuItem("å±•å�…æŸ¥è¯¢");

		jmIt9 = new JMenuItem("è‰ºæœ¯å“�è´­ä¹°");
		jmIt10 = new JMenuItem("æŸ¥è¯¢é‡‡è´­ä¿¡æ�¯");
		jmIt11 = new JMenuItem("å�–æ¶ˆè®¢å�•");

		jmIt13 = new JMenuItem("å…¨éƒ¨å±•è§ˆä¿¡æ�¯æŸ¥è¯¢");
		jmIt12 = new JMenuItem("è‰ºæœ¯å®¶å±•è§ˆä¿¡æ�¯æŸ¥è¯¢");
		
		jmIt15 = new JMenuItem("æ‰€æœ‰è‰ºæœ¯å®¶æŸ¥è¯¢");
		jmIt17 = new JMenuItem("è‰ºæœ¯å®¶å§“å��æŸ¥è¯¢");

		jmIt16 = new JMenuItem("æ‰€æœ‰è‰ºæœ¯å“�æŸ¥è¯¢");
		jmIt8 = new JMenuItem("è‰ºæœ¯å“�ç±»åˆ«æŸ¥è¯¢");
		jmIt18 = new JMenuItem("è‰ºæœ¯å“�ä»·æ ¼æŸ¥è¯¢");
		
		jmIt19 = new JMenuItem("é€€å‡ºåˆ°ä¸»è�œå�•");

		jm1.add(jmIt1);
		jm1.add(jmIt2);
		jm1.add(jmIt3);
		jm1.add(jmIt14);
		
		jm2.add(jmIt5);
		jm2.add(jmIt6);
		jm2.add(jmIt7);

		jm3.add(jmIt9);
		jm3.add(jmIt10);
		jm3.add(jmIt11);

		jm4.add(jmIt13);
		jm4.add(jmIt12);
		

		// è‰ºæœ¯å®¶
		jm5.add(jmIt15);
		jm5.add(jmIt17);

		// è‰ºæœ¯å“�
		jm6.add(jmIt16);
		jm6.add(jmIt8);
		jm6.add(jmIt18);

		jm7.add(jmIt19);
		
		jp5 = new JPanel();
        jb5.addActionListener(this);
        jp5.add(jb5);
        jp5.setOpaque(false);
        this.add(jp5);
        
		jMenuBar.add(jm1);
		jMenuBar.add(jm2);
		jMenuBar.add(jm3);
		jMenuBar.add(jm4);
		jMenuBar.add(jm5);
		jMenuBar.add(jm6);
		jMenuBar.add(jm7);
		setJMenuBar(jMenuBar);

		click();
		// this.add(jp1);
		this.setVisible(true);
		this.setTitle("è‰ºæœ¯ç”»å»Šç®¡ç�†ç³»ç»Ÿ");
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// this.setBounds(300, 200, 800, 500);
		this.setBounds(550, 240, icon.getIconWidth(), 590);
	}

	public void click() {
		jmIt1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new InsertReserve();
			}
		});

		jmIt2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectRno();
			}
		});

		jmIt3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteReserve();
			}
		});

		jmIt5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyTicket();
			}
		});

		jmIt6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTno();
			}
		});

		jmIt7.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTicket();
			}
		});

		jmIt9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new BuyArtWorks();
			}
		});

		jmIt10.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectTIno();
			}
		});

		jmIt11.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new DeleteTrade();
			}
		});

		jmIt13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectInfo();
			}
		});
		
		jmIt12.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectInfoArtist();
			}
		});

		jmIt14.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectHall();
			}
		});

		jmIt15.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtist();
			}
		});

		jmIt17.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtistName();
			}
		});

		jmIt16.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtwork();
			}
		});
		
		jmIt8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtworkKind();
			}
		});
		
		jmIt18.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new SelectArtworkPrice();
			}
		});
		
		jmIt19.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				//new SystemMain();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getActionCommand() == "é€€å‡ºåˆ°ä¸»ç•Œé�¢"){
        	this.dispose();
            //new SystemMain();
        }
	}
}
