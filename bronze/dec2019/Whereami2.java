// Copyright 2021 Sahngwie Yim
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

public class Whereami2 {

  int N;
  String mailboxes;

  int K; // K is the answer

  public static void main(String[] args) throws IOException {
    Whereami2 whereami2 = new Whereami2();
    whereami2.input();
    whereami2.process();
  }

  public void input() throws IOException {
    BufferedReader f = new BufferedReader(new FileReader("whereami.in"));
    StringTokenizer st = new StringTokenizer(f.readLine());
    N = Integer.parseInt(st.nextToken());

    mailboxes = f.readLine();
    f.close();
  }

  String sequencetocompare;
  Set<String> sequence = new HashSet<String>();

  public void process() throws IOException {

    int trialK = 0; // the number of elements in the sequence to compare
    int pointer = 0; // the location of the first element in the sequence to compare

    for (trialK = 0; pointer + trialK <= N; trialK++) {
      for (pointer = 0; pointer + trialK <= N; pointer++) {

        //  System.out.println(i + " " + trialK);
        sequencetocompare = mailboxes.substring(pointer, pointer + trialK);
        // A B C D A B C
        // 1 2 3 4 5 6 7
        // 0 1 2 3 4 5 6
        // i=6 (x)
        // trialK = 3 (CCB)
        // N = 9
        if (is_sequence_unique()) {
          // K = sequencetocompare.length();
          continue;
        } else {
          break;
        }
      }
      if (is_sequence_unique()) {
        K = sequencetocompare.length();
      }
    }

    PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("whereami.out")));
    out.printf("%d", K);
    out.close();
  }

  public boolean is_sequence_unique() {
    if (sequence.contains(sequencetocompare)) {
      return false;
    } else {
      sequence.add(sequencetocompare);
      return true;
    }
  }
}
