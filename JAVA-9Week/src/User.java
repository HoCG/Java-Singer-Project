import java.util.ArrayList;
import java.util.Scanner;

public class User {
	String id, name, mf;
	int age;
	static Main main;
	ArrayList<Song> select = new ArrayList<>();

	void count(int count[]) {
		for (Song s : select)
			count[main.songList.indexOf(s)]++;
	}

	void read(Scanner scan) {
		id = scan.next();
		name = scan.next();
		age = scan.nextInt();
		mf = scan.next();
		int c = scan.nextInt();
		while (c != 0) {
			select.add(main.findSong(c));
			c = scan.nextInt();
		}
	}

	void print() {
		System.out.printf("%s %s %d¼¼, (%s)\n\t", id, name, age, mf);
		for (Song s : select) {
			System.out.printf("%s", s.title);
		}
		System.out.println();
	}

	boolean matches(String kwd) {
		if (id.equals(kwd) || name.equals(kwd) || mf.equals(kwd))
			return true;
		return false;

	}

}
