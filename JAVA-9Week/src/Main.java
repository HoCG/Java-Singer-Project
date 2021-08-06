import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	ArrayList<Song> songList = new ArrayList<>();
	ArrayList<User> userList = new ArrayList<>();
	Scanner keyin = new Scanner(System.in); // ������ �ʵ�� Ű���� ���ɳ�

	void mymain() {
		readAllSongs();
		printAllSongs();
		search();
		//findPopularSingers();
		User.main = this;
		readAllUsers();
		printAllUsers();
		//searchUser();
		getFavoriteF();
	}

	void getFavoriteF() {
		int count[] = new int[100];
		for (User u : userList)
			if (u.matches("��"))
				u.count(count);
		int maxindex = 0;
		for (int i = 0; i < 100; i++) {
			if (count[i] > count[maxindex])
				maxindex = i;
			if (count[i] > 2)
				System.out.printf("%s %d\n",songList.get(i).title, count[i]);
		}
		System.out.printf("������ ���� ���� ������ ���� %s�Դϴ�.\n", songList.get(maxindex).title);
	}

	void searchUser() {
		System.out.printf("Ű���� �Է�: ");
		String kwd = keyin.next();
		while (kwd != "end") {
			for (User s : userList)
				if (s.matches(kwd))
					s.print();
			kwd = keyin.next();
		}
	}

	void readAllUsers() {
		Scanner filein = openFile("users.txt"); // �������� �ٷιٷ� �����ִ°� �߿��ϴ�!!
		while (filein.hasNext()) {
			User s = new User();
			s.read(filein);
			userList.add(s);
		}
		filein.close();
	}

	Song findSong(int n) {
		return songList.get(n);
	}

	void printAllUsers() {
		for (User s : userList)
			s.print();
	}

	void readAllSongs() {
		Scanner filein = openFile("songs.txt"); // �������� �ٷιٷ� �����ִ°� �߿��ϴ�!!
		while (filein.hasNext()) {
			Song s = new Song();
			s.read(filein);
			songList.add(s);
		}
		filein.close();
	}

	void printAllSongs() {
		for (Song s : songList)
			s.print();
	}

	void search() {
		System.out.printf("Ű���� �Է�: ");
		String kwd = keyin.next();
		while (true) {
			if (kwd.equals("end"))
				break;
			for (Song s : songList)
				if (s.matches(kwd))
					s.print();
			kwd = keyin.next();
		}
	}

	void findPopularSingers() {
		ArrayList<String> popular = new ArrayList<>();
		int count[] = new int[200];
		for (Song s : songList) {
			int indx = popular.indexOf(s.singer);
			if (indx == -1) {
				count[popular.size()] = 1;
				popular.add(s.singer);
			} else
				count[indx]++;
		}
		for (int i = 0; i < popular.size(); i++)
			if (count[i] >= 3) {
				System.out.printf("%d:%dȸ \n", popular.get(i), count[i]);
			}
	}

	Scanner openFile(String filename) {
		File f = new File(filename);
		Scanner s = null;
		try {
			s = new Scanner(f);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(e);
		}
		return s;
	}

	public static void main(String[] args) {
		Main a = new Main();
		a.mymain();
	}

}
