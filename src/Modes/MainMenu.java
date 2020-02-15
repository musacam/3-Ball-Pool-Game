package Modes;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JTextField;

import Gameplay.Ball;
import Gameplay.BallPractice;


public class MainMenu extends JComponent {
	
	JFrame jf;
	JTextField header;
	JButton practice,twoPlayer,online;	
	
	public void init() {
		
		jf = new JFrame("3 Ball Poolé!");
		jf.setLayout(null);
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jf.getContentPane().setBackground(Color.cyan);
		
		header = new JTextField("Welcome to 3 Ball Poolé!");
		header.setEditable(false);
		header.setBounds(100,50,200,30);
		header.setHorizontalAlignment(JTextField.CENTER);

		practice = new JButton("Practice Mode");
		twoPlayer = new JButton("Two Player");
		online = new JButton("Online");
		practice.setBounds(100,100,200,50);
		twoPlayer.setBounds(100,170,200,50);
		online.setBounds(100,240,200,50);
		
		jf.add(header);
		jf.add(practice);
		jf.add(twoPlayer);
		jf.add(online);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setLocation(dim.width/2-jf.getSize().width/2, dim.height/2-jf.getSize().height/2);
		jf.setVisible(true);
		
		practice.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				JFrame f = new JFrame();
		        BallPractice bp;
				try {
					bp = new BallPractice();
			        //f.setSize(820,440);
			        f.setSize(1200,600);
			        bp.init();			        
			        f.getContentPane().setBackground(Color.cyan);
			        			
			        f.add(bp.p1);
			        f.add(bp.pw);
			        f.add(bp.tm);
			        f.add(bp.ph1);
			        f.add(bp);
			        
			        f.addMouseListener(bp);
			        f.addMouseMotionListener(bp);
			        f.addKeyListener(bp);
			        
			        f.setVisible(true);       
			        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
			        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}					
			}
		});
		twoPlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				JFrame f = new JFrame();
		        Ball bp;
				try {
					bp = new Ball();
			        //f.setSize(820,440);
			        f.setSize(1200,600);
			        bp.init();			        
			        f.getContentPane().setBackground(Color.cyan);
			        			
			        f.add(bp.p1);
			        f.add(bp.p2);
			        f.add(bp.pw);
			        f.add(bp.pt);
			        f.add(bp.tm);
			        f.add(bp.ph2);
			        f.add(bp.ph1);
			        f.add(bp);
			        
			        f.addMouseListener(bp);
			        f.addMouseMotionListener(bp);
			        f.addKeyListener(bp);
			        
			        f.setVisible(true);       
			        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
			        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		online.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);
				OnlineMode online = new OnlineMode();
				online.init();
			}
		});
		
		
	}

}
