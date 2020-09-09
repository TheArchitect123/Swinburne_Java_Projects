package components.pane;

import java.awt.Color;

import javax.swing.JPanel;

import helpers.ComponentsHelper;

public class PrimePanel extends JPanel
{
	private int fNumbers[][] = {
			{1,11,21,31,41,51,61,71,81,91},
			{2,12,22,32,42,52,62,72,82,92},
			{3,13,23,33,43,53,63,73,83,93},
			{4,14,24,34,44,54,64,74,84,94},
			{5,15,25,35,45,55,65,75,85,95},
			{6,16,26,36,46,56,66,76,86,96},
			{7,17,27,37,47,57,67,77,87,97},
			{8,18,28,38,48,58,68,78,88,98},
			{9,19,29,39,49,59,69,79,89,99},
			{10,20,30,40,50,60,70,80,90,100}
	}; // 10x10 array of numbers
	
	public PrimePanel()
	{
		// create a panel with GridBagLayout
		// use insets of 5, 5, 5, 5
		// initialize array
		// add SimpleNumberCanvas elements to the panel (an array)
		// initially their background should be CYAN
		// layout numbers by columns
		
		initialiseControl();
	}
	
	private void initialiseControl() {
		this.setSize(ComponentsHelper.getControlPanelFrameWidth(), ComponentsHelper.getCommonPanelFrameHeight());
		this.setBackground(Color.red);
	}
	
	public void reset()
	{
		// clear all markings, foreground BLACK, background CYAN
	}
	private SimpleNumberCanvas getNumberCanvas( int aNumber )
	{
		// auxiliary function to find and return the object in fNumbers
		// that corresponds to aNumber
		
		return new SimpleNumberCanvas();
	}
	public void setFiltered( int aNumber )
	{
		// mark cell filtered, background GRAY, foreground DARK_GRAY
	}
	public void setGenerated( int aNumber )
	{
		// mark cell generated, background YELLOW
	}
	public void setPrime( int aNumber )
	{
		// mark cell as prime, background GREEN, foreground RED
	}
	public void blink( int aNumber )
	{
		// let cell blink
	}
}