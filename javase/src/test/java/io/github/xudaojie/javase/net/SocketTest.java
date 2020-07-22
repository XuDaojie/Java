package io.github.xudaojie.javase.net;

import org.junit.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * @author XuDaojie
 * @since 2020/7/21
 */
public class SocketTest {

    @Test
    public void socketTest() throws IOException {
        InetSocketAddress address = new InetSocketAddress("127.0.0.1", 3307);

        Socket socket = new Socket();
        socket.connect(address);
        socket.setTcpNoDelay(true);

        BufferedInputStream in = new BufferedInputStream(socket.getInputStream());
        int readSize = 82;
//        int readSize = 4;
        byte[] data = new byte[readSize];
        int remain = readSize;
        while (remain > 0) {
            int read = in.read(data, readSize - remain, remain);
            if (read > -1) {
                remain = remain - read;
            }
            System.err.println(read + ":" + remain);
        }
        System.out.println((data[0] & 0xFF) | ((data[1] & 0xFF) << 8) | ((data[2] & 0xFF) << 16));
        System.err.println("data:" + new String(data));
        byte[] b = new byte[] {
            78, 0, 0, 0
        };
        System.err.println("data4:" + new String(b));
        // 结束符0
        byte[] c = new byte[] {
                            53, 46, 55,
            46, 50, 56, 45, 108, 111, 103
        };
        System.err.println("data5:" + new String(c));
        // 结束符0
        byte[] d = new byte[] {
            -90, 1, 0, 0
        };
        System.err.println("data6:" + new String(d));
        // 结束符0
        byte[] e = new byte[] {
            30, 107, 43, 32, 39, 31, 76, 86
        };
        System.err.println("data7:" + new String(e));
        // 结束符0
        byte[] f = new byte[] {
            -1, -1
        };
        System.err.println("data8:" + new String(f));
    }
}
