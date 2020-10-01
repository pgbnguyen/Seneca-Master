/**********************************************
Workshop #1
Course: JAC444NCC - Fall2020
Last Name: Nguyen
First Name: Pham Gia Bao
ID: 125433177
Section: NCC
This assignment represents my own work in accordance with Seneca Academic Policy.
Signature
Date: September 26th 2020
**********************************************/
import java.util.*;
public class Maxlocation {
	double max;
	int row;
	int col;
	
	 public static void main(String[] args) {
		  Scanner in = new Scanner(System.in);

	        System.out.print("Enter the number of rows and columns in the array: ");
	        int rows = in.nextInt();
	        int columns = in.nextInt();
	        double[][] userArray = new double[rows][columns];
	        System.out.println("Enter the array:");
	        for (int i = 0; i < userArray.length; i++) {
	            for (int j = 0; j < userArray[i].length; j++) {
	                userArray[i][j] = in.nextDouble();
	            }
	        }
	        in.close();
	        //Create instance of Maxlocation class
	        Maxlocation location = new Maxlocation();
	        //Find max and locate its row and column
	        location.findMax(userArray);
	        //Print out result
	        System.out.format("The location of the largest element is %.2f at (%d, %d)", location.max, location.row, location.col);
	 }
	 
	 public double findMax(double[][] arr) {
		 max = arr[0][0];
		 for(int i=0; i < arr.length; i++) {
			 for(int j=0; j < arr.length; j++) {
				 if(max < arr[i][j]) {
					 max =arr[i][j];
					 row = i;
					 col = j;
				 }
			 }
		 }
		 return max;
	 }
}
