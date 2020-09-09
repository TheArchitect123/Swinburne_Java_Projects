package components.pane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
//Controls
import javax.swing.JButton;
import javax.swing.JPanel;

import helpers.CanvasInstructionsHelper;
//Helpers
import helpers.ComponentsHelper;

//Services
import services.NumberGenerator;

public class ControlPanel extends JPanel
{
	private int fThreadCount;			// number of thread running
	private int fPrimeCount;			// number of primes found
	private int fFiltered;				// number of integers filtered

	private PrimePanel fPrimes; // prime control panel
	private NumberCanvas fThreads; // thread count
	private NumberCanvas fPrimesFound; // prime count
	private NumberCanvas fNumbersTested; // filtered count
	private JButton fGo; // go button

	private NumberGenerator fGenerator; // number generator

	public ControlPanel(NumberGenerator _fGenerator, PrimePanel _fPrimes) {
		fGenerator = _fGenerator;
		fPrimes = _fPrimes;

		initialiseControl();
		initialiseWidgets();
	}

	private void initialiseControl() {
		this.setSize(ComponentsHelper.getControlPanelFrameWidth(), ComponentsHelper.getCommonPanelFrameHeight());
		this.setBackground(Color.blue);
	}

	private void initialiseWidgets() {

		this.add(fThreads = new NumberCanvas(0).setCanvasMode(0).changeCount(fThreadCount));
		this.add(fPrimesFound = new NumberCanvas(1).setCanvasMode(0).changeCount(fPrimeCount));
		this.add(fNumbersTested = new NumberCanvas(2).setCanvasMode(0).changeCount(fFiltered));
		
		goButton();
	}

	private void goButton() {
		this.add(fGo = new JButton());
		fGo.setBorder(BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)); //Border of Component (Material Design)
		fGo.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 14)); //Font Size 
		fGo.setBounds(30, 750, 120, 50); 
	}

	//Force refresh the UI with the new elements
	public void refreshAllElements() {
		fThreads.changeCount(fThreadCount);
		fPrimesFound.changeCount(fPrimeCount);
		fNumbersTested.changeCount(fFiltered);
	}

	@SuppressWarnings("deprecation")
	public void enableControls()
	{
		fGo.enable();
	}

	public void incrementThreads(int threadCount)
	{
		fThreadCount += threadCount;
		refreshAllElements();
	}
	public void decrementThreads(int threadCount)
	{
		fThreadCount -= 1;	
		refreshAllElements();
	}
	public int getFiltered()
	{	
		return fFiltered;
	}
	public void incrementFiltered(int filteredCount)
	{
		fFiltered += filteredCount;
		refreshAllElements();
	}
	public void incrementPrimes(int primesCount)
	{
		fPrimeCount -= primesCount;
		refreshAllElements();
	}
}