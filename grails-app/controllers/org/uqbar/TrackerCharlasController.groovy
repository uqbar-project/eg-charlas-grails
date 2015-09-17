package org.uqbar

class TrackerCharlasController {

	def charlaService
	
    def index() {
		Date unaFecha = new Date(114,10,28)
		
		def mapaCharlas = [:]
		// Inicializamos el mapa de charlas por horario para facilitar la posterior transformación
		def horarios = charlaService.getHorarios(unaFecha)
		horarios.each { horario -> mapaCharlas[horario] = [:] }
		
		// Transformación de charlas -> mapa[horario|sala]=>charla
		charlaService.getCharlas(unaFecha).each {
			charla -> 
				def horarioCharlas = mapaCharlas[charla.horario]
				horarioCharlas[charla.sala] = charla
		}

		[ mapaCharlas: mapaCharlas, salas: charlaService.salas,
			//charlaService.salasOcupadas(unaFecha), 
			horarios: horarios ]		
	}
	
	def favoritearCharla(Charla charla) {
//		def idCharla = params.id as Integer
//		Charla charla = charlaService.getCharla(idCharla)
		if (!charla) {
			throw new RuntimeException("No se encontró una charla con identificador " + idCharla)
		}
		charla.favoritear()
		charlaService.updateCharla(charla)
		flash.message = "Se marcó la charla como favorita"
		redirect (action: "index")
	}
	
}