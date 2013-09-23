/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: CommBase.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.*;

/**
 * Base d'une communication via un fil d'exécution parallèle.
 */
public class CommBase {
	
	private final int DELAI = 1000;
	private SwingWorker threadComm =null;
	private PropertyChangeListener listener = null;
	private boolean isActif = false;
    private Socket socket = null;
    PrintWriter outStream = null;
    BufferedReader inStream = null;


    /**
	 * Constructeur
	 */
	public CommBase(){
	}
	
	/**
	 * Définir le récepteur de l'information reéue dans la communication avec le serveur
	 * @param listener sera alerté lors de l'appel de "firePropertyChanger" par le SwingWorker
	 */
	public void setPropertyChangeListener(PropertyChangeListener listener){
		this.listener = listener;
	}
	
	/**
	 * Démarre la communication
	 */
	public void start(){
        creerCommunication();
    }
	
	/**
	 * Arrête la communication
	 */
	public void stop(){
		if(threadComm!=null)
			threadComm.cancel(true);

        if(inStream != null)
            outStream.println("END");

		isActif = false;
	}
	
	/**
	 * Créer le nécessaire pour la communication avec le serveur
	 */
	protected void creerCommunication() {

        // Crée un fil d'exécusion parallèle au fil courant,
		threadComm = new SwingWorker(){
			@Override
			protected Object doInBackground() throws Exception {
				System.out.println("Le fils d'execution parallele est lance");

                try
                {
                    String addr = "localhost:10000";
                    System.out.println(String.format("Connexion au serveur : %s", addr));
                    socket = connectToServer(addr);

                    outStream = new PrintWriter(socket.getOutputStream(), true);
                    inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    while(true)
                    {
                        Thread.sleep(DELAI);

                        outStream.println("GET");
                        String chaine = inStream.readLine();

                        Forme f = CreateurFormes.creerForme(chaine);

                        //La méthode suivante alerte l'observateur
                        if(listener!=null)
                           firePropertyChange("ENVOIE-TEST", null, (Object) ".");
                    }
                }
                catch (IOException ex)
                {
                    ex.printStackTrace();
                }

                return null;
			}
		};
		if(listener!=null)
		   threadComm.addPropertyChangeListener(listener); // La méthode "propertyChange" de ApplicationFormes sera donc appelée lorsque le SwinkWorker invoquera la méthode "firePropertyChanger" 		
		threadComm.execute(); // Lance le fil d'exécution parallèle.
		isActif = true;
	}

    private Socket connectToServer(String addr) throws IOException {
        String url = addr.substring(0, addr.indexOf(":"));
        int port = Integer.parseInt(addr.substring(addr.indexOf(":") + 1));
        return new Socket(url, port);
    }
	
	/**
	 * @return si le fil d'exécution parallèle est actif
	 */
	public boolean isActif(){
		return isActif;
	}
}
