package visual;

import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import entidades.Cliente;
import visual.Formulario;


public class Menu extends JFrame   {
JLabel Menuu,cuenta,Bienv,SaldoI,SaldoII;
JRadioButton ItemI, ItemII;
JButton BotonI, BotonII,BotonIII,BotonIV,BotonV;
Double monto,Transf;
String m,opc,Usuario;
int OPC;
DecimalFormat df = new DecimalFormat("#.00"); // Limita los decimales
ButtonGroup grupo1 = new ButtonGroup(); // Restringir seleccion
	
	public Menu (Cliente c, ArrayList<Cliente> clientes) {
		
		setLayout(null);
		this.getContentPane().setBackground(Color.RED);
		cuenta= new JLabel("         Tipo de cuenta");
		cuenta.setBounds(5, 10, 150,20);
		cuenta.setOpaque(true);
		cuenta.setBackground(Color.black);
		cuenta.setForeground(Color.red);
		add(cuenta);
		Menuu= new JLabel("       Menu de operaci�nes");
		Menuu.setBounds(5, 130, 150,20);
		Menuu.setOpaque(true);
		Menuu.setBackground(Color.black);
		Menuu.setForeground(Color.red);
		add(Menuu);
		Bienv= new JLabel("Bienvenido "+c.getUsuario()+"");
		Bienv.setBounds(250, 10, 390,20);
		Bienv.setOpaque(true);
		Bienv.setBackground(Color.black);
		Bienv.setForeground(Color.red);
		add(Bienv);
		ItemI= new JRadioButton("Caja de ahorro");
		ItemI.setBounds(5, 30, 150, 30);
		ItemI.setBackground(Color.LIGHT_GRAY);
		add(ItemI);
		ItemII= new JRadioButton("Cuenta corriente");
		ItemII.setBounds(5, 60, 150, 30);
		ItemII.setBackground(Color.LIGHT_GRAY);
		add(ItemII);
		grupo1.add(ItemI);
		grupo1.add(ItemII);
		BotonI= new JButton("Solicitar Saldo");
		BotonI.setBounds(5, 150, 150, 30);
		add(BotonI);
		BotonII = new JButton("Transferencia");
		BotonII.setBounds(5, 180, 150, 30);
		add(BotonII);
		BotonIV = new JButton("Deposito");
		BotonIV.setBounds(5, 210, 150, 30);
		add(BotonIV);
		BotonV = new JButton("Extraccion");
		BotonV.setBounds(5, 240, 150, 30);
		add(BotonV);
		BotonIII = new JButton("Cerrar sesion");
		BotonIII.setBounds(5, 300, 150, 30);
		add(BotonIII);
		
		BotonI.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (ItemI.isSelected() ) { //radiobutton mejor
					JOptionPane.showMessageDialog(null, "El saldo de su Caja de ahorro es de: $ "+c.getSaldoCajaAhorro()+"");
				} 
				if (ItemII.isSelected()) {
					JOptionPane.showMessageDialog(null, "El saldo de su Cuenta Corriente es de: $ "+c.getSaldoCtaCte()+"");					
				}					
			}			
		});
		
		BotonII.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {	
				OPC= Integer.valueOf(JOptionPane.showInputDialog("Desea transferir a: \n 1- Caja de ahorro \n 2- Cuenta corriente"));
				int tipoCuenta = ItemI.isSelected() ? 1 : 2;//short IF
				transferir(tipoCuenta,OPC,c, clientes);
				
			}
		});
		
		BotonIII.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		BotonIV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (ItemI.isSelected() ) {
					m= JOptionPane.showInputDialog("Ingrese monto a depositar en su Caja de Ahorro");
					monto= Double.valueOf(m);
					c.setSaldoCajaAhorro((c.getSaldoCajaAhorro())+monto);
					JOptionPane.showMessageDialog(null, "Se deposito un monto total de "+monto+" a su caja de ahorro", "Deposito aprobado",JOptionPane.INFORMATION_MESSAGE);
				} 
	
				if (ItemII.isSelected() ) {
					m= JOptionPane.showInputDialog("Ingrese monto a depositar en su Cuenta Corrietne");
					monto= Double.valueOf(m);
					c.setSaldoCtaCte((c.getSaldoCtaCte()+monto));
					JOptionPane.showMessageDialog(null, "Se deposito un monto total de "+monto+" a su Cuenta corriente", "Deposito aprobado",JOptionPane.INFORMATION_MESSAGE);
				} 			
			}
		});
	 
		BotonV.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				if (ItemI.isSelected() ) {
					m= JOptionPane.showInputDialog("Ingrese monto a extraer de su Caja de Ahorro");
					monto= Double.valueOf(m);
					if (c.getSaldoCajaAhorro() < monto) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Extraccion cancelada", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						c.setSaldoCajaAhorro((c.getSaldoCajaAhorro())- monto);
						JOptionPane.showMessageDialog(null, "Se extrajo un monto total de "+monto+" de sucaja de ahorro", "Extraccion completada",JOptionPane.INFORMATION_MESSAGE);
					}
				} 
				if (ItemII.isSelected() ) {
					m= JOptionPane.showInputDialog("Ingrese monto a extraer de su Cuenta Corrietne");
					monto= Double.valueOf(m);
					if (c.getSaldoCtaCte() < monto) {
						JOptionPane.showMessageDialog(null, "Saldo insuficiente", "Extraccion cancelada", JOptionPane.ERROR_MESSAGE);
						
					}
					else {
						c.setSaldoCtaCte((c.getSaldoCtaCte()- monto));
						JOptionPane.showMessageDialog(null, "Se extrajo un monto total de "+monto+" de su Cuenta corriente", "Extraccion completada",JOptionPane.INFORMATION_MESSAGE);
					}
				} 
			}
		});		
	}   
	private void transferir(int tipoCuenta,int OPC,Cliente cliente,ArrayList<Cliente> clientes) {
		
		Usuario= JOptionPane.showInputDialog("Ingrese nombre de usuario");
		boolean BusquedaExitosa = false;
		int cont = 0;
		Cliente c2 = null;
		while (BusquedaExitosa==false && cont <clientes.size() ){					
			if (clientes.get(cont).getUsuario().equals(Usuario)) {
				c2 = clientes.get(cont);
				BusquedaExitosa=true ; 
		    }
			cont=cont +1;		
		}
		
		if (BusquedaExitosa==false) {
			JOptionPane.showMessageDialog(null, "Usuario no Encontrado");
		}
		else {
			boolean transfExitosa = false;
			Transf = Double.valueOf(JOptionPane.showInputDialog("Ingrese dinero a transferir"));
			if(tipoCuenta == 1) {
				if (cliente.getSaldoCajaAhorro() >= Transf) {
					cliente.setSaldoCajaAhorro(cliente.getSaldoCajaAhorro()-Transf);
					transfExitosa = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "No tiene fondos suficientes");
				}
			}
			else {
				
				if (cliente.getSaldoCtaCte() >= Transf) {
					cliente.setSaldoCtaCte(cliente.getSaldoCtaCte()-Transf);
					transfExitosa = true;
				}
				else {
					JOptionPane.showMessageDialog(null, "No tiene fondos suficientes");
				}
			}
			
			if (transfExitosa) {
				if (OPC == 1) {
					c2.setSaldoCajaAhorro(c2.getSaldoCajaAhorro() + Transf);
				}
				else {
					c2.setSaldoCtaCte(c2.getSaldoCajaAhorro() + Transf);
				}
			    JOptionPane.showMessageDialog(null, "Transferencia exitosa");
			}

		}
	}
}
