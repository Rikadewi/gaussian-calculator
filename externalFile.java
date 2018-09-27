import java.io.*;
import java.util.*;

public class externalFile {

	public static void main(String[] args) {
		
		try {
			File file = new File ("input.txt");
			Scanner sc = new Scanner(file); 

			if (sc.hasNextLine()){
				String s = sc.nextLine();
				s.trim();
				int c=0;

				for (int i=0; i<s.length();i++){
					if (s.charAt(i)==' '){
						c++; //menghitung jumlah kolom matriks
					}
				}
				c++; //ditambahkan dengan elemen terakhir kolom

				sc = new Scanner(file); 
				
				double[][] matriks = new double [100][c];

				int row = 0; //inisialisasi baris awal
				int col = 0; //inisialisasi kolom awal

				while (sc.hasNextDouble()){
				    matriks[row][col] = sc.nextDouble();
				    col++;
				    if (col == c){
				    	col = 0;
				    	row++;
				    }
				} 

			}else{
				System.out.println("File Kosong");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
