import java.util.ArrayList;
import java.util.List;

public class ImperativeVsFunctionnal {
	public static void main(String[] args) {
		List<String> winners = new ArrayList<>();
		winners.add("Mary");
		winners.add("Lily");
		winners.add("Paul");
		winners.add("Joe");

		boolean gotMary = false;
		for (String winner : winners) {
			if ("Mary".equals(winner)) {
				gotMary = true;
				System.out.println("IMPERATIVE STYLE . Mary won? " + gotMary);
				break;
			}
		}
		System.out.println("Functionnal style. Mary won? "+winners.contains("Mary") );
	}

}
