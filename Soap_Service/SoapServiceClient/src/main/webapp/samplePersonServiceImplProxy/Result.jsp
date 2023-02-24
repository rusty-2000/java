<%@page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<HTML>
<HEAD>
<TITLE>Result</TITLE>
</HEAD>
<BODY>
<H1>Result</H1>

<jsp:useBean id="samplePersonServiceImplProxyid" scope="session" class="com.bhavna.service.PersonServiceImplProxy" />
<%
if (request.getParameter("endpoint") != null && request.getParameter("endpoint").length() > 0)
samplePersonServiceImplProxyid.setEndpoint(request.getParameter("endpoint"));
%>

<%
String method = request.getParameter("method");
int methodID = 0;
if (method == null) methodID = -1;

if(methodID != -1) methodID = Integer.parseInt(method);
boolean gotMethod = false;

try {
switch (methodID){ 
case 2:
        gotMethod = true;
        java.lang.String getEndpoint2mtemp = samplePersonServiceImplProxyid.getEndpoint();
if(getEndpoint2mtemp == null){
%>
<%=getEndpoint2mtemp %>
<%
}else{
        String tempResultreturnp3 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(getEndpoint2mtemp));
        %>
        <%= tempResultreturnp3 %>
        <%
}
break;
case 5:
        gotMethod = true;
        String endpoint_0id=  request.getParameter("endpoint8");
            java.lang.String endpoint_0idTemp = null;
        if(!endpoint_0id.equals("")){
         endpoint_0idTemp  = endpoint_0id;
        }
        samplePersonServiceImplProxyid.setEndpoint(endpoint_0idTemp);
break;
case 10:
        gotMethod = true;
        com.bhavna.service.PersonServiceImpl getPersonServiceImpl10mtemp = samplePersonServiceImplProxyid.getPersonServiceImpl();
if(getPersonServiceImpl10mtemp == null){
%>
<%=getPersonServiceImpl10mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
</TABLE>
<%
}
break;
case 15:
        gotMethod = true;
        String id_1id=  request.getParameter("id18");
        int id_1idTemp  = Integer.parseInt(id_1id);
        boolean deletePerson15mtemp = samplePersonServiceImplProxyid.deletePerson(id_1idTemp);
        String tempResultreturnp16 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(deletePerson15mtemp));
        %>
        <%= tempResultreturnp16 %>
        <%
break;
case 20:
        gotMethod = true;
        com.bhavna.bean.Person[] getAllPersons20mtemp = samplePersonServiceImplProxyid.getAllPersons();
if(getAllPersons20mtemp == null){
%>
<%=getAllPersons20mtemp %>
<%
}else{
        String tempreturnp21 = null;
        if(getAllPersons20mtemp != null){
        java.util.List listreturnp21= java.util.Arrays.asList(getAllPersons20mtemp);
        tempreturnp21 = listreturnp21.toString();
        }
        %>
        <%=tempreturnp21%>
        <%
}
break;
case 23:
        gotMethod = true;
        String age_3id=  request.getParameter("age28");
        int age_3idTemp  = Integer.parseInt(age_3id);
        String name_4id=  request.getParameter("name30");
            java.lang.String name_4idTemp = null;
        if(!name_4id.equals("")){
         name_4idTemp  = name_4id;
        }
        String id_5id=  request.getParameter("id32");
        int id_5idTemp  = Integer.parseInt(id_5id);
        %>
        <jsp:useBean id="com1bhavna1bean1Person_2id" scope="session" class="com.bhavna.bean.Person" />
        <%
        com1bhavna1bean1Person_2id.setAge(age_3idTemp);
        com1bhavna1bean1Person_2id.setName(name_4idTemp);
        com1bhavna1bean1Person_2id.setId(id_5idTemp);
        boolean addPerson23mtemp = samplePersonServiceImplProxyid.addPerson(com1bhavna1bean1Person_2id);
        String tempResultreturnp24 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(addPerson23mtemp));
        %>
        <%= tempResultreturnp24 %>
        <%
break;
case 34:
        gotMethod = true;
        String id_6id=  request.getParameter("id43");
        int id_6idTemp  = Integer.parseInt(id_6id);
        com.bhavna.bean.Person getPerson34mtemp = samplePersonServiceImplProxyid.getPerson(id_6idTemp);
if(getPerson34mtemp == null){
%>
<%=getPerson34mtemp %>
<%
}else{
%>
<TABLE>
<TR>
<TD COLSPAN="3" ALIGN="LEFT">returnp:</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">age:</TD>
<TD>
<%
if(getPerson34mtemp != null){
%>
<%=getPerson34mtemp.getAge()
%><%}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">name:</TD>
<TD>
<%
if(getPerson34mtemp != null){
java.lang.String typename39 = getPerson34mtemp.getName();
        String tempResultname39 = org.eclipse.jst.ws.util.JspUtils.markup(String.valueOf(typename39));
        %>
        <%= tempResultname39 %>
        <%
}%>
</TD>
<TR>
<TD WIDTH="5%"></TD>
<TD COLSPAN="2" ALIGN="LEFT">id:</TD>
<TD>
<%
if(getPerson34mtemp != null){
%>
<%=getPerson34mtemp.getId()
%><%}%>
</TD>
</TABLE>
<%
}
break;
}
} catch (Exception e) { 
%>
Exception: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.toString()) %>
Message: <%= org.eclipse.jst.ws.util.JspUtils.markup(e.getMessage()) %>
<%
return;
}
if(!gotMethod){
%>
result: N/A
<%
}
%>
</BODY>
</HTML>