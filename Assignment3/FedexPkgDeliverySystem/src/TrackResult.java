import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class TrackResult extends JFrame {

	private JPanel contentPane;
	private static JTextArea tfTravelHistory;
	private static JTextArea tfShippedFrom;
	private static JTextArea tfShippedTo;
	private static JTextArea tfTrackingNum;
	private static JTextArea tfWeight;
	private static JTextArea tfSignServices;
	private static JTextArea tfPackaging;
	private static JTextArea tfService;
	private static JTextArea tfDimensions;
	private static JTextArea tfTotalPieces;
	private static JTextArea tfSpecialHandling;

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
		
		JLabel lblNewLabel = new JLabel("Shipped From:");
		lblNewLabel.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 112, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblShippedTo = new JLabel("Shipped To:");
		lblShippedTo.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblShippedTo.setBounds(227, 11, 112, 25);
		contentPane.add(lblShippedTo);
		
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
		
		JLabel lblNewLabel_2_1 = new JLabel("Weight:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(10, 370, 112, 25);
		contentPane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("Sign Services:");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_2.setBounds(10, 403, 112, 25);
		contentPane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("Packaging:");
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_3.setBounds(10, 435, 112, 25);
		contentPane.add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_2_4 = new JLabel("Service:");
		lblNewLabel_2_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_4.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_4.setBounds(227, 338, 112, 25);
		contentPane.add(lblNewLabel_2_4);
		
		JLabel lblNewLabel_2_5 = new JLabel("Dimensions:");
		lblNewLabel_2_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_5.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_5.setBounds(227, 374, 112, 25);
		contentPane.add(lblNewLabel_2_5);
		
		JLabel lblNewLabel_2_6 = new JLabel("Total Pieces:");
		lblNewLabel_2_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_6.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_6.setBounds(227, 406, 112, 25);
		contentPane.add(lblNewLabel_2_6);
		
		JLabel lblNewLabel_2_7 = new JLabel("Special Handling:");
		lblNewLabel_2_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_7.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_7.setBounds(227, 439, 112, 25);
		contentPane.add(lblNewLabel_2_7);
		
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
		
		tfTravelHistory = new JTextArea();
		tfTravelHistory.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfTravelHistory.setBounds(10, 127, 414, 165);
		contentPane.add(tfTravelHistory);
		
		tfShippedFrom = new JTextArea();
		tfShippedFrom.setEditable(false);
		tfShippedFrom.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfShippedFrom.setBounds(10, 46, 180, 34);
		contentPane.add(tfShippedFrom);
		
		tfShippedTo = new JTextArea();
		tfShippedTo.setEditable(false);
		tfShippedTo.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfShippedTo.setBounds(227, 46, 187, 34);
		contentPane.add(tfShippedTo);
		
		tfTrackingNum = new JTextArea();
		tfTrackingNum.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfTrackingNum.setBounds(132, 340, 86, 22);
		contentPane.add(tfTrackingNum);
		
		tfWeight = new JTextArea();
		tfWeight.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfWeight.setBounds(132, 372, 86, 22);
		contentPane.add(tfWeight);
		
		tfSignServices = new JTextArea();
		tfSignServices.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfSignServices.setBounds(132, 405, 86, 22);
		contentPane.add(tfSignServices);
		
		tfPackaging = new JTextArea();
		tfPackaging.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfPackaging.setBounds(132, 437, 85, 22);
		contentPane.add(tfPackaging);
		
		tfService = new JTextArea();
		tfService.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfService.setBounds(349, 340, 86, 22);
		contentPane.add(tfService);
		
		tfDimensions = new JTextArea();
		tfDimensions.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfDimensions.setBounds(349, 373, 86, 22);
		contentPane.add(tfDimensions);
		
		tfTotalPieces = new JTextArea();
		tfTotalPieces.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfTotalPieces.setBounds(349, 411, 86, 22);
		contentPane.add(tfTotalPieces);
		
		tfSpecialHandling = new JTextArea();
		tfSpecialHandling.setFont(new Font("Gadugi", Font.PLAIN, 14));
		tfSpecialHandling.setBounds(349, 441, 86, 22);
		contentPane.add(tfSpecialHandling);
		
		ImageIcon img = new ImageIcon("Fedex.png");
		setIconImage(img.getImage());
	}

	public void updateSrc(String src)
	{
		tfShippedFrom.append(src);
	}
	public void updateDest(String dest)
	{
		tfShippedTo.append(dest);
	}
	public void updateShippingFacts(Package p)
	{
		tfTrackingNum.append(p.trackingNo);
		tfWeight.append(p.getWeight());
		tfSignServices.append(p.getSignServices());
		tfPackaging.append(p.getPackaging());
		tfService.append(p.getService());
		tfDimensions.append(p.getDimensions());
		tfTotalPieces.append(Integer.toString(p.getTotalPieces()));
		tfSpecialHandling.append(p.getSpecialHandlingSrvc());
	}

	public void updateResult(Package p)
	{
		tfTravelHistory.append("Location = " + p.getCurrLocation() + ", " 
								+ "TrackingNumber = " + p.trackingNo + "\n");
	}
}
