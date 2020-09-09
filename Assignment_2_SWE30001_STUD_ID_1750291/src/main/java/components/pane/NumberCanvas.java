package components.pane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.border.Border;

//Helpers
import helpers.CanvasInstructionsHelper;
import helpers.ComponentsHelper;

public class NumberCanvas extends JLabel {

	int modeOfPanel; //Used for tooltip services
	public NumberCanvas(int panelMode) {
		modeOfPanel = panelMode;
		initializeWidget();
	}
	
	public NumberCanvas setCanvasMode(int panelMode) {
		modeOfPanel = panelMode;
		return this;
	}
	
	public NumberCanvas changeCount(int numberedValue) {
		this.setText(String.valueOf(numberedValue));
		
		return this;
	}
	
	private void initializeWidget() {
		this.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)); //Border of Component (Material Design)
		this.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 18)); //Font Size 
		
		// Tooltip Services Text, when hovering the mouse over these controls -- Set Initial Bounds of Controls too
		switch(modeOfPanel) {
		case 0: //Thread Panel
			this.setToolTipText(CanvasInstructionsHelper.getThreadsNumberCanvasString());
			this.setBounds(10, 20, ComponentsHelper.getControlPanelFrameWidth() - 10, 250); 
			break;
		case 1: //Tested Panel
			this.setToolTipText(CanvasInstructionsHelper.getTestedNumberCanvasString());
			this.setBounds(10, 290, ComponentsHelper.getControlPanelFrameWidth() - 10, 250); 
			
			break;
		case 2: //Primes Panel
			this.setToolTipText(CanvasInstructionsHelper.getPrimeNumberCanvasString());
			this.setBounds(10, 460, ComponentsHelper.getControlPanelFrameWidth() - 10, 250); 
			
			break;
		}
	}
}
