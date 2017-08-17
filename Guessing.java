

import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("WelcomeTo猜字符游戏祝你玩得愉快！请输入5个字符");
		char[]chs=generate();
		//System.out.println(chs);
		int count=0;
		while(true){
			System.out.println("开始猜吧！");
			String str = scan.next().toUpperCase();
			if(str.equals("EXIT")){
				System.out.println("慢走了您！");
				break;	
			}
			//System.out.print("开始猜吧！");
			char[] input =str.toCharArray();
			int result[]=check(chs,input);
			if(result[1]==chs.length){
				int score =100*chs.length-10*count;
				System.out.print("恭喜你猜对了！得分:"+score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame> 答对字符数为:"+result[0]+",字符位置对的个数为:"+result[1]+"总次数:"+count+"输入EXIT退出");
			}
		}
	}
	public static char[] generate(){//生成一个随机字符数组 5个字符
		char[]chs=new char[5];
		char[] letters={'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		int index;
		boolean flags[]=new boolean[letters.length];
		for(int i=0;i<chs.length;i++){
			do{
				index=(int)(Math.random()*letters.length);

			}while(flags[index]==true);
			chs[i]=letters[index];
			flags[index]=true;
		}
		return chs;
	}
	public static int[] check(char[]chs,char[]input){
		int result[]=new int [2];
		for(int i=0;i<chs.length;i++){
			for(int j=0;j<input.length;j++){
				if(chs[i]==input[j]){
					result[0]++;
					if(i==j){
						result[1]++;
					}

				}

			}

		}
		return result; 	
	}
}
