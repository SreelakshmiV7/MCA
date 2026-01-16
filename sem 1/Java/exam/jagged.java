import java.util.*;
class jagged{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of rows");
        int r=sc.nextInt();
        int arr[][]=new int[r][];
        for(int i=0;i<r;i++){
            System.out.println("Enter number of columns for row"+i);
            int c=sc.nextInt();
            arr[i]=new int[c];
        }
        System.out.println("Enter the elements of the jagged array");
        for(int i=0;i<r;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.println("Enter element for row"+(i+1)+"column"+(j+1));
                arr[i][j]=sc.nextInt();
            }
        }
        System.out.println("The jagged array is");
        for(int i=0;i<r;i++){
            for(int j=0;j<arr[i].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
}