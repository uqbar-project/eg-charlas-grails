package org.uqbar

import java.text.SimpleDateFormat

class Horario {
	
	Date fecha
	String inicio
	String fin

	static constraints = {
	}
	
	String toString() {
		new SimpleDateFormat("dd/MM/yyyy").format(fecha) + " " + inicio + " a " + fin
	}
	
}
