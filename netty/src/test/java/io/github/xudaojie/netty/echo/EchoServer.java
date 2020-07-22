package io.github.xudaojie.netty.echo;

import java.net.InetSocketAddress;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * echo服务端
 *
 * @author xdj
 * @since 2020/7/19
 */
public class EchoServer {

    private int port;

    public EchoServer(int port) {
        this.port = port;
    }

    public static void main(String[] args) {
        EchoServer server = new EchoServer(3333);
        server.start();
    }

    public void start() {
        NioEventLoopGroup group = new NioEventLoopGroup();
        ServerBootstrap bootstrap = new ServerBootstrap();
        bootstrap.group(group)
            .channel(NioServerSocketChannel.class)
            .localAddress(new InetSocketAddress(this.port))
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline()
                        .addLast(new EchoServerHandler());
                }
            });

        try {
            ChannelFuture future = bootstrap.bind().sync();
            System.out.println(EchoServer.class.getName()
                + " started and listen on " + future.channel().localAddress());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            group.shutdownGracefully();
        }

    }
}
