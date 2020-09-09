/*
 *	SWE30001, 2020
 *
 *	Multi-threaded Sieve of Eratosthenes
 * 
 */

package services;

import components.frames.SieveGridFrame;

public class PrimeFilter implements Runnable
{
    private int fPrime;					// the prime number of this filter
    public SieveGridFrame fSieve;				// reference to Sieve
    private PrimeFilter fNextPrime;		// next prime filter

    private Thread fThread;				// this prime filter’s thread
    private int fTest;					// integer to be tested
	
//    public PrimeFilter(SieveGridFrame aSieve )
//    {
//    	// constructor
//    	// initially fTest is set to -1 signaling that no number is available
//    	fPrime = 100;
//    	fSieve = aSieve;
//    	fNextPrime = null;
//    	fThread = null;
//    	fTest = -1;
//    }
//	
    public PrimeFilter( )
    {
    	// constructor
    	// initially fTest is set to -1 signaling that no number is available
    	fPrime = 100;
    	fNextPrime = null;
    	fThread = null;
    	fTest = -1;
    }
    
    public void start()
    {
    	// create and start filter thread, name it Filter x, where x is the fPrime
    	fThread = new Thread( this, String.format( "Filter %d", fPrime ) );
    	fThread.start();
    }
	
    public void stop()
    {
    	// if next filter is not null, stop it
    	if ( fNextPrime != null )
    	{
    		fNextPrime.stop();
    	}
    	// if this thread is not null, interrupt it
    	if ( fThread != null )
    	{
    		fThread.interrupt();
    		fThread = null;
    	}
    }
	
    public synchronized void filter( int aTest )
    {
    	// set test
    	fTest = aTest;
    	// notify this filter
    	notify();
    }
	
    public void run()
    {
    	try
    	{
    		synchronized(this)
    		{
    			// increment Sieve’s thread count for this prime
    			fSieve.incrementThreads( fPrime );

    			// continuously run a loop that
    			// 1. Tests if a new test number is available, otherwise wait
    			// 2. Using blink of Sieve, signal that this filter is active
    			// 3. If test can be divided by this filter, mark test filtered (use Sieve)
    			// 4. If test cannot be divided, send test to next filter
    			// 5. If no next filter is available, create a new one and signal (to Sieve)
    			//    that a new prime has been discovered and a number has been filtered
    			// 6. Set fTest to -1 indicating that this filter is done
    			// At the end, signal to Sieve, once this thread is done, to decrement the
    			// thread count by one
    	
    			while ( fThread != null )
    			{
    				if ( fTest == -1 )
    				{
    					wait();
    				}

    				fSieve.blink( fTest );
    				
    				if ( fTest % fPrime == 0 )
    				{
    					fSieve.incrementFiltered( fTest );
    				}
    				else
    				{
    					if ( fNextPrime != null )
    					{
    						fNextPrime.filter( fTest );
    					}
    					else
    					{
    						fSieve.incrementPrimes( fTest );
    						fSieve.incrementFiltered( fTest );
    						fNextPrime = new PrimeFilter( );
    						fNextPrime.start();
    					}
    				}
    					
    				fTest = -1;
    			}
    		}
    	}
    	catch (InterruptedException e) 
    	{}
    	
    	fThread = null;
    	fSieve.decrementThreads();
    }
}
