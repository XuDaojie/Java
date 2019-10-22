package io.github.xudaojie.proxy;

public class UserServiceImpl implements UserService {

    @Override
    public void login() {
        System.err.println("登录");
    }

    @Override
    public final void logout() {
        System.err.println("退出登录");
    }

    @Override
    public void log() {
        System.err.println("log");
    }
}
