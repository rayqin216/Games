package practice;
import java.util.*;
import java.io.*;

public class GameRPS {
	// 1. rock; 2.paper; 3.scissors;
	public void Game()
	{
		boolean process = true;
		int input = 0;
		do
		{
			System.out.println("Please select a number as your move");
			System.out.println("1. rock");
			System.out.println("2. paper");
			System.out.println("3. scissors");
			System.out.println("4. quit");
			Scanner sc = new Scanner(System.in);
			try
			{
				input = Integer.parseInt(sc.nextLine());
			}
			catch(Exception e)
			{
				System.out.println("Please enter a number only!");
			}
			if(input == 4)
			{
				System.out.println("Thank you for playing. Closing");
				process = false;
			}
			else if(input == 1 || input == 2 || input == 3)
			{
				GameResult(input);
			}
			else
			{
				System.out.println("Please enter a valid option");
			}
		}while(process);
	}
	// 1 = win ; 2 = lose; 3 = tie
	// 1. rock; 2.paper; 3.scissors;
	public void GameResult(int input)
	{
		Random r = new Random();
		int game = r.nextInt((3-1) + 1) + 1;
		switch(input){
			case 1: 
				if( game == 1)
				{
					System.out.println("Your opponent chose rock");
					System.out.println("You tied");
				}
				else if(game == 2)
				{
					System.out.println("Your opponent chose paper");
					System.out.println("You lost");
				}
				else if(game == 3)
				{
					System.out.println("Your opponent chose scissors");
					System.out.println("You won");
				}
				break;
			case 2:
				if( game == 1)
				{
					System.out.println("Your opponent chose rock");
					System.out.println("You won");
				}
				else if(game == 2)
				{
					System.out.println("Your opponent chose paper");
					System.out.println("You tied");
				}
				else if(game == 3)
				{
					System.out.println("Your opponent chose scissors");
					System.out.println("You lost");
				}
				break;
			case 3:
				if(game == 1)
				{
					System.out.println("Your opponent chose paper");
					System.out.println("You lost");
				}
				else if(game == 2)
				{
					System.out.println("Your opponent chose paper");
					System.out.println("You won");
				}
				else if(game == 3)
				{
					System.out.println("Your opponent chose scissors");
					System.out.println("You tied");
				}
				break;
			default:
				break;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GameRPS obj1 = new GameRPS();
		obj1.Game();
	}

}
