// package bronze.jan2021;

// Copyright 2021 Sahngwie Yim

import java.io.BufferedReader;
import java.io.IOException;

public class Cowphabet {

  String cowphabet;
  String john;

  public static void main(String[] args) throws IOException {
    Cowphabet cowphabet = new Cowphabet();
    cowphabet.input();
    cowphabet.process();
  }

  public void input() throws IOException {
    BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
    // BufferedReader br = new BufferedReader(new FileReader(cowphabet.in));

    cowphabet = br.readLine();
    john = br.readLine();
  }

  int num_of_cowphabets = 0;

  public void process() {
    int johnPointer = 0;

    // for(johnPointer=0; johnPointer<john.length(); johnPointer++) {
    for (int pointer = 0; pointer < john.length(); pointer++) {
      num_of_cowphabets++;
      for (int i = 0; i < cowphabet.length(); i++) {
        if (john.charAt(johnPointer) == cowphabet.charAt(i)) {
          johnPointer++;
        }
        if (johnPointer == john.length()) {
          // print pointer
          System.out.println(num_of_cowphabets);
          return;
        }
      }
    }
  }
}
