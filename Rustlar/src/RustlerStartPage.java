import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;



public class RustlerStartPage extends JFrame{
	
	JLabel firstPlayer, secondPlayer;
	JRadioButton humanPlayer1, computerPlayerRandom, computerPlayerMinmax, humanPlayer2, computerRandomPlayer1, minimaxPlayer2;
	ButtonGroup group1, group2;
	JButton goButton;
	Player whitePlayer, blackPlayer;
	boolean whichComputerPlayer; //true for minimax false for random
	JTextField depth1, depth2;
	
	public RustlerStartPage(){
		
		setSize(450, 280);
		setTitle("Rustlar Game");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
		
		firstPlayer = new JLabel("Select the first player:");
		firstPlayer.setLocation(50, 50);
		firstPlayer.setSize(150, 30);
		
		secondPlayer = new JLabel("Select the second player:");
		secondPlayer.setLocation(250, 50);
		secondPlayer.setSize(200, 30);
		
		
		humanPlayer1= new JRadioButton("Human Player:");
		humanPlayer1.setSize(150, 30);
		humanPlayer1.setLocation(60, 110);
		

		computerRandomPlayer1= new JRadioButton("Random Player:");
		computerRandomPlayer1.setSize(150, 30);
		computerRandomPlayer1.setLocation(60, 80);
		
		minimaxPlayer2= new JRadioButton("Minimax Player:");
		minimaxPlayer2.setSize(150, 30);
		minimaxPlayer2.setLocation(60, 140);
		
		depth1=new JTextField("depth 1");
		depth1.setSize(70, 30);
		depth1.setLocation(90, 170);
		
		computerPlayerRandom= new JRadioButton("Random Player:");
		computerPlayerRandom.setSize(150, 30);
		computerPlayerRandom.setLocation(250, 80);
		
		computerPlayerMinmax= new JRadioButton("MiniMax Player:");
		computerPlayerMinmax.setSize(150, 30);
		computerPlayerMinmax.setLocation(250, 140);
		
		depth2=new JTextField("depth 2");
		depth2.setSize(70, 30);
		depth2.setLocation(270, 170);
		
		humanPlayer2= new JRadioButton("Human Player:");
		humanPlayer2.setSize(150, 30);
		humanPlayer2.setLocation(250, 110);
		
		group1=new ButtonGroup();
		group1.add(computerPlayerRandom);
		group1.add(computerPlayerMinmax);
		group1.add(humanPlayer2);
		
		group2=new ButtonGroup();
		group2.add(humanPlayer1);
		group2.add(computerRandomPlayer1);
		group2.add(minimaxPlayer2);
		
		goButton= new JButton("START");
		goButton.setSize(100, 50);
		goButton.setLocation(165, 200);
		
		goButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if( humanPlayer1.isSelected() && computerPlayerRandom.isSelected() ) {
					new RustlerInterface();
					//whichComputerPlayer=false;
				    
				}else if(humanPlayer1.isSelected() && humanPlayer2.isSelected()){
					new RustlerInterfaceHvsH();
					//whichComputerPlayer=true;
				
				}else if(humanPlayer1.isSelected() && computerPlayerMinmax.isSelected()){
					new RustlerInterfaceMiniMax();
					//whichComputerPlayer=true;
				}
				else if(computerRandomPlayer1.isSelected() && computerPlayerMinmax.isSelected()){
				new RustlerInterfaceAIvsRandom();
				//whichComputerPlayer=true;
				
				}else if (computerPlayerMinmax.isSelected() && minimaxPlayer2.isSelected()) {
					new RustlerInterfaceAIvsAI();
				}
		
			
				else {
					Object [] arr={"Close"};
					
					int n=JOptionPane.showOptionDialog(null, "Select one option for each player", "Rustler",JOptionPane.CLOSED_OPTION, JOptionPane.INFORMATION_MESSAGE,null, arr, arr[0]); 
				}
				
				/*
				if (computerPlayerRandom.isSelected()){
					whitePlayer.setHuman(false);
					whitePlayer.setPlayerOrder(1);
					
				}else if (computerPlayerMinmax.isSelected()){
					blackPlayer.setHuman(false);
					blackPlayer.setPlayerOrder(2);
				
				}else if (humanPlayer1.isSelected()){
					whitePlayer.setHuman(true);
					whitePlayer.setPlayerOrder(1);
				
				}else if (humanPlayer2.isSelected()){
					blackPlayer.setHuman(true);
					blackPlayer.setPlayerOrder(2);
					
				
				}*/
				
									
			}
		});

		
		add(firstPlayer);
		add(secondPlayer);
		add(humanPlayer1);
		add(computerRandomPlayer1);
		add(computerPlayerRandom);
		add(computerPlayerMinmax);
		add(minimaxPlayer2);
		add(humanPlayer2);
		add(depth1);
		add(depth2);
		add(goButton);

		
		setVisible(true);
	}
	public static void main(String[] args) {
		RustlerStartPage rustlarStart= new RustlerStartPage();
	}

}
