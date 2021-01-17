// Copyright 2021 Sahngwie Yim
package bronze.jan2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Race {

  public static void main(String[] args) throws IOException {
    Race race = new Race();
    race.input();
    race.process();
  }

  int[] Xs;
  int K;
  int N;

  public void input() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("race.in"));

    String line = f.readLine();
    StringTokenizer st = new StringTokenizer(line);
    K = Integer.parseInt(st.nextToken());
    N = Integer.parseInt(st.nextToken());

    Xs = new int[N];

    for (int i = 0; i < N; i++) {
      line = f.readLine();
      st = new StringTokenizer(line);
      Xs[i] = Integer.parseInt(st.nextToken());
    }
  }

  public void process() throws IOException {

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("race.out")));

    for (int j = 0; j < N; j++) {
      int distance = 0;
      int current_speed = 0;
      int elapsed_time = 0;
      int final_speed = Xs[j];
      int downhill_distance = 0;
      int downhill_time = 0;

      for (elapsed_time = 1; ; elapsed_time++) {
        current_speed += 1;
        // if (distance >= K - Xs[j] && current_speed > 0) {

        distance += current_speed;

        if (distance + downhill_distance >= K) {
          out.printf("%d\n", elapsed_time + downhill_time);
          break;
        }


        if (current_speed >= Xs[j]) {
          // current_speed -= 1;
          downhill_distance += current_speed;
          downhill_time++;
        }

        if (distance + downhill_distance >= K) {
          out.printf("%d\n", elapsed_time + downhill_time);
          break;
        }

        // System.out.println(current_speed + " " + distance);
        // if (distance >= K && current_speed <= final_speed) {

      }
      // out.printf("%d\n", elapsed_time);
    }

    out.close();
  }
}