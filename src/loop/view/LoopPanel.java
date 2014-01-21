package loop.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SpringLayout;

import loop.controller.LoopController;

/**
 * panel for the Loop Project
 * 
 * @author jwil1446
 * @version 1.2 11/5/13 Base framework, setupPanel method, setup Listeners
 *          methods
 * 
 */
public class LoopPanel extends JPanel
{
	private LoopController baseController;
	private SpringLayout baseLayout;
	private JTextArea loopTextArea;
	private JButton submitButton;
	private JScrollPane textPane;

	/**
	 * Creates a LoopPanel object linked via the controller for MVC paradigm.
	 * 
	 * @param baseController
	 *            The linked controller object.
	 */

	public LoopPanel(LoopController baseController)
	{
		this.baseController = baseController;

		baseLayout = new SpringLayout();
		loopTextArea = new JTextArea(10, 20);
		textPane = new JScrollPane(loopTextArea);
		submitButton = new JButton("click here =D");

		setupPanel();
		setupLayout();
		setupListeners();
	}

	/**
	 * Adds all components to the panel, set color and component settings.
	 */
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(new Color(120, 50, 220));
		this.add(submitButton);
		this.add(textPane);

		loopTextArea.setWrapStyleWord(true);
		loopTextArea.setLineWrap(true);
		loopTextArea.setEditable(false);
	}

	private void setupListeners()
	{
		baseLayout.putConstraint(SpringLayout.NORTH, submitButton, 83, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, submitButton, -55, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, loopTextArea, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, loopTextArea, 10, SpringLayout.WEST, this);
	}

	private void setupLayout()
	{
		submitButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				loopTextArea.append(baseController.getLoopResults());
			}
		});
	}
}
