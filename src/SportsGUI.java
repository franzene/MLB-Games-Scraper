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

import net.miginfocom.swing.MigLayout;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextPane;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.SystemColor;

import javax.swing.JRadioButton;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import javax.swing.Box;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import java.awt.Choice;
import java.awt.Component;

import javax.swing.SwingConstants;
import javax.swing.ListSelectionModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class SportsGUI {

	JFrame frame;
	private JTextField date0;
	private JTextField date1;
	private JTable table;
	Schedule OddsShark;
	private JTextField dateMaster0;
	private JTextField dateMaster1;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public SportsGUI() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 * @wbp.parser.entryPoint
	 */
	private void initialize() throws Exception {
		frame = new JFrame();
		frame.setBounds(100, 100, 808, 575);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[264px,grow]", "[][][536px,grow][]"));
		
		dateMaster0 = new JTextField();
		dateMaster0.setHorizontalAlignment(SwingConstants.CENTER);
		dateMaster0.setText("01/01/2015");
		panel.add(dateMaster0, "flowx,cell 0 0,alignx center,aligny center");
		dateMaster0.setColumns(10);
		
		final JRadioButton allButton = new JRadioButton("All");
		
		panel.add(allButton, "flowx,cell 0 1");
		
		date0 = new JTextField();
		date0.setText("01/01/2015");
		date0.setColumns(10);
		panel.add(date0, "cell 0 1,alignx center,aligny center");
		
		date1 = new JTextField();
		date1.setText("01/07/2015");
		panel.add(date1, "cell 0 1,alignx center,aligny center");
		date1.setColumns(10);
		
		final JComboBox team0 = new JComboBox();
		team0.setModel(new DefaultComboBoxModel(new String[] {"All", "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Bobcats", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "Los Angeles Clippers", "Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Hornets", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia Sixers", "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards"}));
		team0.setToolTipText("");
		panel.add(team0, "cell 0 1,aligny center");
		
		final JComboBox team1 = new JComboBox();
		team1.setModel(new DefaultComboBoxModel(new String[] {"All", "Atlanta Hawks", "Boston Celtics", "Brooklyn Nets", "Charlotte Bobcats", "Chicago Bulls", "Cleveland Cavaliers", "Dallas Mavericks", "Denver Nuggets", "Detroit Pistons", "Golden State Warriors", "Houston Rockets", "Indiana Pacers", "Los Angeles Clippers", "Los Angeles Lakers", "Memphis Grizzlies", "Miami Heat", "Milwaukee Bucks", "Minnesota Timberwolves", "New Orleans Hornets", "New York Knicks", "Oklahoma City Thunder", "Orlando Magic", "Philadelphia Sixers", "Phoenix Suns", "Portland Trail Blazers", "Sacramento Kings", "San Antonio Spurs", "Toronto Raptors", "Utah Jazz", "Washington Wizards"}));
		panel.add(team1, "cell 0 1,aligny center");
		table = new JTable();
	
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		final JComboBox sort = new JComboBox();
		sort.setModel(new DefaultComboBoxModel(new String[] {"Date", "Home Team", "Away Team", "Home Score", "Away Score"}));
		panel.add(sort, "cell 0 1");
		JButton btnSearch = new JButton("Search");

		panel.add(btnSearch, "cell 0 1,aligny center");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "cell 0 2,grow");
		
		dateMaster1 = new JTextField();
		dateMaster1.setText("01/07/2015");
		dateMaster1.setHorizontalAlignment(SwingConstants.CENTER);
		dateMaster1.setColumns(10);
		panel.add(dateMaster1, "cell 0 0");
		
		JButton btnSched = new JButton("Set Schedule");
		panel.add(btnSched, "cell 0 0");
		
		final JLabel MasterSchedSize = new JLabel("0 Games");
		panel.add(MasterSchedSize, "cell 0 0");
		
		final JLabel tempSchedSize = new JLabel("0 Games");
		panel.add(tempSchedSize, "cell 0 1");
		
		
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"", "", "", "", ""},
			},
			new String[] {
				"Date", "Home", "Away", "Home Score", "Away Score"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, Object.class, Object.class, Object.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		//OddsShark = new Schedule("01/01/2015","01/07/2015");
		btnSearch.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				try {
					//get temp schedule 
					if(allButton.isSelected())
					{
						OddsShark.setTemp(team0.getSelectedItem().toString(), team1.getSelectedItem().toString(), sort.getSelectedItem().toString());
					}
					else
					{
					OddsShark.setTemp(date0.getText(), date1.getText(), team0.getSelectedItem().toString(), team1.getSelectedItem().toString(), sort.getSelectedItem().toString());
					}
					//output tempschedule to JTable
					table.setModel(new DefaultTableModel(
							OddsShark.getSchedule(),
							new String[] {
								"Date", "Home", "Away", "Home Score", "Away Score"
							}
						) {
							Class[] columnTypes = new Class[] {
								String.class, Object.class, Object.class, Object.class, Object.class
							};
							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					int size = OddsShark.getTempSize();
					if(size == 1)
					tempSchedSize.setText(size + " Game");
					else
						tempSchedSize.setText(size + " Games");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		scrollPane.setViewportView(table);
		
		
		//At button CLick get Master Schedule
		btnSched.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					OddsShark = new Schedule(dateMaster0.getText(),dateMaster1.getText());
					int size = OddsShark.getMasterSize();
					if (size == 1)
						MasterSchedSize.setText(size + " Game");
					else
						MasterSchedSize.setText(size + " Games");
						
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		allButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				date0.setText(dateMaster0.getText());
				date1.setText(dateMaster1.getText());
				if(allButton.isSelected())
				{

				date0.disable();
				date1.disable();
				}
				else
				{
					date0.enable();
					date1.enable();	
				}
				}
				
			
		});

	}

}
