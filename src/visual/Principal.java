package visual;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import visual.Formulario;

public class Principal extends JFrame  {
	
	public static void main(String[] args) {
		Formulario login= new Formulario (); // Aca creo formulario y hago la plantilla inicial 
		login.setBounds(465, 125,350, 300); //defino ubicacion - tama�o 
		login.setTitle("Login");
		login.setVisible(true); //lo hago viisble 
		login.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}	
}
