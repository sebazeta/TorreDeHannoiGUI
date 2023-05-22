import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

public class TorreDeHanoiGUI extends JFrame {
    private JLabel[] labels;
    private JButton resolverButton;
    private JComboBox<String> solucionComboBox;

    private Stack<Integer>[] torres;
    private Queue<Integer> movimientos;

    public TorreDeHanoiGUI(int numDiscos) {
        setTitle("Torre de Hanoi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(numDiscos, 4));
        labels = new JLabel[numDiscos * 4];
        torres = new Stack[3];
        movimientos = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            torres[i] = new Stack<>();
        }

        for (int i = numDiscos; i > 0; i--) {
            torres[0].push(i);
        }

        for (int i = 0; i < numDiscos * 4; i++) {
            labels[i] = new JLabel();
            labels[i].setOpaque(true);
            labels[i].setBackground(Color.WHITE);
            labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK));
            add(labels[i]);
        }

        resolverButton = new JButton("Resolver");
        resolverButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String solucion = (String) solucionComboBox.getSelectedItem();
                resolverTorreDeHanoiConSolucion(solucion);
                actualizarInterfazGrafica();
            }
        });

        solucionComboBox = new JComboBox<>();
        solucionComboBox.addItem("Solución automática");
        solucionComboBox.addItem("Solución personalizada");

        add(resolverButton);
        add(solucionComboBox);

        pack();
        setLocationRelativeTo(null);
    }

    private void actualizarInterfazGrafica() {
    }

    public void moverDisco(int torreOrigen, int torreDestino) {
        int disco = torres[torreOrigen].pop();
        torres[torreDestino].push(disco);
        movimientos.add(torreOrigen);
        movimientos.add(torreDestino);
    }

    public void resolverTorreDeHanoi(int numDiscos, int torreOrigen, int torreDestino, int torreAuxiliar) {
        if (numDiscos == 1) {
            moverDisco(torreOrigen, torreDestino);
        } else {
            resolverTorreDeHanoi(numDiscos - 1, torreOrigen, torreAuxiliar, torreDestino);
            moverDisco(torreOrigen, torreDestino);
            resolverTorreDeHanoi(numDiscos - 1, torreAuxiliar, torreDestino, torreOrigen);
        }
    }

    public void resolverTorreDeHanoiConSolucion(String solucion) {
        if (solucion.equals("Solución automática")) {
            resolverTorreDeHanoi(torres[0].size(), 0, 2, 1);
        } else if (solucion.equals("Solución personalizada")) {
            int[] pasos = {0, 2, 0, 1, 2, 1, 0};
            for (int paso : pasos) {
                int torreOrigen = movimientos.poll();
                int tor;
            }
        }
    }
}