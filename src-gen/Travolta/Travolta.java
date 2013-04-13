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
public class Travolta implements Component {
  protected Port<Integer> powerR;
  public Port<Integer> getPort_powerR(){
    return this.powerR;
  }
  protected Port<Integer> powerL;
  public Port<Integer> getPort_powerL(){
    return this.powerL;
  }
  protected Port<MotorDirection> dirR;
  public Port<MotorDirection> getPort_dirR(){
    return this.dirR;
  }
  protected Port<MotorDirection> dirL;
  public Port<MotorDirection> getPort_dirL(){
    return this.dirL;
  }
  protected Port<Integer> lightVal;
  public void setPort_lightVal(  Port<Integer> lightVal){
    this.lightVal=lightVal;
  }
  protected Port<Integer> soundVal;
  public void setPort_soundVal(  Port<Integer> soundVal){
    this.soundVal=soundVal;
  }
  protected Port<Integer> colorVal;
  public void setPort_colorVal(  Port<Integer> colorVal){
    this.colorVal=colorVal;
  }
  public Travolta(){
  }
  public Button escButton;
  public SystemExit system;
  public MotorControl motorR;
  public MotorControl motorL;
  public ColorDistinguisher colorSensor;
  public LightLevel lightLevel;
  public SoundLevel soundLevel;
  public void init(){
    this.system.setPort_bExitSystem(this.escButton.getPort_isPressed());
    this.motorR.setPort_direction(this.dirR);
    this.motorR.setPort_power(this.powerR);
    this.motorL.setPort_direction(this.dirL);
    this.motorL.setPort_power(this.powerL);
    escButton.init();
    system.init();
    motorR.init();
    motorL.init();
    colorSensor.init();
    lightLevel.init();
    soundLevel.init();
  }
  public void setUp(){
    escButton=ButtonFactory.create(lejos.nxt.Button.ID_ESCAPE);
    escButton.setUp();
    system=SystemExitFactory.create();
    system.setUp();
    motorR=MotorControlFactory.create(MotorPort.B);
    motorR.setUp();
    motorL=MotorControlFactory.create(MotorPort.C);
    motorL.setUp();
    colorSensor=ColorDistinguisherFactory.create(SensorPort.S3);
    colorSensor.setUp();
    lightLevel=LightLevelFactory.create(SensorPort.S4);
    lightLevel.setUp();
    soundLevel=SoundLevelFactory.create(SensorPort.S1);
    soundLevel.setUp();
    this.powerR=new Port<Integer>();
    this.powerL=new Port<Integer>();
    this.dirR=new Port<MotorDirection>();
    this.dirL=new Port<MotorDirection>();
    this.colorVal=this.colorSensor.getPort_colorValue();
    this.lightVal=this.lightLevel.getPort_lightLevel();
    this.soundVal=this.soundLevel.getPort_soundLevel();
  }
  public void compute(){
    escButton.compute();
    system.compute();
    motorR.compute();
    motorL.compute();
    colorSensor.compute();
    lightLevel.compute();
    soundLevel.compute();
  }
  public void update(){
    escButton.update();
    system.update();
    motorR.update();
    motorL.update();
    colorSensor.update();
    lightLevel.update();
    soundLevel.update();
  }
}

