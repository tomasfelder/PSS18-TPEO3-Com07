package paraProbar;

public class B extends A{

	public B() {
		
	}
	
	public B ret(B b) {
		System.out.println("estoy en B");
		return new B();
	}
}
