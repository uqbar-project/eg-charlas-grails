package org.uqbar

class TrackerCharlasController {

	def charlaService
	
    def index() { 
		Date unaFecha = new Date(114,10,28)
		
		def mapaCharlas = [:]
		// Inicializamos las charlas
		def horarios = charlaService.getHorarios(unaFecha)
		horarios.each { horario -> mapaCharlas[horario] = generarMapaSalas() }
		
		charlaService.getCharlas(unaFecha).each {
			charla -> 
				def horarioCharlas = mapaCharlas[charla.horario]
				horarioCharlas[charla.sala] = charla
		}
		
		[ mapaCharlas: mapaCharlas, salas: charlaService.salasOcupadas(unaFecha), horarios: horarios ]		
	}
	
	def generarMapaSalas() {
		def mapaSalas = [:]
		charlaService.salas.each { mapaSalas[it] = null }
		mapaSalas
	}
	
}