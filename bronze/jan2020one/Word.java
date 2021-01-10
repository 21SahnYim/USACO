package bronze.jan2020one;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.StringTokenizer;


public class Word {
    
//public Word() {

//}
    public static void main(String[] args) throws IOException {
        Word word = new Word();
        word.input();
        word.process();
            
    }
String[] words;
int K;
	public void input() throws IOException {

        BufferedReader f = new BufferedReader(new FileReader("word.in"));
        
    String line = f.readLine();
    StringTokenizer st = new StringTokenizer(line);
    int N = Integer.parseInt(st.nextToken());
K = Integer.parseInt(st.nextToken());
        
    line = f.readLine();
    st = new StringTokenizer(line);
    words = new String[N];

    for(int i=0; i<N; i++) {
        words[i] = st.nextToken();    

    }
    }
    
    public void process() {
        int position = 0;

        for(String token:words) {
            if ((position + token.length())<=K) {
            if(position>0) {
                System.out.print(" ");
            }
            System.out.print(token);
            position += token.length();
            }
            else {
                System.out.print("\n" + token);
                position = token.length();

            }
    }
    }
}
