/******************************************************
Cours:  LOG121
Projet: Squelette du laboratoire #1
Nom du fichier: FenetrePrincipale.java
Date créé: 2013-05-03
*******************************************************
Historique des modifications
*******************************************************
*@author Patrice Boucher
2013-05-03 Version initiale
*******************************************************/  

import java.awt.BorderLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;

import javax.swing.*;

/**
 * Cette classe représente la fenêtre principale de l'application 
 * @author Patrice Boucher
 */
public class FenetrePrincipale extends JFrame implements PropertyChangeListener{
	
	private static final long serialVersionUID = -1210804336046370508L;


    private FenetreFormes fenetreFormes;

    /**
	 * Constructeur
	 */
	public FenetrePrincipale(CommBase comm){

        MenuFenetre menu = new MenuFenetre(comm);
		this.setLayout(new BorderLayout());
		this.add(menu, BorderLayout.NORTH);
        fenetreFormes = new FenetreFormes();
		this.add(fenetreFormes, BorderLayout.CENTER); // Ajoute la fenêtre de forme à la fenètre principale
		this.pack(); // Ajuste la dimension de la fenêtre principale selon celle de ses composants
		this.setVisible(true); // Rend la fenêtre principale visible.
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //... à réviser selon le comportement que vous désirez ...

        comm.setPropertyChangeListener(this);
        this.addWindowListener(new FenetrePrincipaleClosingListener(comm));

	}

    /**
     * Classe qui implémente l'action WindowClosing pour terminer la connexion de façon propre
     */
    private class FenetrePrincipaleClosingListener extends WindowAdapter
    {
        private CommBase comm;

        public FenetrePrincipaleClosingListener(CommBase comm)
        {
            this.comm = comm;
        }

        @Override
        public void windowClosing(WindowEvent e) {
            try {
                comm.stop();
            } catch (IOException e1) {
                // suppress
            }
        }
    }


    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if(evt.getPropertyName().equals("FORME"))
        {
            System.out.println(evt.getNewValue());
            Forme f = CreateurFormes.creerForme((String) evt.getNewValue());
            fenetreFormes.ajouterForme(f);
            repaint();
        }
        if(evt.getPropertyName().equals("ERREUR"))
        {
            Exception ex = (Exception) evt.getNewValue();
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
}
