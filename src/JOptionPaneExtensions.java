import javax.swing.*;
import java.awt.*;

public final class JOptionPaneExtensions {


    /**
     * Affiche un message d'erreur ayant comme titre "Erreur..."
     * @param parent composante parente au message d'erreur
     * @param msg message à afficher
     */
    public static void showErrorMessage(Component parent, String msg)
    {
        showErrorMessage(parent, msg, "Erreur...");
    }


    /**
     * Affiche une message d'erreur
     * @param parent composante parente au message d'erreur
     * @param msg message à afficher
     * @param title titre du message d'erreur
     */
    public static void showErrorMessage(Component parent, String msg, String title)
    {
        JOptionPane.showMessageDialog(parent,
                msg,
                title,
                JOptionPane.ERROR_MESSAGE);
    }

}
