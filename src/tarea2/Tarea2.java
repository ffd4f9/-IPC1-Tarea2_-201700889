package tarea2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.LineBorder;
public class Tarea2 {
    public static usuario user;
    public static login inicio;
    public static void main(String[] args) {
        user = new usuario(201700889,"wagner","fuentes");
        inicio = new login();
    }
    
}
class usuario{
    private int carne;
    private String nombre;
    private String apellido;
    usuario(int carne, String nombre, String apellido){
     this.carne = carne;
     this.nombre = nombre;
     this.apellido = apellido;
    }
    int getCarne(){return carne;}
    String getNombre(){return nombre;}
    String getApellido(){return apellido;}
}
class login extends JFrame{
    private JPanel panel;
    private JLabel etiqueta1;
    private JLabel etiqueta2;
    private JTextField espacio1;
    private JTextField espacio2;
    private JButton boton;
    private JLabel titulo;
    private JLabel emergente;
    login(){
        setSize(450,300);
        setTitle("LOG IN");
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(Color.blue);
                add(panel);
            titulo = new JLabel("INICIAR SESION");
            titulo.setFont(new Font("Comic Sans MS",2,20));
            titulo.setBounds(120,0,250,50);
            titulo.setForeground(Color.yellow);
                panel.add(titulo);
            etiqueta1 = new JLabel();
            etiqueta1.setBounds(100,100,100,30);
            etiqueta1.setForeground(Color.white);
            etiqueta1.setText("NOMBRE");
                panel.add(etiqueta1);
            etiqueta2 = new JLabel();
            etiqueta2.setBounds(100,130,100,30);
            etiqueta2.setForeground(Color.white);
            etiqueta2.setText("PASSWORD");
                panel.add(etiqueta2);
            espacio1 = new JTextField();
            espacio1.setBounds(200,100,100,20);
            //espacio1.setBackground(Color.white);
                panel.add(espacio1);
            espacio2 = new JTextField();
            espacio2.setBounds(200,130,100,20);
            //espacio2.setBackground(Color.white);
                panel.add(espacio2);
            emergente = new JLabel();
            emergente.setBounds(60,50,450,30);
            emergente.setFont(new Font("Comic Sans MS",1,20));
            emergente.setForeground(Color.red);
                panel.add(emergente);
            boton = new JButton("INICIAR SESION");
            boton.setBounds(140,190,150,50);
            boton.setBorder(new LineBorder(Color.black,1));
            boton.setFont(new Font("Comic Sans MS",2,10));
                    ActionListener iniciarSesion = new ActionListener() {@Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            String user = espacio1.getText();
                            int password = Integer.parseInt(espacio2.getText());
                                if(user.equals(Tarea2.user.getNombre())){
                                    if(password==Tarea2.user.getCarne()){
                                        dispose();
                                        JFrame inicio = new JFrame();
                                        inicio.setTitle("INICIO");
                                        inicio.setSize(600,400);
                                        inicio.setLocationRelativeTo(null);
                                        inicio.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                            JPanel panel = new JPanel();
                                            panel.setLayout(null);
                                            panel.setBackground(Color.yellow);
                                            inicio.add(panel);
                                                JLabel iniciaste = new JLabel();
                                                iniciaste.setFont(new Font("Comic Sans MS",2,20));
                                                iniciaste.setForeground(Color.red);
                                                iniciaste.setBounds(150,0,600,320);
                                                iniciaste.setText("<html>HAS INICIADO SESION!! :D<br/>"
                                                +"Nombre: "+Tarea2.user.getNombre()+"<br/>"
                                                +"Apellido: "+Tarea2.user.getApellido()+"<br/>"
                                                +"Carnet: "+Tarea2.user.getCarne()+"</html>");
                                                    panel.add(iniciaste);
                                            inicio.setVisible(true);           
                                    }else{emergente.setText("   PASSWORD INCORRECTA");}
                                }else{emergente.setText("USUARIO NO ENCONTRADO");}
                        }catch(Exception e1){emergente.setText("       HUBO UN ERROR");}
                    }};
                boton.addActionListener(iniciarSesion);
                panel.add(boton);    
        setVisible(true);
    }
}

