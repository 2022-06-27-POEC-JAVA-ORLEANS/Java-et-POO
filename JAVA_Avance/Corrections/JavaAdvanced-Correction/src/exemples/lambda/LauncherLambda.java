package exemples.lambda;

import java.util.function.BiFunction;
import java.util.function.Consumer;

public class LauncherLambda {

	public static void main(String[] args) {

		BiFunction<Integer, Integer, Long> additionner = (val1, val2) -> (long) val1 + val2;
		System.out.println(additionner.apply(4,  15));
		
		Consumer<String> afficher = (String param) -> System.out.println(param);
		afficher.accept("Test afficher en lambda");
	}

}
