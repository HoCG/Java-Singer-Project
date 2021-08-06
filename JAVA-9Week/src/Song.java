import java.util.Scanner;

public class Song {
	int id;
	String singer;
	String title;
	int year;

	void read(Scanner scan) {
		id = scan.nextInt();
		singer = scan.next();
		title = scan.next();
		year = scan.nextInt();
	}

	void print() {
		System.out.printf("[%3d] %s %s (%d³â)\n", id, singer, title, year);
	}


	boolean matches(String kwd) {
		if (kwd.equals(id + ""))
			return true;
		if (singer.equals(kwd))
			return true;
		if (title.equals(kwd))
			return true;
		return false;
	}
}
