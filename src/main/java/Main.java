import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(10);

        List<MyCall> callableList = new ArrayList<>();

        for (int i = 1; i <= 3; i++) {
            callableList.add(new MyCall(i * 2, "thread - " + i));
        }
        List<Future<Integer>> futures = executor.invokeAll(callableList);

        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }
        executor.shutdown();
    }
}

