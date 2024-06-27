package eliponga_vrixzandroho09;

public class MyThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
        }
    }
}