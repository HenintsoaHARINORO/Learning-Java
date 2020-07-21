import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CompareBeer1 {
    static List<Beer1> loadCellar(){
        List<Beer1> beerStock= new ArrayList<>();
        beerStock.add(new Beer1("Stella", "Belgium", 7.75f));
        beerStock.add(new  Beer1("Sam Adams", "USA", 7.00f));
        beerStock.add(new  Beer1("Obolon", "Ukraine", 4.00f));
        beerStock.add(new  Beer1("Bud Light", "USA", 5.00f));
        beerStock.add(new  Beer1("Yuengling", "USA", 5.50f));
        beerStock.add(new  Beer1("Leffe Blonde", "Belgium", 8.75f));
        beerStock.add(new  Beer1("Chimay Blue", "Belgium", 10.00f));
        beerStock.add(new Beer1("Brooklyn Lager", "USA", 8.25f));

        return beerStock;
    }
    public static void main(String [] args){
        List<Beer1> beers = loadCellar();
        Collections.sort(beers);
        beers.forEach(System.out::println);
    }
}
