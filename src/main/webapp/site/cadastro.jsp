<html >
	<head>
		<title>OiSul - Planos empresariais da operadora Oi</title>
		<%@include file="includes.jsp"%> 
    </head>
	<body>
		<div id="site">
			<%@include file="cabecalho.jsp" %>
 			<div id="conteudo">
			 	<div id="corpo">
			 	<h2>Cadastro de usuários</h2>
			 		<form action="salvarUsuarioSite" method="Post" >
				 			<input type="hidden" name="usuario.idUsuario" />
				 		<table width="800px">
				 			<tr>
				 				<td class="label">Nome:</td>
				 				<td><input class="form-control" type="text" name="usuario.nome"placeholder="Nome" ng-required="true"></td>
				 			</tr>
				 			<tr>
				 				<td class="label">E-mail:</td>
				 				<td><input class="form-control" type="text" name="usuario.email"  placeholder="E-mail" ng-required="true"></td>
				 			</tr>
				 			<tr>
				 				<td class="label">Senha:</td>
				 				<td><input class="form-control" type="password" name="usuario.senha"  placeholder="8-16 caracteres" ng-required="true"></td>
				 			</tr>
				 			<tr>
				 				<td class="label">Telefone:</td>
				 				<td>
				 					<input class="form-control floatLeft" style="width: 50px;" type="text" name="usuario.ddd"  placeholder="00" ng-required="true">
				 					<input class="form-control" type="text" name="usuario.telefone" placeholder="0000-0000" ng-required="true" style="width: 120px;">
				 				</td>
				 			</tr>
				 		</table>
						<br>
						<p class="alignCenter">
							<input type="submit"  class="btn btn-primary"  title="Confirmar Cadastro" />
						</p>
			 		</form>
			 	</div>
			 </div>
			<%@include file="rodape.jsp" %>  
		</div>
	</body>
</html>
