package il.ac.tau.cs.smlab.model2lejos.library.wrappers.soundlevel;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public class SoundLevelFactory {
  private static SoundLevelFactory instance;
  public static void setInstance(  SoundLevelFactory factory){
    instance=factory;
  }
  public static SoundLevel create(  lejos.nxt.SensorPort sensorPort){
    if (instance == null)     instance=new SoundLevelFactory();
    return instance.doCreate(sensorPort);
  }
  protected SoundLevel doCreate(  lejos.nxt.SensorPort sensorPort){
    return new SoundLevelImpl(sensorPort);
  }
}

