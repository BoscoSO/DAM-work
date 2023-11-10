/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compoñentespersonalizados;
import java.io.File;
import java.io.Serializable;

public class ImaxeFondo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private File ruta;
	private Float opacidade;

	public ImaxeFondo(File ruta, Float opacidade) {
		this.ruta = ruta;
		this.opacidade = opacidade;
	}
	
	public File getRuta() {
		return ruta;
	}
	public void setRuta(File ruta) {
		this.ruta = ruta;
	}
	public Float getOpacidade() {
		return opacidade;
	}
	public void setOpacidade(Float opacidade) {
		this.opacidade = opacidade;
	} 
	
	
}
