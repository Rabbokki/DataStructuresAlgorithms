package com.example.socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSide {
    public static void main(String[] args) {
        new ServerSide();
    }

    //클라이언트 연결을 받는 소켓(서버 소켓)
    ServerSocket serverSocket;

    //실제 통신용 소켓
    Socket socket;

    BufferedReader br;//클라이언트가 보낸 글 읽기 용도
    //키보드 입력용
    BufferedReader keyboard;
    //클라이언트로 보낼 버퍼
    BufferedWriter bw;

    public ServerSide(){
        System.out.println("1.서버소켓 시작 ----------------------");
        try {
            serverSocket = new ServerSocket(10000);
            System.out.println("2.서버소켓 생성완료--------------------");
            System.out.println("3.클라이언트 연결 대기중--------------------");
            socket = serverSocket.accept();
            System.out.println("4.클라이언트 접속 완료");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            //서버쪽에서 키보드로 입력받는 용도
            keyboard = new BufferedReader(new InputStreamReader(System.in));

            //입력받은 글을 클라이언트로 흘려보내는 용도
            bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

            //클라이언트로 보내는 기능
            WriteThread writeThread = new WriteThread();
            Thread serverThread = new Thread(writeThread);
            serverThread.start();


            while (true) {
                //클라이언트가 보낸 메시지를 읽는 용도
                String clientMessage = br.readLine();
                System.out.println("5.클라이언트로부터 받은 메시지 : " + clientMessage);
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

    //내부클래스
    //키보드에서 입력받아 클라이언트에 보내는 역할
    class WriteThread implements Runnable{

        @Override
        public void run() {
            while (true){
                try{
                    String keyboardMessage = keyboard.readLine();
                    bw.write(keyboardMessage + "\n");
                    bw.flush();

                }catch (Exception e){
                    System.out.println("클라이언트 메시지 수신오류" + e.getMessage());
                }
            }
        }
    }

}
