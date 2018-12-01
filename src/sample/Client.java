package sample;

import sample.SerializeClasses.*;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;


public class Client {
    Socket socket;
    ObjectOutputStream oos;
    ObjectInputStream ois;

    Client()
    {
        try
        {
            socket = new Socket("localhost", 7777);
            System.out.println("Клиент подключен к сокету");
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
            System.out.println("Каналы записи клиента и чтения клиента инициализированы");

        }

        catch (UnknownHostException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public boolean readBoolean()
    {
        boolean Result = true;
        try {
            boolean Res = ois.readBoolean();

            System.out.println("Клиент пытается авторизоваться...");
            if(Res == true){Result = true;}
            else {Result = false;}
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Result;
    }

    public void write(Object obj)
    {
        try {
            oos.writeObject(obj);
            oos.flush();
            System.out.println("Клиент запрашивает данные...");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public double readDouble() {
        double Res = 0;
        try {
            Res = ois.readDouble();

            System.out.println("Клиент ожидает результаты расчета...");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Res;
    }

    public int readInt() {
        int Res = 0;
        try {
            Res = ois.readInt();

            System.out.println("Клиент ожидает результаты расчета...");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return Res;
    }

    public Object read() {
        Object object = new Object();
        try {
             object = ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return object;
    }
}