
<%@ page import="org.uqbar.Charla" %>
<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<g:set var="entityName" value="${message(code: 'charla.label', default: 'Charla')}" />
		<title><g:message code="default.list.label" args="[entityName]" /></title>
	</head>
	<body>
		<a href="#list-charla" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
		<div class="nav" role="navigation">
			<ul>
				<li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
				<li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
			</ul>
		</div>
		<div id="list-charla" class="content scaffold-list" role="main">
			<h1><g:message code="default.list.label" args="[entityName]" /></h1>
			<g:if test="${flash.message}">
				<div class="message" role="status">${flash.message}</div>
			</g:if>
			<table>
			<thead>
					<tr>
					
						<g:sortableColumn property="oradores" title="${message(code: 'charla.oradores.label', default: 'Oradores')}" />
					
						<g:sortableColumn property="titulo" title="${message(code: 'charla.titulo.label', default: 'Titulo')}" />
					
						<g:sortableColumn property="favorita" title="${message(code: 'charla.favorita.label', default: 'Favorita')}" />
					
						<th><g:message code="charla.horario.label" default="Horario" /></th>
					
						<th><g:message code="charla.sala.label" default="Sala" /></th>
					
					</tr>
				</thead>
				<tbody>
				<g:each in="${charlaInstanceList}" status="i" var="charlaInstance">
					<tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
					
						<td><g:link action="show" id="${charlaInstance.id}">${fieldValue(bean: charlaInstance, field: "oradores")}</g:link></td>
					
						<td>${fieldValue(bean: charlaInstance, field: "titulo")}</td>
					
						<td><g:formatBoolean boolean="${charlaInstance.favorita}" /></td>
					
						<td>${fieldValue(bean: charlaInstance, field: "horario")}</td>
					
						<td>${fieldValue(bean: charlaInstance, field: "sala")}</td>
					
					</tr>
				</g:each>
				</tbody>
			</table>
			<div class="pagination">
				<g:paginate total="${charlaInstanceCount ?: 0}" />
			</div>
		</div>
	</body>
</html>
