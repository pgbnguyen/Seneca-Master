import java.util.Scanner;

public class Welcome {
	public static void main(String[] args) {

        Scanner input= new Scanner(System.in);
int row = 3;
int col = 4;
     int array[][]= new int[row][col];
        System.out.println("Please enter 10 integers");
        for(int i=0; i<row; i++){
        for(int j=0; j<col;j++){
                array[i][j]= input.nextInt();
}
}
int max = Integer.MIN_VALUE;
int maxRow = 0;
int maxCol = 0;
  for(int i=0; i<row; i++){
      for(int j =0; j<col; j++){
                if(max<array[i][j]){
                    max = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
      }
            System.out.println("Maximum number in the is "+ max + " at row " + maxRow  + "th " + "collums " + maxCol  + "th ");
            System.out.println();
        }              

    }
}
