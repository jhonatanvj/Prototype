/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Prototype_end;

/**
 *
 * @author jhona
 */

import Vehiculos.Automovil;
import Vehiculos.Motocicleta;
import Interface.Vehiculos;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.EmptyBorder;

public class Prototype_ends extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textFieldColor, textFieldVelocidad;
    private JLabel lblColor, lblVelocidad;
    private JTextArea textAreaOriginal, textAreaClon;
    private Vehiculos vehiculoOriginal, vehiculoClon;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Prototype_ends frame = new Prototype_ends();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Prototype_ends() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 500, 400);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        addComponentsToPane();
    }

    private void addComponentsToPane() {
        JLabel pregunta_txt = new JLabel("Seleccione el vehículo a clonar:");
        pregunta_txt.setBounds(160, 10, 200, 20);
        contentPane.add(pregunta_txt);

        JRadioButton bton_Automovil = new JRadioButton("Automóvil");
        JRadioButton bton_Motocicleta = new JRadioButton("Motocicleta");
        bton_Automovil.setBounds(61, 61, 103, 21);
        bton_Motocicleta.setBounds(61, 93, 103, 21);
        contentPane.add(bton_Automovil);
        contentPane.add(bton_Motocicleta);

        ButtonGroup grupoOpciones = new ButtonGroup();
        grupoOpciones.add(bton_Automovil);
        grupoOpciones.add(bton_Motocicleta);

        JButton btnSeleccionar = new JButton("Seleccionar");
        btnSeleccionar.setBounds(210, 120, 115, 21);
        contentPane.add(btnSeleccionar);

        JButton btnAplicarCambios = new JButton("Aplicar cambios");
        btnAplicarCambios.setBounds(336, 320, 150, 21);
        contentPane.add(btnAplicarCambios);

        textFieldVelocidad = createTextField(160, 180);
        textFieldColor = createTextField(160, 210);

        lblVelocidad = createLabel("Velocidad del clon", 10, 183);
        lblColor = createLabel("Color del clon", 10, 213);

        textAreaOriginal = createTextArea(10, 240, 220, 60);
        textAreaClon = createTextArea(260, 240, 220, 60);

        btnSeleccionar.addActionListener(e -> {
            if (bton_Automovil.isSelected()) {
                vehiculoOriginal = new Automovil();
                vehiculoOriginal.setNombre("Automóvil");
                vehiculoOriginal.setColor("Rojo");
                vehiculoOriginal.setVelocidadMaxima(180);
                vehiculoClon = vehiculoOriginal.clonar();
            } else if (bton_Motocicleta.isSelected()) {
                vehiculoOriginal = new Motocicleta();
                vehiculoOriginal.setNombre("Motocicleta");
                vehiculoOriginal.setColor("Azul");
                vehiculoOriginal.setVelocidadMaxima(220);
                vehiculoClon = vehiculoOriginal.clonar();
            }
            mostrarDatos();
        });

        btnAplicarCambios.addActionListener(e -> applyChanges());
    }

    private JTextField createTextField(int x, int y) {
        JTextField textField = new JTextField();
        textField.setBounds(x, y, 96, 19);
        textField.setVisible(true);
        contentPane.add(textField);
        return textField;
    }

    private JLabel createLabel(String text, int x, int y) {
        JLabel label = new JLabel(text);
        label.setBounds(x, y, 154, 13);
        label.setVisible(true);
        contentPane.add(label);
        return label;
    }

    private JTextArea createTextArea(int x, int y, int width, int height) {
        JTextArea textArea = new JTextArea();
        textArea.setBounds(x, y, width, height);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false);
        contentPane.add(textArea);
        return textArea;
    }

    private void applyChanges() {
        vehiculoClon.setColor(textFieldColor.getText());
        vehiculoClon.setVelocidadMaxima(Integer.parseInt(textFieldVelocidad.getText()));
        mostrarDatos();
    }

    private void mostrarDatos() {
        textAreaOriginal.setText("Vehículo Original:\n" + vehiculoOriginal.mostrarDatos());
        textAreaClon.setText("Vehículo Clonado:\n" + vehiculoClon.mostrarDatos());
    }
}

