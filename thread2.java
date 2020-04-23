package javaapplication8;

class A extends Thread
{
    public void run()
    {
        
        for(int i=0;i<5;i++)
        {
            System.out.println(" thread A running");
        }
       
    }
}
class B extends Thread
{
    public void run()
    {
       
        for(int j=0;j<5;j++)
        {
            System.out.println(" thread B running");
        }
        
    }
}
class C extends Thread
{
    public void run()
    {
      
        for(int k=0;k<5;k++)
        {
            System.out.println("thread C running");
        }
        
    }
}
class JavaApplication
{
public static void main(String args[])
{
A threadA=new A();
B threadB=new B();
C threadC=new C();
threadC.setPriority(Thread.MIN_PRIORITY);
threadB.setPriority(Thread.NORM_PRIORITY);
threadA.setPriority(Thread.MAX_PRIORITY);
threadA.start();
threadB.start();
threadC.start();
}
}


















































































































