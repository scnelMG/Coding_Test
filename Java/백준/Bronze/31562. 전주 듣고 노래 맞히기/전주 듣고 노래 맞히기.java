import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
//import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		BufferedReader br = new BufferedReader(new FileReader("input (4).txt")) ;
		
		String line = br.readLine();
		StringTokenizer st= new StringTokenizer(line);
		int N= Integer.parseInt(st.nextToken());
		int M= Integer.parseInt(st.nextToken());
		
		Map<String, char[]> map = new HashMap<>();
		String[] mapkey = new String[N];
		
		for (int i = 0; i < N; i++) {
			line = br.readLine();
			st=new StringTokenizer(line);
			int n= Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			mapkey[i]=str;
			char[] melody =new char[3];
			for (int j = 0; j < 3; j++) {
				melody[j]=st.nextToken().charAt(0);
			}
			map.put(str, melody);
		}
		
		for (int i = 0; i < M; i++) {
			int count =0;
			String printString="";
			line = br.readLine();
			st=new StringTokenizer(line);	
			char[] check = new char[3];
			for (int j = 0; j < 3; j++) {
				check[j]= st.nextToken().charAt(0);
			}
			
			for (int j = 0; j < N; j++) {
				Boolean isEqual =true;
				char[] match =map.get(mapkey[j]);
				for (int k = 0; k < 3; k++) {
					if (check[k]!=match[k]) {
						isEqual=false;
					}
				}
				if (isEqual) {
					count++;
					printString=mapkey[j];
				}
				
			}
			if (count>1) {
				System.out.println("?");
			}else if (count==1) {
				System.out.println(printString);
			}else {
				System.out.println("!");
			}
		}

		
	}

}