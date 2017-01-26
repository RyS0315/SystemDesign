import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;

public class StadelPizzaframe extends JFrame {

	private JPanel contentPane;
	private final JLabel lblStadelsPizzaria = new JLabel("Stadel's Pizzaria");
	private final JLabel lblSize = new JLabel("Size:");
	private final JComboBox SizeCombo = new JComboBox();
	private final JLabel lblToppings = new JLabel("Toppings:");
	private final JList Toppinglist = new JList();
	private final JButton btnPlaceOrder = new JButton("Place Order");
	private final JScrollPane scrollPane = new JScrollPane();
	private final JTextArea Order = new JTextArea();
	private final JLabel lblName = new JLabel("Name");
	private final JTextField NameText = new JTextField();
	private final JLabel NameError = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StadelPizzaframe frame = new StadelPizzaframe();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public StadelPizzaframe() {
		NameText.setBounds(76, 55, 86, 20);
		NameText.setColumns(10);
		jbInit();
	}
	private void jbInit() {
		setTitle("Stadel Pizza");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new MatteBorder(1, 1, 1, 1, (Color) Color.RED));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblStadelsPizzaria.setForeground(Color.RED);
		lblStadelsPizzaria.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblStadelsPizzaria.setBounds(145, 11, 128, 35);
		
		contentPane.add(lblStadelsPizzaria);
		lblSize.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSize.setBounds(10, 103, 56, 21);
		
		contentPane.add(lblSize);
		SizeCombo.setModel(new DefaultComboBoxModel(new String[] {"Super Size", "Extra Large", "Large ", "Medium", "Small", "Individual"}));
		SizeCombo.setBounds(95, 105, 90, 20);
		
		contentPane.add(SizeCombo);
		lblToppings.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblToppings.setBounds(208, 100, 64, 26);
		
		contentPane.add(lblToppings);
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				do_btnPlaceOrder_actionPerformed(arg0);
			}
		});
		btnPlaceOrder.setForeground(Color.LIGHT_GRAY);
		btnPlaceOrder.setBackground(Color.BLACK);
		btnPlaceOrder.setBounds(57, 151, 128, 23);
		
		contentPane.add(btnPlaceOrder);
		scrollPane.setBounds(291, 106, 111, 68);
		
		contentPane.add(scrollPane);
		scrollPane.setViewportView(Toppinglist);
		Toppinglist.setModel(new AbstractListModel() {
			String[] values = new String[] {"Pepperoni ", "Sausage", "Bacon ", "Mushroom", "Onion", "Olives", "Pineapple", "Buffalo Chicken", "Anchovies", "Spinach"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		Order.setBounds(10, 182, 414, 68);
		
		contentPane.add(Order);
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(10, 50, 56, 26);
		
		contentPane.add(lblName);
		
		contentPane.add(NameText);
		NameError.setForeground(Color.RED);
		NameError.setBounds(194, 58, 151, 14);
		
		contentPane.add(NameError);
	}
	protected void do_btnPlaceOrder_actionPerformed(ActionEvent arg0) {
		if(NameText.getText().isEmpty())
		{
			NameError.setText("Please Insert Your Name");
		}
		else	
		{
		Object[] chosenlist = Toppinglist.getSelectedValues();
		Order.append("You order a(n) " + SizeCombo.getSelectedItem().toString() + "pizza \n with the following toppings \n" );
		for(int i=0; i < chosenlist.length; i++)
			Order.append(chosenlist[i] + "\n");
		}
	}
}
