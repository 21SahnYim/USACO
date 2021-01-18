/*
ID: sahngwi1
LANG: JAVA
TASK: ariprog
 */

// Copyright 2021 Sahngwie Yim

// package ariprog;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ariprog {

	int n;
	int M;
	int MM2;
	// HashSet<Integer> bisquare_elements;
	boolean[] bisquare_array;
	// int[] differences;
	int MAX_M = 250;
	List<int[]> abstorage = new ArrayList<>();


	public void input() throws IOException {
		bisquare_array = new boolean[MAX_M*MAX_M*2+1];
		// differences = new int[MAX_M*MAX_M*2];

		for(int i=0; i<bisquare_array.length; i++) {
			bisquare_array[i] = false;
		}

		BufferedReader f = new BufferedReader(new FileReader("ariprog.in"));
		n = Integer.parseInt(f.readLine());
		M = Integer.parseInt(f.readLine());
		MM2 = M*M*2;
	}

	public void process() throws IOException {
		boolean printed = false;
		// bisquare_elements = new HashSet<Integer>();
		int element;
		for(int i=0; i<=M; i++) {
			for(int j=0; j<=M; j++) {
				element = i*i + j*j;
				// bisquare_elements.add(element);
				bisquare_array[element] = true;
			}
		}
		/*
			int previous = -1;
			for(int i=0; i<MM2; i++) {
				if(bisquare_array[i]==true) {
					if(previous!=-1) {
						// differences[previous] = i-previous;
					}
					previous = i;
				} 
			}
		 */
		for(int a=0; a<MM2; a++) {
			if(!bisquare_array[a]) continue;

			// for(int a=0; a<M*M*2; a++) {
			// for(Integer a : bisquare_elements) {
			// for(int b=1; b<M*M*2; b++) {
			// for(int a=0; a<M*M*2; a++) {
			// for(Integer a : bisquare_elements) {
			//label:
			// for(int b=differences[a]; b<=(MM2-a)/(n-1); b++) {
			for(int b=1; b<=(MM2-a)/(n-1); b++) {

				// for(int a=0; a<M*M*2; a++) {
				// if(bisquare_array[a]==false) continue;
				boolean check = true;

				// int y = n-1;
				// if((a+y*b)>=bisquare_array.length) continue;
				for(int z=1; z<n; z++) {
					// if(!bisquare_elements.contains(a+z*b)) {
					// check = false;
					// break;
					// }
					if(!bisquare_array[a+z*b]) {
						check = false;
						break;
						// continue label;
					}
				}
				if(check) {
					abstorage.add(new int[]{a, b});
				}
			}
		}
	}

	public void output() throws IOException {
		try (PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("ariprog.out")))) {
			if(abstorage.isEmpty()) out.println("NONE");
			else {
				Collections.sort(abstorage, new Comparator<int[]>() {
					public int compare(int[] ab1, int[] ab2) {
						if(ab1[1]>ab2[1]) return 1;
						if(ab1[1]<ab2[1]) return -1;
						if(ab1[0]>ab2[0]) return 1;
						if(ab1[0]<ab2[0]) return -1;
						return 0;
					}
				});


				for(int[] ab : abstorage) {
					out.println(String.format("%d %d", ab[0], ab[1]));
					// System.out.println(ab[0] + " " + ab[1]);
				}
			}
		}		

	}

	public static void main(String[] args) throws Exception {
		// long start = System.currentTimeMillis();
		ariprog ap = new ariprog();
		ap.input();
		ap.process();
		ap.output();
		// long finish = System.currentTimeMillis();
		// long timeElapsed = finish - start;
		// System.out.println(timeElapsed/1000.0);
		// System.exit(0);

	}

}
