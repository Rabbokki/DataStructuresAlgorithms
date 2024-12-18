package threadTest;

import java.io.IOException;
import java.io.InputStream;

public class StreamEx01 {
    public static void main(String[] args) {
        InputStream in = System.in;//바이트스트림 아스키코드 1글자씩 받음
        try {
            int data = in.read();
            System.out.println((char) data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
