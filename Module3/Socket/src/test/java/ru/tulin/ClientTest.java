package ru.tulin;

import org.junit.Test;

import java.io.*;
import java.net.Socket;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * @author Viktor Tulin
 * @version 1
 * @since 09.10.2016
 */
public class ClientTest {

    @Test
    public void whenSentMessageThenTrue() throws IOException {
        String logPath = "\\src\\test\\java\\ru\\tulin\\log.txt";
        String command = "закончить";
        String servResponse = "ответ";
        final Socket socket = mock(Socket.class);

        Client text = new Client() {
            @Override
            protected Socket createSocket(String hostname, int port) throws IOException {
                return socket;
            }
        };

        when(socket.getInputStream()).thenReturn(new ByteArrayInputStream(servResponse.getBytes()));
        when(socket.getOutputStream()).thenReturn(new ByteArrayOutputStream());

        System.setIn(new ByteArrayInputStream(command.getBytes()));
        boolean result = text.launch(new File(logPath), "localhost", 1234);


        assertTrue(result);
    }

}