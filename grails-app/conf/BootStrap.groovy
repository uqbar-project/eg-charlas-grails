import org.uqbar.Charla
import org.uqbar.Horario
import org.uqbar.Sala

class BootStrap {

    def init = { servletContext ->
		initSalas()
		initHorarios()
		initCharlas()
    }
	
    def destroy = {
    }
	
	void initSalas() {
		createSalaIfNotExists(new Sala(descripcion: "Aula Magna"))
		createSalaIfNotExists(new Sala(descripcion: "Auditorio"))
		createSalaIfNotExists(new Sala(descripcion: "Labo Rojo"))
		createSalaIfNotExists(new Sala(descripcion: "Labo Azul"))
		createSalaIfNotExists(new Sala(descripcion: "Labo Verde"))
	}

	void createSalaIfNotExists(Sala sala) {
		Sala salaPosta = Sala.findByDescripcion(sala.descripcion)
		if (!salaPosta) {
			sala.save(failOnError: true)
		}
	}

	void initHorarios() {
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "14:30", fin: "15:15"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "15:15", fin: "16:00"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "16:00", fin: "16:45"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "17:15", fin: "18:00"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "18:00", fin: "18:30"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "18:30", fin: "19:00"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "19:30", fin: "20:15"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "20:15", fin: "21:00"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 28), inicio: "21:00", fin: "21:45"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "10:00", fin: "10:40"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "10:40", fin: "11:10"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "11:40", fin: "12:10"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "12:10", fin: "12:50"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "14:00", fin: "14:40"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "14:40", fin: "15:15"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "15:15", fin: "15:45"))
		createHorarioIfNotExists(new Horario(fecha: new Date(114, 10, 29), inicio: "16:15", fin: "17:00"))
	}

	void createHorarioIfNotExists(Horario horario) {
		Horario horarioPosta = Horario.findByInicio(horario.inicio)
		if (!horarioPosta) {
			horario.save(failOnError: true)
		}
	}

	void initCharlas() {
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("14:30"), titulo: "Experiencias de la construcción de una carrera de programación", oradores: "Pablo Martínez López"))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("15:15"), titulo: "Pleasy Web: Inclusión Digital", oradores: "Alan Szpigiel, Guido Kuznicki, Nicolás Kovalsky y Emmanuel Schönfeld", favorita: true))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("16:00"), titulo: "Computadora Industrial Abierta Argentina (CIAA)", oradores: "Ariel Lutenberg y Pablo Ridolfi"))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("17:15"), titulo: "Desarrollo de videojuegos con pilas-engine", oradores: "Hugo Ruscitti", favorita: true))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("18:00"), titulo: "Escalar sin antecedentes - Una Aventura de Microservicios", oradores: "Pablo González y Marcelo Mendoza"))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("18:30"), titulo: "Utilización de NoSQL para resolución de problemas al trabajar con cantidades masivas de datos", oradores: "Giovanni Róttoli, Marcelo López Nocer y Ma Florencia Pollo-Cattaneo"))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("19:30"), titulo: "En camino hacia Java 8", oradores: "Gisela Decuzzi y Lucas Giudice"))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("20:15"), titulo: "Poné Node.js en la nube", oradores: "Johnny Halife", favorita: true))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("21:00"), titulo: "Un sistema para 500 millones de inversiones", oradores: "Daniel Altman", favorita: true))
		createCharlaIfNotExists(new Charla(sala: getSala("Aula Magna"), horario: getHorario("21:00"), titulo: "Un sistema para 500 millones de inversiones", oradores: "Daniel Altman", favorita: true))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("14:30"), titulo: "Tutorial en Apache Spark: Clasificando tweets en realtime", oradores: "Gustavo Arjones"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("15:15"), titulo: "Tutorial en Apache Spark: Clasificando tweets en realtime", oradores: "Gustavo Arjones"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("16:00"), titulo: "Tutorial en Apache Spark: Clasificando tweets en realtime", oradores: "Gustavo Arjones"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("17:15"), titulo: "Web app moderna utilizando stack MEAN", oradores: "Federico Aloi"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("18:00"), titulo: "Web app moderna utilizando stack MEAN", oradores: "Federico Aloi"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Rojo"), horario: getHorario("18:30"), titulo: "Web app moderna utilizando stack MEAN", oradores: "Federico Aloi"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("14:30"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("15:15"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("16:00"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("17:15"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("18:00"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
		createCharlaIfNotExists(new Charla(sala: getSala("Labo Azul"), horario: getHorario("18:30"), titulo: "How I met your Android", oradores: "Matías Dumrauf"))
	}

	Horario getHorario(String inicio) {
		Horario.findByInicio(inicio)
	}
	
	Sala getSala(String descripcion) {
		Sala.findByDescripcion(descripcion)
	}

	void createCharlaIfNotExists(Charla charla) {
		List charlas = Charla.createCriteria().list {
			createAlias("horario", "horario")
			eq("titulo", charla.titulo)
			eq("horario.inicio", charla.inicio)
		}
		if (charlas.isEmpty()) {
			charla.save(failOnError: true)
		}
	}

}
