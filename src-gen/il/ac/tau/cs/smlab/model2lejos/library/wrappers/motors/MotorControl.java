package il.ac.tau.cs.smlab.model2lejos.library.wrappers.motors;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public abstract class MotorControl implements Component {
  protected Port<Integer> power;
  public void setPort_power(  Port<Integer> power){
    this.power=power;
  }
  protected Port<MotorDirection> direction;
  public void setPort_direction(  Port<MotorDirection> direction){
    this.direction=direction;
  }
  public lejos.nxt.MotorPort motorPort;
  public MotorControl(  lejos.nxt.MotorPort motorPort){
    this.motorPort=motorPort;
  }
  public void init(){
  }
  public void setUp(){
  }
  public void compute(){
  }
  public void update(){
  }
}

