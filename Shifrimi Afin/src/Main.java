import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        new Afin(17, 20);
        String mesazhi = JOptionPane.showInputDialog("Sheno mesazhin: ");
        String mesazhiEnkriptuar = Afin.enkriptimi(mesazhi.toUpperCase().toCharArray());
        JOptionPane.showMessageDialog(null, "Mesazhi i Enkriptuar: " + mesazhiEnkriptuar + "\n" + "Messazhi i Dekriptuar: " + Afin.dekriptimi(mesazhiEnkriptuar));

    }
}