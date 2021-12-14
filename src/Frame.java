import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Calendar;

//	Author
//	Elia El Khoury
//	201910274

public class Frame implements ActionListener {

	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
//	SimpleDateFormat formatterId = new SimpleDateFormat("yymmddhhmmss");
	private Date Date = new Date();
	private long Id;
	private double price = 0, deliveryPrice = 0, sizePrice = 0, addonPrice = 0;
	private String DateString, log;
	private JFrame frame;
	private JPanel panel;
	private Map<String, String> dictionary;
	private String other = "", pSize = "";

	private Font text = new Font("Arial", Font.BOLD, 14);

	// field to display
	protected JTextField TF_OrderId, TF_Date;
	protected JTextField DisplayField[] = new JTextField[3];

	// field to enter
	protected JTextField TF_Number, TF_CustomerName;
	protected JTextField EnterField[] = new JTextField[3];

	// Buttons
	protected JButton btnSubmit, btnClear;

	// checkboxes
	private JCheckBox chckbxCheese, chckbxSalami;

	// radioButtons
	private JRadioButton rdbtnS, rdbtnM, rdbtnL, rdbtnDelivery, rdbtnPickup;

	// radioGroups
	private ButtonGroup Radio1, Radio2;

	// spinners
	private JSpinner spinnerQuantity, spinnerDate;

	// TextAreas
	private JTextArea TF_Address, TF_Result, txtrExtraIngredients, txtrDateToDeliverpickup, txtrQuantity;
	private JTextArea txtrOrderId, txtrName, txtrPhoneNumber, txtrPizzaType, txtrPizzaSize, txtrAddress, txtrDate;
	private JTextArea[] TextAreas = new JTextArea[12];

	// List
	private JList listOfPizza;
	private JScrollPane scrollPane;

	// icon
	private ImageIcon icon;

	public Frame() {
		initialize();
	}

	private void initialize() {
//		Id = Long.parseLong(formatterId.format(Date));
		Id = 1000;

		DateString = formatter.format(Date);

		icon = new ImageIcon("pizza.png");

		setFrame(new JFrame());
		getFrame().getContentPane().setBackground(SystemColor.textInactiveText);
		getFrame().setBounds(100, 100, 860, 480);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getFrame().getContentPane().setLayout(null);
		getFrame().setResizable(false);
		getFrame().setIconImage(icon.getImage());

		// TextArias
		txtrOrderId = new JTextArea();
		txtrOrderId.setFont(new Font("Arial", Font.BOLD, 17));
		txtrOrderId.setText("ORDER ID:");
		txtrOrderId.setBounds(10, 10, 131, 28);
		getFrame().getContentPane().add(txtrOrderId);

		txtrName = new JTextArea();
		txtrName.setFont(new Font("Arial", Font.BOLD, 17));
		txtrName.setText("Customer Name:");
		txtrName.setBounds(10, 65, 131, 28);
		getFrame().getContentPane().add(txtrName);

		txtrPhoneNumber = new JTextArea();
		txtrPhoneNumber.setFont(new Font("Arial", Font.BOLD, 17));
		txtrPhoneNumber.setText("Phone Number:");
		txtrPhoneNumber.setBounds(10, 103, 131, 28);
		getFrame().getContentPane().add(txtrPhoneNumber);

		txtrPizzaType = new JTextArea();
		txtrPizzaType.setFont(new Font("Arial", Font.BOLD, 17));
		txtrPizzaType.setText("Pizza Type:");
		txtrPizzaType.setBounds(10, 157, 131, 28);
		getFrame().getContentPane().add(txtrPizzaType);

		txtrPizzaSize = new JTextArea();
		txtrPizzaSize.setFont(new Font("Arial", Font.BOLD, 17));
		txtrPizzaSize.setText("Pizza Size:");
		txtrPizzaSize.setBounds(30, 308, 111, 28);
		getFrame().getContentPane().add(txtrPizzaSize);

		txtrDate = new JTextArea();
		txtrDate.setFont(new Font("Arial", Font.BOLD, 17));
		txtrDate.setText("Date:");
		txtrDate.setBounds(384, 10, 56, 28);
		getFrame().getContentPane().add(txtrDate);

		txtrAddress = new JTextArea();
		txtrAddress.setFont(new Font("Arial", Font.BOLD, 17));
		txtrAddress.setText("Address:");
		txtrAddress.setBounds(384, 65, 79, 28);
		getFrame().getContentPane().add(txtrAddress);

		txtrExtraIngredients = new JTextArea();
		txtrExtraIngredients.setFont(new Font("Arial", Font.BOLD, 17));
		txtrExtraIngredients.setText("Extra Ingredients");
		txtrExtraIngredients.setBounds(453, 180, 166, 28);
		getFrame().getContentPane().add(txtrExtraIngredients);

		txtrDateToDeliverpickup = new JTextArea();
		txtrDateToDeliverpickup.setFont(new Font("Arial", Font.BOLD, 17));
		txtrDateToDeliverpickup.setText("Date to deliver/Pickup");
		txtrDateToDeliverpickup.setBounds(641, 131, 182, 19);
		getFrame().getContentPane().add(txtrDateToDeliverpickup);

		txtrQuantity = new JTextArea();
		txtrQuantity.setFont(new Font("Arial", Font.BOLD, 17));
		txtrQuantity.setText("Quantity");
		txtrQuantity.setBounds(693, 208, 69, 19);
		getFrame().getContentPane().add(txtrQuantity);

		TF_Address = new JTextArea();
		TF_Address.setTabSize(4);
		TF_Address.setFont(new Font("Arial", Font.BOLD, 14));
		TF_Address.setForeground(SystemColor.text);
		TF_Address.setBackground(SystemColor.controlShadow);
		TF_Address.setLineWrap(true);
		TF_Address.setSize(new Dimension(100, 100));
		TF_Address.setToolTipText("");
		TF_Address.setBounds(475, 65, 144, 102);
		getFrame().getContentPane().add(TF_Address);
		TF_Address.setColumns(10);

		TF_Result = new JTextArea();
		TF_Result.setTabSize(4);
		TF_Result.setFont(new Font("Tahoma", Font.BOLD, 14));
		TF_Result.setForeground(SystemColor.text);
		TF_Result.setBackground(SystemColor.controlShadow);
		TF_Result.setLineWrap(true);
		TF_Result.setBounds(366, 282, 457, 135);
		getFrame().getContentPane().add(TF_Result);
		TF_Result.setColumns(10);

		// inserting them into an array
		TextAreas[0] = txtrOrderId;
		TextAreas[1] = txtrName;
		TextAreas[2] = txtrPhoneNumber;
		TextAreas[3] = txtrPizzaType;
		TextAreas[4] = txtrPizzaSize;
		TextAreas[5] = txtrDate;
		TextAreas[6] = txtrAddress;
		TextAreas[7] = txtrExtraIngredients;
		TextAreas[8] = txtrDateToDeliverpickup;
		TextAreas[9] = txtrQuantity;
		TextAreas[10] = TF_Address;
		TextAreas[11] = TF_Result;

		// for to edit the text arias all at once
		for (int i = 0; i < 10; i++) {
			TextAreas[i].setFont(text);
			TextAreas[i].setBackground(new Color(0, 0, 0, 0));
			TextAreas[i].setForeground(SystemColor.window);
		}

		// radio1 Buttons
		rdbtnS = new JRadioButton("S");
		rdbtnS.setSelected(true);
		rdbtnS.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnS.setForeground(SystemColor.text);
		rdbtnS.setBackground(SystemColor.textInactiveText);
		rdbtnS.setBounds(168, 309, 40, 23);
		getFrame().getContentPane().add(rdbtnS);

		rdbtnM = new JRadioButton("M");
		rdbtnM.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnM.setForeground(SystemColor.text);
		rdbtnM.setBackground(SystemColor.textInactiveText);
		rdbtnM.setBounds(210, 310, 45, 21);
		getFrame().getContentPane().add(rdbtnM);

		rdbtnL = new JRadioButton("L");
		rdbtnL.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnL.setForeground(SystemColor.text);
		rdbtnL.setBackground(SystemColor.textInactiveText);
		rdbtnL.setBounds(257, 310, 40, 21);
		getFrame().getContentPane().add(rdbtnL);

		// Radio2 Buttons
		rdbtnPickup = new JRadioButton("Pickup");
		rdbtnPickup.setSelected(true);
		rdbtnPickup.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnPickup.setForeground(SystemColor.text);
		rdbtnPickup.setBackground(SystemColor.textInactiveText);
		rdbtnPickup.setBounds(679, 24, 103, 21);
		getFrame().getContentPane().add(rdbtnPickup);

		rdbtnDelivery = new JRadioButton("Delivery");
		rdbtnDelivery.setFont(new Font("Arial", Font.BOLD, 14));
		rdbtnDelivery.setForeground(SystemColor.text);
		rdbtnDelivery.setBackground(SystemColor.textInactiveText);
		rdbtnDelivery.setBounds(679, 66, 103, 21);
		getFrame().getContentPane().add(rdbtnDelivery);

		// adding them to groups
		Radio1 = new ButtonGroup();
		Radio1.add(rdbtnS);
		Radio1.add(rdbtnM);
		Radio1.add(rdbtnL);

		Radio2 = new ButtonGroup();
		Radio2.add(rdbtnPickup);
		Radio2.add(rdbtnDelivery);

		// TextFields
		TF_OrderId = new JTextField();
		TF_OrderId.setForeground(SystemColor.windowBorder);
		TF_OrderId.setFont(new Font("Arial", Font.BOLD, 14));
		TF_OrderId.setHorizontalAlignment(SwingConstants.CENTER);
		TF_OrderId.setBackground(SystemColor.controlHighlight);
		TF_OrderId.setBounds(178, 14, 121, 25);
		getFrame().getContentPane().add(TF_OrderId);
		TF_OrderId.setColumns(10);

		TF_CustomerName = new JTextField();
		TF_CustomerName.setFont(new Font("Arial", Font.BOLD, 12));
		TF_CustomerName.setForeground(SystemColor.text);
		TF_CustomerName.setBackground(SystemColor.controlShadow);
		TF_CustomerName.setColumns(10);
		TF_CustomerName.setBounds(168, 65, 140, 28);
		getFrame().getContentPane().add(TF_CustomerName);

		TF_Number = new JTextField();
		TF_Number.setFont(new Font("Arial", Font.BOLD, 12));
		TF_Number.setForeground(SystemColor.text);
		TF_Number.setBackground(SystemColor.controlShadow);
		TF_Number.setColumns(10);
		TF_Number.setBounds(168, 103, 140, 28);
		getFrame().getContentPane().add(TF_Number);

		TF_Date = new JTextField();
		TF_Date.setForeground(SystemColor.windowBorder);
		TF_Date.setFont(new Font("Arial", Font.BOLD, 14));
		TF_Date.setHorizontalAlignment(SwingConstants.CENTER);
		TF_Date.setBackground(SystemColor.controlHighlight);
		TF_Date.setBounds(473, 9, 144, 28);
		getFrame().getContentPane().add(TF_Date);
		TF_Date.setColumns(10);

// adding the text fields to diff arrays
		DisplayField[0] = TF_Date;
		DisplayField[1] = TF_OrderId;
//		DisplayField[2] = TF_Result;

		EnterField[0] = TF_CustomerName;
		EnterField[1] = TF_Number;
		// EnterField[2] = TF_Address;

		// for loops to edit the text fields all at once
		for (int i = 0; i < 2; i++) {
			DisplayField[i].setEditable(false);
			// EnterField[i].addActionListener(this);
		}
		TF_Result.setEditable(false);

		// checkBoxes
		chckbxCheese = new JCheckBox("Cheese");
		chckbxCheese.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxCheese.setForeground(SystemColor.text);
		chckbxCheese.setBackground(SystemColor.textInactiveText);
		chckbxCheese.setBounds(463, 202, 103, 30);
		getFrame().getContentPane().add(chckbxCheese);

		chckbxSalami = new JCheckBox("Salami");
		chckbxSalami.setFont(new Font("Arial", Font.BOLD, 14));
		chckbxSalami.setForeground(SystemColor.text);
		chckbxSalami.setBackground(SystemColor.textInactiveText);
		chckbxSalami.setBounds(463, 232, 103, 30);
		getFrame().getContentPane().add(chckbxSalami);
		// Spinners
		spinnerDate = new JSpinner();
		spinnerDate.setModel(new SpinnerDateModel(new Date(), new Date(System.currentTimeMillis() - 60000), null,
				Calendar.DAY_OF_YEAR));
		spinnerDate.setForeground(SystemColor.text);
		spinnerDate.setBackground(SystemColor.controlShadow);
		spinnerDate.setBounds(682, 160, 125, 25);
		getFrame().getContentPane().add(spinnerDate);

		spinnerQuantity = new JSpinner();
		spinnerQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		spinnerQuantity.setForeground(SystemColor.text);
		spinnerQuantity.setModel(new SpinnerNumberModel(1, 1, null, 1));
		spinnerQuantity.setBackground(SystemColor.controlShadow);
		spinnerQuantity.setBounds(703, 237, 56, 25);
		getFrame().getContentPane().add(spinnerQuantity);

		// clear and submit
		btnClear = new JButton("Clear");
		btnClear.setBackground(SystemColor.controlDkShadow);
		btnClear.setForeground(new Color(255, 255, 255));
		btnClear.setBounds(22, 357, 144, 60);
		getFrame().getContentPane().add(btnClear);
		btnClear.addActionListener(this);

		btnSubmit = new JButton("Submit");
		btnSubmit.setBackground(SystemColor.controlDkShadow);
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBounds(194, 357, 144, 60);
		getFrame().getContentPane().add(btnSubmit);

		// List and other stuff related
		listOfPizza = new JList();
		listOfPizza.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listOfPizza.setForeground(SystemColor.text);
		listOfPizza.setBackground(SystemColor.controlShadow);
		listOfPizza.setModel(new AbstractListModel() {
			String[] values = new String[] { "Cheese Pizza", "Veggie Pizza", "Pepperoni Pizza", "Meat Pizza",
					"Margherita Pizza", "BBQ Chicken Pizza", "Hawaiian Pizza", "Buffalo Pizza", "Verdugo Pizza",
					"Pizza Capri", "Neapolitan Pizza" };

			public int getSize() {
				return values.length;
			}

			public Object getElementAt(int index) {
				return values[index];
			}
		});
		listOfPizza.setBounds(140, 162, 152, 135);
		// frame.getContentPane().add(listOfPizza);
		btnSubmit.addActionListener(this);

		// KList
		JScrollPane scrollPane = new JScrollPane(listOfPizza);
//		scrollPane.setViewportView(listOfPizza);
		listOfPizza.setLayoutOrientation(JList.VERTICAL);
		scrollPane.setBounds(299, 157, 17, 133);

		// Panel
		panel = new JPanel(new BorderLayout());
		panel.setBounds(181, 157, 131, 135);
		panel.add(scrollPane);
		frame.getContentPane().add(panel);

		// map of pizza prices
		dictionary = new HashMap<String, String>();
		dictionary.put("Cheese Pizza", "12");
		dictionary.put("Veggie Pizza", "10");
		dictionary.put("Pepperoni Pizza", "15");
		dictionary.put("Meat Pizza", "14");
		dictionary.put("Margherita Pizza", "14");
		dictionary.put("BBQ Chicken Pizza", "15");
		dictionary.put("Hawaiian Pizza", "17");
		dictionary.put("Buffalo Pizza", "11");
		dictionary.put("Verdugo Pizza", "17");
		dictionary.put("Pizza Capri", "18");
		dictionary.put("Neapolitan Pizza", "11");

		// setting up
		setup();
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
		frame.setBackground(SystemColor.windowBorder);
	}

	public void setup() {
		TF_OrderId.setText(String.valueOf(Id));
		TF_Date.setText(DateString);
		spinnerQuantity.setValue(1);
	}

	public void resetMenu() {
		log = "";
		TF_CustomerName.setText("");
		TF_Number.setText("");
		TF_Address.setText("");

		chckbxCheese.setSelected(false);
		chckbxSalami.setSelected(false);

		rdbtnPickup.setSelected(true);
		rdbtnS.setSelected(true);

		spinnerQuantity.setValue(1);
		listOfPizza.clearSelection();

		// resetting pricesvalues
		price = 0;
		deliveryPrice = 0;
		sizePrice = 0;
		addonPrice = 0;
	}

	public String pizzaSize() {

		if (rdbtnS.isSelected()) {
			pSize = "0$ Small Pizza";
			return "► Size Small";
		}

		if (rdbtnM.isSelected()) {
			sizePrice = 5;
			pSize = "5$ medium";
			return "► Size Medium Pizza";
		}

		if (rdbtnL.isSelected()) {
			sizePrice = 10;
			pSize = "10$ Large Pizza";
			return "► Size Large";
		}

		return "";
	}

	public String pickupOrDelivery() {

		if (rdbtnDelivery.isSelected()) {
			deliveryPrice = 1;
			other = "1$ Delivery";
			return "Deliver";
		}

		if (rdbtnPickup.isSelected()) {
			other = "no Delivery";
			return "Pickup";
		}
		return "";
	}

	public String addons() {

		if (chckbxCheese.isSelected() && chckbxSalami.isSelected())

		{
			addonPrice = 2;
			other += "+ 2$ Cheese and Salami";
			return "► With Cheese and Salami";
		}

		if (chckbxSalami.isSelected()) {
			addonPrice = 1;
			other += "+ 1$ Salami";
			return "► With Salami";
		}

		if (chckbxCheese.isSelected()) {
			addonPrice = 1;
			other += "+ 1$ Cheese";
			return "► With Cheese";
		}
		return "► No Addons";
	}

	public static boolean isInt(String str) {

		try {
			@SuppressWarnings("unused")
			long x = Long.parseLong(str);
			return true; // String is an Integer
		} catch (NumberFormatException e) {
			return false; // String is not an Integer
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnClear) {
			resetMenu();
			TF_Result.setText("");
		}

		if (e.getSource() == btnSubmit) {
			String piprice = "";
			log = " ";

			// check critical info
			if (TF_CustomerName.getText().isEmpty() || TF_Address.getText().isEmpty() || (TF_Number.getText().isEmpty())
					|| listOfPizza.getSelectedValue() == null) {
				TF_Result.setText("Missing critical information");
			} else if (isInt(TF_CustomerName.getText()) || TF_CustomerName.getText().length() < 3) {
				TF_Result.setText("Please Enter A Valid Name");
			} else if (!isInt(TF_Number.getText()) || TF_Number.getText().length() < 8) {
				TF_Result.setText("Please Enter A Valid phone number");
			} else {

				log += "Full Name: " + TF_CustomerName.getText() + "\t || \t  ";

				log += "Phone Number: " + TF_Number.getText() + "\n ";

				log += "Address: " + TF_Address.getText() + "\n ";

				log += listOfPizza.getSelectedValue() + "\t || \t ";
				piprice = dictionary.get(listOfPizza.getSelectedValue());

				log += "Qty: " + spinnerQuantity.getValue() + "\n ";

				log += "To " + pickupOrDelivery() + " On " + spinnerDate.getValue() + "\n ";

				if (pizzaSize() != "")
					log += pizzaSize() + "\t";

				log += addons() + "\n ";
				price = (Integer.valueOf(piprice) + sizePrice) * (int) spinnerQuantity.getValue() + deliveryPrice
						+ addonPrice;

				log += "Ξ Total: " + price + "$ = (" + spinnerQuantity.getValue() + "x " + "(" + piprice + "$ "
						+ listOfPizza.getSelectedValue() + " + " + pSize + ")\n" + " + " + other + ")";

				// updating the interface
				Id += 1;
				TF_OrderId.setText(String.valueOf(Id));
				TF_Result.setText(log);

			}
			resetMenu();
		}
	}
}