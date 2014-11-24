<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Charlas Uqbar</title>
	</head>
	<body>
		<table>
			<th>
				Horario
			</th>
			<g:each in="${salas}" var="sala">
				<th>
					${sala.descripcion}
				</th>
			</g:each>
			<g:each in="${horarios}" var="horario">
				<tr>
					<td>
						${horario.inicio}
					</td>
					<g:each in="${salas}" var="sala">
						<g:set var="charlasDeUnHorario" value="${mapaCharlas[horario]}"/>
						<g:set var="charla" value="${charlasDeUnHorario[sala]}"/>
						<td title="${charla?.oradores}">
							<g:if test="${charla?.favorita}">
								<b>${charla?.titulo}</b>
							</g:if>	
							<g:else>
								${charla?.titulo} 
							</g:else>
						</td>	
					</g:each>
				</tr>
			</g:each>
		</table>
	</body>
</html>
