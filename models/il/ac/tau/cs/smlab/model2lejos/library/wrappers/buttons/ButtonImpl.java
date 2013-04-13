package il.ac.tau.cs.smlab.model2lejos.library.wrappers.buttons;

/**
 * Implementation of component Button used to observe whether a special button on the 
 * lejos nxt brick is pressed.
 */
public class ButtonImpl extends Button{

	/** id of observed button **/
	private int iButtonNr;
	
	/**
	 * Constructor, initializing the ButtonImpl
	 * @param iButtonNr id of button, which will be observed
	 */
	public ButtonImpl(Integer iButtonNr)
	{
		super(iButtonNr);
		this.iButtonNr = iButtonNr;
	}
	
	/**
	 * Evaluating button state of observed button.
	 * Result is sent to outport isPressed of component Button
	 * ('true' if button is pressed, 'false' else)
	 */
	@Override
	public void compute() {
		
		boolean bPressed = false;
		switch(iButtonNr)
		{
		case (lejos.nxt.Button.ID_ENTER): //Id 1
			if (lejos.nxt.Button.ENTER.isDown())
				bPressed = true;
			break;
		case (lejos.nxt.Button.ID_LEFT): //Id 2
			if (lejos.nxt.Button.LEFT.isDown())
				bPressed = true;
			break;
		case (lejos.nxt.Button.ID_RIGHT): //Id 4
			if (lejos.nxt.Button.RIGHT.isDown())
				bPressed = true;
			break;
		case (lejos.nxt.Button.ID_ESCAPE): //Id 8
			if (lejos.nxt.Button.ESCAPE.isDown())
				bPressed = true;
			break;
		}
		
		
		this.isPressed.setNextValue(bPressed);
	}
	
}
