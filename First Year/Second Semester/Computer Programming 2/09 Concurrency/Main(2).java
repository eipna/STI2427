package eliponga_vrixzandroho09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        
        MyThread thread1 = new MyThread();
        MyThread thread2 = new MyThread();
        
        System.out.print("Enter your first thread: ");
        String firstThreadName = scanner.nextLine();
        System.out.print("Enter your second thread: ");
        String secondThreadName = scanner.nextLine();
        
        thread1.setName(firstThreadName);
        thread2.setName(secondThreadName);
        
        System.out.println(thread1.getName() + " is " + thread1.getState());
        System.out.println(thread2.getName() + " is " + thread2.getState());
        System.out.println("\nStarting the threads...");
        
        thread1.start();
        thread2.start();
        System.out.println(thread1.getName() + " is " + thread1.getState());
        System.out.println(thread2.getName() + " is " + thread2.getState());
        
        thread1.join();
	thread2.join();
        
	System.out.println("\nAfter sleep...");
        System.out.println(thread1.getName() + " is " + thread1.getState());
        System.out.println(thread2.getName() + " is " + thread2.getState());
    }
}