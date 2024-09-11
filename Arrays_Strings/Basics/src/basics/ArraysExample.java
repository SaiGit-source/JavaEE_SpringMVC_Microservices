package basics;

import java.util.Scanner;

public class ArraysExample {
	// arrays are for homogeneous datasets like integer etc
	// Contiguous memory allocated
	// No buffer overrun problem in Java, array memory boundaries are guarded

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[][][] ar = new int[2][3][4];
		// lets say we have 2 schools, 3 classes and 4 students in each class so it is a regular array and we could pre-define the sizes
		System.out.println("Regular array");
		for (int i=0; i<ar.length; i++) {
			for (int j=0; j<ar[i].length; j++) {
				for(int k=0; k<ar[i][j].length; k++) {
					System.out.print("Enter mark for school "+i+" for class "+j+" for student "+k + " ");
					ar[i][j][k] = scan.nextInt();
				}
			}
		}
		
		for (int i=0; i<ar.length; i++) {
			for (int j=0; j<ar[i].length; j++) {
				for(int k=0; k<ar[i][j].length; k++) {
					System.out.print(ar[i][j][k] + " ");
				}
				System.out.println();
			}
			System.out.println();
		}
		
		System.out.println("Jagged or irregular array");
		// Jagged array or irregular array where sizes are different
		int[][] arr = new int[3][]; // 3 classes are there but no of students are variables
		arr[0]=new int[3];
		arr[1]=new int[2];
		arr[2]=new int[4]; // no of students is a variable
		for (int i=0; i<arr.length; i++) {
			for (int j=0; j<arr[i].length; j++) {
					System.out.print("Enter mark for class "+i+" for student "+j+" ");
					arr[i][j] = scan.nextInt();
				}
			}
	
	for (int i=0; i<arr.length; i++) {
		for (int j=0; j<arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
		System.out.println();
		}

	}
}
