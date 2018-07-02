package demo.demo;

import java.io.IOException;
import java.io.FileWriter;
public class Throw {
	public void viDuThrow() throws IOException{
		FileWriter fileWriter = new FileWriter("data.txt");
		fileWriter.write("XIn chao Cong");
		fileWriter.close();
	}
	public void callViDuThrow() {
		try {
			viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void callViDuThrow2() throws IOException {
			viDuThrow();
		
	}
	public static void main(String[] args) throws IOException{
		Throw throww=new Throw();
		throww.callViDuThrow();
		try {
			throww.viDuThrow();
		} catch (IOException e) {
			e.printStackTrace();
		}
		throww.callViDuThrow2();
	}
}
