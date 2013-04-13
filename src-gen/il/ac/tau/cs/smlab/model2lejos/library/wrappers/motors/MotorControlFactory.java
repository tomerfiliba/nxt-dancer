package il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public class MotorControlFactory {
  private static MotorControlFactory instance;
  public static void setInstance(  MotorControlFactory factory){
    instance=factory;
  }
  public static MotorControl create(  lejos.nxt.MotorPort motorPort){
    if (instance == null)     instance=new MotorControlFactory();
    return instance.doCreate(motorPort);
  }
  protected MotorControl doCreate(  lejos.nxt.MotorPort motorPort){
    return new MotorControlImpl(motorPort);
  }
}

