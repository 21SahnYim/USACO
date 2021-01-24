// Copyright 2021 Sahngwie Yim
package bronze.dec2019;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Whereami2_differentinput {

  int N;
  String mailboxes;

  int K; // K is the answer

  public static void main(String[] args) throws IOException {
    Whereami2_differentinput whereami2_differentinput = new Whereami2_differentinput();
    whereami2_differentinput.input();
    whereami2_differentinput.process();
  }

  public void input() throws IOException {
    BufferedReader f = new BufferedReader(new java.io.InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(f.readLine());
    N = Integer.parseInt(st.nextToken());

    mailboxes = f.readLine();
    f.close();
    // System.out.println(N + "");
  }

  String sequencetocompare;
  Set<String> sequence = new HashSet<String>();

  public void process() throws IOException {

    int trialK = 0; // the number of elements in the sequence to compare

    for (trialK = 1; trialK <= N; trialK++) {
      if (inner_for(trialK)) {
        System.out.println(trialK);
        break;
      }
    }
  }

  // System.out.printf("%d", K);

  public boolean is_sequence_unique() {
    if (sequence.contains(sequencetocompare)) {
      return false;
    } else {
      sequence.add(sequencetocompare);
      return true;
    }
  }

  public boolean inner_for(int trialK) {
    int i = 0;
    for (i = 0; i + trialK <= N; i++) {
      //  System.out.println(i + " " + trialK);
      sequencetocompare = mailboxes.substring(i, i + trialK);
      // A B C D A B C
      // 1 2 3 4 5 6 7
      // 0 1 2 3 4 5 6
      // i=6 (x)
      // trialK = 3 (CCB)
      // N = 9
      if (is_sequence_unique()) {
        continue;
        // K = sequencetocompare.length();
      } else {
        return false;
      }
    }
    return true;
  }
}
