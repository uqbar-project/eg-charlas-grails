<%@ page import="org.uqbar.Horario" %>



<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'fecha', 'error')} required">
	<label for="fecha">
		<g:message code="horario.fecha.label" default="Fecha" />
		<span class="required-indicator">*</span>
	</label>
	<g:datePicker name="fecha" precision="day"  value="${horarioInstance?.fecha}"  />

</div>

<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'fin', 'error')} required">
	<label for="fin">
		<g:message code="horario.fin.label" default="Fin" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="fin" required="" value="${horarioInstance?.fin}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: horarioInstance, field: 'inicio', 'error')} required">
	<label for="inicio">
		<g:message code="horario.inicio.label" default="Inicio" />
		<span class="required-indicator">*</span>
	</label>
	<g:textField name="inicio" required="" value="${horarioInstance?.inicio}"/>

</div>

