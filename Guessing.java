

import java.util.Scanner;

public class Guessing {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("WelcomeTo���ַ���Ϸף�������죡������5���ַ�");
		char[]chs=generate();
		//System.out.println(chs);
		int count=0;
		while(true){
			System.out.println("��ʼ�°ɣ�");
			String str = scan.next().toUpperCase();
			if(str.equals("EXIT")){
				System.out.println("����������");
				break;	
			}
			//System.out.print("��ʼ�°ɣ�");
			char[] input =str.toCharArray();
			int result[]=check(chs,input);
			if(result[1]==chs.length){
				int score =100*chs.length-10*count;
				System.out.print("��ϲ��¶��ˣ��÷�:"+score);
				break;
			}else{
				count++;
				System.out.println("GuessingGame> ����ַ���Ϊ:"+result[0]+",�ַ�λ�öԵĸ���Ϊ:"+result[1]+"�ܴ���:"+count+"����EXIT�˳�");
			}
		}
	}
	public static char[] generate(){//����һ������ַ����� 5���ַ�
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
