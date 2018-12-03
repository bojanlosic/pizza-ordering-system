import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;


/**
 * Created by Admin on 1/13/2018.
 */
public class Program extends Application {

    private String velicina, vrsta, odPriloga, nacinPlacanja, adresa, brojTelefona, napomena;


    Stage window;
    Scene scena1;
    Scene scena2;
    Scene scena3;
    Scene scena4;
    Scene scena5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("Narucivanje pice - Klijent");

        Label labela = new Label("Odaberi velicinu pice:");
        Button velicina25 = new Button("25cm");
        Button velicina32 = new Button("32cm");
        Button velicina50 = new Button("50cm");
        Button izadji = new Button("Izadji");

        velicina25.setMinWidth(90);
        velicina32.setMinWidth(90);
        velicina50.setMinWidth(90);

        velicina25.setOnAction(e -> postaviVelicinu(velicina25));
        velicina32.setOnAction(e -> postaviVelicinu(velicina32));
        velicina50.setOnAction(e -> postaviVelicinu(velicina50));

        izadji.setOnAction(e -> System.exit(1));

        VBox layout = new VBox();
        //Dodaj sve na trenutnu sliku
        layout.getChildren().addAll(labela, velicina25, velicina32, velicina50, izadji);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        scena1 = new Scene(layout, 400, 300);
        window.setScene(scena1);
        window.show();
    }

    private void postaviVelicinu(Button vrednost){
        velicina = "Velicina pice: ";
        velicina += vrednost.getText();
        System.out.println(velicina);

        Label labela = new Label("Odaberi vrstu pice:");
        Button vrsta1 = new Button("Margarita");
        Button vrsta2 = new Button("Funghi");
        Button vrsta3 = new Button("Quatro Stagione");
        Button vrsta4 = new Button("Vegeteriana");
        Button izadji = new Button("Izadji");

        vrsta1.setOnAction(e -> postaviVrstu(vrsta1));
        vrsta2.setOnAction(e -> postaviVrstu(vrsta2));
        vrsta3.setOnAction(e -> postaviVrstu(vrsta3));
        vrsta4.setOnAction(e -> postaviVrstu(vrsta4));

        izadji.setOnAction(e -> System.exit(2));

        VBox layout = new VBox();

        layout.getChildren().addAll(labela, vrsta1, vrsta2, vrsta3, vrsta4, izadji);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        scena2 = new Scene(layout,400,300);
        window.setScene(scena2);
        window.show();
    }

    private void postaviVrstu(Button vrednost){
        vrsta = "Vrsta pice: ";
        vrsta += vrednost.getText();
        System.out.println(vrsta);

        Label labela = new Label("Preko pice:");
        CheckBox kecap = new CheckBox("Kecap");
        CheckBox majonez = new CheckBox("Majonez");
        CheckBox origano = new CheckBox("Origano");
        Button potvrdi = new Button("Odaberi");
        Button izadji = new Button("Izadji");

        potvrdi.setOnAction(e -> dodaci(kecap, majonez, origano));
        izadji.setOnAction(e -> System.exit(3));
        VBox layout = new VBox();

        layout.getChildren().addAll(labela, kecap, majonez, origano, potvrdi, izadji);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        scena3 = new Scene(layout,400,300);
        window.setScene(scena3);
        window.show();
    }

    private void dodaci(CheckBox kecap, CheckBox majonez, CheckBox origano){
        odPriloga = "Preko pice: ";
        if (kecap.isSelected())
            odPriloga += kecap.getText() + " ";
        if (majonez.isSelected())
            odPriloga += majonez.getText() + " ";
        if (origano.isSelected())
            odPriloga += origano.getText() + " ";
        if (!(kecap.isSelected() || majonez.isSelected() || origano.isSelected()))
            odPriloga += "nista";
        System.out.println(odPriloga);

        Label labela = new Label("Odaberi nacin placanja:");
        Button kes = new Button("Kes");
        Button kartica = new Button("Kartica");
        Button izadji = new Button("Izadji");

        kes.setOnAction(e -> naruci(kes));
        kartica.setOnAction(e -> naruci(kartica));

        izadji.setOnAction(e -> System.exit(4));

        VBox layout = new VBox();

        layout.getChildren().addAll(labela, kes, kartica, izadji);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        scena4 = new Scene(layout,400,300);
        window.setScene(scena4);
        window.show();
    }

    private void naruci(Button vrednost){
        nacinPlacanja = "Nacin placanja: ";
        nacinPlacanja += vrednost.getText();
        System.out.println(nacinPlacanja);

        TextField adresa, brojTelefona, napomena;
        Label labela = new Label("Unesi adresu:");
        adresa = new TextField();
        adresa.setPromptText("Vojvode Stepe 268");
        Label labela1 = new Label("Unesi broj telefona:");
        brojTelefona = new TextField();
        brojTelefona.setPromptText("0612345678");
        Label labela2 = new Label("Unesi napomenu:");
        napomena = new TextField();
        napomena.setPromptText("Vise kecapa, vise ");

        Button potvrdi = new Button("Potvrdi");
        Button izadji = new Button("Izadji");

        potvrdi.setOnAction(e -> posalji(vrednost, adresa, brojTelefona, napomena));

        izadji.setOnAction(e -> System.exit(5));

        VBox layout = new VBox();

        layout.getChildren().addAll(labela, adresa, labela1, brojTelefona, labela2, napomena, potvrdi, izadji);
        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(10);

        scena4 = new Scene(layout,400,300);
        window.setScene(scena4);
        window.show();
    }

    private void posalji(Button vrednost, TextField vrednost1, TextField vrednost2, TextField vrednost3){
        adresa = "Adresa: ";
        brojTelefona = "Broj telefona: ";
        napomena = "Napomena: ";

        if (vrednost1.getText().equals("")){
            System.out.println("Unesi adresu!");
            naruci(vrednost);
            return;
        }
        else if (vrednost2.getText().equals("")){
            System.out.println("Unesi broj telefona!");
            naruci(vrednost);
            return;
        }

        adresa += vrednost1.getText();
        brojTelefona += vrednost2.getText();
        napomena += vrednost3.getText();

        if (vrednost3.getText().equals("")){
            napomena += "nema napomenu";
        }

        System.out.println(adresa);
        System.out.println(brojTelefona);
        System.out.println(napomena);

        Pica pica = new Pica();
        pica.setVelicina(velicina);
        pica.setVrsta(vrsta);
        pica.setOdPriloga(odPriloga);
        pica.setNacinPlacanja(nacinPlacanja);
        pica.setAdresa(adresa);
        pica.setBrojTelefona(brojTelefona);
        pica.setNapomena(napomena);

        window.setOnCloseRequest(e -> {
            e.consume();
            window.close();
            System.exit(7);
        });
        try {
            Label labela;
            Socket socket = new Socket("127.0.0.1", 4445);
            System.out.println("Connected");
            ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(pica);
            Scanner scanner = new Scanner(socket.getInputStream());
            int minuti = scanner.nextInt();
            minuti = minuti / 60;
            labela = new Label("Pica stize za " + minuti + " minuta.");

            VBox layout = new VBox();

            layout.getChildren().addAll(labela);
            layout.setAlignment(Pos.CENTER);
            layout.setSpacing(10);

            scena5 = new Scene(layout,400,300);
            window.setScene(scena5);
            window.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
