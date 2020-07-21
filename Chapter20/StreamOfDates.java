
import java.time.LocalDateTime;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamOfDates {
    public static void main(String [] args){
        Supplier<LocalDateTime> myStopWatch= ()->{
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            return LocalDateTime.now();
        };
        Stream<LocalDateTime> timeStream= Stream.generate(myStopWatch);
        timeStream.forEach(System.out::println);
    }
}
