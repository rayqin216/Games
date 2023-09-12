package practice;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.*;
import java.text.DecimalFormat;

public class Practice2 {	
	public void count()
	{
		Scanner sc = new Scanner(System.in);
		int count = 0;
		for(int x = 0; x < 101; x++)
		{
			String input = sc.nextLine();
			if( x == 69)
			{
				System.out.println(input);
			}
		}
	}
	
	public void MergeString(String a1, String a2)
	{
		if(a1.length() == a2.length())
		{
			String result ="";
			for(int x = 0; x < a1.length(); x++)
			{
				char c1 = a1.charAt(x);
				char c2 = a2.charAt(x);
				result += String.valueOf(c1);
				result += String.valueOf(c2);
			}
			System.out.println(result);
		}
		else if(a1.length() < a2.length())
		{
			int ct = a1.length();
			String result ="";
			for(int x = 0; x < ct; x++)
			{
				char c1 = a1.charAt(x);
				char c2 = a2.charAt(x);
				result += String.valueOf(c1);
				result += String.valueOf(c2);
			}
			result += a2.substring(ct, a2.length());
			System.out.println(result);
		}
		else
		{
			int ct = a2.length();
			String result ="";
			for(int x = 0; x < ct; x++)
			{
				char c1 = a1.charAt(x);
				char c2 = a2.charAt(x);
				result += String.valueOf(c1);
				result += String.valueOf(c2);
			}
			result += a1.substring(ct, a1.length());
			System.out.println(result);
		}
	}
	
	public String gcdOfStrings(String str1, String str2)
	{
		if(str1.length() < str2.length())
		{
			return gcdOfStrings(str2, str1);
		}
		else if(!str1.startsWith(str2))
		{
			return "";
		}
		else if(str2.isEmpty())
		{
			return str1;
		}
		else
		{
			return gcdOfStrings(str1.substring(str2.length()), str2);
		}
	}
	
	/*public String gcdOfStrings(String str1, String str2)
	{
		if(str1.length() < str2.length())
		{
			return gcdOfStrings(str2, str1);
		}
		else if(!str1.startsWith(str2))
		{
			return "";
		}
		else if(str2.isEmpty())
		{
			return str1;
		}
		else
		{
			return gcdOfStrings(str1.substring(str2.length()), str2);
		}
	}*/

	public List<Boolean> kidsWithCandies(int extraCandies)
	{
		int[] candies = {2,3,5,1,3};
		List<Boolean> list = new LinkedList<>();
		for(int x = 0; x < candies.length; x++)
		{
			int sum = candies[x] + extraCandies;
			list.add(CompareCandies(candies, sum));
		}
		System.out.println(list.toString());
		return list;
	}
	
	public boolean CompareCandies(int[] candies, int sum)
	{
		 
		boolean result = true;
		for(int x = 0; x < candies.length; x++)
		{
			if(sum < candies[x])
			{
				result = false;
			}
		}
		return result;
	}
	
	public boolean  canPlaceFlowers(int[] flowerbed, int n)
	{
		int ct = 0;
		for(int x = 0; x < flowerbed.length;x++) 
		{
			if(flowerbed[x] == 0)
			{
				boolean LeftEmpty = CheckFront(flowerbed,x);
				boolean RightEmpty = CheckBack(flowerbed,x);
				if(RightEmpty && LeftEmpty)
				{
					flowerbed[x] = 1;
					ct++;
				}
			}
			
		}
		return ct >= n;

	}
	
	public boolean CheckFront(int[] flowerbed, int x)
	{
		if(flowerbed[flowerbed.length -1] == 0 || flowerbed[x+1] == 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public boolean CheckBack(int[] flowerbed, int x)
	{
		if(x == 0 || flowerbed[x -1] == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public void reverseVowels(String input)
	{
		char[] array = input.toCharArray();
		int leftpoint = 0;
		int rightpoint = array.length -1;
		do
		{
			if(Vowel(array[leftpoint]))
			{
				do
				{
					if(Vowel(array[rightpoint]))
					{
						char temp = array[rightpoint];
						array[rightpoint] = array[leftpoint];
						array[leftpoint] = temp;
						//System.out.println(array[rightpoint] + "u");
						rightpoint--;
						break;
					}
					else
					{
						rightpoint--;
					}
				}while(true);
				leftpoint++;
			}
			else
			{
				leftpoint++;
			}
			
		}while(leftpoint < rightpoint);

		String result ="";
		for(char c : array)
		{
			System.out.print(c + ",");
		}
		System.out.println(result);
	}
	
	public boolean Vowel(char input)
	{
		switch(input)
		{
		case 'a':
			return true;
		case 'e':
			return true;
		case 'i':
			return true;
		case 'o':
			return true;
		case 'u':
			return true;
		case 'A':
			return true;
		case 'E':
			return true;
		case 'I':
			return true;
		case 'O':
			return true;
		case 'U':
			return true;
		default:
			return false;
		}
	}
	
	public String reverseWords(String s)
	{
		String[] array = s.split(" ");
		ArrayList<String> alist = new ArrayList();
		for(int x = array.length - 1; x >= 0;x--)
		{
			if(!array[x].isBlank())
			{
				alist.add(array[x]);
			}
		}

		String result = "";
		for(int y = 0; y < alist.size(); y++)
		{
			if(y != alist.size() -1)
			{
				result+= alist.get(y) + " ";
			}
			else
			{
				result+= alist.get(y);
			}
		}
		return result;
	}
	
	/*public int[] productExceptSelf(int[] nums)
	{
		return 
	}*/
	
	public int Product(int ct, int pos, int result, int end)
	{
		if(pos == end)
		{
			result = result * 2;
			System.out.println(result);
			return result;

		}
		else if(pos == ct)
		{
			result = result *1;
			pos++;
			return Product(ct, pos,result,end);
		}
		else 
		{
			result = result * 2;
			System.out.println(result);
			pos++;
			return Product(ct, pos, result,end);
		}
	}
	
	public boolean increasingTriplet()
	{
		int[] nums = {2,4,-2,-3};
		int big = Integer.MAX_VALUE;
		int small = Integer.MAX_VALUE;
		for(int n : nums)
		{
			if(n <= small)
			{
				small = n;
			}
			else if(n <= big)
			{
				big = n;
			}
			else
			{
				System.out.println("true");
				return true;
			}
			System.out.println(n);
		}
		return false;
	}
	
	public void compress()
	{
		char[] chars = {'x','a','e','b','c','c','d'};
		int ct = 0;
		char pos = Character.MAX_VALUE;
		String input = "";
		if(chars.length == 1)
		{
			input += String.valueOf(chars[0]);
		}
		else
		{
			for(int x = 0; x < chars.length;x++)
			{
				if(x == 0)
				{
					pos = chars[x];
					input += String.valueOf(pos);
					ct++;
				}
				else if(x != 0 && x != chars.length -1 && chars[x] != pos)
				{
					String temp = String.valueOf(ct);
					input += temp;
					pos = chars[x];
					input += String.valueOf(pos);
					ct = 1;	
				}
				else if(chars[x] == pos && x != chars.length -1)
				{
					ct++;
				}
				else if(x == chars.length -1)
				{
					if(chars[x] == pos)
					{
						ct++;
						
						String temp = String.valueOf(ct);
						input += temp;
					}
					else
					{
						input += String.valueOf(ct);
						input += String.valueOf(chars[x]) + '1';
					}
				}
			}
		}
		System.out.println(input);
		char[] result = new char[input.length()];
		for( int g = 0; g < input.length();g++)
		{
			char c = input.charAt(g);
			result[g] = c;
		}
		System.out.println(result.length);
	}
	
	public void moveZeroes()
	{
		int[] nums = {0,7,0,0,12};
		if(EmptyArray(nums) || CountZeros(nums) == 0)
		{
			System.out.println(Arrays.toString(nums));
		}
		else
		{
			int nofz = CountZeros(nums);
			int pos = 0;
			do
			{
				if(nums[pos] != 0)
				{
					pos++;
				}
				else
				{
					int temp = NoneZeroPosition(pos, nums);
					nums[pos] = nums[temp];
					nums[temp] = 0;
					pos++;
				}
			}while(pos != nums.length - nofz);
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public int CountZeros(int[] nums)
	{
		int ct = 0;
		for(int x = 0; x< nums.length;x++)
		{
			if(nums[x] == 0)
			{
				ct++;
			}
		}
		return ct;
	}
	
	public int NoneZeroPosition(int pos, int[] nums)
	{
		int ct = 0;
		for(int x = pos; x < nums.length; x++)
		{
			if(nums[x] != 0)
			{
				ct = x;
				break;
			}
		}
		return ct;
	}
	
	public boolean EmptyArray(int nums[])
	{
		boolean result = true;
		for(int x = 0; x < nums.length; x++)
		{
			if(nums[x] != 0)
			{
				result = false;
				break;
			}
		}
		return result;
	}
	
	public boolean isSubsequence(String s,String t )
	{
		if(s.length() > 0 && t.length() > 0)
		{
			char[] array = t.toCharArray();
			Queue<Character> q = new LinkedList<>();
			for(int x = 0; x < s.length();x++)
			{
				char c = s.charAt(x);
				q.add(c);
			}
			System.out.print(q);
			for(int y = 0; y < t.length(); y++)
			{
				if(array[y] == q.peek())
				{
					q.poll();
					if(q.isEmpty())
					{
						break;
					}
				}
			}
			if(q.isEmpty())
			{
				System.out.println(true);
				return true;
			}
			else
			{
				System.out.println(false);
				return false;
			}
		}
		else if(s.length() == 0)
		{
			return true;
		}
		else if(t.length() == 0)
		{
			return false;
		}
		else
		{
			return false;
		}
	}
	
	public int MaxArea(int[] height)
	{
		// two pointer problem;
		int left = 0;
		int right = height.length - 1;
		int maxa = 0;
		do
		{
			int currenta = Math.min(height[left], height[right]) * (right - left);
			maxa = Math.max(maxa, currenta);
			if(height[right] > height[left])
			{
				left++;
			}
			else
			{
				right--;
			}
		}while(left <= right);
		System.out.println(maxa);
		return maxa;
	}
	
	public int maxOperations()
	{	
		int[] nums = {1,2,3,4};
		int ct = 0;
		Arrays.sort(nums);
		int k = 5;
		int S = 0;
		int E = nums.length -1;
		do
		{
			int sum = nums[S] + nums[E];
			if(sum == k)
			{
				ct++;
				S++;
				E--;
			}
			else if( sum < k)
			{
				S++;
			}
			else if(sum > k)
			{
				E--;
			}
		}while(S < E);
		return ct;
	}
	
	public double findMaxAverage()
	{
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		if(nums.length < k)
		{
			return 0;
		}
		else
		{
			
			return findaverage(nums, k);
		}
	}
	
	public double findaverage(int[] nums, int k)
	{
		ArrayList<Integer> list = new ArrayList<>();
		for(int x = 0; x <= nums.length - k;x++)
		{
			int result = 0;
			//System.out.println(x);
			for(int y = 0; y < k; y++)
			{
				result += nums[x+y];
				//System.out.print(result + ",");
			}
			list.add(result);
			//System.out.println(result);
		}
		//System.out.println(list.size());
		Integer[] arr = new Integer[list.size()];
		arr = list.toArray(arr);
		//System.out.println();
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		double b = (double)arr[arr.length -1] /4;
		double result = FormatDecimal(b);
		System.out.println(b);
		return result;
		
	}
	
	public double FormatDecimal(double input)
	{
		DecimalFormat df = new DecimalFormat("########0.00000");
		double result =  Double.parseDouble(df.format(input));
		return result;
	}
	
	public double FindMaxAverage(int[] nums, int k)
	{
		//Sliding windows problem;
		int sum = 0;
		for(int x = 0; x < k; x++)
		{
			sum += nums[x];
		}
		int maxsum = sum;
		for(int y = k; y < nums.length; y++)
		{
			sum += nums[y] - nums[y - k];
			Math.max(maxsum, sum);
		}
		return (double)maxsum / k;
	}
	
	public int maxVowels()
	{
		String s = "ibpbhixfiouhdljnjfflpapptrxgcomvnb";
		int k = 33;
		char[] array = s.toCharArray();
		int ct = 0;
		for(int x = 0; x < k; x++)
		{
			if(Vowel(array[x]))
			{
				ct++;
			}
		}
		int max =ct;
		for(int y = k; y < array.length; y++)
		{
			
			if(Vowel(array[y]) && !Vowel(array[y -k]))
			{
				ct++;
			}
			else if(!Vowel(array[y]) && Vowel(array[y -k])) 
			{
				ct--;
			}
			max = Math.max(max, ct);
		}
		//System.out.println(max);
		return max;
	}
	
	public int longestOnes()
	{
		int[] nums = {0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1};
		int k = 3;
		int ct = 0;
		int anchor = 0;
		int max = Integer.MIN_VALUE;
		for(int x = 0; x < nums.length; x++)
		{
			if(nums[x] == 0)
			{
				ct++;
			}
			if(ct > k)
			{
				while(nums[anchor] != 0)
				{
					anchor++;
				}
				anchor++;
				ct--;
			}
			max = Math.max(max, x - anchor + 1);
		}
		System.out.print(max);
		return max;
	}
	
	public int longestSubarray()
	{
		int[] nums = {0,1,1,1,0,1,1,0,1};
		int ct = 0; 
		int max = Integer.MIN_VALUE;
		int anchor = 0;
		int[] check = new int[nums.length];
		for(int x : nums)
		{
			check[x] = nums[x];
		}
		Arrays.sort(check);
		if(check[0] == 1)
		{
			return check.length - 1;
		}
		else if(check[nums.length - 1] == 0)
		{
			return 0;
		}
		else
		{
			for(int x =0; x< nums.length;x++)
			{
				if(nums[x] == 0 && ct == 0)
				{
					ct++;
				}
				else if(nums[x] == 0 && ct == 1 )
				{
					while(nums[anchor] == 0)
					{
						anchor++;
					}
					ct--;
				}
				max = Math.max(x - anchor, max);
				System.out.println("max area in:" + x + " anchor: " + anchor);
				System.out.println(max);
			}
		}
		//System.out.print(max);
		return max;
	}
	
	public int largestAltitude()
	{
		int[] gain = {-5,1,5,0,-7};
		int max = 0;
		int total = 0;
		Arrays.sort(gain);
		for(int x = 0; x < gain.length; x++)
		{
			total += gain[x];
			max = Math.max(total, max);
		}
		System.out.println(max);
		return max;
	}
	
	public int pivotIndex()
	{
		int[] nums = {-1,-1,-1,0,-1,-1};
		int pivot = -1;
		int ct = 0;
		int left = 0;
		int right = 0;
		for(int z = 0; z < nums.length; z++)
		{
			right += nums[z];
		}
		while( ct < nums.length)
		{
			right -= nums[ct];
			if(right == left)
			{
				pivot  = ct;
				break;
			}
			else
			{
				left+= nums[ct];
			}
			System.out.println(left + " : " + right + " : " + ct);
			ct++;
		}
		System.out.println(pivot);
		return pivot;
	}
	
	public List<List<Integer>> findDifference()
	{
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,4,6};
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		List<List<Integer>> Lst = new ArrayList<>();
		List<Integer> answer0 = new ArrayList<>();
		List<Integer> answer1 = new ArrayList<>();
		HashMap<Integer, Integer> hm1 = new HashMap<>();
		HashMap<Integer, Integer> hm2 = new HashMap<>();
		int temp = Integer.MIN_VALUE;
		for(int x = 0; x < nums1.length;x++)
		{
			hm1.put(nums1[x], 0);
		}
		for(int y = 0; y < nums2.length; y++)
		{
			if(!hm1.containsKey(nums2[y]) && temp != nums2[y] )
			{
				answer1.add(nums2[y]);
				temp = nums2[y];
			}
		}
		temp = Integer.MIN_VALUE;
		for(int z = 0; z < nums2.length; z++)
		{
			hm2.put(nums2[z], 0);
		}
		for(int d = 0; d < nums1.length; d++)
		{
			if(!hm2.containsKey(nums1[d]) && temp != nums1[d])
			{
				answer0.add(nums1[d]);
				temp = nums1[d];
			}
		}
		Lst.add(answer0);
		Lst.add(answer1);	
		return Lst;
	}
	
	public  boolean uniqueOccurrences()
	{
		int[] arr = {3,5,-2,-3,-6,-6};
		Arrays.sort(arr);
		boolean result = true;
		HashMap <Integer, Integer> hm = new HashMap<>();
		for(int x = 0; x < arr.length; x++)
		{
			if(!hm.containsKey(arr[x]))
			{
				hm.put(arr[x], 1);
			}
			else if(hm.containsKey(arr[x]))
			{
				int value = hm.get(arr[x]);
				hm.put(arr[x], value + 1);
			}
		}
		Stack<Integer> st = new Stack<>();
		for(int x : hm.keySet())
		{
			if(!st.contains(hm.get(x)))
			{
				st.push(hm.get(x));
			}
			else
			{
				result = false;
				break;
			}
		}
		//System.out.println("key: " + x + " value: " + hm.get(x));
		System.out.println(result);
		return result;
	}
	
	public boolean closeStrings()
	{
		String word1 = "";
		String word2 = "";
		if(CheckUniqueCharInStrings(word1, word2))
		{
			if(CheckOccurance(word1, word2))
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public boolean CheckUniqueCharInStrings(String word1, String word2)
	{
		HashSet<Character> w1 = new HashSet<>();
		HashSet<Character> w2 = new HashSet<>();
		if(word1.length() != word2.length())
		{
			return false;
		}
		else
		{
			for(int x = 0; x < word1.length(); x++)
			{
				char one = word1.charAt(x);
				char two = word2.charAt(x);
				w1.add(one);
				w2.add(two);
			}
			if(w1.size() != w2.size())
			{
				return false;
			}
			else
			{
				for(Character e : w2)
				{
					if(!w1.contains(e))
					{
						return false;
					}
				}
				return true;
			}
		}
	}
	
	
	public boolean CheckOccurance(String word1, String word2)
	{
		HashMap<Character, Integer> hm1 = new HashMap<>();
		HashMap<Character, Integer> hm2 = new HashMap<>();
		for(int x = 0; x < word1.length(); x++)
		{
			char one = word1.charAt(x);
			char two = word2.charAt(x);
			if(!hm1.containsKey(one))
			{
				hm1.put(one, 1);
			}
			else
			{
				int value = hm1.get(one);
				hm1.put(one, value + 1);
			}
			if(!hm2.containsKey(two))
			{
				hm2.put(two, 1);
			}
			else
			{
				int value = hm2.get(two);
				hm2.put(two, value + 1);
			}
		}
		for(Map.Entry<Character, Integer> entry : hm2.entrySet())
		{
			int value = entry.getValue();
			char temp = ' ';
			if(hm1.containsValue(value))
			{
				for(Map.Entry<Character, Integer> entry2 : hm1.entrySet())
				{
					if(Objects.equals(entry2.getValue(), value))
					{
						  temp = entry2.getKey();
					}
				}
				hm1.remove(temp);
			}
			else
			{
				System.out.println("false");
				return false;
			}
		}
		return true;
	}
	
	public String removeStars()
	{
		String s = "leet**cod*e";
		Stack<Character> stk = new Stack<>();
		for(int x = 0; x < s.length(); x++)
		{
			char c = s.charAt(x);
			if(c != '*')
			{
				stk.push(c);
			}
			else
			{
				stk.pop();
			}
		}
		if(stk.isEmpty())
		{
			return "";
		}
		StringBuilder result = new StringBuilder();
		for(char c : stk)
		{
			result.append(c);
		}
		System.out.println(result);		
		return result.toString();
	}
	
	public int[] asteroidCollision()
	{
		int[] asteroids = {-2,-1,1,2};
		Stack<Integer> stk = new Stack<>();
		for(int x = 0; x < asteroids.length;x++)
		{
			while(true)
			{
				if(stk.isEmpty() || stk.peek() > 0 && asteroids[x] > 0 || stk.peek() < 0 && asteroids[x] < 0)
				{
					stk.push(asteroids[x]);
					break;
				}
				else if(stk.peek() > 0 && asteroids[x] < 0)
				{
					if(Math.abs(stk.peek()) == Math.abs(asteroids[x]))
					{
						stk.pop();
						break;
					}
					else if(Math.abs(stk.peek()) < Math.abs(asteroids[x]))
					{
						stk.pop();
					}
					else 
					{
						break;
					}
				}
				else if(stk.peek() < 0 && asteroids[x] > 0)
				{
					stk.push(asteroids[x]);
					break;
				}
			}
		}
		int[] arr = new int[stk.size()];
		int ct = stk.size() -1;
		while(!stk.isEmpty())
		{
			arr[ct] = stk.pop();
			ct--;
		}
		//System.out.println(Arrays.toString(arr));
		return arr;
	}
	
	public int[] dailyTemperatures()
	{
		int[] temperatures = {73,74,75,71,69,72,76,73};
		int[] result = new int[temperatures.length];
		if(temperatures.length == 0)
		{
			return result;
		}
		for(int x = 0; x < temperatures.length;x++)
		{
			int temp = temperatures[x];
			for(int y = x + 1; y < temperatures.length; y++)
			{
				if(temperatures[y] > temp)
				{
					int r = y - x;
					result[x] = r;
					break;
				}
			}
		}
		result[result.length - 1] = 0;
		System.out.println(Arrays.toString(result));
		return result;
	}
	
	public int tribonacci(int n)
	{
	       if(n==0) return 0;
	       if(n==1) return 1;
	       if(n==2) return 1;
	       int a=0,b=1,c=1,d=0;
	       for(int i=3; i<=n; i++){
	         d=a+b+c;a=b;b=c;c=d; 
	       } 
	       return d;
	}
	
	public int SortingArray(int[] nums, int k)
	{
		for(int x = 1; x < nums.length; x++)
		{
			while(x > 0 && nums[x -1] < nums[x])
			{
				int temp = nums[x -1];
				nums[x -1] = nums[x];
				nums[x] = temp;
				x--;
			}
		}
		//System.out.println(Arrays.toString(nums));
		return 0;
	}
	
	//System.out.println("true");
	public static void main(String[] args) {
		Practice2 obj1 = new Practice2();
	}

}
