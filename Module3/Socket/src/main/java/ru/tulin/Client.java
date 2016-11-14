package ru.tulin;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.nio.file.Paths;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 03.10.2016
 */
public class Client {

    static final String GO = "продолжить";
    static final String STOP = "стоп";
    static final String END = "закончить";


    protected Socket createSocket(String hostname, int port) throws IOException {
        return new Socket(hostname, port);
    }

    String getReadLine() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    public boolean launch(File logPath, String hostname, int port) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(String.valueOf(Paths.get(System.getProperty("user.dir") + logPath))));
        boolean sent = false;

        try {
            System.out.println("Подключаемся к серверу: " + port);
            Socket socket = createSocket(hostname, port);

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            BufferedReader in = new BufferedReader(new InputStreamReader(socketIn));
            PrintWriter out = new PrintWriter(socketOut, true);

            String input = null;
            boolean toggle = true;

            System.out.println("Введите фразу для передачи серверу: ");

            while (!END.equalsIgnoreCase(input)) {
                input = getReadLine();
                pw.println(input);

                if(STOP.equalsIgnoreCase(input) || END.equalsIgnoreCase(input)) {
                    toggle = false;
                }

                if (toggle) {
                    out.println(input);
                    out.flush();
                    input = in.readLine();
                    pw.println(input);
                    System.out.println("Сервер прислал в ответ: " + input);
                    System.out.println("Введите следующую фразу для отправки на сервер: ");
                }

                if (GO.equalsIgnoreCase(input)) {
                    toggle = true;
                    System.out.println("Введите следующую фразу для отправки на сервер: ");
                }
            }

            System.out.println("Работа завершена");
            sent = true;

        }catch (Exception e) {
            e.printStackTrace();
        }

        pw.close();

        return sent;
    }
}
