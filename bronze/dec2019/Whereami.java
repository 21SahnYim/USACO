package bronze.dec2019;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Whereami {

  int N;
  String mailboxes;

  int K; // K is the answer

  public static void main(String[] args) throws IOException {
    Whereami whereami = new Whereami();
    whereami.input();
    whereami.process();
  }

  public void input() throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    N = Integer.parseInt(st.nextToken());

    mailboxes = f.readLine();
    // System.out.print(mailboxes);

  }

  public void process() throws IOException {

    for (int i = 1; i < N + 1; i++) {
      if (thing(i)) {
        K = i;
        break;
      }
    }

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
    out.printf("%d", K);
    out.close();
  }

  Set<String> sequencetocompare = new HashSet<String>(); // Set == interface, HashSet == class

  public boolean thing(int trialK) {
    sequencetocompare.clear();
    for (int i=0; i+trialK <= N; i++) {
      String pattern = mailboxes.substring(i, i + trialK);
      if (sequencetocompare.contains(pattern)) {
        return false;
      } else {
        sequencetocompare.add(pattern);
        continue;
      }
    }

    return true;
  }
}