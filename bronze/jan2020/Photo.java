// Copyright 2021 Sahngwie Yim
package bronze.jan2020;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Photo {

  int N;

  public static void main(String[] args) throws IOException {
    Photo photo = new Photo();
    photo.input();
    photo.process();
  }

  int[] a;
  int[] b;

  public void input() throws IOException {

    BufferedReader f = new BufferedReader(new FileReader("photo.in"));

    String line = f.readLine();
    StringTokenizer st = new StringTokenizer(line);
    N = Integer.parseInt(st.nextToken());

    line = f.readLine();
    st = new StringTokenizer(line);
    b = new int[N - 1];
    a = new int[N];

    for (int i = 0; i < N - 1; i++) {
      b[i] = Integer.parseInt(st.nextToken());
    }
  }

  public void process() throws IOException {
    // b[i] = a[i] + a[i+1];

    for (int i = 1; i < b[0]; i++) {
      a[0] = i;

      for (int j = 1; j < N; j++) {
        a[j] = b[j - 1] - a[j - 1];
      }

      int[] count = new int[N + 1];
      boolean valid = true;
      for (int k = 0; k < N; k++) {
        if (a[k] < 1 || a[k] > N) {
          valid = false;
          break;
        }
        count[a[k]] += 1;
        if (count[a[k]] > 1) {
          valid = false;
          break;
        }
      }
      if (valid) {
        output();
        return;
      }
    }
  }

  public void output() throws IOException {

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("photo.out")));

    for (int i = 0; i < N; i++) {
      out.print(a[i] + " ");
    }
    out.print("\n");
    out.close();
  }
}
