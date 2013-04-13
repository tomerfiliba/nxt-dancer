package il.ac.tau.cs.smlab.model2lejos.library.wrappers.soundlevel;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public abstract class SoundLevel implements Component {
  protected Port<Integer> soundLevel;
  public Port<Integer> getPort_soundLevel(){
    return this.soundLevel;
  }
  public lejos.nxt.SensorPort sensorPort;
  public SoundLevel(  lejos.nxt.SensorPort sensorPort){
    this.sensorPort=sensorPort;
  }
  public void init(){
  }
  public void setUp(){
    this.soundLevel=new Port<Integer>();
  }
  public void compute(){
  }
  public void update(){
    this.soundLevel.update();
  }
}

