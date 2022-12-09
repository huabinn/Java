import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 多线程
 * @author bin
 * @date 2022-12-05-9:51
 */
public class Threads {
    public static void main(String[] args) {
        // 创建固定线程服务对象 (创建有3个线程的线程池)
        ExecutorService executorService = Executors.newFixedThreadPool(3);

        for (int i=0; i<5; i++) {
            executorService.submit(
                    new Runnable() {
                        @Override
                        public void run() {
                            System.out.println(Thread.currentThread().getName());
                        }
                    }
            );
        }
    }
}
