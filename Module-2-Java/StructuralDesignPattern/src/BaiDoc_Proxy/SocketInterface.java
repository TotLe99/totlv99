package BaiDoc_Proxy;

public interface SocketInterface {
    String readLine();
    void writeLine(String str);
    void dispose();
}
