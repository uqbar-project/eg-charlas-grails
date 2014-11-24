<%@ page import="org.uqbar.Charla" %>



<div class="fieldcontain ${hasErrors(bean: charlaInstance, field: 'oradores', 'error')} ">
	<label for="oradores">
		<g:message code="charla.oradores.label" default="Oradores" />
		
	</label>
	<g:textField name="oradores" maxlength="200" value="${charlaInstance?.oradores}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: charlaInstance, field: 'titulo', 'error')} required">
	<label for="titulo">
		<g:message code="charla.titulo.label" default="Titulo" />
		<span class="required-indicator">*</span>
	</label>
	<g:textArea name="titulo" cols="40" rows="5" maxlength="512" required="" value="${charlaInstance?.titulo}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: charlaInstance, field: 'favorita', 'error')} ">
	<label for="favorita">
		<g:message code="charla.favorita.label" default="Favorita" />
		
	</label>
	<g:checkBox name="favorita" value="${charlaInstance?.favorita}" />

</div>

<div class="fieldcontain ${hasErrors(bean: charlaInstance, field: 'horario', 'error')} required">
	<label for="horario">
		<g:message code="charla.horario.label" default="Horario" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="horario" name="horario.id" from="${org.uqbar.Horario.list()}" optionKey="id" required="" value="${charlaInstance?.horario?.id}" class="many-to-one"/>

</div>

<div class="fieldcontain ${hasErrors(bean: charlaInstance, field: 'sala', 'error')} required">
	<label for="sala">
		<g:message code="charla.sala.label" default="Sala" />
		<span class="required-indicator">*</span>
	</label>
	<g:select id="sala" name="sala.id" from="${org.uqbar.Sala.list()}" optionKey="id" required="" value="${charlaInstance?.sala?.id}" class="many-to-one"/>

</div>

