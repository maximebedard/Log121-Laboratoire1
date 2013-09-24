import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;


public class ConnectionServeur {

    /**
     * Socket
     */
    private Socket socket = null;

    /**
     * Flux de données sortant
     */
    private PrintWriter outStream = null;

    /**
     * Flux de données entrant
     */
    private BufferedReader inStream = null;

    /**
     * Connexion au serveur à partir d'une adresse au format [nom]:[port]
     * @param addr adresse du serveur
     * @throws IOException Exception lancé lors des erreurs de connexion
     */
    public void connect(String addr) throws IOException {
        if(isConnected())
            disconnect();

        String url = addr.substring(0, addr.indexOf(":"));
        int port = Integer.parseInt(addr.substring(addr.indexOf(":") + 1));
        socket = new Socket(url, port);
        outStream = new PrintWriter(socket.getOutputStream(), true);
        inStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));

    }

    /**
     * Vérifie si la connexion du socket est toujours active
     * @return true si la connexion est toujours active
     */
    public boolean isConnected()
    {
        return socket != null && socket.isConnected();
    }

    /**
     * Intéroge le serveur dans le but d'obtenir la définition d'une forme sous la forme d'une chaîne de caractère.
     * @return la forme sous forme de chaîne de caractères
     * @throws IOException
     */
    public String getForme() throws IOException {
        if(!isConnected())
            return null;

        inStream.readLine();
        outStream.println("GET");
        return inStream.readLine();
    }

    /**
     * Ferme la connexion du socket
     * @throws IOException
     */
    public void disconnect() throws IOException {
        if(!isConnected())
            return;

        outStream.println("END");
        socket.close();
    }


}
