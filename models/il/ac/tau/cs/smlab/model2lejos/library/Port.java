package il.ac.tau.cs.smlab.model2lejos.library;

public class Port<T> {
	private T currentValue = null;
	private T nextValue = null;
	
	public T getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(T currentValue) {
		this.currentValue = currentValue;
	}
	public T getNextValue() {
		return nextValue;
	}
	public void setNextValue(T nextValue) {
		this.nextValue = nextValue;
	}
	
	public void update() {
		this.currentValue = this.nextValue;
		this.nextValue = null;
	}
}
