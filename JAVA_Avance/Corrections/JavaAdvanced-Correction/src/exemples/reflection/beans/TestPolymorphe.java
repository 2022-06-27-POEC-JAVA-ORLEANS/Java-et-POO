package exemples.reflection.beans;

public class TestPolymorphe {

	public static void main(String[] args) {


		Animal test = new Cat();
		Animal test2 = new Dog();
		//Animal test3 = new Animal();
		
		Integer nb = 8;
		
		runAnimal(test);
		runAnimal(test2);
		
		Animal test4 = new Animal() {

			Integer nbT = nb;
			
			@Override
			public int getNumberOfLegs() {
				// TODO Auto-generated method stub
				return 0;
			}
			
			public int getNnbTumberOfAiles() {
				return nbT;
			}
			
		};
	}
	
	
	public static void runAnimal(Animal a) {
		System.out.println(a.toString());
	}

}
