package il.ac.tau.cs.smlab.model2lejos.library.wrappers.lightlevel;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public abstract class LightLevel implements Component {
  protected Port<Integer> lightLevel;
  public Port<Integer> getPort_lightLevel(){
    return this.lightLevel;
  }
  public lejos.nxt.SensorPort sensorPort;
  public LightLevel(  lejos.nxt.SensorPort sensorPort){
    this.sensorPort=sensorPort;
  }
  public void init(){
  }
  public void setUp(){
    this.lightLevel=new Port<Integer>();
  }
  public void compute(){
  }
  public void update(){
    this.lightLevel.update();
  }
}

