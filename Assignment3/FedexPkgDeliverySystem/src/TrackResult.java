import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TrackResult extends JFrame {

	private JPanel contentPane;
	private JTextField tfTravelHistory;
	private JTextField tfShippedFrom;
	private JTextField tfShippedTo;
	private JTextField tfTrackingNum;
	private JTextField tfWeight;
	private JTextField tfSignServices;
	private JTextField tfPackaging;
	private JTextField tfService;
	private JTextField tfDimensions;
	private JTextField tfTotalPieces;
	private JTextField tfSpecialHandling;

	/**
	 * Launch the application.
	 */
	public void init() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackResult frame = new TrackResult();
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
	public TrackResult() {
		setTitle("Fedex Tracking Results");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tfTravelHistory = new JTextField();
		tfTravelHistory.setBounds(10, 128, 425, 163);
		contentPane.add(tfTravelHistory);
		tfTravelHistory.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Shipped From:");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 112, 25);
		contentPane.add(lblNewLabel);
		
		tfShippedFrom = new JTextField();
		tfShippedFrom.setBounds(10, 44, 197, 36);
		contentPane.add(tfShippedFrom);
		tfShippedFrom.setColumns(10);
		
		JLabel lblShippedTo = new JLabel("Shipped To:");
		lblShippedTo.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblShippedTo.setBounds(227, 11, 112, 25);
		contentPane.add(lblShippedTo);
		
		tfShippedTo = new JTextField();
		tfShippedTo.setColumns(10);
		tfShippedTo.setBounds(227, 44, 197, 36);
		contentPane.add(tfShippedTo);
		
		JLabel lblNewLabel_1 = new JLabel("Travel History");
		lblNewLabel_1.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 92, 117, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Shipment Facts");
		lblNewLabel_1_1.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(10, 302, 122, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2 = new JLabel("Tracking Number:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 338, 112, 25);
		contentPane.add(lblNewLabel_2);
		
		tfTrackingNum = new JTextField();
		tfTrackingNum.setBounds(132, 342, 86, 20);
		contentPane.add(tfTrackingNum);
		tfTrackingNum.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("Weight:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 370, 112, 25);
		contentPane.add(lblNewLabel_2_1);
		
		tfWeight = new JTextField();
		tfWeight.setColumns(10);
		tfWeight.setBounds(132, 374, 86, 20);
		contentPane.add(tfWeight);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sign Services:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 403, 112, 25);
		contentPane.add(lblNewLabel_2_2);
		
		tfSignServices = new JTextField();
		tfSignServices.setColumns(10);
		tfSignServices.setBounds(132, 407, 86, 20);
		contentPane.add(tfSignServices);
		
		JLabel lblNewLabel_2_3 = new JLabel("Packaging:");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(10, 435, 112, 25);
		contentPane.add(lblNewLabel_2_3);
		
		tfPackaging = new JTextField();
		tfPackaging.setColumns(10);
		tfPackaging.setBounds(132, 439, 86, 20);
		contentPane.add(tfPackaging);
		
		JLabel lblNewLabel_2_4 = new JLabel("Service:");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(227, 338, 112, 25);
		contentPane.add(lblNewLabel_2_4);
		
		tfService = new JTextField();
		tfService.setColumns(10);
		tfService.setBounds(349, 342, 86, 20);
		contentPane.add(tfService);
		
		JLabel lblNewLabel_2_5 = new JLabel("Dimensions:");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(227, 374, 112, 25);
		contentPane.add(lblNewLabel_2_5);
		
		tfDimensions = new JTextField();
		tfDimensions.setColumns(10);
		tfDimensions.setBounds(349, 378, 86, 20);
		contentPane.add(tfDimensions);
		
		JLabel lblNewLabel_2_6 = new JLabel("Total Pieces:");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(227, 406, 112, 25);
		contentPane.add(lblNewLabel_2_6);
		
		tfTotalPieces = new JTextField();
		tfTotalPieces.setColumns(10);
		tfTotalPieces.setBounds(349, 410, 86, 20);
		contentPane.add(tfTotalPieces);
		
		JLabel lblNewLabel_2_7 = new JLabel("Special Handling:");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(227, 439, 112, 25);
		contentPane.add(lblNewLabel_2_7);
		
		tfSpecialHandling = new JTextField();
		tfSpecialHandling.setColumns(10);
		tfSpecialHandling.setBounds(349, 443, 86, 20);
		contentPane.add(tfSpecialHandling);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnExit.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnExit.setBounds(188, 477, 89, 23);
		contentPane.add(btnExit);
	}

	public void updateSrc(String src)
	{
		tfShippedFrom.setText(src);
		validate();
		repaint();
	}
	public void updateDest(String dest)
	{
		tfShippedTo.setText(dest);
		validate();
		repaint();
	}
	public void updateShippingFacts(Package p)
	{
		tfTrackingNum.setText("Hello");
		tfWeight.setText(p.getWeight());
		tfSignServices.setText(p.getSignServices());
		tfPackaging.setText(p.getPackaging());
		tfService.setText(p.getService());
		tfDimensions.setText(p.getDimensions());
		tfTotalPieces.setText(Integer.toString(p.getTotalPieces()));
		tfSpecialHandling.setText(p.getSpecialHandlingSrvc());
		validate();
		repaint();
	}

	public void updateResult(Package p)
	{
		String prevStr = tfTravelHistory.getText();
		tfTravelHistory.setText(prevStr + "\n" + "Location = " + p.getCurrLocation() + ", " 
								+ "TrackingNumber = " + p.trackingNo);
		validate();
		repaint();
	}
}
