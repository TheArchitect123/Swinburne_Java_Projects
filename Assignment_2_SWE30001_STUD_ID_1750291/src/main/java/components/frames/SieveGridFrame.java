package components.frames;

import java.awt.Color;

import javax.inject.Inject;
import javax.swing.JSplitPane;

import components.pane.ControlPanel;
import components.pane.PrimePanel;
import constants.AppInformation;
import helpers.ScreenHelper; //Helpers
import services.NumberGenerator;

public class SieveGridFrame extends BaseFrame {

	private NumberGenerator _fGenerator;		// integer generator
	private ControlPanel _controlPanel;
	private PrimePanel _primePanel;
	
	public SieveGridFrame(NumberGenerator fGenerator, ControlPanel controlPanel, 
			PrimePanel primePanel) {
		this._fGenerator = fGenerator;
		this._fGenerator.sieveFrame = this;
		this._fGenerator._primeFilter.fSieve = this;
		
		//Widgets
		_controlPanel = controlPanel; //Add the Widgets to the frame heirarchy
		_primePanel = primePanel;
	}
	
	public synchronized int getFiltered() throws InterruptedException
	{
		Thread.sleep(200);
		return _controlPanel.getFiltered();
	}

	public synchronized void blink( int aTest )
	{

	}
 
	public synchronized void incrementThreads( int aPrime )
	{ 
		// increments thread count
		// prints Thread name, thread count, and prime if prime != 0
		// otherwise, just prints thread name and thread count

		_controlPanel.incrementThreads(aPrime);
	}

	public synchronized void decrementThreads()
	{
		// decrements thread count
		// prints Thread name and thread count

		_controlPanel.decrementThreads(1); 
	}

	public synchronized void incrementFiltered( int aTest )
	{
		// increments filtered count
		// prints Thread name and integer filtered

		_controlPanel.incrementFiltered(aTest); 
	}

	public synchronized void incrementPrimes( int aTest )
	{
		_controlPanel.incrementPrimes(aTest); 
	}

	public void execute()
	{
		// creates generator for 100 integers
		// starts generator
		// waits 1ms (in loop) until thread count is zero, requires synchronization
		// prints ÒTest completed.Ó and the number of primes found
	}

	@Override
	public void generateGUI() {
		//Load the widgets & controls here...
		setupFrame();
		initializeSplitWidget();
	}
	
	private void setupFrame() {
		this.setBackground(Color.white);
		this.setTitle(AppInformation.AppName());
		this.setSize(ScreenHelper.getStarterFrameWidth(), ScreenHelper.getStarterFrameHeight());
		this.setVisible(true);
	}
	
	//This will split between the Control Panel and the Prime Panel
	private void initializeSplitWidget() {
		
		var splitWidget = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, _primePanel, _controlPanel);
		splitWidget.setSize(ScreenHelper.getStarterFrameWidth(), ScreenHelper.getStarterFrameHeight());
		this.getContentPane().add(splitWidget);
	}

	@Override
	public void loadRootFrame() {

		//Generate the component required for the GUI, then run the implementation for the number generator
		execute();
		generateGUI();
	}
}
