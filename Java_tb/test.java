import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Main{

	static int Y = 0;
	static int X = 0;
	static char[][] map;
	static int[] movy = { 0, 0, 1, -1 };
	static int[] movx = { 1, -1, 0, 0 };

	static int jY = 0, jX = 0, fY = 0, fX = 0;
	static Queue fireMov = new LinkedList<>();
	// static boolean[][] visitFire;
	static Queue JihoonMov = new LinkedList<>();
	static boolean[][] visitJihoon;
	static int answerCount = 1;
	static boolean answerCheck;

	public static void main(String[] args) throws Exception, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String input;

		st = new StringTokenizer(br.readLine());
		Y = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		map = new char[Y][X];
		visitJihoon = new boolean[Y][X];

		for (int i = 0; i < Y; i++) {
			input = br.readLine();

			for (int j = 0; j < X; j++) {
				map[i][j] = input.charAt(j);
				if (map[i][j] == 'J') {
					jY = i;
					jX = j;
				} else if (map[i][j] == 'F') {
					fY = i;
					fX = j;
					fireMov.add(new int[] { fY, fX });
				}
			}
		}

		if (jY == Y - 1 || jX == X - 1 || jY == 0 || jX == 0) {
			answerCheck = true;
			System.out.println(answerCount);
			return;
		} else {
			JihoonMov.add(new int[] { jY, jX });
			visitJihoon[jY][jX] = true;
		}

		while (true) {
			nextFireTrack();
			MoveJihoon();
			if (answerCheck) {
				System.out.println(answerCount);
				break;
			} else {
				if (JihoonMov.isEmpty()) {
					System.out.println("IMPOSSIBLE");
					break;
				}
			}

		}

	}

	// Move Jihoon
	static void MoveJihoon() {
		answerCount++;
		int len = JihoonMov.size();

		for (int i = 0; i < len; i++) {
			int[] temp = (int[])JihoonMov.poll();

			for (int j = 0; j < 4; j++) {
				int ny = temp[0] + movy[j];
				int nx = temp[1] + movx[j];

				if (!check(ny, nx) || visitJihoon[ny][nx] == true || map[ny][nx] == '#' || map[ny][nx] == 'F')
					continue;

				if (ny == Y - 1 || nx == X - 1 || ny == 0 || nx == 0) {
					answerCheck = true;
					return;
				}

				visitJihoon[ny][nx] = true;
				JihoonMov.add(new int[] { ny, nx });
			}
		}
	}

	// Fire Track
	static void nextFireTrack() {
		int len = fireMov.size();

		for (int i = 0; i < len; i++) {
			int[] temp = (int[])fireMov.poll();

			for (int j = 0; j < 4; j++) {
				int ny = temp[0] + movy[j];
				int nx = temp[1] + movx[j];

				if (!check(ny, nx) || map[ny][nx] == '#' || map[ny][nx] == 'F')
					continue;

				map[ny][nx] = 'F';
				fireMov.add(new int[] { ny, nx });
			}
		}
	}

	// Out of Bount check
	static boolean check(int y, int x) {
		if (y >= Y || y < 0 || x >= X || x < 0) {
			return false;
		}
		return true;
	}

}