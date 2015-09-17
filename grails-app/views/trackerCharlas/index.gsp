<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main">
		<title>Charlas Uqbar</title>
	</head>
	<body>
		<g:set var="porcentaje" value="${90 / salas.size()}"/>
		<table>
			<th style="width: 10%;">
				Horario
			</th>
			<g:each in="${salas}" var="sala">
				<th style="width: ${porcentaje}%;">
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
						<g:if test="${charla}">
							<td title="${charla?.oradores}">
								<g:if test="${charla?.favorita}">
									<b>${charla?.titulo}</b>
								</g:if>	
								<g:else>
									${charla?.titulo}
									<g:link alt="Marcar como favorita" id="${charla?.id}" action="favoritearCharla">
										<asset:image src="favorite.png" width="16" height="16"/>
									</g:link>
								</g:else>
							</td>
						</g:if>
						<g:else>
							<td style="background: #f2f2f2"/> 
						</g:else>
					</g:each>
				</tr>
			</g:each>
		</table>
	</body>
</html>
