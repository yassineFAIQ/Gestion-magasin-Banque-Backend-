package Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;

import Compte.Compte;
import Compte.CompteDAOIMPL;



public class ClientThread implements Runnable {
    private Socket clientSocket;
    private InputStream inputStream;
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private OutputStream outputStream;
    private CompteDAOIMPL compte;

    public ClientThread(Socket clientSocket) {
        this.clientSocket = clientSocket;
        this.compte = new CompteDAOIMPL();

        try {
            this.outputStream = this.clientSocket.getOutputStream();
            this.inputStream = this.clientSocket.getInputStream();
            this.in = new ObjectInputStream(inputStream);
            this.out = new ObjectOutputStream(outputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void sendInfosCompte() {
        try {
            Compte receivedAccount = null;
            try {
            	System.out.println("before receivedAccount = (Compte)in.readObject();");
                receivedAccount = (Compte)in.readObject();
                System.out.println(receivedAccount.getCarte().getLibelle_carte());
            } catch (ClassNotFoundException e) {
            	System.out.println("inside catch:object not read");
                out.writeObject(500);
            }
            Compte cmpt = compte.find(receivedAccount);
            System.out.println("after Compte cmpt = compte.find(receivedAccount);");
            if (cmpt != null) {
                if(cmpt.getMontant_compte() >= receivedAccount.getMontant_compte()) {
                	compte.update(cmpt, receivedAccount.getMontant_compte());
                	System.out.println(receivedAccount.getMontant_compte()+"hhhhhgh");
                    out.writeObject(200);
                } else {
                    out.writeObject(400);
                }
            } else {
                System.out.println("no account 404");
                out.writeObject(404);
            }
        } catch (IOException e) {
        	System.out.println("last catctch excetion: "+ e.getMessage());
            try {
                out.writeObject(500);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }

    @Override
    public void run() {
    	System.out.println("run() function thread class ClientThread");
        sendInfosCompte();
    }
}
