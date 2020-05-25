/*
ID: sahngwi1
LANG: JAVA
TASK: skidesign
 */

// package skidesign;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class skidesign {

	int N;
	int MAX_N = 1000;
	int[] hills = new int[MAX_N];

	public void input() throws Exception {
		BufferedReader f = new BufferedReader(new FileReader("skidesign.in"));
		StringTokenizer st = new StringTokenizer(f.readLine());
		N = Integer.parseInt(st.nextToken());


		for(int i=0; i<N; i++) {
			String line = f.readLine();
			st = new StringTokenizer(line);
			hills[i] = Integer.parseInt(st.nextToken());
		}
	}

	public int process() {
		// sort();
		return price();	
	}

	/*
	public void sort() {

		int i, j;
		int temp;
		for(i=1; i<hills.length; i++) {
			temp = hills[i];
			for(j=i-1; j>=0; j--) {
				if(hills[j]>temp) hills[j+1] = hills[j]; 
				else break;  
			}
			hills[j+1] = temp;
		}
	}
	 */

	public int price() {
		int min_price = 1000000;
		for(int base_h=0; base_h<100; base_h++) {
			int current_price = 0;
			for(int i=0; i<N; i++) {
				if(hills[i]<base_h) {
					current_price += Math.pow(base_h - hills[i], 2);
				}
				else if(hills[i]-base_h>17) {
					current_price += Math.pow(hills[i]-base_h-17, 2);
				}

			}
			if(current_price<min_price) {
				// System.out.println(String.format("base_i: %d, current_price: %d", base_i, current_price));
				min_price = current_price;
			}

		}
		return min_price;
	}

	public void output(int min_price) throws Exception {
		PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("skidesign.out")));

		out.println(String.format("%d", min_price));
		out.close();
	}

	public static void main(String[] args) throws Exception {
		skidesign sd = new skidesign();
		// String currentDirectory = System.getProperty("user.dir");
		// System.out.println("The current working directory is " + currentDirectory);

		sd.input();
		int min_price = sd.process();
		sd.output(min_price);
	}
}
