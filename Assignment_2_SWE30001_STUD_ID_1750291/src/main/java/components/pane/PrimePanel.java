package components.pane;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import helpers.ComponentsHelper;

public class PrimePanel extends JPanel
{
	private SimpleNumberCanvas fNumbers[][] = {
			{simComp(1),simComp(11),simComp(21),simComp(31),simComp(41),simComp(51),simComp(61),simComp(71),simComp(81),simComp(91)},
			{simComp(2),simComp(12),simComp(22),simComp(32),simComp(42),simComp(52),simComp(62),simComp(72),simComp(82),simComp(92)},
			{simComp(3),simComp(13),simComp(23),simComp(33),simComp(43),simComp(53),simComp(63),simComp(73),simComp(83),simComp(93)},
			{simComp(4),simComp(14),simComp(24),simComp(34),simComp(44),simComp(54),simComp(64),simComp(74),simComp(84),simComp(94)},
			{simComp(5),simComp(15),simComp(25),simComp(35),simComp(45),simComp(55),simComp(65),simComp(75),simComp(85),simComp(95)},
			{simComp(6),simComp(16),simComp(26),simComp(36),simComp(46),simComp(56),simComp(66),simComp(76),simComp(86),simComp(96)},
			{simComp(7),simComp(17),simComp(27),simComp(37),simComp(47),simComp(57),simComp(67),simComp(77),simComp(87),simComp(97)},
			{simComp(8),simComp(18),simComp(28),simComp(38),simComp(48),simComp(58),simComp(68),simComp(78),simComp(88),simComp(98)},
			{simComp(9),simComp(19),simComp(29),simComp(39),simComp(49),simComp(59),simComp(69),simComp(79),simComp(89),simComp(99)},
			{simComp(10),simComp(20),simComp(30),simComp(40),simComp(50),simComp(60),simComp(70),simComp(80),simComp(90),simComp(100)}
	}; // 10x10 array of numbers


	private SimpleNumberCanvas simComp(int number) {
		return new SimpleNumberCanvas().setTitleText(number);
	}

	private GridBagLayout mainGridLayout;

	public PrimePanel()
	{
		// create a panel with GridBagLayout
		// use insets of 5, 5, 5, 5
		// initialize array
		// add SimpleNumberCanvas elements to the panel (an array)
		// initially their background should be CYAN
		// layout numbers by columns



		initialiseControl();
		initializeGridLayout();
	}

	private void initialiseControl() {
		this.setSize(ComponentsHelper.getControlPanelFrameWidth(), ComponentsHelper.getCommonPanelFrameHeight());
		this.setBackground(Color.red);
	}

	private void initializeGridLayout() {

		this.setLayout(mainGridLayout = new GridBagLayout()); //Set the gridBag as the layout for this widget
		GridBagConstraints mainGridConstraints = new GridBagConstraints();

		mainGridConstraints.fill = GridBagConstraints.BOTH;
		mainGridConstraints.gridwidth = GridBagConstraints.REMAINDER;

		for(int row = 0; row < fNumbers.length; row++) {
			for(SimpleNumberCanvas numberItem : fNumbers[row]) {

				//Add the items into the grid control
			}
		}

	}

	public void reset()
	{
		// clear all markings, foreground BLACK, background CYAN
	}
	private SimpleNumberCanvas getNumberCanvas(int aNumber )
	{
		return new SimpleNumberCanvas();
	}
	public void setFiltered( int aNumber )
	{
		// mark cell filtered, background GRAY, foreground DARK_GRAY
		for(int row = 0; row < fNumbers.length; row++) {
			fNumbers[row ][aNumber].setBackground(Color.gray);
			fNumbers[row ][aNumber].setForeground(Color.darkGray);
		}
	}
	public void setGenerated( int aNumber )
	{
		// mark cell generated, background YELLOW
		for(int row = 0; row < fNumbers.length; row++) 
			fNumbers[row][aNumber].setBackground(Color.yellow);
	}
	public void setPrime( int aNumber )
	{
		// mark cell as prime, background GREEN, foreground RED
		for(int row = 0; row < fNumbers.length; row++) {
			fNumbers[row ][aNumber].setBackground(Color.green);
			fNumbers[row ][aNumber].setForeground(Color.red);
		}
	}
	public void blink( int aNumber )
	{
		// let cell blink
		
		for(int row = 0; row < fNumbers.length; row++) {
			fNumbers[row ][aNumber].setBackground(Color.gray);
		}
	}
}