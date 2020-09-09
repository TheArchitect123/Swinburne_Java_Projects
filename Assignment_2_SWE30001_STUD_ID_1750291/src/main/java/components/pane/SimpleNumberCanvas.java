package components.pane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

import helpers.CanvasInstructionsHelper;
import helpers.ComponentsHelper;

public class SimpleNumberCanvas extends JLabel {
	
	public SimpleNumberCanvas() {
		initializeWidget();
	}
	
	public SimpleNumberCanvas setTitleText(int numberedValue) { //Allow Method Chaining in higher contexts
		this.setText(String.valueOf(numberedValue));
		
		return this;
	}
	
	private void initializeWidget() {
		this.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black)); //Border of Component (Material Design)
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18)); //Font Size 
		this.setBackground(Color.cyan);
	}
}
