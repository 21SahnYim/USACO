package bronze.dec2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Gymnastics2 {

  int K;
  int N;
  int rounds_and_cows[][];

  public static void main(String[] args) throws IOException {
    Gymnastics2 gymnastics = new Gymnastics2();
    gymnastics.input();
    gymnastics.process();
  }

  public void input() throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    rounds_and_cows = new int[K][N];

    String line;
    for (int i = 0; i < K; i++) {
        line = f.readLine();
        st = new StringTokenizer(line);
      for (int j = 0; j < N; j++) {
        rounds_and_cows[i][j] = Integer.parseInt(st.nextToken());
      }
    }
  }

  public void process() throws IOException {
    int pairs = 0;

    int cow1, cow2;

    for (int i = 1; i < N; i++) {
      for (int j = i + 1; j < N + 1; j++) {
        cow1 = i;
        cow2 = j;
        if(is_consistent(cow1, cow2)) {
            pairs += 1;
        }
      }
    }

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
    out.printf("%d", pairs);
    out.close();
  }

  public int getRanking(int round, int cow_number) {
    for (int i = 0; i < N; i++) {
      if (rounds_and_cows[round][i] == cow_number) { // print index
        return i;
      }
    }
    return 0;
  }

  public boolean is_consistent(int cow1, int cow2) {
    int pairs = 0;
    for (int i = 0; i < K; i++) {
      if (getRanking(i, cow1) > getRanking(i, cow2)) {
        pairs += 1;
      } else {
        pairs -= 1;
      }
    }
    if (pairs == K || pairs == -1 * K) {
      return true;
    }

    return false;
  }
}
