class examplethread1 extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
            System.out.println("hello Thread1");
        }
    }
}
class examplethread2 extends Thread
{
    public void run()
    {
        for(int i=0;i<5;i++)
        {
             System.out.println("hello Thread2");
        }
    }
}
class JavaApplication7
{
    public static void main(String args[])
    {
        examplethread1 t1=new examplethread1();
        examplethread2 t2=new examplethread2();
        t1.start();
        t2.start();
    }
}






