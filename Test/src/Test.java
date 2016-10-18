import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws IOException { //예외처리 꼭 해주기! 아니면 try catch finally 문으로!
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //경로 \가 2개임.
		ArrayList<String> s = new ArrayList<String>();
		String str = null;
		while((str = reader.readLine()) != null){
			System.out.println(str);
			s.add(str);
		}
		reader.close();	// 파일 입출력 끝나고 반드시 close해줄것!
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\JEONGHYUN\\Desktop\\output.txt"));
		for(String st : s){
			writer.write(st);
			writer.newLine();	//"\n"역할
		}
		writer.close();
		
		
		
	}
}
