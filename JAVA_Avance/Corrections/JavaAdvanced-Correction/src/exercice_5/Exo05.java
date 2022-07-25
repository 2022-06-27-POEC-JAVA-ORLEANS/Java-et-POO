package exercice_5;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class Exo05 {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Long> multiplier = (val1, val2) -> (long) val1 * val2;
		System.out.println(multiplier.apply(4,  5));
		
		Consumer<Integer> compter = (Integer param) -> {
			for(int i = 1; i <= param; i++) {
				System.out.println(i);
			}
		};
		compter.accept(8);

	}

}
