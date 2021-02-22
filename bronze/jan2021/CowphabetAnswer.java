// package bronze.jan2021;

// Copyright 2021 Sahngwie Yim

import java.io.BufferedReader;
import java.io.IOException;

public class CowphabetAnswer {

  String alphabet;
  String s;

  public static void main(String[] args) throws IOException {
    Cowphabet cowphabet = new Cowphabet();
    cowphabet.input();
    cowphabet.process();
  }

  public void input() throws IOException {
    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

    // std::string alphabet, s;
    // std::cin >> alphabet >> s;

    alphabet = br.readLine();
    s = br.readLine();
  }

  int num_of_cowphabets = 0;

  public void process() {
    // std::string hummed = "";

    String hummed = "";

    /*
        for(int numHums = 1; true; numHums++) {
          hummed += alphabet;
          int idx = 0;
          for(int i = 0; i < hummed.size() && idx < s.size(); i++) {
            if(hummed[i] == s[idx]) {
              idx++;
            }
          }
          if(idx == s.size()) {
            std::cout << numHums << "\n";
            return 0;
          }
        }
    */


    for (int numHums = 1; true; numHums++) { 
      hummed += alphabet;
      int idx = 0;

      for (int i = 0; i < hummed.length() && idx < s.length(); i++) {
        if (hummed.charAt(i) == s.charAt(idx)) {
          idx++;
        }
      }
      if (idx == s.length()) {
        System.out.println(numHums);
        return;
      }
    }
  }
}
