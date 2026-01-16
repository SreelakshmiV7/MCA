class ExceptionDemo
{
    public static void main(String[] args)
    {
        System.out.println("welcome");
        try
        {
        int a=Integer.parseInt(args[0]);
        int b=Integer.parseInt(args[1]);
        int c=a/b;
        System.out.println("result is: "+c);
        }
        catch(ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Array index is not present, please provide command line argument");
        }
        catch(ArithmeticException e)
        {
            System.out.println("Denominator should not be zero");
        }
        finally
        {
            System.out.println("finally block executed");
            System.out.println("end");
        }
    }
}
// try block is used because of the possibility of exception
// catch block is to be  exeuted when exception occurs
// finally block is always executed whether exception occurs or not
//multiple exceptions in a program can be handled by multiple catch blocks
//two types of exceptions -checked and unchecked
