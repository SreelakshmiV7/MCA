import java.io.*;

// Custom Exception using 'extends Exception'
class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class MasterExceptionDemo {

    // 'throws' → method declares that it may throw InvalidAgeException
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            // 'throw' → manually create & throw an exception
            throw new InvalidAgeException("Age must be 18+");
    }

    // 'throws' → this method might throw IOException
    static void readFile() throws IOException {
        FileReader fr = new FileReader("missing.txt");  
    }

    // risky code WITHOUT throws (unchecked exceptions)
    static void riskyOperation(int n) {
        int a = 10 / n;     // ArithmeticException (divide by zero)
        int arr[] = new int[2];
        arr[5] = 10;        // ArrayIndexOutOfBoundsException
    }

    public static void main(String[] args) {

        // 'try' → group of statements that may cause one or more exceptions
        try {

            // May throw InvalidAgeException
            validateAge(12);

            // May throw IOException
            readFile();

            // May throw ArithmeticException or ArrayIndexOutOfBoundsException
            riskyOperation(0);
        }

        // 'catch' → handle specific exceptions one-by-one

        catch (InvalidAgeException e) {
            System.out.println("Custom Exception: " + e.getMessage());
        }

        catch (IOException e) {
            System.out.println("File Operation Error");
        }

        catch (ArithmeticException e) {
            System.out.println("Divide by zero error");
        }

        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array index error");
        }

        // General Exception catch (must be LAST)
        catch (Exception e) {
            System.out.println("General Exception: " + e);
        }

        // 'finally' → ALWAYS runs (error or no error)
        finally {
            System.out.println("FINALLY BLOCK: Always executes");
        }

        System.out.println("Program continues...");
    }
}
