import javafx.scene.control.TextArea;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Random;

/**
 * Created by Admin on 1/13/2018.
 */
public class ServerNit extends Thread {
    private TextArea labelaIsporucene;
    private TextArea labelaNeisporucene;
    private Socket socket;
    private int brojacPica;
    private Server s;


    ServerNit(Socket socket, TextArea labelaIsporucene, TextArea labelaNeisporucene, int brojacPica){
        this.socket = socket;
        this.labelaIsporucene = labelaIsporucene;
        this.labelaNeisporucene = labelaNeisporucene;
        this.brojacPica = brojacPica;
    }

    public void run() {
        s = new Server(labelaIsporucene, labelaNeisporucene);
        Random r = new Random();
        int vreme = r.nextInt(24) + 6;
        Pica pica = new Pica();
        try {
            ObjectInputStream inputStream = new ObjectInputStream(socket.getInputStream());
            pica = (Pica) inputStream.readObject();
            s.dodajPicu(brojacPica, pica);
            brojacPica++;
            s.setBrojacPica(brojacPica);
            brojacPica--;
            PrintStream p = new PrintStream(socket.getOutputStream());
            p.println(vreme);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            while (vreme > 0) {
                s.dodajVremena(brojacPica, vreme);
                s.ispisiPicu();
                Thread.sleep(1000);
                vreme--;
            }
            brojacPica--;
            labelaNeisporucene.setText("");
            labelaIsporucene.appendText(pica.toString() + " - je isporucena" + "\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
