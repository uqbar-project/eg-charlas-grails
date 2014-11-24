package org.uqbar

class Sala {

	String descripcion
	
    static constraints = {
		descripcion(size:1..40)
    }
	
	String toString() {
		descripcion
	}
	
}
