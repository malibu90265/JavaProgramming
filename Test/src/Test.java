import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Test {
	public static void main(String[] args) throws IOException { //����ó�� �� ���ֱ�! �ƴϸ� try catch finally ������!
		
		BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\JEONGHYUN\\Desktop\\input.txt")); //��� \�� 2����.
		ArrayList<String> s = new ArrayList<String>();
		String str = null;
		while((str = reader.readLine()) != null){
			System.out.println(str);
			s.add(str);
		}
		reader.close();	// ���� ����� ������ �ݵ�� close���ٰ�!
		
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\JEONGHYUN\\Desktop\\output.txt"));
		for(String st : s){
			writer.write(st);
			writer.newLine();	//"\n"����
		}
		writer.close();
		
		
		
	}
}
