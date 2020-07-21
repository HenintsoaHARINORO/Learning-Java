package tryit;
import java.time.LocalDateTime;

import java.util.stream.Stream;

public class StreamOfDates {
    public static LocalDateTime myStopWatchFunction(){
        try{
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return LocalDateTime.now();

    }
    public static void main(String [] args){
        Stream<LocalDateTime> timeStream = Stream
                .generate(StreamOfDates::myStopWatchFunction)
                .limit(5);
        timeStream.forEach(System.out::println);
    }
}