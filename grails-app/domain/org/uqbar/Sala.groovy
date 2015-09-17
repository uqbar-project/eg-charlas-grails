package org.uqbar

class Sala {

	String descripcion = ""
	
    static constraints = {
		descripcion(size:1..40)
    }
	
	boolean equals(Object o) {
		try {
			this.descripcion.equals(o.descripcion)
		} catch (ClassCastException e) {
			false
		}
	}
	
	int hashCode() {
		descripcion.hashCode()
	}
	
	String toString() {
		descripcion
	}
	
}
