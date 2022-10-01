import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Random;
import java.awt.event.ActionEvent;

public class PlaceMyOrder extends JFrame {

	private JPanel contentPane;
	private JTextField tfWeight;
	private JTextField tfSignService;
	private JTextField tfPackaging;
	private JTextField tfService;
	private JTextField tfDim;
	private JTextField tfTotalPieces;
	private JTextField tfSpecialHandling;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PlaceMyOrder frame = new PlaceMyOrder();
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
	public PlaceMyOrder() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 466, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter Order Details");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblNewLabel.setBounds(114, 33, 200, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Weight:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(130, 94, 112, 25);
		contentPane.add(lblNewLabel_2_1);
		
		tfWeight = new JTextField();
		tfWeight.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfWeight.setColumns(10);
		tfWeight.setBounds(252, 98, 110, 20);
		contentPane.add(tfWeight);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sign Services:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(130, 130, 112, 25);
		contentPane.add(lblNewLabel_2_2);
		
		tfSignService = new JTextField();
		tfSignService.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfSignService.setColumns(10);
		tfSignService.setBounds(252, 134, 110, 20);
		contentPane.add(tfSignService);
		
		JLabel lblNewLabel_2_3 = new JLabel("Packaging:");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(130, 162, 112, 25);
		contentPane.add(lblNewLabel_2_3);
		
		tfPackaging = new JTextField();
		tfPackaging.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfPackaging.setColumns(10);
		tfPackaging.setBounds(252, 166, 110, 20);
		contentPane.add(tfPackaging);
		
		JLabel lblNewLabel_2_4 = new JLabel("Service:");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(130, 197, 112, 25);
		contentPane.add(lblNewLabel_2_4);
		
		tfService = new JTextField();
		tfService.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfService.setColumns(10);
		tfService.setBounds(252, 201, 110, 20);
		contentPane.add(tfService);
		
		JLabel lblNewLabel_2_5 = new JLabel("Dimensions:");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(130, 233, 112, 25);
		contentPane.add(lblNewLabel_2_5);
		
		tfDim = new JTextField();
		tfDim.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfDim.setColumns(10);
		tfDim.setBounds(252, 237, 110, 20);
		contentPane.add(tfDim);
		
		JLabel lblNewLabel_2_6 = new JLabel("Total Pieces:");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(130, 265, 112, 25);
		contentPane.add(lblNewLabel_2_6);
		
		tfTotalPieces = new JTextField();
		tfTotalPieces.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfTotalPieces.setColumns(10);
		tfTotalPieces.setBounds(252, 269, 110, 20);
		contentPane.add(tfTotalPieces);
		
		JLabel lblNewLabel_2_7 = new JLabel("Special Handling:");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(130, 298, 112, 25);
		contentPane.add(lblNewLabel_2_7);
		
		tfSpecialHandling = new JTextField();
		tfSpecialHandling.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfSpecialHandling.setColumns(10);
		tfSpecialHandling.setBounds(252, 302, 110, 20);
		contentPane.add(tfSpecialHandling);
		
		JLabel lblSrc = new JLabel("Select Source:");
		lblSrc.setFont(new Font("Gadugi", Font.PLAIN, 16));
		lblSrc.setBounds(140, 337, 102, 24);
		contentPane.add(lblSrc);
		
		JComboBox cbSrc = new JComboBox();
		cbSrc.setModel(new DefaultComboBoxModel(new String[] {"Northborough, MA", "Edison, NJ", "Pittsburgh, PA", "Allentown, PA", "Martinsburg, WV", "Charlotte, NC", "Atlanta, GA", "Orlando, FL", "Memphis, TN", "Grove City, OH", "Indianapolis, IN", "Detroit, MI", "New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX", "Denver, CO", "Salt Lake City, UT", "Phoenix, AZ", "Los Angeles, CA", "Chino, CA", "Sacramento, CA", "Seattle, WA"}));
		cbSrc.setFont(new Font("Gadugi", Font.PLAIN, 14));
		cbSrc.setBounds(252, 338, 110, 24);
		contentPane.add(cbSrc);
		
		JLabel lblDest = new JLabel("Select Destination:");
		lblDest.setFont(new Font("Gadugi", Font.PLAIN, 16));
		lblDest.setBounds(114, 377, 127, 24);
		contentPane.add(lblDest);
		
		JComboBox cbDest = new JComboBox();
		cbDest.setModel(new DefaultComboBoxModel(new String[] {"Northborough, MA", "Edison, NJ", "Pittsburgh, PA", "Allentown, PA", "Martinsburg, WV", "Charlotte, NC", "Atlanta, GA", "Orlando, FL", "Memphis, TN", "Grove City, OH", "Indianapolis, IN", "Detroit, MI", "New Berlin, WI", "Minneapolis, MN", "St. Louis, MO", "Kansas, KS", "Dallas, TX", "Houston, TX", "Denver, CO", "Salt Lake City, UT", "Phoenix, AZ", "Los Angeles, CA", "Chino, CA", "Sacramento, CA", "Seattle, WA"}));
		cbDest.setFont(new Font("Gadugi", Font.PLAIN, 14));
		cbDest.setBounds(251, 377, 110, 24);
		contentPane.add(cbDest);
		
		JButton btnNewButton = new JButton("Done");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				Random r = new Random();
				String tracking_no = "" + r.nextInt(999999);
				Package p = new Package();
				
				p.trackingNo = tracking_no;
				p.setService(tfService.getText().toString());
				p.setWeight(tfWeight.getText().toString());
				p.setPackaging(tfPackaging.getText().toString());
				p.setSignServices(tfSignService.getText().toString());
				p.setTotalPieces(Integer.parseInt(tfTotalPieces.getText()));
				p.setSpecialHandlingSrvc(tfSpecialHandling.getText().toString());
				p.setSrc(cbSrc.getSelectedItem().toString());
				p.setDest(cbDest.getSelectedItem().toString());
				p.setDimensions(tfDim.getText().toString());
				
				try 
				{
					Connection conn = FedexDB.getConn();
					FedexDB.addPckgDet(conn, p);
					
				} 
				catch (Exception e2) 
				{
					e2.printStackTrace();
				}
				
				JOptionPane.showMessageDialog(null, "Your Tracking Number is " + p.trackingNo);
				dispose();
			}
		});
		btnNewButton.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnNewButton.setBounds(200, 426, 89, 33);
		contentPane.add(btnNewButton);
		
		ImageIcon img = new ImageIcon("Fedex.png");
		setIconImage(img.getImage());
	}
}
