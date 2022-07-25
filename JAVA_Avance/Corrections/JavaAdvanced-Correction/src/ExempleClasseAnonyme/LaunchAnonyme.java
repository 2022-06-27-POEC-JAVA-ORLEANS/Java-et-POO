package ExempleClasseAnonyme;

public class LaunchAnonyme {

	public static void main(String[] args) {

		Bird test = new Bird() {

			@Override
			public void fly() {
				System.out.println("Je nage !");
			}
			
		};
		
		//Bird test2 = new Bird();

	}

}
