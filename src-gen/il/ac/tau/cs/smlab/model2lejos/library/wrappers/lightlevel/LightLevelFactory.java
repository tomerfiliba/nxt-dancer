package il.ac.tau.cs.smlab.model2lejos.library.wrappers.lightlevel;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public class LightLevelFactory {
  private static LightLevelFactory instance;
  public static void setInstance(  LightLevelFactory factory){
    instance=factory;
  }
  public static LightLevel create(  lejos.nxt.SensorPort sensorPort){
    if (instance == null)     instance=new LightLevelFactory();
    return instance.doCreate(sensorPort);
  }
  protected LightLevel doCreate(  lejos.nxt.SensorPort sensorPort){
    return new LightLevelImpl(sensorPort);
  }
}

