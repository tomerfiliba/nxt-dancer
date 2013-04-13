package il.ac.tau.cs.smlab.model2lejos.library.wrappers.colordistinguisher;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lejos.nxt.ColorSensor.Color;
public class ColorDistinguisherFactory {
  private static ColorDistinguisherFactory instance;
  public static void setInstance(  ColorDistinguisherFactory factory){
    instance=factory;
  }
  public static ColorDistinguisher create(  lejos.nxt.SensorPort sensorPort){
    if (instance == null)     instance=new ColorDistinguisherFactory();
    return instance.doCreate(sensorPort);
  }
  protected ColorDistinguisher doCreate(  lejos.nxt.SensorPort sensorPort){
    return new ColorDistinguisherImpl(sensorPort);
  }
}

