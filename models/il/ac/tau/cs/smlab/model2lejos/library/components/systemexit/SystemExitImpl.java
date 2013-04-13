package il.ac.tau.cs.smlab.model2lejos.library.components.systemexit;
import java.lang.System;

/**
 * Implementation of component SystemExit, used to exit a java program on a single boolean value
 */
public class SystemExitImpl extends SystemExit {

	/**
	 * Constructor
	 */
	public SystemExitImpl()
	{
		super();
	}
	
	/**
	 * If inport bExitSystem is set to true, exit the program with exit status 0 (ok)
	 */
	@Override
	public void compute() 
	{
		if(this.bExitSystem != null)
		{
			if(this.bExitSystem.getCurrentValue() != null && this.bExitSystem.getCurrentValue().booleanValue())
				System.exit(0);
		}
	}

}
