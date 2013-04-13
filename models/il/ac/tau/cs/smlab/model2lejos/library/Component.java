package il.ac.tau.cs.smlab.model2lejos.library;
/**
 * Interface for all components 
 */
public interface Component {
	public void setUp();
	public void init();
	public void compute();
	public void update();
}
