import javafx.scene.control.TextArea;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Admin on 1/13/2018.
 */
public class Server extends Thread{

    private TextArea labelaIsporucene;
    private TextArea labelaNeisporucene;
    private ArrayList<Pica> pice = new ArrayList<>();
    private ArrayList<Integer> vremena = new ArrayList<>();
    private int brojacFunkcije = 0;
    private int brojacPica = 0;
    private boolean tacno = true;

    public Server(){

    }

    public Server(TextArea labelaIsporucene, TextArea labelaNeisporucene) {
        this.labelaIsporucene = labelaIsporucene;
        this.labelaNeisporucene = labelaNeisporucene;
    }

    public void run(){
        try {

            ServerSocket serverSocket = new ServerSocket(4445);
            while (true){
                int vreme;
                Socket socket = serverSocket.accept();
                new ServerNit(socket, labelaIsporucene, labelaNeisporucene, brojacPica).start();
//                while (true) {
//                    vreme = Calendar.getInstance().get(Calendar.MILLISECOND);
//                    if (vreme % 1000 == 0) {
//                        new ServerNit(socket, labelaIsporucene, labelaNeisporucene, brojacPica).start();
//                        break;
//                    }
//                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public void dodajPicu(int index, Pica p){
        pice.add(index, p);
    }
    public void dodajVremena(int index, int vreme){
        vremena.add(index, vreme);
    }

    public void ispisiPicu(){
        brojacFunkcije++;
        if (brojacFunkcije == brojacPica && tacno) {
            tacno = false;
            labelaNeisporucene.setText("");
            String tekst = "";
            for (int i = 0; i < brojacPica; i++) {
                tekst += (pice.get(i).toString() + " - " + vremena.get(i) + "\n");
                vremena.remove(i);
            }
            labelaNeisporucene.setText(tekst);
            brojacFunkcije = 0;
            tacno = true;
        }

    }

    public void setBrojacPica(int brojacPica) {
        this.brojacPica = brojacPica;
    }
}
