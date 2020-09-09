package client;
import components.frames.SieveGridFrame;
import components.pane.ControlPanel;
import components.pane.PrimePanel;
import eu.lestard.easydi.EasyDI;
import services.NumberGenerator;
import services.PrimeFilter;

//Application Manager -- Registers View Models, Services, Components required for dependency injection
public class ApplicationMngr {

	private EasyDI _container;
	public void initializeApplication() {
		_container = new EasyDI();
		
		registerComponents();
		registerServices();


		initializeApplicationFrame(); //Start up the main root frame & the application
	}

	private void registerComponents() {
		_container.markAsSingleton(SieveGridFrame.class);
		
		//Panels
		_container.markAsSingleton(ControlPanel.class);
		_container.markAsSingleton(PrimePanel.class);
	}

	private void registerServices() {
		_container.markAsSingleton(NumberGenerator.class);
		_container.markAsSingleton(PrimeFilter.class);
	}

	private void initializeApplicationFrame() {
		_container.getInstance(SieveGridFrame.class).loadRootFrame();
	}
}
