package visual;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import entidades.Cliente;

public class Formulario extends JFrame {
	JButton Ingreso,Registro,Finalizar; //defino al boton como JButton
	JLabel  txtU, TXTp;
	JTextField Campo1;
	JPasswordField Campo2;
	boolean LogueoExitoso = false;
	boolean Error = false;
	int error= 0;
	ArrayList<Cliente> clientes= new ArrayList<Cliente>(); //declaro aca la arraylist porque es una variable de clase, y el constructor inicializa en base a esto
	
	public Formulario() { // creo un metodo ppublico llamado formulario, aca agrego tooooodo lo extra , SERIA UN CONSTRUCTOR
		clientes.add(new Cliente("lucasguerr7","lucasgue","4595828",100.0,"645646",50.0));
		clientes.add(new Cliente("francoguerr7","francogu","4239384",200.00,"649222",100.0));
		clientes.add(new Cliente("Javierguerr7", "87654321","334293",90435.70,"342938",7645.50));
		clientes.add(new Cliente("CarinaSan7","12345678","4382364",56483.50,"448373",33344.60));
		
		setLayout(null);
		this.getContentPane().setBackground(Color.lightGray);
		txtU = new JLabel("Usuario"); // 1) creo un texto , 2) lo ubico y 3) lo agrego 
		txtU.setBounds(4, -15,100, 100);
		add(txtU);
		TXTp = new JLabel("Password");
		TXTp.setBounds(4, 30,100, 100);
		add(TXTp);
		Campo1 = new JTextField ();
		Campo1.setBounds(70, 20, 150, 30);
		add(Campo1);
		Campo2 = new JPasswordField();
		Campo2.setBounds(70, 65, 150, 30);
		add(Campo2);
		Ingreso= new JButton("Iniciar sesion");
		Registro = new JButton("Crear cuenta");
		Finalizar = new JButton ("Cancelar");
		Ingreso.setBounds(45, 150, 125, 30);  //Lo ubico porque si no no me aparece
		Finalizar.setBounds(185,150,125,30);
		add(Ingreso);
		add(Finalizar);
		Finalizar.addActionListener( new ActionListener() {	
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		Ingreso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				validarDatos(); //invoco metodo validar datos
			}
		});
	}
	
	public void validarDatos() {
		try {
			char [] passwor = Campo2.getPassword(); // Asigno el valor ingresado en el campo2 a una variable password . 
		    String password = String.valueOf(passwor); //cambio de char a string .
			String usuario = Campo1.getText(); // asigno el valor ingresado en el campo 1 a una variable usuario.  ;
			int contador = 0;
			
			if (usuario.equals("")|| password.equals("")) {
				JOptionPane.showMessageDialog(null, "Complete todos los campos para proceder");
				Error= true; //es un Booleano para ir determinando cuando entrar o no en el while 
			}
			else{
				if (usuario.length() <8 || usuario.length()>20) {
					JOptionPane.showMessageDialog(null, "El usuario debe contener entre 8 y 20 caracteres");
					Error= true;
				} 
				else {
					if (password.length()!=8) {
						JOptionPane.showMessageDialog(null, "El PIN es de 8 digitos");
						Error= true;
					}
					else {
						Error= false;
					}
				}
			}
			while (LogueoExitoso== false && contador <= clientes.size() && Error== false) {
				if (clientes.get(contador).getUsuario().equals(usuario) && clientes.get(contador).getClave().equals(password)) {
					LogueoExitoso= true;
					Cliente c = clientes.get(contador);
					error=0;
					Campo1.setText("");
					Campo2.setText("");
					Menu menu= new Menu (c,clientes); // Aca creo menu y hago la plantilla inicial 
					menu.setBounds(465, 125,650, 400); //defino ubicacion - tama�o 
					menu.setVisible(true); //lo hago viisble 
					menu.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
					menu.setTitle("Menu de operaciones");
				}
				contador = contador+1;	
			}
			LogueoExitoso= false;
			contador = 0;
		}
		catch (Exception e2) {
			error = error +1;
			JOptionPane.showMessageDialog(null,"Usuario denegado quedan "+ (3-error) +" intentos","Erro de validacion",JOptionPane.ERROR_MESSAGE);
		}		
		if (error== 3) {
			JOptionPane.showMessageDialog(null,"Maximo numero de intentos superado ","Acceso denegado",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}	
}
		
	
		
	
