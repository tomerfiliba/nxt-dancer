package il.ac.tau.cs.smlab.model2lejos.library.components.systemexit;
import il.ac.tau.cs.smlab.model2lejos.library.Component;
import il.ac.tau.cs.smlab.model2lejos.library.Port;
public class SystemExitFactory {
  private static SystemExitFactory instance;
  public static void setInstance(  SystemExitFactory factory){
    instance=factory;
  }
  public static SystemExit create(){
    if (instance == null)     instance=new SystemExitFactory();
    return instance.doCreate();
  }
  protected SystemExit doCreate(){
    return new SystemExitImpl();
  }
}

