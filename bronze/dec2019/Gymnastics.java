// Copyright 2021 Sahngwie Yim
package bronze.dec2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Gymnastics {

  public static void main(String[] args) throws IOException {
    Gymnastics gymnastics = new Gymnastics();
    gymnastics.input();
    gymnastics.process();
  }

  int K;
  int N;
  int[][] ranking;

  public void input() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("gymnastics.in"));

    String line = f.readLine();
    StringTokenizer st = new StringTokenizer(line);
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    ranking = new int[K][];
    for (int i = 0; i < K; i++) {
      line = f.readLine();
      st = new StringTokenizer(line);
      ranking[i] = new int[N];
      for (int j = 0; j < N; j++) {
        ranking[i][j] = Integer.parseInt(st.nextToken());
      }
    }
    f.close();
  }

  public void process() throws IOException {
    int pairs = 0;

    for (int i = 1; i < N; i++) { // pick first cow
      for (int j = i + 1; j < N + 1; j++) { // pick second cow
        if (is_consistent_performance(i, j)) {
          pairs += 1;
        }
      }
    }

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
    out.printf("%d", pairs);
    out.close();
  }

  public boolean is_consistent_performance(int cow1, int cow2) {
    int score = 0;
    for (int round = 0; round < K; round++) {
      if (getRank(round, cow1) < getRank(round, cow2)) {
        score += 1;
      } else {
        score -= 1;
      }
    }
    if (score == K || score == -1 * K) {
      return true;
    }
    return false;
  }

  public int getRank(int round, int cow_number) {
    for (int i = 0; i < N; i++) {
      if (ranking[round][i] == cow_number) {
        return i;
      }
    }
    return 0;
  }
}
