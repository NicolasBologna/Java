package entidades;

import java.util.ArrayList;

public class Cliente {
 
	String Usuario;
	String Clave;
	String NroCajaAhorro;
	Double SaldoCajaAhorro;
	String NroCtaCte;
	Double SaldoCtaCte;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}
	
	public Cliente (String _Usuario, String _Clave , String _NroCajaAhorro ,Double _SaldoCajaAhorro, String _NroCtaCte , Double _SaldoCtaCte) { //Metodo constructor
	Usuario = _Usuario;
	Clave = _Clave;
	NroCajaAhorro = _NroCajaAhorro;
	SaldoCajaAhorro = _SaldoCajaAhorro;
	NroCtaCte = _NroCtaCte;
	SaldoCtaCte = _SaldoCtaCte;
	
	
		
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getClave() {
		return Clave;	
	}
	public void setClave(String clave) {
		Clave = clave;
	}
	public String getNroCajaAhorro() {
		return NroCajaAhorro;
	}
	public void setNroCajaAhorro(String nroCajaAhorro) {
		NroCajaAhorro = nroCajaAhorro;
	}
	public String getNroCtaCte() {
		return NroCtaCte;
	}
	public void setNroCtaCte(String nroCtaCte) {
		NroCtaCte = nroCtaCte;
	}
	public double getSaldoCajaAhorro() {
		return SaldoCajaAhorro;
	}
	public void setSaldoCajaAhorro(double saldoCajaAhorro) {
		SaldoCajaAhorro = saldoCajaAhorro;
	}
	public double getSaldoCtaCte() {
		return SaldoCtaCte;
	}
	public void setSaldoCtaCte(double saldoCtaCte) {
		SaldoCtaCte = saldoCtaCte;
	}
	

	
}
