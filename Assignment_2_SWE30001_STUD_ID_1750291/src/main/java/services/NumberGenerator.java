/*
 *	SWE30001, 2020 

 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

package services;

import components.frames.SieveGridFrame;

public class NumberGenerator extends Thread //Inherit from Thread since it already implements Runnable (to manage synchronisation)
{		// number of integers to generate
	public SieveGridFrame sieveFrame;		// reference to main object 

	public PrimeFilter _primeFilter;	// the first filter for 2
	final int gLimit = 100;
	
	//Dependency Injection manages instantiating each of these classes, along with passing the arguments required for making this class work
	public NumberGenerator(PrimeFilter primeFilter)
	{
		super("NumberGenerator");
		_primeFilter = primeFilter;
	}

	@Override
	public synchronized void start()
	{
		super.start();
		sieveFrame.incrementThreads( 0 ); 
	}

	public synchronized void stopRunningThread()
	{
		// if fTwo is not null, stop fTwo
		if ( _primeFilter != null )
			_primeFilter.stop();

		this.interrupt(); //Stop running thread if need to
	}

	@Override
	public synchronized void run()
	{
		try 
		{
			synchronized(this)
			{
				sieveFrame.incrementFiltered( 1 );

				_primeFilter.start();
				sieveFrame.incrementFiltered( 2 );
				sieveFrame.incrementPrimes( 2 );

				while (true)
				{
					for ( int i = 3; i <= gLimit; i++ )
					{
						wait( 100 );
						_primeFilter.filter( i );
					}

					while ( sieveFrame.getFiltered() != gLimit )
					{
						wait( 1 );
					}

					stopRunningThread(); //Stop the running thread then exit the loop
					break;
				}
			}
		}
		catch (InterruptedException e) 
		{
			System.out.print("Looks like something went wrong..." + e.getMessage());
		}

		sieveFrame.decrementThreads();
	}
}
