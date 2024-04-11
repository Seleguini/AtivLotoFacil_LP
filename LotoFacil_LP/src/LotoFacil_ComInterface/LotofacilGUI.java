package LotoFacil_ComInterface;

import java.awt.*;
import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;


public class LotofacilGUI extends JFrame{
    // Atributos
    private JPanel painel = new JPanel();
    private JButton jButtonAposta1 = new JButton("Aposta de 0 a 100");
    private JButton jButtonAposta2 = new JButton("Aposta de A a Z");
    private JButton jButtonAposta3 = new JButton("Aposta par ou ímpar");

    //Métodos
    private static void aposta1() {
        ImageIcon icon = new ImageIcon("sorteio.png");
        Object numeroApostado = JOptionPane.showInputDialog(null, "Digite sua aposta, de 0 a 100: ",
                "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon,null,"");
        Random rnd = new Random();
        int sorteio = rnd.nextInt(101);
        int numeroDigitado = Integer.parseInt(numeroApostado.toString());
        if(numeroDigitado == sorteio){
            JOptionPane.showMessageDialog(null, "Você ganhou milzão.");
        }else{
            JOptionPane.showMessageDialog(null, "Você perdeu!, o número sorteado foi: " + sorteio);
        }
    }
    private static void aposta2() throws IOException {
        ImageIcon icon = new ImageIcon("letras.png");
        String input = (String) JOptionPane.showInputDialog(null, "Digite uma letra de A a Z: ",
                "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon,null,"");
        char letraSorteada = 'G';

        if (input != null && input.length() == 1) {
            char letraApostada = input.toUpperCase().charAt(0);
            if (Character.isLetter(letraApostada)) {
                if (letraApostada == letraSorteada) {
                    JOptionPane.showMessageDialog(null, "Você ganhou R$500,00.");
                } else {
                    JOptionPane.showMessageDialog(null, "Que pena você perdeu! A letra sorteada foi: " + letraSorteada + "\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Não é uma letra válida.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Digite apenas uma letra.");
        }
    }

    private static void aposta3() {
        ImageIcon icon = new ImageIcon("parouimpar.png");
        String input = (String) JOptionPane.showInputDialog(null, "Digite um número par ou um número impar para tentar acertar: ",
                "Aposta 1", JOptionPane.INFORMATION_MESSAGE, icon,null,"");
        int numeroDigitado = Integer.parseInt(input);
        if(numeroDigitado % 2 == 0){
            JOptionPane.showMessageDialog(null, "Você ganhou R$100,00.");
        }else{
            JOptionPane.showMessageDialog(null, "Você perdeu! Um número par era a aposta correta");
        }
    }

    // Construtor
    public LotofacilGUI(){
        this.setTitle("Lotofácil - Interface Gráfica");
        this.setSize(400,200);
        painel.setLayout(new FlowLayout(FlowLayout.CENTER, 100, 20));
        painel.setBackground(new Color(255,255,255));
        painel.add(jButtonAposta1); painel.add(jButtonAposta2); painel.add(jButtonAposta3);
        this.getContentPane().add(painel);
        this.setLocationRelativeTo(null); // Centralizar janela
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true); // Exibir janela

        jButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta1();
            }
        });

        jButtonAposta2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    aposta2();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        jButtonAposta3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aposta3();
            }
        });

    }
    public static void main(String[] args) {new LotofacilGUI();}
}