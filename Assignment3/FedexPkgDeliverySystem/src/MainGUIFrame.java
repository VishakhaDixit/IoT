import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUIFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUIFrame frame = new MainGUIFrame();
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
	public MainGUIFrame() {
		setTitle("FedX Package Delivery");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlaceOrder = new JButton("Place Your Order");
		btnPlaceOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				PlaceMyOrder pOrder = new PlaceMyOrder();
				pOrder.init();
			}
		});
		btnPlaceOrder.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnPlaceOrder.setBounds(53, 101, 173, 70);
		contentPane.add(btnPlaceOrder);
		
		JButton btnTrackYourOrder = new JButton("Track Your Order");
		btnTrackYourOrder.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				TrackPackage tPackage = new TrackPackage();
				tPackage.init();
			}
		});
		btnTrackYourOrder.setFont(new Font("Gadugi", Font.BOLD, 16));
		btnTrackYourOrder.setBounds(240, 101, 173, 70);
		contentPane.add(btnTrackYourOrder);

		ImageIcon img = new ImageIcon("Fedex.png");
		setIconImage(img.getImage());
	}

}
