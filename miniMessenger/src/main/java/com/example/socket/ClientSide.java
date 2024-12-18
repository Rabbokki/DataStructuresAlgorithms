package com.example.socket;

import java.io.*;
import java.net.Socket;

public class ClientSide {
    public static void main(String[] args) {
        new ClientSide();
    }
    BufferedWriter bw; //서버에 보내는 용도(출력)
    BufferedReader keyboard;//키보드에서 입력 받는 용도
    BufferedReader br;//서버에서 보낸 소켓에서 읽는 용도
    Socket socket;
    public ClientSide() {

        try{
            System.out.println("1. 클라이언트 소켓 시작 ------------------------");
            socket = new Socket("192.168.0.67",10000);
            System.out.println("2.버퍼연결 완료");


            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            //서버로 메시지를 보내기 위한 키보드를 연결
            keyboard = new BufferedReader(new InputStreamReader(System.in));
            //서버에서 보낸 메시지 받는 용도
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //서버에서 전달한 메시지 수신용 스레드
            ReadThread readThread = new ReadThread();
            Thread thread = new Thread(readThread);
            thread.start();


            while (true) {
                System.out.println("3.키보드 메시지 입력 대기중.......");

                String keyboardMessage = keyboard.readLine();
                bw.write(keyboardMessage + "\n");
                bw.flush();
            }

        }catch (Exception e){
            e.getMessage();
        }
    }
    class ReadThread implements Runnable{
        @Override
        public void run() {
            while (true){
                try {
                    String message = br.readLine();
                    System.out.println("서버가 보낸 메시지 : " + message);
                } catch (IOException e) {
                    System.out.println("서버 메시지 수신 오류 " + e.getMessage());
                }
            }
        }
    }
}
