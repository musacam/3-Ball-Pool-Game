package Modes;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.io.IOException;

import javax.swing.*;

import Gameplay.Ball;
import Gameplay.BallClient;
import Gameplay.BallServer;

public class OnlineMode {

	JFrame jf;
	JTextField header,testData,testData2;
	JButton server,client,send;
	JCheckBox s,c;
	
	public void init() {
		
		jf = new JFrame("3 Ball Poolé! - Online Modé");
		jf.setLayout(null);
		jf.setSize(400, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.getContentPane().setBackground(Color.cyan);
		
		s = new JCheckBox("Local Play?");
		s.setBounds(150,250,100,20);	
	    s.setSelected(false);	  
		jf.add(s);
		
		
		header = new JTextField("This Is Online Mode!");
		header.setEditable(false);
		header.setBounds(100,50,200,30);
		header.setHorizontalAlignment(JTextField.CENTER);
		jf.add(header);
		testData = new JTextField("Ip Here!");
		testData.setHorizontalAlignment(JTextField.CENTER);
		testData.setBounds(100,200,200,30);
		jf.add(testData);
		
		server = new JButton("Server");
		client = new JButton("Client");
		server.setBounds(100,100,200,30);
		client.setBounds(100,150,200,30);
		jf.add(server);
		jf.add(client);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		jf.setLocation(dim.width/2-jf.getSize().width/2, dim.height/2-jf.getSize().height/2);
		jf.setVisible(true);
		
		server.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				jf.setVisible(false);												
				JFrame f = new JFrame("3 Ball Poolé! - Server");
				try {
					BallServer bp = new BallServer();
			        //f.setSize(820,440);
			        f.setSize(1200,600);		        
			        f.getContentPane().setBackground(Color.cyan);
			        bp.init();			
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
			        bp.serverinit();			        
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		client.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//JOptionPane.showMessageDialog(null,"Practice Mode Locked!");
				jf.setVisible(false);												
				JFrame f = new JFrame("3 Ball Poolé! - Client");
				try {					
					BallClient bp = new BallClient();
			        //f.setSize(820,440);
			        f.setSize(1200,600);		        
			        f.getContentPane().setBackground(Color.cyan);
			        bp.init();			
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
			        bp.clientinit(testData.getText());
			        
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		s.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent event) {
		        JCheckBox s = (JCheckBox) event.getSource();
		        if (s.isSelected()) {
					testData.setText("localhost"); 		    
				} 
		    }
		});

		
		
	}
	
	
}
