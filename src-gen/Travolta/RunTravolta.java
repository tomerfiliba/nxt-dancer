package Travolta;
public class RunTravolta {
  public static void main(  String[] args){
    Travolta cmp=TravoltaFactory.create();
    cmp.setUp();
    cmp.init();
    while (true) {
      cmp.compute();
      cmp.update();
    }
  }
}

