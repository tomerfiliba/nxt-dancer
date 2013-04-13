package il.ac.tau.cs.smlab.model2lejos.library.wrappers.colordistinguisher;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
import lejos.nxt.ColorSensor.Color;
public abstract class ColorDistinguisher implements Component {
  protected Port<Integer> colorValue;
  public Port<Integer> getPort_colorValue(){
    return this.colorValue;
  }
  public lejos.nxt.SensorPort sensorPort;
  public ColorDistinguisher(  lejos.nxt.SensorPort sensorPort){
    this.sensorPort=sensorPort;
  }
  public void init(){
  }
  public void setUp(){
    this.colorValue=new Port<Integer>();
  }
  public void compute(){
  }
  public void update(){
    this.colorValue.update();
  }
}

