import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import java.util.Scanner;

public class Baccarat_GUI extends JFrame {
	int rounds = 0;
	int purse = 50;
	JPanel p0 = new JPanel();
	JPanel p01 = new JPanel();
	JPanel p02 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p12 = new JPanel();
	JPanel p2 = new JPanel();
	JPanel p21 = new JPanel();
	JPanel p211 = new JPanel();
	JPanel p22 = new JPanel();
	JPanel p222 = new JPanel();
	JPanel p3 = new JPanel();
	JPanel p32 = new JPanel();
	JPanel p4 = new JPanel();
	JPanel p5 = new JPanel();
	JPanel p6 = new JPanel();
	JLabel l1 = new JLabel();
	JLabel l21 = new JLabel();
	JLabel l22 = new JLabel();
	JLabel[] icons1 = new JLabel[10];
	JLabel[] icons2 = new JLabel[10];
	int bet = 0;
	JLabel l41 = new JLabel();
	JButton b41 = new JButton("$1");
	JButton b42 = new JButton("$2");
	JButton b43 = new JButton("$3");
	JButton b44 = new JButton("$4");
	JButton b45 = new JButton("$5");
	JLabel l42 = new JLabel();
	JLabel l5 = new JLabel();
	JButton b51 = new JButton("Deal");
	JLabel l6 = new JLabel();
	JButton b6 = new JButton("New Game");
	// cards
	int[][] previous_cards = new int[50][2];
	int nop = 0;
	int[][] hand1 = new int[10][2]; // human hand
	int no1 = 0;
	int[][] hand2 = new int[10][2]; // computer
	int no2 = 0;
	int sum1 = 0;
	int sum2 = 0;
	
	
	
	// Constructor
	Baccarat_GUI(){
		this.setSize(1000, 800);
		this.setLayout(new GridLayout(2,1));
		this.add(p2); this.add(p3);
		p3.setLayout(new GridLayout(5,1));
		p3.add(p0); p3.add(p1); p3.add(p4); p3.add(p5); p3.add(p6); 
		rounds = 0;
		p0.setLayout(new GridLayout(1,2));
		p0.add(p01); p0.add(p02);
		p01.add(l21); p02.add(l22);
		p01.setBorder(new LineBorder(new Color(0,0,0),2));
		p02.setBorder(new LineBorder(new Color(0,0,0),2));
		p1.add(l1);
		p2.setLayout(new GridLayout(1,2));
		p2.add(p211); p2.add(p222);
		p211.setBorder(new LineBorder(new Color(0,0,0),2));
		p222.setBorder(new LineBorder(new Color(0,0,0),2));
		p211.setLayout(new GridLayout(1,5));
		p222.setLayout(new GridLayout(1,5));
		b41.setEnabled(false);
		b42.setEnabled(false);
		b43.setEnabled(false);
		b44.setEnabled(false);
		b45.setEnabled(false);
		b51.setEnabled(false);
		
		p4.add(l41);
		p4.add(b41);
		p4.add(b42);
		p4.add(b43);
		p4.add(b44);
		p4.add(b45);
		p4.add(l42);
		l41.setText("Bet: ");
		p5.add(l5);
		l5.setText("Action: ");
		p5.add(b51);
		p6.add(l6);
		p6.add(b6);
		b41.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b41"); } } );
		b42.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b42"); } } );
		b43.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b43"); } } );
		b44.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b44"); } } );
		b45.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b45"); } } );
		b51.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b51"); } } );
		b6.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent e) { refreshDisplay("b6"); } } );
		// ACTIONS
		l1.setText("Click New Game to begin playing Baccarat.");
		
		
		for(int i=0; i<no1; i++){
			icons1[i] = new JLabel();
			icons1[i].setIcon(card_to_ImageIcon(hand1[i]));
			icons1[i].setSize(30,30);
			p211.add(icons1[i]);
		}
		for(int i=0; i<no2; i++){
			icons2[i] = new JLabel();
			icons2[i].setIcon(card_to_ImageIcon(hand2[i]));
			p222.add(icons2[i]);
		}
		sum1 = sum_hand(hand1,no1);
		sum2 = sum_hand(hand2,no2);
		l21.setText("Player    ---    Purse: $"+purse+"    ---    Sum: "+ (sum1%10));
		l22.setText("Computer    ---    Sum: "+ (sum2%10));
		l42.setText("Bet: $"+bet);
	//	l6.setText("Result:        => New purse: $   ");
		b51.disable();
		b6.disable();
		setVisible(true);
		repaint();
	}
	
	public static void main(String[] args) throws IOException {
		Baccarat_GUI pg = new Baccarat_GUI();
		
	}
	
	public void drawCard() {
		clearCards();
		// generate one card
		hand1[no1] = generate_card(previous_cards,nop);
		previous_cards[nop][0] = hand1[no1][0];
		previous_cards[nop][1] = hand1[no1][1];
		nop++;
		no1++;
		sum1 = sum_hand(hand1,no1);
		for(int i=0; i<no1; i++){
			icons1[i] = new JLabel();
			icons1[i].setIcon(card_to_ImageIcon(hand1[i]));
			icons1[i].setSize(30,30);
			p211.add(icons1[i]);
		}
		for(int i=0; i<no2; i++){
			icons2[i] = new JLabel();
			icons2[i].setIcon(card_to_ImageIcon(hand2[i]));
			p222.add(icons2[i]);
		}
	}
	
	public void drawBankCard() {
		clearCards();
		// generate computer card
		hand2[no2] = generate_card(previous_cards,nop);
		previous_cards[nop][0] = hand2[no2][0];
		previous_cards[nop][1] = hand2[no2][1];
		nop++;
		no2++;
		sum2 = sum_hand(hand2,no2);
		for(int i=0; i<no1; i++){
			icons1[i] = new JLabel();
			icons1[i].setIcon(card_to_ImageIcon(hand1[i]));
			icons1[i].setSize(30,30);
			p211.add(icons1[i]);
		}
		for(int i=0; i<no2; i++){
			icons2[i] = new JLabel();
			icons2[i].setIcon(card_to_ImageIcon(hand2[i]));
			p222.add(icons2[i]);
		}
	}
	
	public void refreshDisplay(String option){
		System.out.println("Option: "+option);
		if( option.equals("b41") || option.equals("b42")  || option.equals("b43")  || option.equals("b44")  || option.equals("b45") ){
			
			if( option.equals("b41") ){
				bet = 1;
			}else if( option.equals("b42") ){
				bet = 2;
			}else if( option.equals("b43") ){
				bet = 3;
			}else if( option.equals("b44") ){
				bet = 4;
			}else bet = 5;
			l42.setText("Bet: $"+bet);
			b41.disable();
			b42.disable();
			b51.setEnabled(true);
			b6.disable();
			l1.setText("Round "+rounds+"     ---     "+ "Placed bet of " + bet + ".  Click deal to play.");
			
		} else if(option.equals("b51")){
			/** MAKE IT SO PREVIOUS GAME CLEARS HERE ^^^ */
			System.out.println("hi");
			b6.setEnabled(true);
			b51.setEnabled(false);
			b41.setEnabled(false);
			b42.setEnabled(false);
			b43.setEnabled(false);
			b44.setEnabled(false);
			b45.setEnabled(false);
			drawCard();
			drawCard();
			drawBankCard();
			drawBankCard();
			
			String resultText = "Round "+rounds+"     ---     "; //+ "Placed bet of " + bet"
			int result = -1;
			int drawnCard = 0;
			boolean playerDrew = false;
			System.out.println("SUM1: " + (sum1%10));
			System.out.println("SUM2: " + (sum2%10));
			
			
			if(((sum1%10) == 8 || (sum1%10) == 9) && ((sum2%10) != 8 && (sum2%10) != 9)) {
				//Player wins
				result = 0;
			}
			else if(((sum1%10) != 8 && (sum1%10) != 9) && ((sum2%10) == 8 || (sum2%10) == 9)) {
				//Computer wins
				result = 1;
			}
			else if (((sum1%10) == 8 || (sum1%10) == 9) && ((sum2%10) == 8 || (sum2%10) == 9)) {
				//Tie
				result = 2;
			}
			else if((sum1%10) >= 0 && (sum1%10) <=5) {
				playerDrew = true;
				//PLAYER DRAWS A CARD
				int temp = sum1;
				drawCard();   //SUM1 WILL BE CHANGED
				drawnCard = sum1 - temp;
			}
			else {
				playerDrew = false;
				//PLAYER STANDS
			}
			if(result == -1) {
				System.out.println("Someone needs to draw");
				if(!playerDrew) {
					//PLAYER DID NOT DRAW.
					if((sum2%10) >= 0 && (sum2%10) <= 5) {
						drawBankCard(); //Banker draws third card.  sum2 will change.
					}
					else {
						//Banker stands
					}
					
				}
				else {
					//PLAYER DID DRAW.  THEREFORE, MORE COMPLEX RULES BELOW
					/////
					if(drawnCard == 2 || drawnCard == 3) {
						//Banker draws with 0-4 and stands with 5-7
						if((sum2%10) >= 0 && (sum2%10) <= 4) {
							//BANKER DRAWS
							drawBankCard();
						}
						else {
						//BANKER STANDS
						}
					}
					else if(drawnCard == 4 || drawnCard == 5) {	
						//Banker draws with 0-5 and stands with 6-7
						if((sum2%10) >= 0 && (sum2%10) <= 5) {
							//BANKER DRAWS
							drawBankCard();
						}
						else {
							//BANKER STANDS
						}
					}
					else if(drawnCard == 6 || drawnCard == 7) {
						//Banker draws with 0-6 and stands with 7
						if((sum2%10) >= 0 && (sum2%10) <= 6) {
							//BANKER DRAWS
							drawBankCard();
						}
						else {
							//BANKER STANDS
						}
					}
					else if(drawnCard == 8) {
						//Banker draws with 0-2 and stands with 3-7
						if((sum2%10) >= 0 && (sum2%10) <= 2) {
							//BANKER DRAWS
							drawBankCard();
						}
						else {
							//BANKER STANDS
						}
					}
					else {
						//Banker draws with 0-3 and stands with 4-7
						if((sum2%10) >= 0 && (sum2%10) <= 3) {
							//BANKER DRAWS
							drawBankCard();
						}
						else {
							//BANKER STANDS
						}
					}
				}
				
			
			
			
			}
			if(result == -1) {
				if((sum1%10) > (sum2%10)) {
					//PLAYER WINS
						result = 0;
				}
				else if((sum2%10) > (sum1%10)) {
					result = 1;
				}
				else
					result = 2;
			}
			if(result == 0) {
				//PLAYER HAS WON
				//update text:
				resultText+= "Player Wins.  ";
				purse+=bet;
				l1.setText(resultText);
				l6.setText("Result: Win $" + bet + "       => New purse: $" + purse);
				l21.setText("Player    ---    Purse: $"+purse+"    ---    Sum: "+ (sum1%10));
				l22.setText("Computer    ---    Sum: "+ (sum2%10));
			}
			else if(result == 1) {
				//COMPUTER HAS WON
				resultText+= "Computer Wins.  ";
				purse-=bet;
				l1.setText(resultText);
				l6.setText("Result: Lose $" + bet + "       => New purse: $" + purse);
				l21.setText("Player    ---    Purse: $"+purse+"    ---    Sum: "+ (sum1%10));
				l22.setText("Computer    ---    Sum: "+ (sum2%10));
			}
			else if(result == 2) {
				//GAME WAS TIED
				resultText+= "Tie.  ";
				l1.setText(resultText);
				l6.setText("Result: Tie       => New purse: $" + purse);
				l21.setText("Player    ---    Purse: $"+purse+"    ---    Sum: "+ (sum1%10));
				l22.setText("Computer    ---    Sum: "+ (sum2%10));
			}
			System.out.println("ssss: " + (sum1%10));
			System.out.println("ssss: " + (sum2%10));
			
		} else if(option.equals("b6")){
			clearCards();
			rounds++;
			no1 = 0;
			no2 = 0;
			nop = 0;
			if(rounds > 1) {
				l1.setText("Round "+rounds+"     ---     "+ "Please place your bet, or click Deal to bet $" + bet + " again.");
				b51.setEnabled(true);
			}
			else {
				l1.setText("Round "+rounds+"     ---     "+ "Please place your bet.");
				b51.setEnabled(false);
			}
				
			b6.setEnabled(false);
			if(bet > purse) {
				l1.setText("Round "+rounds+"     ---     "+ "You don't have enough money to bet $" + bet + ".  Please place a new bet.");
				bet = purse;
				l42.setText("Bet: $"+bet);
			}
			if(purse >= 1)
				b41.setEnabled(true);
			else {
				bet = 0;
				l1.setText("Round "+rounds+"     ---     "+ "You have no money left, but you can deal again to play with no bet.");
				l42.setText("Bet: $"+bet);
			}
			if(purse >= 2)
				b42.setEnabled(true);
			if(purse >= 3)
				b43.setEnabled(true);
			if(purse >= 4)
				b44.setEnabled(true);
			if(purse >= 5)
				b45.setEnabled(true);
		} else System.out.println("Invalid option: "+option);
		repaint();
	
	}
	
	public void clearCards() {
		for(int i=0; i<icons1.length; i++) 
			if(icons1[i] != null)
				p211.remove(icons1[i]);
		for(int i=0; i<icons2.length; i++) 
			if(icons2[i] != null)
				p222.remove(icons2[i]);
		
		p211.removeAll();
		p222.removeAll();
		repaint();
	}

	public static ImageIcon card_to_ImageIcon(int[] c){
		String fileString = "images/Playing_card_";
		if(c[1]==1) fileString += "heart";
		else if(c[1]==2) fileString += "diamond";
		else if(c[1]==2) fileString += "club";
		else fileString += "spade";
		fileString += "_";
		if(2<=c[0] && c[0]<=10) fileString += c[0];
		else if(c[0]==11) fileString += "J";
		else if(c[0]==12) fileString += "Q";
		else if(c[0]==13) fileString += "K";
		else fileString += "A";
		fileString += ".jpg";
		return new ImageIcon(fileString);
	}

	
	public static int sum_hand(int[][] hand1,int no1){
		int sum = 0;
		for(int i=0; i<no1;i++){
			if(hand1[i][0]<=10)
				sum += hand1[i][0];
			else if(hand1[i][0] == 14)
				sum += 1;
			else sum += 0; // these cards are 0 -- implement the Ace treatment
		}
		return sum;
	}
	
	public static int[] generate_card(int[][] previous_cards,int nop){
		boolean duplicate = false;
		int[] card = new int[2];
		do{
			duplicate = false;
			card[0] = (int) (Math.random()*13 + 2);
			card[1] = (int) (Math.random()*4 + 1);
			// compare all the previous hands with the current hand
			for(int i=0; i<nop;i++){
				if(card[0]==previous_cards[i][0] && card[1]==previous_cards[i][1]) duplicate = true;
			}
		}while(duplicate);
		return card;
	}
	public static int[] generate_card(){
		int[] card = new int[2];
		card[0] = (int) (Math.random()*13 + 2);
		card[1] = (int) (Math.random()*4 + 1);
		return card;
	}
	public static String card_to_String(int[] c){
		String card = "";
		if(2<=c[0] && c[0]<=10) 
			card += c[0];
		else if(c[0]==11) card += "Jack";
		else if(c[0]==12) card += "Queen";
		else if(c[0]==13) card += "king";
		else if(c[0]==14) card += "Ace";
		else card += "card_to_String error: card number="+c[0];
		card += " of ";
		if(c[1]==1) card += "hearts";
		else if(c[1]==2) card += "diamonds";
		else if(c[1]==2) card += "clubs";
		else card += "spades";
		return card;
	}
}