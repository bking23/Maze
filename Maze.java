/*
 * Program Name: Maze
 * 
 * Name: Benjamin King
 * 
 * Date: October 11, 2019
 * 
 */
import java.util.*;
import java.io.*;
public class Maze {
	public static String MAZE;
	public static char[][] charMaze = new char[20][20];
	public static void main(String[] args){
		Scanner input = new Scanner(System.in), inputFile = null;
		List<String> temp = new ArrayList<String>();
		int row = 0, col = 0, r = 0, c = 0, c1 = 0;
		System.out.print("Enter a file to open (maze.txt): ");
		String file = input.next(), tempStr = "";
		File someFile = new File(file);
		//reading the maze from a .txt file
		try{
			inputFile = new Scanner(someFile);	
			while(inputFile.hasNext()){
				MAZE = inputFile.next();
				temp.add(MAZE);
				for(col = 0; col < 20; col++) 
					charMaze[row][col] = MAZE.charAt(col);					
				tempStr = tempStr.concat(MAZE);
				row++;
			}			
			String[] tempToArray = temp.toArray(new String[0]);
			System.out.println();
			System.out.print("Column: ");
			while(c < 20){
				System.out.print(c++ + " ");
			}
			System.out.println();
			for (String s : tempToArray){
				System.out.print("Row " + r++ + ": ");
				System.out.println(s);
			}
			System.out.println("Enter a starting point to traverse through the maze (row and column must be between 0 and 19): ");
			int userRow = getInt(input);
			int userCol = getInt(input);
			//input validation
			while(userRow < 0 || userRow > 20 || userCol < 0 || userCol > 20){
				System.out.println("Out of bounds. Choose and integer between 0 and 19: ");
				userRow = getInt(input);
				userCol = getInt(input);
			}	
			System.out.println("You entered " + userRow + ", " + userCol + " and the result is: ");
			linkedListSolve(userRow, userCol);	
			System.out.print("Column: ");
			while(c1 < 20){
				System.out.print(c1++ + " ");
			}
			System.out.println();
			charMaze[userRow][userCol] = 'S';
			printArr(charMaze);
		}
		catch (FileNotFoundException e){
			System.err.println("---File Not Found!---");
		}
	}
	//input validation
	public static int getInt(Scanner input){
		while(!input.hasNextInt()){
			System.out.println("Not an integer!!! Try again: ");
			input.next();
		}
		return input.nextInt();
	}
	//simple print method for printing the array
	public static void printArr(char[][] arr) {
		int r = 0;
		for(int row = 0; row < 20; row++) {
			System.out.print("Row " + r++ + ": ");
			for(int col = 0; col < 20; col++) 
				System.out.print(arr[row][col]);
			System.out.println();
		}
	}
	//using the linkedlist to remember the path it is traversing through
	public static void linkedListSolve(int row, int col) {
		LinkedList<Integer> llist = new LinkedList<Integer>();
		LinkedListNode<Integer> current = new LinkedListNode<Integer>(row, col);
		llist.first = current;
		if(findPath(current, row, col)) 
			System.out.println("I am free.");
		else
			System.out.println("Help, I am trapped.");
	}
	//method used to traverse through the maze to find a path
	public static boolean findPath(LinkedListNode<Integer> current, int row, int col) {
		LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(row,col);
		current.next = newNode;
		if (charMaze[row][col] == 'E')
			return true;
		if(col-1 >= 0 && col-1 <= 19 && charMaze[row][col-1] != '+') { 
			if (charMaze[row][col-1] != '1' ) { 
				if (charMaze[row][col-1] == 'E')
					return true;
				charMaze[row][col-1] = '+';
				if (findPath(newNode, row, col-1)) 
					return true;
				charMaze[row][col-1] = '0';
			}
		}
		if(row-1 >= 0 && row-1 <= 19 && charMaze[row-1][col] != '+') { 
			if (charMaze[row-1][col] != '1' ) { 
				if (charMaze[row-1][col] == 'E')
					return true;
				charMaze[row-1][col] = '+';
				if (findPath(newNode, row-1, col))
					return true;
				charMaze[row-1][col] = '0';
			}
		}
		if(col+1 >= 0 && col+1 <= 19 && charMaze[row][col+1] != '+') { 
			if (charMaze[row][col+1] != '1' ) { 
				if (charMaze[row][col+1] == 'E')
					return true;
				charMaze[row][col+1] = '+';
				if (findPath(newNode, row, col+1))
					return true;
				charMaze[row][col+1] = '0';
			}
		}
		if(row+1 >= 0 && row+1 <= 19 && charMaze[row+1][col] != '+') { 
			if (charMaze[row+1][col] != '1') { 
				if (charMaze[row+1][col] == 'E')
					return true;
				charMaze[row+1][col] = '+';
				if (findPath(newNode, row+1, col))
					return true;
				charMaze[row+1][col] = '0';
			}
		}
		return false;
	}
}
