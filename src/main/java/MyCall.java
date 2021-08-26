import java.util.concurrent.Callable;

public class MyCall implements Callable<Integer> {
    private int maxCount;
    private String threadName;

    public MyCall(int maxCount, String threadName) {
        this.maxCount = maxCount;
        this.threadName = threadName;
    }

    @Override
    public Integer call() {
        int count = 0;

        while (count < maxCount){
            Thread.currentThread().setName(threadName);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток " + Thread.currentThread().getName() + " увеличивает count на единицу ");
            count++;
        }
        System.out.println("Для потока " + Thread.currentThread().getName() + " вернется значение: " + count);
        return count;
    }

}
