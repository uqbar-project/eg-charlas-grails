
<%@ page import="org.uqbar.Charla" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'charla.label', default: 'Charla')}" />
		<title><g:message code="default.show.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#show-charla" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]" /></g:link></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="show-charla" class="content scaffold-show" role="main">
			<h1><g:message code="default.show.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
			<div class="message" role="status">${flash.message}</div>
			</g:if>
			<ol class="property-list charla">
			
				<g:if test="${charlaInstance?.oradores}">
				<li class="fieldcontain">
					<span id="oradores-label" class="property-label"><g:message code="charla.oradores.label" default="Oradores" /></span>
					
						<span class="property-value" aria-labelledby="oradores-label"><g:fieldValue bean="${charlaInstance}" field="oradores"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${charlaInstance?.titulo}">
				<li class="fieldcontain">
					<span id="titulo-label" class="property-label"><g:message code="charla.titulo.label" default="Titulo" /></span>
					
						<span class="property-value" aria-labelledby="titulo-label"><g:fieldValue bean="${charlaInstance}" field="titulo"/></span>
					
				</li>
				</g:if>
			
				<g:if test="${charlaInstance?.favorita}">
				<li class="fieldcontain">
					<span id="favorita-label" class="property-label"><g:message code="charla.favorita.label" default="Favorita" /></span>
					
						<span class="property-value" aria-labelledby="favorita-label"><g:formatBoolean boolean="${charlaInstance?.favorita}" /></span>
					
				</li>
				</g:if>
			
				<g:if test="${charlaInstance?.horario}">
				<li class="fieldcontain">
					<span id="horario-label" class="property-label"><g:message code="charla.horario.label" default="Horario" /></span>
					
						<span class="property-value" aria-labelledby="horario-label"><g:link controller="horario" action="show" id="${charlaInstance?.horario?.id}">${charlaInstance?.horario?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
				<g:if test="${charlaInstance?.sala}">
				<li class="fieldcontain">
					<span id="sala-label" class="property-label"><g:message code="charla.sala.label" default="Sala" /></span>
					
						<span class="property-value" aria-labelledby="sala-label"><g:link controller="sala" action="show" id="${charlaInstance?.sala?.id}">${charlaInstance?.sala?.encodeAsHTML()}</g:link></span>
					
				</li>
				</g:if>
			
			</ol>
			<g:form url="[resource:charlaInstance, action:'delete']" method="DELETE">
				<fieldset class="buttons">
					<g:link class="edit" action="edit" resource="${charlaInstance}"><g:message code="default.button.edit.label" default="Edit" /></g:link>
					<g:actionSubmit class="delete" action="delete" value="${message(code: 'default.button.delete.label', default: 'Delete')}" onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');" />
				</fieldset>
			</g:form>
		</div>
	</body>
</html>
