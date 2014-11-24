package org.uqbar

class Charla {

	Horario horario
	Sala sala
	String titulo
	String oradores
	boolean favorita = false

	static constraints = {
		oradores(nullable: true, maxSize: 200)
		titulo(maxSize: 512)
	}
	
	String toString() {
		titulo
	}
}
