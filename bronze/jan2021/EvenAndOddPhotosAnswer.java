package bronze.jan2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class EvenAndOddPhotosAnswer {

  public static void main(String[] args) throws IOException {
    EvenAndOddPhotosAnswer evenAndOddPhotos = new EvenAndOddPhotosAnswer();
    evenAndOddPhotos.input();
    int result = evenAndOddPhotos.process();
    System.out.println(result);
  }

  int N; // int O=0, E=0, N, x;
  int E = 0;
  int O = 0;

  int x;

  public void input() throws IOException {
    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

    StringTokenizer st = new StringTokenizer(br.readLine());
    N = Integer.parseInt(st.nextToken()); // cin >> N;

    String line = br.readLine();
    st = new StringTokenizer(line);

    // for (int i=0; i<N; i++) {
    // cin >> x;
    // if (x % 2 == 0) E++; else O++;
    // }

    for (int i = 0; i < N; i++) {
      x = Integer.parseInt(st.nextToken());
      if (x % 2 == 0) E++;
      else O++;
    }
  }

  public int process() {
    // while (O > E) { O=O-2; E++; }
    // if (E > O+1) E = O+1;
    // cout << E + O << "\n";
    while (O > E) {
      O = O - 2;
      E++;
    }
    if (E > O + 1) E = O + 1;

    return E + O;
  }

}
