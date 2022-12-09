/**
 * 同步线程
 * @author bin
 * @date 2022-12-05-10:03
 */
public class SingleSynchronized {
    public static void main(String[] args) {
        Num num = new Num();
        User user = new User(num);
        Thread u1 = new Thread(user);
        u1.start();

        Bank bank = new Bank(num);
        bank.start();

    }
}

class Num {

}

class Bank extends Thread {

    private Num num;

    public Bank(Num num) {
        this.num = num;
    }

    @Override
    public void run() {
        synchronized (num) {
            try {
                sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("银行：开门叫号");
            num.notify();
        }
    }
}

class User implements Runnable {

    private Num num;

    public User(Num num) {
        this.num = num;
    }

    public void run() {
        synchronized (num) {
            System.out.println("客户：银行没开门，等待中...");
            try {
                num.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("客户：叫到号了");
        }
    }
}