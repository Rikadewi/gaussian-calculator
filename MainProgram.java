import java.util.*;

public class MainProgram
{
	public static void main(String[] args) 
	{
	/*Atribut*/
	boolean exit, backutama;
	int menu,metode;


	/*ALgoritma*/
	exit = false;
	while(!exit)
		{	
			backutama = false;
			while(!backutama)
			{
				System.out.println("===================================================");
				System.out.println("Tugas Besar Aljabar Geometri SPL dan Aplikasinya");	
				System.out.println("Credit : Kelompok 'Ga Luka'");	
				System.out.println("	Lukas Kurnia Jonathan / 13517006 (K-03)");	
				System.out.println("	Gardahadi / 13517144 (K-03)");	
				System.out.println("	Rika Dewi / 13517147 (K-03)");	
				System.out.println("===================================================");
				System.out.println();

			
				System.out.println("Silakan pilih menu yang diinginkan: ");
				System.out.println("1. Sistem Persamaan Linear ");
				System.out.println("2. Interpolasi Polinom ");
				System.out.println("3. Keluar program");
				System.out.println();
				

				
					do
					{
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih menu: ");
						menu = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((menu != 1) && (menu != 2) && (menu != 3))
						{
							System.out.println("Menu salah, silakan coba lagi !");
						}
					}
					while((menu != 1) && (menu != 2) && (menu != 3));

				if(menu == 3) //command untuk keluar dari program
				{
					backutama=true;
					exit = true;

				}

				else if(menu == 1)//user memilih menu Sistem Persamaan Linear
				{
					System.out.println("Anda telah memilih menu Sistem Persamaan Linear, silakan pilih metode yang diinginkan: ");
					System.out.println("1. Metode eliminasi Gauss ");
					System.out.println("2. Metode eliminasi Gauss Jordan ");
					System.out.println("3. Back ke menu utama");
					System.out.println();


					do
					{
						//Scanner in = new Scanner(System.in); 
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih metode: ");
						metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((metode != 1) && (metode != 2) && (metode != 3))
						{
							System.out.println("Metode salah, silakan coba lagi !");
						}
					}
					while((metode != 1) && (metode != 2) && (metode != 3));

					if(metode == 3) //command untuk back ke program utama
					{
						backutama=true;
					}
					else if(metode== 1)
					{
						System.out.println("Anda telah memilih Eliminasi Gauss, silakan pilih metode yang diinginkan: ");
						System.out.println("1. Masukkan input dari keyboard ");
						System.out.println("2. Masukkan input dari file eksternal ");
						System.out.println("3. Back ke menu utama");
						System.out.println();


						do
						{
							//Scanner in = new Scanner(System.in); 
							Scanner in = new Scanner(System.in); 
							System.out.print("Pilih metode: ");
							metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
							if((metode != 1) && (metode != 2) && (metode != 3))
							{
								System.out.println("Metode salah, silakan coba lagi !");
							}
						}
						while((metode != 1) && (metode != 2) && (metode != 3));

						if(metode == 3) //command untuk back ke program utama
						{
							backutama=true;
						}
							
						/*else if(metode== 1)
						{
							langsung dari keyboard (gunakan class buatan rika)
							Tunggu Garda, Gauss
						}
						*/
						/*else if(metode== 2)
						{
							file eksternal (gunakan class buatan rika)
							Tunggu Garda, Gauss Jorsn
						}
						*/
					}
					
					else if(metode== 2)
					{
						System.out.println("Anda telah memilih Eliminasi Gauss Jordan, silakan pilih metode yang diinginkan: ");
						System.out.println("1. Masukkan input dari keyboard ");
						System.out.println("2. Masukkan input dari file eksternal ");
						System.out.println("3. Back ke menu utama");
						System.out.println();


						do
						{
							//Scanner in = new Scanner(System.in); 
							Scanner in = new Scanner(System.in); 
							System.out.print("Pilih metode: ");
							metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
							if((metode != 1) && (metode != 2) && (metode != 3))
							{
								System.out.println("Metode salah, silakan coba lagi !");
							}
						}
						while((metode != 1) && (metode != 2) && (metode != 3));

						if(metode == 3) //command untuk back ke program utama
						{
							backutama=true;
						}
							
						/*else if(metode== 1)
						{
							langsung dari keyboard (gunakan class buatan rika)
							Tunggu Garda, Gauss
						}
						*/
						/*else if(metode== 2)
						{
							file eksternal (gunakan class buatan rika)
							Tunggu Garda, Gauss Jorsn
						}
						*/
					}
					
				}

				else if(menu == 2)//user memilih menu Interpolasi Polinom, menggunakan Gauss atau Gauss Jordan
				{
					System.out.println("Anda telah memilih menu Interpolasi Polinom, silakan pilih metode yang diinginkan: ");
					System.out.println("1. Masukkan input dari keyboard ");
					System.out.println("2. Masukkan input dari file eksternal ");
					System.out.println("3. Back ke menu utama");
					System.out.println();


					do
					{
						//Scanner in = new Scanner(System.in); 
						Scanner in = new Scanner(System.in); 
						System.out.print("Pilih metode: ");
						metode = in.nextInt(); //Memasukkan input integer 1 sampai 3 berupa menu
						if((metode != 1) && (metode != 2) && (metode != 3))
						{
							System.out.println("Metode salah, silakan coba lagi !");
						}
					}
					while((metode != 1) && (metode != 2) && (metode != 3));

					if(metode == 3) //command untuk back ke program utama
					{
						backutama=true;
					}
					/*else if(metode== 1)
					{
						langsung dari keyboard (gunakan class buatan rika)
						Tunggu Garda, Gauss
					}
					*/
					/*else if(metode== 2)
					{
						file eksternal (gunakan class buatan rika)
						Tunggu Garda, Gauss Jorsn
					}
					*/
				}
			}	
		}

	}

}