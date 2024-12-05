import org.w3c.dom.ls.LSOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Saboon {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int x = 0;
    int y = 0;

    public int qudrantN(int n, int m)throws IOException {
        int answer = 0;

        int x = Integer.parseInt(br.readLine());
        int y = Integer.parseInt(br.readLine());

        if(x>0 && y>0){ // 1분면
            answer = 1;
        } else if (x<0 && y>0) {
            answer = 2; // 2분면
        } else if (x<0 && y<0) {
            answer = 3; // 3분면
        } else if (x>0 && y<0) {
            answer = 4; //4분면
        }

        return answer;
    }
}
