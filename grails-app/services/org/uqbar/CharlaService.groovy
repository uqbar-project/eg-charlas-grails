package org.uqbar

import grails.transaction.Transactional

@Transactional
class CharlaService {

	static transactional = false
	
	@Transactional(readOnly = true)
    def getCharlas(Date unaFecha) {
		Charla.createCriteria().list {
			createAlias("horario", "horario")
			eq("horario.fecha", unaFecha)
		}
    }
	
	@Transactional(readOnly = true)
	def getSalas() {
		Sala.list()
	}

	@Transactional(readOnly = true)
	def salasOcupadas(Date unaFecha) {
		Charla.createCriteria().list {
			createAlias("horario", "horario")
			eq("horario.fecha", unaFecha)
		}.collect { it.sala }.unique()
	}

	@Transactional(readOnly = true)
	def getHorarios(Date unaFecha) {
		Horario.findAllByFecha(unaFecha)
	}
	
}
