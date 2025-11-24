class One extends Thread {
 public void run()   {
 System.out.println(Thread.currentThread().getName()+" "+getPriority());
 } } 
class MainThread {
 public static void main(String args[]) {
 One t1=new One();
 One t2=new One(); 
One t3=new One();   
t1.setPriority(Thread.NORM_PRIORITY); 
t2.setPriority(Thread.MIN_PRIORITY); 
t3.setPriority(Thread.MAX_PRIORITY); 
t1.start(); 
t2.start(); 
t3.start();
 } }