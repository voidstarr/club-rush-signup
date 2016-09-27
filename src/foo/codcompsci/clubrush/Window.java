package foo.codcompsci.clubrush;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import net.miginfocom.swing.MigLayout;

public class Window implements KeyListener, ActionListener {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField2;
	private JButton btnSubmit;

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
		panel.add(lblMessage, BorderLayout.NORTH);

		JPanel innerPanel = new JPanel();
		panel.add(innerPanel);
		innerPanel.setLayout(new MigLayout("", "[grow,center]", "[][][center][][][]"));

		JLabel lblName = new JLabel("Name:");
		innerPanel.add(lblName, "flowx,cell 0 2");

		textField = new JTextField();
		innerPanel.add(textField, "cell 0 2,growx,aligny center");
		textField.setColumns(40);
		textField.addActionListener(this);

		JLabel lblEmail = new JLabel("Email:");
		innerPanel.add(lblEmail, "flowx,cell 0 3");

		textField2 = new JTextField();
		innerPanel.add(textField2, "cell 0 3,alignx center,aligny center");
		textField2.setColumns(40);
		textField2.addActionListener(this);

		btnSubmit = new JButton("Submit");
		innerPanel.add(btnSubmit, "cell 0 5");
		btnSubmit.addActionListener(this);
	}

	private void submit() {
		Main.memberEntered(textField.getText(), textField.getText());
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnSubmit) {
			System.out.println(e.getActionCommand());
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			submit();
		}

	}

}
