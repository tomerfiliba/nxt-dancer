package il.ac.tau.cs.smlab.model2lejos.library.components.systemexit;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public abstract class SystemExit implements Component {
  protected Port<Boolean> bExitSystem;
  public void setPort_bExitSystem(  Port<Boolean> bExitSystem){
    this.bExitSystem=bExitSystem;
  }
  public SystemExit(){
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

