import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import java.awt.BorderLayout;

import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.factories.FormFactory;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.GridLayout;
import javax.swing.JLabel;


public class SportsGUI {

	JFrame frame;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 */
	public SportsGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea textArea = new JTextArea();
		frame.getContentPane().add(textArea, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JSplitPane splitPane = new JSplitPane();
		panel.add(splitPane);
		
		final JTextArea textArea_1 = new JTextArea();
		textArea_1.setText("02/01/2015");
		textArea_1.setColumns(10);
		splitPane.setLeftComponent(textArea_1);
		
		final JTextArea textArea_2 = new JTextArea();
		textArea_2.setText("02/04/2015");
		textArea_2.setColumns(10);
		splitPane.setRightComponent(textArea_2);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//System.out.println(textArea_1.getText()+textArea_2.getText());
				Schedule OddsShark;
				try {
					OddsShark = new Schedule(textArea_1.getText(),textArea_2.getText());
					OddsShark.print();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		panel.add(btnNewButton);
	}

}
