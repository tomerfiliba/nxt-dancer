package il.ac.tau.cs.smlab.model2lejos.library.wrappers.buttons;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public class ButtonFactory {
  private static ButtonFactory instance;
  public static void setInstance(  ButtonFactory factory){
    instance=factory;
  }
  public static Button create(  Integer buttonNr){
    if (instance == null)     instance=new ButtonFactory();
    return instance.doCreate(buttonNr);
  }
  protected Button doCreate(  Integer buttonNr){
    return new ButtonImpl(buttonNr);
  }
}

