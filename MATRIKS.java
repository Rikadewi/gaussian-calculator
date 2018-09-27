import java.io.*;
import java.util.*;

public class MATRIKS {
	//Atribut
	double[][] Tab = new double[100][100];
	int NBrsEff;
	int NKolEff;

	//Method

	//KONSTRUKTOR

	MATRIKS(){
		//menghasilkan matriks kosong

		this.NBrsEff = 0;
		this.NKolEff = 0;
	}

	public void BacaFileEksternal (String FileEksternal) {
		//membaca file eksternal yang bernama FileEksternal

		try {
			File file = new File (FileEksternal);
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
				

				int row = 0; //inisialisasi baris awal
				int col = 0; //inisialisasi kolom awal

				while (sc.hasNextDouble()){
				    this.Tab[row][col] = sc.nextDouble();
				    col++;
				    if (col == c){
				    	col = 0;
				    	row++;
				    }
				} 

				this.NKolEff = c;
				this.NBrsEff = row;

			}else{
				System.out.println("File Kosong");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
