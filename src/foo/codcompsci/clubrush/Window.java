package foo.codcompsci.clubrush;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

public class Window implements ActionListener {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField2;
	private JButton btnSubmit;
	JLabel lblThanks;

	Timer visibleTimer = new Timer();

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 594, 375);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JLabel lblMessage = new JLabel(
				"<html><center>This is a program thrown together quickly to get your name and email address!<br>If you're interested in joining the club please add yourself to the list to receive our updates.</center></html>");
		lblMessage.setFont(new Font("Dialog", Font.BOLD, 20));
		lblMessage.setVerticalAlignment(SwingConstants.CENTER);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblMessage, BorderLayout.NORTH);

		JPanel innerPanel = new JPanel();
		panel.add(innerPanel);
		innerPanel.setLayout(new MigLayout("", "[grow,center]", "[][][center][][][][]"));

		JLabel lblName = new JLabel("Name:");
		innerPanel.add(lblName, "flowx,cell 0 2");

		textField = new JTextField();
		innerPanel.add(textField, "cell 0 2,growx,aligny center");
		textField.setColumns(40);

		JLabel lblEmail = new JLabel("Email:");
		innerPanel.add(lblEmail, "flowx,cell 0 3");

		textField2 = new JTextField();
		innerPanel.add(textField2, "cell 0 3,alignx center,aligny center");
		textField2.setColumns(40);

		btnSubmit = new JButton("Submit");
		innerPanel.add(btnSubmit, "cell 0 5");

		lblThanks = new JLabel("Thanks, !");
		lblThanks.setVisible(false);
		innerPanel.add(lblThanks, "cell 0 6");
		btnSubmit.addActionListener(this);
	}

	private void submit() {

		String name = textField.getText();
		String email = textField2.getText();
		if (name.equalsIgnoreCase("") || email.equalsIgnoreCase("")) {
			return;
		}
		Main.memberEntered(name, email);
		lblThanks.setText("Thanks, " + name + "!");
		lblThanks.setVisible(true);
		textField.setText("");
		textField2.setText("");
		visibleTimer.schedule(new TimerTask() {

			@Override
			public void run() {
				lblThanks.setVisible(false);

			}
		}, 5000);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit && e.getActionCommand().toLowerCase().equals("submit")) {
			submit();
		}

	}

}
