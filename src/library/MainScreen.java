package library;

import java.util.Scanner;

public class MainScreen {

	MovieManager movieManager = new MovieManager();
	UserManager userManager = new UserManager();

	static Scanner scanner = new Scanner(System.in);

	public void printScreen1() {
		System.out.println("1- Kullanıcı Girişi\n" + "2- Hesap Oluşturma\n" + "3- Hesap Silme\n" + "4- Kullanıcı ara\n"
				+ "5- Tüm kullanıcıları görüntüle\n" + "6- Çıkış (-1'e basın)");
	}

	public void printScreen2() {

		int choise1 = 0;

		do {
			System.out.println();
			System.out.println("**********************************\n");
			System.out.println("1- Film ekleme\n" + "2- Film Silme\n" + "3- Film arama\n" + "4- Filmleri listele\n"
					+ "5- Kullanıcı çıkışı\n");
			System.out.print("Seçiminizi giriniz: ");
			choise1 = scanner.nextInt();
			switch (choise1) {
			case 1 -> {
				scanner.nextLine();
				System.out.print("Filmin adınızı giriniz: ");
				String movieName = scanner.nextLine();
				movieManager.addMovie(new Movie(movieName, " ", new String[] { " " }, " ", " ", " "));
			}
			case 2 -> {
				scanner.nextLine();
				System.out.print("Filmin adını giriniz: ");
				String movieName = scanner.nextLine();
				movieManager.deleteMovie(new Movie(movieName, " ", new String[] {}, " ", " ", " "));
			}
			case 3 -> {
				scanner.nextLine();
				System.out.print("Filmin adını giriniz: ");
				String movieName = scanner.nextLine();
				movieManager.searchMovie(movieName);
			}
			case 4 -> {
				movieManager.listMovies();
			}
			case 5 -> {
				System.out.println("Kullanıcıdan çıkış yapılıyor");
				choise1 = -1;
			}
			}
		} while (choise1 > -1);
	}

	public void printScreen() {

		int choise = 0;
		do {

			System.out.println("******** FILM KUTUPHANESI ********");
			printScreen1();
			System.out.print("Seçiminizi giriniz: ");
			choise = scanner.nextInt();

			switch (choise) {
			case 1 -> {
				scanner.nextLine();
				System.out.print("Kullanıcı adı: ");
				String userName = scanner.nextLine();
				System.out.print("Kullanıcı şifresi: ");
				String password = scanner.nextLine();
				
				Boolean result = userManager.loginAccount(new User(userName, password, ""));
				if (result) {
					printScreen2();
				}
			}
			case 2 -> {
				scanner.nextLine();
				System.out.print("Kullanıcı adı: ");
				String userName = scanner.nextLine();
				System.out.print("Kullanıcı şifresi: ");
				String password = scanner.nextLine();
				System.out.print("Email : ");
				String email = scanner.nextLine();
				userManager.createAccount(new User(userName, password, email));

			}
			case 3 -> {
				scanner.nextLine();
				System.out.print("Kullanıcı adı: ");
				String userName = scanner.nextLine();
				System.out.print("Kullanıcı şifresi: ");
				String password = scanner.nextLine();
				System.out.print("Email : ");
				String email = scanner.nextLine();
				User user1 = new User(userName, password, email);
				userManager.deleteAccount(user1);
			}
			case 4 -> {
				scanner.nextLine();
				System.out.print("Kullanıcı adı: ");
				String userName = scanner.nextLine();
				userManager.searchUser(userName);
			}
			case 5 -> {
				userManager.listUsers();
				
			}
			case -1 -> {
				System.out.println("Çıkış yapılıyor....");
				break;
			}
			}
		} while (choise > -1);
	}
}
