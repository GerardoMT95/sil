<%@ page contentType="text/html;charset=utf-8"%>
<%@ taglib uri="aftags" prefix="af" %>
<%@ include file="../global/noCaching.inc" %>
<%@ include file="../global/getCommonObjects.inc" %>

<%@ page import=" com.engiweb.framework.base.*,
                  com.engiweb.framework.dispatching.module.AbstractModule,
                  
                  com.engiweb.framework.util.QueryExecutor,
                  it.eng.sil.security.*,
                  it.eng.sil.util.*,
                  it.eng.afExt.utils.*,
                  java.util.*,
                  java.math.*,
                  java.io.*,
                  com.engiweb.framework.security.*" %>

<%@ page extends="com.engiweb.framework.dispatching.httpchannel.AbstractHttpJspPage" %>

<%
  String htmlStreamTop = StyleUtils.roundTopTable(false);
  String htmlStreamBottom = StyleUtils.roundBottomTable(false);
  String _funzione = (String) serviceRequest.getAttribute("cdnfunzione");
  String aggFunz = (String) serviceRequest.getAttribute("AGG_FUNZ");
%>
<html>

<head>
<title>Ricerca Azienda</title>
<link rel="stylesheet" href="../../css/stili.css" type="text/css">
<af:linkScript path="../../js/"/>    

</head>
<body class="gestione" onload="">
<p class="titolo">Ricerca di un'Azienda</p>
<p align="center">

<af:form method="POST" action="AdapterHTTP">
<input type="hidden" name="PAGE" value="IdoListAziendePage"/> 
<input type="hidden" name="AGG_FUNZ" value="<%=aggFunz%>"/>  
<input type="hidden" name="cdnFunzione" value="<%=_funzione%>"/>  

  <%= htmlStreamTop %>
  <table class="main">
      <tr>
        <td class="etichetta">Codice Fiscale</td>
        <td class="campo">
          <af:textBox type="text" name="cf_ric" size="20" maxlength="16"/>
        </td>
      </tr>
      <tr>
        <td class="etichetta">Partita IVA</td>
        <td class="campo">
          <af:textBox type="text" name="piva_ric" value="" size="20" maxlength="11"/>
        </td>
      </tr>
      <tr>
        <td class="etichetta">Ragione Sociale</td>
        <td class="campo">
          <af:textBox type="text" name="ragsoc_ric" value="" size="20" maxlength="100"/>
        </td>
      </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    <tr>
      <td colspan="2" align="center">
        <span class="bottoni">
	      <input class="pulsanti" type="submit" name="cerca" value="Cerca"/>
	      &nbsp;&nbsp;
	      <input class="pulsanti" type="reset" name="reset" value="Annulla"/>
		</span>
      </td>
    </tr>
    <tr><td colspan="2">&nbsp;</td></tr>
    <tr>
      <td colspan="2">
	      <span class="bottoni">
	        <input type="button" class="pulsanti" value="Chiudi" onClick="window.close();" />
	      </span>
      </td>
    </tr>
  </table>
  <%= htmlStreamBottom %> 
</af:form>
</p>

</body>
</html>
