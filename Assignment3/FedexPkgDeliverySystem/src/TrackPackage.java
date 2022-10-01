import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class TrackPackage extends JFrame {

	private JPanel contentPane;
	private JTextField tfTrackingNum;

	/**
	 * Launch the application.
	 */
	public void init()
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TrackPackage frame = new TrackPackage();
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
	public TrackPackage() {
		setResizable(false);
		setTitle("Fedex Track My Package");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 451, 258);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitle = new JLabel("Track My Package >>>");
		lblTitle.setFont(new Font("Gadugi", Font.BOLD, 16));
		lblTitle.setBounds(127, 51, 184, 24);
		contentPane.add(lblTitle);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String trackingNum = tfTrackingNum.getText();
				
				try 
				{
					Connection conn = FedexDB.getConn();
		            String sql = "SELECT * FROM `fedex`.`package_details` WHERE TrackingNumber = " + "'" + trackingNum + "'";

		            PreparedStatement stmt = conn.prepareStatement(sql); 
		            ResultSet rs = stmt.executeQuery();

					if(rs.next())
					{
						Package p = new Package();
						p.trackingNo = trackingNum;
						p.setWeight(rs.getString("Weight"));
						p.setSrc(rs.getString("Source"));
						p.setDest(rs.getString("Destination"));
						p.setSignServices(rs.getString("SignService"));
						p.setPackaging(rs.getString("Packaging"));
						p.setTotalPieces(Integer.parseInt(rs.getString("TotalPieces")));
						p.setService(rs.getString("Service"));
						p.setSpecialHandlingSrvc(rs.getString("SpecialHandling"));
						p.setCurrLocation(rs.getString("CurrentLocation"));
						
						PkgThread p_thread = new PkgThread(p);
						
						try 
						{
							p_thread.startThread();
						} 
						catch (Exception e2) 
						{
							e2.printStackTrace();
						}
					}
					else
						System.out.println("No such Entry found in the database !!!");
				} 
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		btnProceed.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnProceed.setBounds(230, 163, 102, 23);
		contentPane.add(btnProceed);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				dispose();
			}
		});
		btnCancel.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnCancel.setBounds(109, 163, 105, 23);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_2_1 = new JLabel("Enter Your Tracking Number:");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("Gadugi", Font.PLAIN, 14));
		lblNewLabel_2_1.setBounds(20, 109, 194, 25);
		contentPane.add(lblNewLabel_2_1);
		
		tfTrackingNum = new JTextField();
		tfTrackingNum.setColumns(10);
		tfTrackingNum.setBounds(224, 109, 184, 24);
		contentPane.add(tfTrackingNum);
	}
}
