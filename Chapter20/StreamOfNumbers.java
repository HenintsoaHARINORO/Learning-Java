import java.util.stream.LongStream;

public class StreamOfNumbers {
    public static void main(String [] args){
        LongStream evenNumbers= LongStream.iterate(0,num->num+2).limit(10);
        evenNumbers.forEach(System.out::println);
    }
}
