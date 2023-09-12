package practice;
import java.util.*;
import java.io.*;

public class Hangman {
	public boolean Game()
	{
		boolean process = true;
		ArrayList<Character> word = new ArrayList<>();
		do
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("Please enter the word");
			String input = sc.next().toLowerCase();
			ArrayList<Character> temp = new ArrayList<>();
			for(int x = 0; x < input.length();x++)
			{
				char c = input.charAt(x);
				if(c >= 'a' && c <= 'z')
				{
					process = true;
					temp.add(c);
				}
				else
				{
					System.out.println("Please enter a valid word");
					process = false;
					break;
				}
			}
			word = temp;
		}while(!process);
		int attemp = 7;
		int missing = word.size();
		ArrayList<Character> guess = new ArrayList<>();
		do
		{
			System.out.println("Please enter a character");
			Scanner sc = new Scanner(System.in);
			char c = ' ';
			try
			{
				c = sc.next().charAt(0);
				attemp--;
				if(c >= 'a' && c <= 'z' && !guess.contains(c))
				{
					guess.add(c);
					for(int x = 0; x < word.size();x ++)
					{
						if(word.get(x) == c)
						{
							missing--;
						}
					}
				}
				else
				{
					System.out.println("Please enter a valid character");
				}
			}
			catch(Exception e)
			{
				System.out.println("This is not a character");
			}
			for(int x = 0; x < word.size();x++)
			{
				if(guess.contains(word.get(x)))
				{
					System.out.print(word.get(x));
				}
				else
				{
					System.out.print('*');
				}
			}
			System.out.println();
			System.out.println("Attempt left: " + attemp + "/" + 7);
		}while(attemp > 0 && missing != 0);
		if(missing == 0)
		{
			System.out.println("You win");
		}
		else
		{
			System.out.println("You Lose");
		}
		System.out.println("Do you want to play again ?");
		System.out.println("Press 1 to replay or other numbers to close the game");
		Scanner bc = new Scanner(System.in);
		int a = 0;
		boolean dc = false;
		while(!dc)
		{
			try
			{
				a = bc.nextInt();
				dc = true;
			}
			catch(Exception e)
			{
				System.out.println("Press 1 to replay or other numbers to close the game");
			}
		}
		if( a == 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void Start()
	{
		System.out.println("Welcom to hangman game");
		boolean process = true;
		do
		{
			process = Game();
		}while(process);
		System.out.println("Closing the game");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hangman obj1 = new Hangman();
		obj1.Start();
	}

}
