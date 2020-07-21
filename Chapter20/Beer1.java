
public class Beer1 implements Comparable<Beer1>{
    public String name;
    public String country;
    public float price;

    Beer1(String name,String country,float price){
        this.name= name;
        this.country= country;
        this.price= price;
    }


    public int compareTo(Beer1 otherBeer) {
       if(this.price > otherBeer.price){
           return  1;
       }else  if(this.price < otherBeer.price){
           return  -1;
       }else {
           return 0;
       }
    }
    public  String toString(){
        return  "Name: "+ name +", price: "+price;
    }
}
