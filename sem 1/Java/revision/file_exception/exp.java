import java.io.*;

class InvalidAgeException extends Exception {
    InvalidAgeException(String msg) {
        super(msg);
    }
}

public class exp {

    static void validateAge(int age) throws InvalidAgeException {
        if (age < 18)
            throw new InvalidAgeException("Age must be 18+");
    }

    static void readFile() throws IOException {
        FileReader fr = new FileReader("missing.txt");
    }

    static void riskyOperation(int n) {
        int a = 10 / n;  // may cause divide by zero
        int arr[] = new int[2];
        arr[5] = 10;     // array error
    }

    public static void main(String[] args) {

        try {
            validateAge(12);
            readFile();
            riskyOperation(0);
        }
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
        catch (Exception e) {
            System.out.println("General Exception: " + e);
        }
        finally {
            System.out.println("FINALLY BLOCK: Always executes");
        }

        System.out.println("Program continues...");
    }
}
