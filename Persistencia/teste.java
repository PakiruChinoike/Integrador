import java.io.*;
import py4j.*;
  
class GFG {
    public String Message() { return "Hello"; }
    public static void main(String[] args)
    {
        GatewayServer g = new GatewayServer(new GFG(), 25539);
        g.start();
        System.out.println("Gateway Server Started");
    }
}