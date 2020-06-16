package ru.job4j.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean bye = false;
            while (!bye) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    String query = "";
                    while (!(str = in.readLine()).isEmpty()) {
                        System.out.println(str);
                        bye = bye || str.contains("Exit");
                        if (str.contains("GET")) {
                            query = str.substring(str.indexOf("=") + 1, str.indexOf(" HTTP/"));
                        }
                    }
                    if (!query.isEmpty()) {
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        if ("Exit".equals(query)) {
                            out.write("Завершить работу сервера.".getBytes(StandardCharsets.UTF_16));
                        } else {
                            out.write(query.getBytes(StandardCharsets.UTF_16));
                        }

                    }
                }
            }
        }
    }
}