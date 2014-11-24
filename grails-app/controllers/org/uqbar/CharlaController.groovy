package org.uqbar



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class CharlaController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Charla.list(params), model:[charlaInstanceCount: Charla.count()]
    }

    def show(Charla charlaInstance) {
        respond charlaInstance
    }

    def create() {
        respond new Charla(params)
    }

    @Transactional
    def save(Charla charlaInstance) {
        if (charlaInstance == null) {
            notFound()
            return
        }

        if (charlaInstance.hasErrors()) {
            respond charlaInstance.errors, view:'create'
            return
        }

        charlaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'charla.label', default: 'Charla'), charlaInstance.id])
                redirect charlaInstance
            }
            '*' { respond charlaInstance, [status: CREATED] }
        }
    }

    def edit(Charla charlaInstance) {
        respond charlaInstance
    }

    @Transactional
    def update(Charla charlaInstance) {
        if (charlaInstance == null) {
            notFound()
            return
        }

        if (charlaInstance.hasErrors()) {
            respond charlaInstance.errors, view:'edit'
            return
        }

        charlaInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Charla.label', default: 'Charla'), charlaInstance.id])
                redirect charlaInstance
            }
            '*'{ respond charlaInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Charla charlaInstance) {

        if (charlaInstance == null) {
            notFound()
            return
        }

        charlaInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Charla.label', default: 'Charla'), charlaInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'charla.label', default: 'Charla'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
