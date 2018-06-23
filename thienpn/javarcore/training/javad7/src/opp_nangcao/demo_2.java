package opp_nangcao;

public class demo_2 {
  static public int x= 200;
  static {
	  x+=100;
  }
  static public void methob() {
	  x+=200;
  }
  public static void main(String[] args) {
	  demo_2 demo = new demo_2();
	  demo.x += 300;
	System.out.println(demo_2.x);
	demo_2.x +=500; //demo_2.methob();
	System.out.println(demo_2.x);
	
	
}
}
