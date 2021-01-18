/*
ID: sahngwi1
LANG: JAVA
TASK: wormhole
 */

// Copyright 2021 Sahngwie Yim

package wormhole;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class wormhole {

	final int MAX_N = 12;
	int[] partner = new int[MAX_N+1];
	int[] next_on_right = new int[MAX_N+1];
	int N;
	int[] X = new int[MAX_N+1];
	int[] Y = new int[MAX_N+1];

	boolean debug = true;

	public boolean cycle_exists() {
		for (int start=1; start<=N; start++) {
			// does there exist a cycle starting from start
			int pos = start;
			for (int count=0; count<N; count++)
				pos = next_on_right[partner[pos]];
			if (pos != 0) return true;
		}
		return false;
	}

	// count all solutions
	public int solve() {
		// find first unpaired wormhole
		int i, total=0;
		for (i=1; i<=N; i++) 
			if (partner[i] == 0) break;

		// everyone paired?
		if (i > N) {
			if (cycle_exists()) return 1;
			else return 0;
		}

		// try pairing i with all possible other wormholes j
		for (int j=i+1; j<=N; j++)
			if (partner[j] == 0) {
				// try pairing i & j, let recursion continue to 
				// generate the rest of the solution
				partner[i] = j;
				partner[j] = i;
				total += solve();
				partner[i] = partner[j] = 0;
			}
		return total;
	}

	public void input() throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("wormhole.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());

		if(debug) System.out.println(String.format("N == [%d]", N));

		for(int i = 1; i<=N; i++) {
			String line = f.readLine();
			st = new StringTokenizer(line);
			X[i] = Integer.parseInt(st.nextToken());
			Y[i] = Integer.parseInt(st.nextToken());
			if(debug) System.out.println(String.format("coordinate[%d] == %d, %d", i, X[i], Y[i]));
		}	
	}

	public void preprocess() {
		
		for (int i=1; i<=N; i++) { // set next_on_right[i]...
			for (int j=1; j<=N; j++) {
				if (X[j] > X[i] && Y[i] == Y[j]) {  // j right of i...
					if (next_on_right[i] == 0 ||
							X[j]-X[i] < X[next_on_right[i]]-X[i]) {
						next_on_right[i] = j;
					}
				}
			}
		}
		
		for(int i=1; i<N; i++) {
			if(debug) System.out.println(String.format("next_on_right[%d] == %d", i, next_on_right[i]));

		}
	}

	public void output(int count) throws IOException {		
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("wormhole.out")));

		out.println(String.format("%d", count));
		out.close();
		System.out.println("done");
	}

	public static void main(String[] args) throws Exception {
		wormhole wh = new wormhole();
		wh.input();
		wh.preprocess();
		
		wh.output(wh.solve());
	}

}
