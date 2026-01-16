
class NewThread extends Thread 
{
    public void run( )
    {
        for(int i=0;i<5;i++) 
        {
            System.out.println("Value of i "+i);
            System.out.println(Thread.currentThread().getName());
        }
    }
 }
class threads
{
    public static void main(String args[]) 
    {
        NewThread t=new NewThread();
        t.start();
    }
}
