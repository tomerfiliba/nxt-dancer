package il.ac.tau.cs.smlab.model2lejos.library.wrappers.buttons;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public abstract class Button implements Component {
  protected Port<Boolean> isPressed;
  public Port<Boolean> getPort_isPressed(){
    return this.isPressed;
  }
  public Integer buttonNr;
  public Button(  Integer buttonNr){
    this.buttonNr=buttonNr;
  }
  public void init(){
  }
  public void setUp(){
    this.isPressed=new Port<Boolean>();
  }
  public void compute(){
  }
  public void update(){
    this.isPressed.update();
  }
}

