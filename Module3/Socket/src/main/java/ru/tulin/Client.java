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
    static final int servPort = 5000;
    static final String ipAdress = "127.0.0.1";

    public void launch(File logPath) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File(String.valueOf(Paths.get(System.getProperty("user.dir") + logPath))));

        try {
            InetAddress inetAddress = InetAddress.getByName(ipAdress);
            System.out.println("Подключаемся к серверу: " + servPort);
            Socket socket = new Socket(inetAddress, servPort);

            InputStream socketIn = socket.getInputStream();
            OutputStream socketOut = socket.getOutputStream();

            DataInputStream in = new DataInputStream(socketIn);
            DataOutputStream out = new DataOutputStream(socketOut);

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String input = null;
            boolean toggle = true;

            System.out.println("Введите фразу для передачи серверу: ");

            while (!END.equalsIgnoreCase(input)) {
                input = reader.readLine();
                pw.println(input);

                if(STOP.equalsIgnoreCase(input) || END.equalsIgnoreCase(input)) {
                    toggle = false;
                }

                if (toggle) {
                    out.writeUTF(input);
                    out.flush();
                    input = in.readUTF();
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

        }catch (Exception e) {
            e.printStackTrace();
        }

        pw.close();
    }
}
