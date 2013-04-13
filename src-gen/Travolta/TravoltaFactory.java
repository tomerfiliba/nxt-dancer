package Travolta;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.buttons.Button;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.buttons.ButtonFactory;
import il.ac.tau.cs.smlab.model2lejos.library.components.systemexit.SystemExit;
import il.ac.tau.cs.smlab.model2lejos.library.components.systemexit.SystemExitFactory;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.soundlevel.SoundLevel;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.soundlevel.SoundLevelFactory;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.lightlevel.LightLevel;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.lightlevel.LightLevelFactory;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.colordistinguisher.ColorDistinguisher;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.colordistinguisher.ColorDistinguisherFactory;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors.MotorControl;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors.MotorControlFactory;
import il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors.MotorDirection;
import lejos.nxt.MotorPort;
import lejos.nxt.SensorPort;
public class TravoltaFactory {
  private static TravoltaFactory instance;
  public static void setInstance(  TravoltaFactory factory){
    instance=factory;
  }
  public static Travolta create(){
    if (instance == null)     instance=new TravoltaFactory();
    return instance.doCreate();
  }
  protected Travolta doCreate(){
    return new TravoltaImpl();
  }
}

