package org.uqbar



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class HorarioController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Horario.list(params), model:[horarioInstanceCount: Horario.count()]
    }

    def show(Horario horarioInstance) {
        respond horarioInstance
    }

    def create() {
        respond new Horario(params)
    }

    @Transactional
    def save(Horario horarioInstance) {
        if (horarioInstance == null) {
            notFound()
            return
        }

        if (horarioInstance.hasErrors()) {
            respond horarioInstance.errors, view:'create'
            return
        }

        horarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'horario.label', default: 'Horario'), horarioInstance.id])
                redirect horarioInstance
            }
            '*' { respond horarioInstance, [status: CREATED] }
        }
    }

    def edit(Horario horarioInstance) {
        respond horarioInstance
    }

    @Transactional
    def update(Horario horarioInstance) {
        if (horarioInstance == null) {
            notFound()
            return
        }

        if (horarioInstance.hasErrors()) {
            respond horarioInstance.errors, view:'edit'
            return
        }

        horarioInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Horario.label', default: 'Horario'), horarioInstance.id])
                redirect horarioInstance
            }
            '*'{ respond horarioInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Horario horarioInstance) {

        if (horarioInstance == null) {
            notFound()
            return
        }

        horarioInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Horario.label', default: 'Horario'), horarioInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'horario.label', default: 'Horario'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
