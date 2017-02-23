

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuOperations extends JFrame {
	
	JTextArea itemListText = new JTextArea(); 
	
	JPanel buttonPanel = new JPanel();
	JPanel userInterfacePanel = new JPanel();
	JPanel centerPanel = new JPanel();

	JScrollPane menuListPanel = new JScrollPane();
	JScrollPane orderListPanel = new JScrollPane();
	
	
	JButton buttonA = new JButton("Add Card");
	JButton buttonC = new JButton("Copy");
	JButton buttonE = new JButton("Update price");
	JButton buttonG = new JButton("Get Card");
	JButton buttonL = new JButton("Locate Card");
	JButton buttonN = new JButton("Update name");
	JButton buttonP = new JButton("Print All Cards");
	JButton buttonR = new JButton("Remove Card");
	JButton buttonS = new JButton("Size");
	JButton buttonT = new JButton("Trade");
	JButton buttonV = new JButton("Value");
	JButton buttonQ = new JButton("Quit");
	
	JButton enterButton = new JButton("Enter");
	JButton backButton = new JButton("Back to Menu");
	
	Menu menu = new Menu();
	Menu order = new Menu();
	
	public MenuOperations() {
		
		super.setTitle("CSE 214 Homework 1");		
		super.add(new JLabel("Baseball Card Collection"),BorderLayout.NORTH);
		super.setSize(800, 800);
		
		buttonPanel.setLayout(new GridLayout(11,1,1,1));
		userInterfacePanel.setLayout(new FlowLayout());
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		
		buttonPanel.add(buttonA);
		buttonPanel.add(buttonC);
		buttonPanel.add(buttonE);
		buttonPanel.add(buttonG);
		buttonPanel.add(buttonL);
		buttonPanel.add(buttonN);
		buttonPanel.add(buttonP);
		buttonPanel.add(buttonR);
		buttonPanel.add(buttonS);
		buttonPanel.add(buttonT);
		buttonPanel.add(buttonV);
		buttonPanel.add(buttonQ);
		
		displayMainMenu();
		super.setVisible(true);
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
			
	}    
	
	public void displayMainMenu() {
		
		add(buttonPanel, BorderLayout.CENTER);
	
		buttonA.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionA");
                    }
        });
		
		buttonC.addActionListener(new ActionListener() {
            
			@Override
            public void actionPerformed(ActionEvent e) {
				refreshDisplay("optionC");
            
                    }
        });
		
		buttonE.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionE");
                    }
        });
		
		buttonG.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionG");
                    }
        });
		
		buttonL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionL");
                    }
        });
		
		buttonN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionN");
                    }
        });
		
		buttonP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionP");
                    }
        });
		
		buttonR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionR");
                    }
        });
		
		buttonS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionS");
                    }
        });
		
		buttonT.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionT");
                    }
        });
		
		buttonV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    refreshDisplay("optionV");
                    }
        });
		
		buttonQ.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    System.out.println("Exiting");
                    System.exit(0);
                    }
        });
		backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   refreshDisplay("optionBack");
                    }
        });
		
	}
	
	public void refreshDisplay(String option) {
		remove(buttonPanel);
		menuListPanel.removeAll();
		centerPanel.removeAll();
		userInterfacePanel.removeAll();
		remove(buttonPanel);
		remove(backButton);
		
		generateMenuListPanel();
		
		if(option == "optionA") {
			userInterfacePanel.setLayout(new GridLayout(4,1));
			JTextField nameTextField = new JTextField(25);
			JTextField descriptionTextField = new JTextField(50);
			JTextField priceTextField = new JTextField(7);
			JTextField positionTextField = new JTextField(3);
			
			JPanel namePanel = new JPanel();
			namePanel.add(new JLabel("Name: "));
			namePanel.add(nameTextField);
			
			JPanel descriptionPanel = new JPanel();
			descriptionPanel.add(new JLabel("Description: "));
			descriptionPanel.add(descriptionTextField);
			
			JPanel pricePanel = new JPanel();
			pricePanel.add(new JLabel("Price: "));
			pricePanel.add(priceTextField);
			
			JPanel positionPanel = new JPanel();
			positionPanel.add(new JLabel("Position: "));
			positionPanel.add(positionTextField);
			
			userInterfacePanel.add(namePanel);
			userInterfacePanel.add(descriptionPanel);
			userInterfacePanel.add(pricePanel);
			userInterfacePanel.add(positionPanel);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Add Item:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            	String name = nameTextField.getText();
	            	String description = descriptionTextField.getText();
	        	
	            	String stringToPrice = priceTextField.getText();
	        		double price = Double.parseDouble(stringToPrice);
	            	
	            	String stringToPosition = positionTextField.getText();
	            	int position = Integer.parseInt(stringToPosition);
	            		
	            	
	            	try {
						menu.addItem(new MenuItem(name, description, price), position);
						menu.printAllItems();
					} catch (IllegalArgumentException e1) {
						System.out.println("Position is not in range");
						e1.printStackTrace();
					} catch (FullListException e2) {
						System.out.println("Menu is full");
						e2.printStackTrace();
					}	
	            	
	            	    remove(centerPanel);	
	            	    remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		
	            		generateMenuListPanel();
	            		centerPanel.add(menuListPanel);
	            		
	            		String output = String.format("Added \"%s: %s\" for $%.2f at position %d\n", 
	            				menu.getItem(position).getName(), menu.getItem(position).getDescription() 
	            			    ,menu.getItem(position).getPrice(), position);
	            		centerPanel.add(new JLabel(output));
	            		
	            		add(centerPanel);
	            		repaint();
	            	
	            		
	            		
	            		setVisible(true);
	            		
	                   
	                    }
	        });
		}
		
		
		if(option == "optionG") {
			
			JTextField positionTextField = new JTextField(3);
			
			userInterfacePanel.add(new JLabel("Position: "));
			userInterfacePanel.add(positionTextField);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Get Item:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            		String input = positionTextField.getText();
	            		int position = Integer.parseInt(input);
	            		
	            		if(position > 0 && position <= menu.size()){
	            			menu.getItem(position);
	            		}
	            		remove(centerPanel);
	            		remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		generateMenuListPanel();
	            		centerPanel.add(menuListPanel);
	            		
	            		
	            		String output = String.format("Item Name: %s\nDescription: %s \nPice: $%.2f at position %d\n", 
	            				menu.getItem(position).getName(), menu.getItem(position).getDescription() 
	            			    ,menu.getItem(position).getPrice(), position);
	            		
	            		centerPanel.add(new JLabel(output));
	            		add(centerPanel);
	            		
	            		
	            		
	            		System.out.printf("%-2s %-25s %-75s %-7s\n", 
	        					"#", "Name", "Description", "Price");
	        			System.out.println("--------------------------------------------------"
	        					+ "----------------------------------------------------------------");
	        			System.out.printf("%-2d %-25s %-75s $%-7.2f\n", 
	        					(position), menu.getItem(position).getName(), 
	        					menu.getItem(position).getDescription(), menu.getItem(position).getPrice());
	            		
	        			
	        			
	            		
	            		repaint();
	            		setVisible(true);
	            		
	                   
	                    }
	        });
			
		}
		
		if(option == "optionR") {
			
			JTextField positionTextField = new JTextField(3);
			
			userInterfacePanel.add(new JLabel("Position: "));
			userInterfacePanel.add(positionTextField);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Remove Item:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            		String input = positionTextField.getText();
	            		int position = Integer.parseInt(input);
	            		
	            		
	            		String output = String.format("%s removed", 
	            				menu.getItem(position).getName());
	            		
	            		
	            		if(position > 0 && position <= menu.size()){
	            			menu.removeItem(position);
	            		}
	            		remove(centerPanel);
	            		remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		generateMenuListPanel();
	            		centerPanel.add(menuListPanel);
	            		
	            		centerPanel.add(new JLabel(output));
	            		add(centerPanel);
	            	
	        		
	            		
	            		repaint();
	            		setVisible(true);
	            		
	                   
	                    }
	        }); 
}

		if(option == "optionP") {
			generateMenuListPanel();
			centerPanel.add(menuListPanel);
			add(centerPanel, BorderLayout.CENTER);
		}
		

		if(option == "optionS") {
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			if(menu.size() == 1)
				centerPanel.add(new JLabel("There is 1 item in the menu"));
			else
				centerPanel.add(new JLabel("There are " + menu.size() + " items in the menu"));
			
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			
			
			add(centerPanel, BorderLayout.CENTER);
			
			setVisible(true);

			}
		
		if(option == "optionC") {
			userInterfacePanel.setLayout(new GridLayout(4,1));
	
			JTextField priceTextField = new JTextField(7);
			
			JTextField positionTextField = new JTextField(3);
		
			JPanel positionPanel = new JPanel();
			positionPanel.add(new JLabel("Position: "));
			positionPanel.add(positionTextField);
			
			JPanel descriptionPanel = new JPanel();
			descriptionPanel.add(new JLabel("Price: "));
			descriptionPanel.add(priceTextField);
			
			userInterfacePanel.add(descriptionPanel);
		
			userInterfacePanel.add(positionPanel);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Update Price:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            	
	            	String stringToPrice = priceTextField.getText();
	        	
	            
	            	
	            	String stringToPosition = positionTextField.getText();
	            	int position = Integer.parseInt(stringToPosition);
	            		
	            	
	            	try {
	            		
		        		double price = Double.parseDouble(stringToPrice);
						menu.getItem(position).setPrice(price);
						menu.printAllItems();
					} catch (IllegalArgumentException e1) {
							System.out.println("Position is not in range");
						e1.printStackTrace();
					} 	
	            	
	            	    remove(centerPanel);	
	            	    remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		
	            		generateMenuListPanel();
	            		centerPanel.add(menuListPanel);
	            		
	            		String output = String.format("Updated price of \"%s: at position %d to %.2f ", 
	            				menu.getItem(position).getName(), position,
	            				menu.getItem(position).getPrice());
	            			    
	            		centerPanel.add(new JLabel(output));
	            		
	            		add(centerPanel);
	            		repaint();
	            	
	            		
	            		
	            		setVisible(true);
	            		
	                   
	                    }
	        });
		}
		
		if(option == "optionD") {
			userInterfacePanel.setLayout(new GridLayout(4,1));
			
			JTextField descriptionTextField = new JTextField(50);
	
			JTextField positionTextField = new JTextField(3);
		
			JPanel positionPanel = new JPanel();
			positionPanel.add(new JLabel("Position: "));
			positionPanel.add(positionTextField);
			
			JPanel descriptionPanel = new JPanel();
			descriptionPanel.add(new JLabel("Description: "));
			descriptionPanel.add(descriptionTextField);
			
			userInterfacePanel.add(descriptionPanel);
		
			userInterfacePanel.add(positionPanel);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Update Description:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            	
	            	String description = descriptionTextField.getText();
	        	
	            
	            	
	            	String stringToPosition = positionTextField.getText();
	            	int position = Integer.parseInt(stringToPosition);
	            		
	            	
	            	try {
						menu.getItem(position).setDescription(description);
						menu.printAllItems();
					} catch (IllegalArgumentException e1) {
					System.out.println("Position is not in range");
						e1.printStackTrace();
					} 	
	            	
	            	    remove(centerPanel);	
	            	    remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		
	            		generateMenuListPanel();
	            		centerPanel.add(menuListPanel);
	            		
	            		String output = String.format("Updated description of \"%s: at position %d\n to %s ", 
	            				menu.getItem(position).getName(), position,
	            				menu.getItem(position).getDescription());
	            			    
	            		centerPanel.add(new JLabel(output));
	            		
	            		add(centerPanel);
	            		repaint();
	            	
	            		
	            		
	            		setVisible(true);
	            		
	                   
	                    }
	        });
		}
		
if(option == "optionO") {
			
			JTextField positionTextField = new JTextField(3);
			
			userInterfacePanel.add(new JLabel("Position: "));
			userInterfacePanel.add(positionTextField);
			
			centerPanel.add(menuListPanel, BorderLayout.CENTER);
			centerPanel.add(new JLabel("Add to order:"));
			centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
			centerPanel.add(enterButton);
			
			add(centerPanel, BorderLayout.CENTER);
			
			enterButton.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent e) {
	                    
	            		String input = positionTextField.getText();
	            		int position = Integer.parseInt(input);
	            		
	            		
	            			try {
								order.addItem(new MenuItem(menu.getItem(position).getName(), 
										menu.getItem(position).getDescription(), 
										menu.getItem(position).getPrice()), order.size()+1);
							} catch (IllegalArgumentException e1) {
								System.out.println(e1.getMessage());
								e1.printStackTrace();
							} catch (FullListException e2) {
								System.out.println(e2.getMessage());
							}
	            		
	            		
	            	String output = String.format("%s added to order", 
	            				menu.getItem(position).getName());
	            	
	            		remove(centerPanel);
	            		remove(userInterfacePanel);
	            		centerPanel.removeAll();
	            		generateMenuListPanel();
	            		generateOrderListPanel();
	            		
	            		centerPanel.add(new JLabel("Menu"));
	            		centerPanel.add(menuListPanel);
	            		centerPanel.add(new JLabel("Order"));
	            		centerPanel.add(orderListPanel);
	            		
	            		centerPanel.add(new JLabel(output));
	            		add(centerPanel);
	            	
	        		
	            		
	            		repaint();
	            		setVisible(true);
	            		
	                   
	                    }
	        }); 
}

if(option == "optionI") {
	
	JTextField positionTextField = new JTextField(3);
	
	userInterfacePanel.add(new JLabel("Position: "));
	userInterfacePanel.add(positionTextField);
	
	generateOrderListPanel();
	centerPanel.add(new JLabel("Order List"));
	centerPanel.add(orderListPanel, BorderLayout.CENTER);
	centerPanel.add(new JLabel("Remove from order:"));
	centerPanel.add(userInterfacePanel, BorderLayout.CENTER);
	centerPanel.add(enterButton);
	
	add(centerPanel, BorderLayout.CENTER);
	
	enterButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
                
        		String input = positionTextField.getText();
        		int position = Integer.parseInt(input);
        	
        		
        		String output = String.format("%s removed to order", 
        				menu.getItem(position).getName());
        		
        			try {
						order.removeItem(position);
					} catch (IllegalArgumentException e1) {
						System.out.println(e1.getMessage());;}
					
        		remove(centerPanel);
        		remove(userInterfacePanel);
        		centerPanel.removeAll();
        		generateMenuListPanel();
        		generateOrderListPanel();
        		
        		centerPanel.add(new JLabel("Menu"));
        		centerPanel.add(menuListPanel);
        		centerPanel.add(new JLabel("Order"));
        		centerPanel.add(orderListPanel);
        		
        		centerPanel.add(new JLabel(output));
        		add(centerPanel);
        	
    		
        		
        		repaint();
        		setVisible(true);
        		
               
                }
    }); 
}
		
if(option == "optionV") {
	generateOrderListPanel();
	centerPanel.add(new JLabel("Order"));
	centerPanel.add(orderListPanel);
	add(centerPanel, BorderLayout.CENTER);
}
		
		
		if(option == "optionBack"){
			
			
			centerPanel.removeAll();
			centerPanel.remove(menuListPanel);
			userInterfacePanel.removeAll();
			
			
			remove(centerPanel);
    		remove(backButton);
    		
    		displayMainMenu();
    		repaint();
    		return;
		}
		
		add(backButton, BorderLayout.SOUTH);
		repaint();
		setVisible(true);
	}
	
	
	public void generateMenuListPanel() {
		
		String menuItems = "";
		
		String menuHeader = String.format("%-2s %-50s %-140s %-7s\n"
        	, "#", "Name", "Description", "Price");
        
        menuHeader+=("--------------------------------------------------"
    			+ "---------------------------------------------------"
    			+ "-------------\n");
        
		JTextArea menuTextArea = new JTextArea(menuHeader, 75, 4);
		
        
 
        
        for (int i = 1; i <= menu.size(); i++) {
			menuItems += String.format("%-2d %-25s %-75s $%-7.2f\n", (i),
					menu.getItem(i).getName(), menu.getItem(i).getDescription(),
					menu.getItem(i).getPrice());
			menuTextArea.setText(menuTextArea.getText() + String.format("%-2d %-25s %-75s $%-7.2f\n", (i),
					menu.getItem(i).getName(), menu.getItem(i).getDescription(),
					menu.getItem(i).getPrice()));
			}



		    
        
		    
		menuListPanel = new JScrollPane(menuTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}
	
	
public void generateOrderListPanel() {
		
		String orderItems = "";
		
	
        
        String orderHeader = String.format("%-2s %-25s %-75s %-7s\n"
        	, "#", "Name", "Description", "Price");
        
        orderHeader+=("--------------------------------------------------"
    			+ "---------------------------------------------------"
    			+ "-------------\n");
        
        for (int i = 1; i <= order.size(); i++) {
			orderItems += String.format("%-2d %-25s %-75s $%-7.2f\n", (i),
					order.getItem(i).getName(), order.getItem(i).getDescription(),
					order.getItem(i).getPrice());
			}
      
		    
        JTextArea menuTextArea = new JTextArea(orderHeader + orderItems, 50, 20);
		    
		orderListPanel = new JScrollPane(menuTextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
	}
	
 
	/**
	   *  Provides menu interface for Menu and Order operations using a switch statement
	   *  
	   * <dt><b>Switch Statement Cases<dt></b>
	   * <dd> "A" Add Item: <Name> <Description> <Price> <Position> (add the item to the menu)
	   * <dd> "G" Get Item:<Position> (Print out the name, description, 
	   * and price of the item at the specified position in the menu) 
	   * <dd> "R" Remove Item: <Position> (Remove the item at the specified position in the menu)
	   * <dd> "P" Print All Items: (print the list of all items on the menu)
	   * <dd> "S" Size:  (print the number of items on the menu)
	   * <dd> "D" Update description:  <Name> <New description> (update the description of the named item)
	   * <dd> "C" Update Price: <Name> <New price> (update the price of the named item)
	   * <dd> "O" Add to order: <Position> (Add the item at the specified position in the menu to the order)
	   * <dd> "I" Remove from order:  <Position> (Remove the item at the specified position in the order)
	   * <dd> "V" View Order: (print the items in the current order)
	   * <dd> "Q" Quit: (terminate the program)
	   *  
	   * <dt><b>Note</b><dt>
	   * <dd> All switch cases that take user input use a different scanner object
	   * this solves conflict where user input would jump over selections
	   * 
	   * @exception IllegalArgumentException
	   *   Indicates that position is not within the valid range 
	   *   or argument is invalid 
	   *   
	   * @exception FullListException
	   * 	Indicates that there is no more room inside of the Menu to
	   *    store new object.
	   * 
	   * @exception InputMismatchException
	   * 	Used by Scanner to indicate user input does not match the
	   * 	expected type.  
	   * 
	   *
	   */ 
	public static void main(String[] args) throws IllegalArgumentException, FullListException, InputMismatchException {
		
		Scanner menuSelectionInput = new Scanner(System.in); // Scanner used exclusively for menu selection 
		
		Menu menu = new Menu(); 
		Menu order = new Menu();
		
		String name = null; // name of MenuItem object
		String description = null; // description of MenuItem object
		double price = 0.0; // price of MenuItem object
		int position = 0; // position in menu or order 
		
		while(true) {
			
			System.out.print("Main Menu\n"
						+ "A) Add Item\n"
						+ "G) Get Item\n"
						+ "R) Remove Item\n"
						+ "P) Print All Items\n"
						+ "S) Size\n"
						+ "D) Update description\n"
						+ "C) Update price\n"
						+ "O) Add to order\n"
						+ "I) Remove from order\n"
						+ "V) View Order\n"
						+ "Q) Quit\n"
						+ "Z) Extra Credit GUI\n"
						+ "Select an operation: " );
			
			char option = menuSelectionInput.next().toUpperCase().charAt(0);
			
			switch(option) {
			case 'A':
				try {
					
					Scanner addInput = new Scanner(System.in); 
					System.out.print("Enter name: ");
					name = addInput.nextLine();			
				
					System.out.print("Enter Description: ");
					description = addInput.nextLine();	
					System.out.print("Enter price: ");
					price = addInput.nextDouble();
					System.out.print("Enter a position: ");
					position = addInput.nextInt();	
					
					menu.addItem(new MenuItem(name, description, price), position);
					
					System.out.printf("Added \"%s: %s\" for $%.2f at position %d\n", menu.getItem(position).getName(), 
							menu.getItem(position).getDescription() ,menu.getItem(position).getPrice(), position);
					
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch(FullListException e2) {
					System.out.println("List is full");
				} catch(InputMismatchException e3) {
					System.out.println("Invalid Input!");
				}
			break;
			
			case 'R':
				try{
					System.out.print("Enter a position: ");
					position = menuSelectionInput.nextInt();
					System.out.println(menu.getItem(position).getName() + " removed");
					menu.removeItem(position);
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e2) {
					System.out.println("Invalid Input!");
				}
				break;
			
			case 'P':
				menu.printAllItems();	
			break;
			
			case 'G':
				try {
					System.out.print("Enter a position: ");
					position = menuSelectionInput.nextInt();
					
					menu.getItem(position); // checks if position is valid, if not throws IllegalArgumentException
				
					System.out.printf("%-2s %-25s %-75s %-7s\n", 
						"#", "Name", "Description", "Price");
					System.out.println("--------------------------------------------------"
						+ "----------------------------------------------------------------");
					System.out.printf("%-2d %-25s %-75s $%-7.2f\n", 
						(position), menu.getItem(position).getName(), 
					
					menu.getItem(position).getDescription(), menu.getItem(position).getPrice());
		        } catch (IllegalArgumentException e) {
		            System.out.println(e.getMessage());
		        }catch(InputMismatchException e2) {
					System.out.println("Invalid Input!");
				}
			break;
			
			case 'S':
				if(menu.size() == 1)
					System.out.println("There is 1 item in the menu");
				else
					System.out.println("There are " + menu.size() + " items in the menu");
			break;
			
			case 'D':
				try{
					System.out.print("Enter a position: ");
					Scanner descriptionInput = new Scanner(System.in);
					position = descriptionInput.nextInt();
					
					menu.getItem(position);
					
					System.out.print("Enter new description: ");
					menu.getItem(position).setDescription(descriptionInput.next());
					System.out.println("New description for " + menu.getItem(position).getName() + 
							": " + menu.getItem(position).getDescription());
				} catch(IllegalArgumentException e) { 
					System.out.println(e.getMessage());
				} catch(InputMismatchException e2) {
					System.out.println("Invalid Input!");
				}
				
				
			break;
			case 'C':
				try {
					Scanner priceInput = new Scanner(System.in);
					System.out.print("Enter a position: ");
					position = priceInput.nextInt();
					
					menu.getItem(position); // checks if position is valid, if not throws IllegalArgumentException
					
					System.out.print("Enter new price: ");
					menu.getItem(position).setPrice(priceInput.nextDouble());
					System.out.printf("New price for %s: $%.2f\n", menu.getItem(position).getName(), 
							menu.getItem(position).getPrice());
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e2) {
					System.out.println("Invalid Input!");
				}
			break;
			
			case 'O':
				try {	
					System.out.print("Enter position of item to add to order: ");
					position = menuSelectionInput.nextInt();
					order.addItem(menu.getItem(position), order.size()+1);
					System.out.println("Added " + menu.getItem(position).getName() + " to order.");
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e2){
					System.out.println("Invalid Input!");
				}
			break;
			
			case 'I':
				try {
					System.out.print("Enter position of item to remove from order: ");
					position = menuSelectionInput.nextInt();	
					
					order.getItem(position); // checks if position is valid, if not throws IllegalArgumentException
					
					System.out.println(order.getItem(position).getName() + " removed.");
					order.removeItem(position);
				} catch(IllegalArgumentException e) {
					System.out.println(e.getMessage());
				} catch(InputMismatchException e2) {
					System.out.println("Invalid Input!");
				}
			break;
			
			case 'V':
				order.printAllItems();
			break;
			
			case 'Z':
				System.out.println("Starting GUI, Switch to java icon.");
				MenuOperations GUI = new MenuOperations(); // starts GUI application
				break;
			
			case 'Q':
				System.out.println("Exiting.");
				System.exit(0);
			break;
			
			default:
				System.out.println("No such operation");
				
			}
			
			System.out.print("Enter E to return to menu: ");
			menuSelectionInput.next();
		
		}}
}
