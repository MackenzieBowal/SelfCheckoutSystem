package org.gB.selfcheckout.software.UI;

import java.awt.*;

/*
 * Backend integration required: 
 * 	Hardware: 
 * 		access coin and banknote slots
 *  Software:
 *  	amount paid so far
 *  	total amount to pay
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class PayWithCash extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JLabel enterCoins;
	private JLabel enterBanknotes;
	
	private JButton backButton;
	public CustomerFrame customerFrame;
	private GridBagConstraints gbc = new GridBagConstraints();
	private JPanel bottomPanel;
	
	JButton c5 = new JButton("¢5");
	JButton c10 = new JButton("¢10");
	JButton c25 = new JButton("¢25");
	JButton d1 = new JButton("$1");
	JButton d2 = new JButton("$2");
	
	JButton b5 = new JButton("$5");
	JButton b10 = new JButton("$10");
	JButton b20 = new JButton("$20");
	JButton b50 = new JButton("$50");
	
	JLabel paidLabel;
	JLabel totalLabel;
	
	// Update these to work with the backend
	private double paid = 0.0;
	private double total = 54.99;
	
	
	public PayWithCash(CustomerFrame customerFrame) {
		
		this.customerFrame = customerFrame;

		//this.setBorder(BorderFactory.createEmptyBorder(10, 10, 0, 0));
		this.setLayout(new GridLayout(2,1));
		
		setUpBackButton();
		
		bottomPanel.setLayout(new GridBagLayout());
		
		enterCoins = new JLabel("Enter Coins");
		enterCoins.setFont(new Font("serif", Font.PLAIN, 18));
		enterBanknotes = new JLabel("Enter Banknotes");
		enterBanknotes.setFont(new Font("serif", Font.PLAIN, 18));

		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(enterCoins, gbc);
		
		gbc.gridx = 1;
		gbc.gridy = 0;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(enterBanknotes, gbc);
		
		
		// Set up coin input buttons
		c5.addActionListener(this);
		c10.addActionListener(this);
		c25.addActionListener(this);
		d1.addActionListener(this);
		d2.addActionListener(this);
		b5.addActionListener(this);
		b10.addActionListener(this);
		b20.addActionListener(this);
		b50.addActionListener(this);
		
		JPanel coinsPanel = new JPanel();
		coinsPanel.setLayout(new GridLayout(3, 2));
		
		coinsPanel.add(c5);
		coinsPanel.add(c10);
		coinsPanel.add(c25);
		coinsPanel.add(d1);
		coinsPanel.add(d2);
		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(coinsPanel, gbc);
		
		
		// Set up banknote input buttons
		
		JPanel banknotesPanel = new JPanel();
		banknotesPanel.setLayout(new GridLayout(2, 2));
		
		banknotesPanel.add(b5);
		banknotesPanel.add(b10);
		banknotesPanel.add(b20);
		banknotesPanel.add(b50);
		
		gbc.gridx = 1;
		gbc.gridy = 1;
		gbc.weightx = 0.0;
		gbc.weighty = 1.0;
		gbc.anchor = GridBagConstraints.CENTER;
		bottomPanel.add(banknotesPanel, gbc);
		
		// Set up bottom buttons
		paidLabel = new JLabel("Paid: $"+paid);
		totalLabel = new JLabel("Total: "+total);
		
		
		gbc.gridx = 0;
		gbc.gridy = 2;
		gbc.weightx = 0.0;
		gbc.weighty = 0.0;
		gbc.anchor = GridBagConstraints.CENTER;
		
		JPanel labelPanel = new JPanel();
		labelPanel.setLayout(new GridLayout(2, 1));
		
		bottomPanel.add(labelPanel, gbc);
		labelPanel.add(paidLabel);
		labelPanel.add(totalLabel);
		
	}

	public void setUpBackButton() {
		
		gbc.insets = new Insets(3, 3, 3, 3);
		this.setLayout(new GridBagLayout());
		
		backButton = new JButton("Back");
		backButton.addActionListener(this);
		
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.weighty = 0.0;
		gbc.weightx = 0.0;
		gbc.anchor = GridBagConstraints.BASELINE_LEADING;
		
		backButton.addActionListener(this);
		this.add(backButton, gbc);
		
		gbc.weighty = 1.0;
		gbc.weightx = 1.0;		
		gbc.gridx = 0;
		gbc.gridy = 1;
		gbc.anchor = GridBagConstraints.CENTER;
		bottomPanel = new JPanel();
		this.add(bottomPanel, gbc);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == backButton) {
			// Go back to ProceedToPayment Panel
			this.customerFrame.cardLayout.show(this.customerFrame.getContentPane(), "proceedToPay");
		}
		else if (e.getSource() == c5) {
			// update amount in Paid
			paid += 0.05;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == c10) {
			// update amount in Paid
			paid += 0.10;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == c25) {
			// update amount in Paid
			paid += 0.25;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == d1) {
			// update amount in Paid
			paid += 1.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == d2) {
			// update amount in Paid
			paid += 2.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == b5) {
			// update amount in Paid
			paid += 5.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == b10) {
			// update amount in Paid
			paid += 10.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == b20) {
			// update amount in Paid
			paid += 20.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		else if (e.getSource() == b50) {
			// update amount in Paid
			paid += 50.0;
			paidLabel.setText(String.format("Paid: $%.2f", paid));
		}
		
	}
	
	
}
