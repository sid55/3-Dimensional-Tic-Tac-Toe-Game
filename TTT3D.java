import java.util.*;
import java.io.*;
/**
 * 
 * @author Sidharth Gilela
 * 
 * This class allows the user to play a complex
 * tic tac toe game against a very hard to beat ai.
 *
 */
public class TTT3D{
	public static void main(String[] args) throws FileNotFoundException {
		int userPoint=5;
		int computerPoint= 1;
		int [] user = new int[3];
		int [] array = new int[3];
		int [] comp = new int[3];
		int line = 0;
		Random rand = new Random();
		boolean thatsGame = false;
		Scanner sc = new Scanner (System.in);
		
		while(!thatsGame)
		{
		printMarkers();
		boolean moves = false;
		while(!moves)
		{
			System.out.println("Type your move as one one three digit number(lrc)");
			int playermove = sc.nextInt();
			user[2]=(playermove%10)%4;
			user[1]=((playermove/10)%10)%4;
			user[0]=(playermove/100)%4;
			if(isEmpty(user)){
				moves = true;
				move(user, userPoint);
			}//end if statement
			else{
				System.out.println("That spot is picked");
			}//end else statement
			  }//end while loop
			lineSums();
			if(LineComp(4*userPoint) !=-1){
				printMarkers();
				System.out.println("Good Job, You WON!!");
				thatsGame =  true;
			}//end if statement
			else if((line = LineComp(3*computerPoint)) !=-1){
				move(lastSpot(lines[line]), computerPoint);
				printMarkers();
				System.out.println("The computer wins.");
				thatsGame = true;
			}//end else if statement
			else if (!deadLine()){
				System.out.println("Well Played");
			}//end else if statement
			else if ((line = LineComp(3*userPoint)) != -1){
				move(lastSpot(lines[line]),computerPoint);
			}//end else if statement
			else if ((array = fork(computerPoint, lines, sum)) != null){
				move(array, computerPoint);
			}//end else if statement
			else if ((array = fork(userPoint, lines, sum)) != null){
				move(array, computerPoint);
			}//end else if statement
			else{
				boolean y = true;
				while(y){
					int a1 = rand.nextInt(4);
					int a2 = rand.nextInt(4);
					int a3 = rand.nextInt(4);
						if (layout[a1][a2][a3]==0){
							layout[a1][a2][a3] = 1;
						y = false;
						}//end if statement
						else 
							y = true;
						}//end while loop
			}//end else statement	
		}///end while loop
	}// end of main
	
	static int [][][] layout = new int [4][4][4];
	static int [] sum = new int [76];
	static final int [][][] lines = {
		{ { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 2 }, { 0, 0, 3 } },
		{ { 0, 1, 0 }, { 0, 1, 1 }, { 0, 1, 2 }, { 0, 1, 3 } }, 
		{ { 0, 2, 0 }, { 0, 2, 1 }, { 0, 2, 2 }, { 0, 2, 3 } }, 
		{ { 0, 3, 0 }, { 0, 3, 1 }, { 0, 3, 2 }, { 0, 3, 3 } },
		{ { 1, 0, 0 }, { 1, 0, 1 }, { 1, 0, 2 }, { 1, 0, 3 } }, 
		{ { 1, 1, 0 }, { 1, 1, 1 }, { 1, 1, 2 }, { 1, 1, 3 } },
		{ { 1, 2, 0 }, { 1, 2, 1 }, { 1, 2, 2 }, { 1, 2, 3 } },
		{ { 1, 3, 0 }, { 1, 3, 1 }, { 1, 3, 2 }, { 1, 3, 3 } }, 
		{ { 2, 0, 0 }, { 2, 0, 1 }, { 2, 0, 2 }, { 2, 0, 3 } }, 
		{ { 2, 1, 0 }, { 2, 1, 1 }, { 2, 1, 2 }, { 2, 1, 3 } }, 
		{ { 2, 2, 0 }, { 2, 2, 1 }, { 2, 2, 2 }, { 2, 2, 3 } }, 
		{ { 2, 3, 0 }, { 2, 3, 1 }, { 2, 3, 2 }, { 2, 3, 3 } }, 
		{ { 3, 0, 0 }, { 3, 0, 1 }, { 3, 0, 2 }, { 3, 0, 3 } }, 
		{ { 3, 1, 0 }, { 3, 1, 1 }, { 3, 1, 2 }, { 3, 1, 3 } }, 
		{ { 3, 2, 0 }, { 3, 2, 1 }, { 3, 2, 2 }, { 3, 2, 3 } }, 
		{ { 3, 3, 0 }, { 3, 3, 1 }, { 3, 3, 2 }, { 3, 3, 3 } },
		{ { 0, 0, 0 }, { 0, 1, 0 }, { 0, 2, 0 }, { 0, 3, 0 } },
		{ { 0, 0, 1 }, { 0, 1, 1 }, { 0, 2, 1 }, { 0, 3, 1 } }, 
		{ { 0, 0, 2 }, { 0, 1, 2 }, { 0, 2, 2 }, { 0, 3, 2 } },
		{ { 0, 0, 3 }, { 0, 1, 3 }, { 0, 2, 3 }, { 0, 3, 3 } }, 
		{ { 1, 0, 0 }, { 1, 1, 0 }, { 1, 2, 0 }, { 1, 3, 0 } }, 
		{ { 1, 0, 1 }, { 1, 1, 1 }, { 1, 2, 1 }, { 1, 3, 1 } }, 
		{ { 1, 0, 2 }, { 1, 1, 2 }, { 1, 2, 2 }, { 1, 3, 2 } }, 
		{ { 1, 0, 3 }, { 1, 1, 3 }, { 1, 2, 3 }, { 1, 3, 3 } }, 
		{ { 2, 0, 0 }, { 2, 1, 0 }, { 2, 2, 0 }, { 2, 3, 0 } }, 
		{ { 2, 0, 1 }, { 2, 1, 1 }, { 2, 2, 1 }, { 2, 3, 1 } }, 
		{ { 2, 0, 2 }, { 2, 1, 2 }, { 2, 2, 2 }, { 2, 3, 2 } }, 
		{ { 2, 0, 3 }, { 2, 1, 3 }, { 2, 2, 3 }, { 2, 3, 3 } }, 
		{ { 3, 0, 0 }, { 3, 1, 0 }, { 3, 2, 0 }, { 3, 3, 0 } }, 
		{ { 3, 0, 1 }, { 3, 1, 1 }, { 3, 2, 1 }, { 3, 3, 1 } }, 
		{ { 3, 0, 2 }, { 3, 1, 2 }, { 3, 2, 2 }, { 3, 3, 2 } }, 
		{ { 3, 0, 3 }, { 3, 1, 3 }, { 3, 2, 3 }, { 3, 3, 3 } }, 
		{ { 0, 0, 0 }, { 1, 0, 0 }, { 2, 0, 0 }, { 3, 0, 0 } }, 
		{ { 0, 0, 1 }, { 1, 0, 1 }, { 2, 0, 1 }, { 3, 0, 1 } },
		{ { 0, 0, 2 }, { 1, 0, 2 }, { 2, 0, 2 }, { 3, 0, 2 } },
		{ { 0, 0, 3 }, { 1, 0, 3 }, { 2, 0, 3 }, { 3, 0, 3 } },
		{ { 0, 1, 0 }, { 1, 1, 0 }, { 2, 1, 0 }, { 3, 1, 0 } }, 
		{ { 0, 1, 1 }, { 1, 1, 1 }, { 2, 1, 1 }, { 3, 1, 1 } },
		{ { 0, 1, 2 }, { 1, 1, 2 }, { 2, 1, 2 }, { 3, 1, 2 } },
		{ { 0, 1, 3 }, { 1, 1, 3 }, { 2, 1, 3 }, { 3, 1, 3 } },
		{ { 0, 2, 0 }, { 1, 2, 0 }, { 2, 2, 0 }, { 3, 2, 0 } }, 
		{ { 0, 2, 1 }, { 1, 2, 1 }, { 2, 2, 1 }, { 3, 2, 1 } },
		{ { 0, 2, 2 }, { 1, 2, 2 }, { 2, 2, 2 }, { 3, 2, 2 } },
		{ { 0, 2, 3 }, { 1, 2, 3 }, { 2, 2, 3 }, { 3, 2, 3 } },
		{ { 0, 3, 0 }, { 1, 3, 0 }, { 2, 3, 0 }, { 3, 3, 0 } }, 
		{ { 0, 3, 1 }, { 1, 3, 1 }, { 2, 3, 1 }, { 3, 3, 1 } },
		{ { 0, 3, 2 }, { 1, 3, 2 }, { 2, 3, 2 }, { 3, 3, 2 } },
		{ { 0, 3, 3 }, { 1, 3, 3 }, { 2, 3, 3 }, { 3, 3, 3 } },
		{ { 0, 0, 0 }, { 0, 1, 1 }, { 0, 2, 2 }, { 0, 3, 3 } }, 
		{ { 0, 3, 0 }, { 0, 2, 1 }, { 0, 1, 2 }, { 0, 0, 3 } },
		{ { 1, 0, 0 }, { 1, 1, 1 }, { 1, 2, 2 }, { 1, 3, 3 } }, 
		{ { 1, 3, 0 }, { 1, 2, 1 }, { 1, 1, 2 }, { 1, 0, 3 } },
		{ { 2, 0, 0 }, { 2, 1, 1 }, { 2, 2, 2 }, { 2, 3, 3 } }, 
		{ { 2, 3, 0 }, { 2, 2, 1 }, { 2, 1, 2 }, { 2, 0, 3 } },
		{ { 3, 0, 0 }, { 3, 1, 1 }, { 3, 2, 2 }, { 3, 3, 3 } }, 
		{ { 3, 3, 0 }, { 3, 2, 1 }, { 3, 1, 2 }, { 3, 0, 3 } },
		{ { 0, 0, 0 }, { 1, 0, 1 }, { 2, 0, 2 }, { 3, 0, 3 } }, 
		{ { 3, 0, 0 }, { 2, 0, 1 }, { 1, 0, 2 }, { 0, 0, 3 } },
		{ { 0, 1, 0 }, { 1, 1, 1 }, { 2, 1, 2 }, { 3, 1, 3 } }, 
		{ { 3, 1, 0 }, { 2, 1, 1 }, { 1, 1, 2 }, { 0, 1, 3 } },
		{ { 0, 2, 0 }, { 1, 2, 1 }, { 2, 2, 2 }, { 3, 2, 3 } }, 
		{ { 3, 2, 0 }, { 2, 2, 1 }, { 1, 2, 2 }, { 0, 2, 3 } },
		{ { 0, 3, 0 }, { 1, 3, 1 }, { 2, 3, 2 }, { 3, 3, 3 } }, 
		{ { 3, 3, 0 }, { 2, 3, 1 }, { 1, 3, 2 }, { 0, 3, 3 } },
		{ { 0, 0, 0 }, { 1, 1, 0 }, { 2, 2, 0 }, { 3, 3, 0 } }, 
		{ { 3, 0, 0 }, { 2, 1, 0 }, { 1, 2, 0 }, { 0, 3, 0 } },
		{ { 0, 0, 1 }, { 1, 1, 1 }, { 2, 2, 1 }, { 3, 3, 1 } }, 
		{ { 3, 0, 1 }, { 2, 1, 1 }, { 1, 2, 1 }, { 0, 3, 1 } },
		{ { 0, 0, 2 }, { 1, 1, 2 }, { 2, 2, 2 }, { 3, 3, 2 } }, 
		{ { 3, 0, 2 }, { 2, 1, 2 }, { 1, 2, 2 }, { 0, 3, 2 } },
		{ { 0, 0, 3 }, { 1, 1, 3 }, { 2, 2, 3 }, { 3, 3, 3 } }, 
		{ { 3, 0, 3 }, { 2, 1, 3 }, { 1, 2, 3 }, { 0, 3, 3 } },
		{ { 0, 0, 0 }, { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } }, 
		{ { 3, 0, 0 }, { 2, 1, 1 }, { 1, 2, 2 }, { 0, 3, 3 } },
		{ { 0, 3, 0 }, { 1, 2, 1 }, { 2, 1, 2 }, { 3, 0, 3 } },
		{ { 3, 3, 0 }, { 2, 2, 1 }, { 1, 1, 2 }, { 0, 0, 3 } }};
	
	/**
	 * This method takes in an integer and 
	 * converts that integer to a "_" or
	 * "O" or "X" or "?". It then returns one
	 * of these values depending on the integer
	 * placed into the method.
	 * @param val - an integer value
	 * @return - One of the corresponding values
	 * 			 to the number put into the method
	 */
	static char Marker (int val){
		switch(val){
		case 0:
			return'_';
		case 1:
			return'O';
		case 5:
			return'X';
		default:
			return'?';
		}//end switch
	}//end method
	
	/**
	 * This method  prints all the markers onto the screen
	 * in order for the user to play the game.
	 */
	static void printMarkers(){
		for(int level = 3; level>= 0 ; level--){
			for(int row = 3; row>= 0; row--){
				if (row == 0){
				System.out.print(level);
				System.out.print(row + " ");
				}else if(row == 1){
					System.out.print(" "+level);
					System.out.print(row + " ");
				}else if(row == 2){
					System.out.print("  "+level);
					System.out.print(row + " ");
				}else if(row == 3){
					System.out.print("   "+level);
					System.out.print(row + " ");
					}//end else if statements
				for(int column = 0; column<4; column++){
					System.out.print( " "+ Marker(layout[level][row][column]));
				}//end for loop
				System.out.println();
			}//end for loop
			System.out.println();
		}//end for loop
		System.out.println("    0 " + "1 " + "2 " + "3 ");
	}// end method
	
	/**
	 * This method sets the value inputed into the
	 * method to the corresponding location of the board 
	 * inputed into this method.
	 * @param x - the level of the board
	 * @param y - the row of the board
	 * @param z - the column of the board
	 * @param val - the value assigned to the 
	 * 				location chosen on the board
	 */
	static void move(int x, int y, int z, int val){
		layout[x][y][z] = val;
	}// end method
	
	/**
	 * This method calls the other move method after 
	 * inputing an array and a value into this method
	 * @param array - the array chosen to be the parameter
	 * @param val - the value chosen to be associated
	 * 				with the position found inside the method
	 */
	static void move(int[] array, int val){
		move(array[0], array[1], array[2], val);
	}// end method
	
	/**
	 * This method either returns true or false 
	 * depending on if the position chosen from the board
	 * equals 0 or not.
	 * @param array - the array with all the positions on the board
	 * @return - either true or false depending
	 *			 on which statement is satisfied.
	 */
	static boolean isEmpty(int [] array){
		if(layout[array[0]][array[1]][array[2]]== 0){
			return true;
		}//end if statement
		else{
			return false;
		}//end else statement
	}// end method
	
	/**
	 * This method calculates the sum of all the numbers associated 
	 * with all possible wins on the board and puts that number into
	 * different positions of the sum array.
	 */
	static void lineSums(){
		for(int x=0;x< sum.length; x++){
			sum[x] = 0;
			for(int y =0; y<4; y++){
				sum[x] += layout[lines[x][y][0]]
								[lines[x][y][1]]
								[lines[x][y][2]];
			}//end for loop
		}//end for loop
	}// end method
	
	/**
	 * This method takes in an integer value and if
	 * a certain position in the sum array is equal to 
	 * that number that is being looked for, this
	 * method will return that position of the sum array. 
	 * @param x - the number being looked for
	 * @return - the position in the sum array associated 
	 * with the number being searched for
	 */
	static int LineComp(int x){
		for(int i = 0; i<sum.length; i++){
			if(sum[i] == x){
				return i; 
			}//end if statement
		}//end for loop
		return -1;
	}// end method
	
	/**
	 * This method causes the ai to block a potential fork
	 * that is about to occur when the user trys to create
	 * that fork.
	 * @param x - an integer value
	 * @param lines - an array with all possible wins
	 * @param array - an array that shows the board and
	 * 				  and all its positions
	 * @return - the cell at which the ai is supposed to 
	 * 			 play an "0" at the block the fork
	 */
	static int [] fork(int x, int [][][] lines, int[] array){
		int[] cell = new int [3];
		for(int i=0; i<array.length -1; i++){
			if(array[i]== 2*x){
				for(int j= i+1; j<array.length; j++){
					if(array[j] == 2*x && (cell = commonPoint(lines[i], lines[j])) != null){
						return cell;
					}//end if statement
				}//end for loop
			}//end if statement
		}//end for loop
		return null;
	}//end method
	
	/**
	 * This method takes in two different arrays
	 * and returns the number associated with position
	 * @param line1 - the first array
	 * @param line2 - the second array
	 * @return - the number associated with the position
	 */
	static int[] commonPoint(int[][]line1, int[][]line2){
		for(int x=0; x<line1.length; x++){
			for(int y=0; y<line1.length; y++){
				if(isEqual(line1[x],line2[y]) && isEmpty(line1[x]) && isEmpty(line2[y])){
					return line1[x];
				}//end if statement
			}//end for loop
		}//end for loop
		return null;
	}// end method
	
	/**
	 * This method takes in an array and returns
	 * a position associated with the location 
	 * of the array.
	 * @param line - the array put in as a parameter
	 * @return - either the position or null
	 */
	static int[] lastSpot(int[][]line){
		for(int x = 0 ;x<4; x++){
			if(isEmpty(line[x]))
			{
				return line[x];
			}//end if statement
		}//end for loop
		return null;
	}//end method
	 
	/**
	 * This method checks if the same position associated with
	 * the two separate arrays is equal and then returns 
	 * either true or false
	 * @param a - the first array
	 * @param b - the second array
	 * @return - either true or false depending
	 * 			 on which scenario is satisfied
	 */
	static boolean isEqual(int [] a, int [] b){
		int i = 0;
		while (i<a.length){
			if(a[i] != b[i]){
				return false;
			}//end if statement
			i++;
		}//end while loop
		return true;
	}// end method
	
	/**
	 * This method checks if the entire program
	 * results in a draw. If it does, the program says 
	 * that game becomes a draw.
	 * @return - true or false depending on if
	 * 			 the game is a draw or not
	 */
	static boolean deadLine(){
		for(int i = 0; i<sum.length ; i++){
			if (sum[i]==5 || sum[i]==10 ||sum[i]==15 ){	
				return true;
			}//end if statement
		}//end for loop
		return false;
	}//end method
}// end class