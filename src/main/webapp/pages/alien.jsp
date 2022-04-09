<html>
<head><title>I'm the new Home!</title></head>
<body>
  <%
    double num = Math.random();
    if (num > 0.95) {
  %>
      <h2>new Home: Welcome: ${obj.aId}, ${obj.aName}, ${obj.lang}: You'll have a luck day!</h2><p>(<%= num %>)</p>
  <%
    } else {
  %>
      <h2>new Home: Welcome: ${obj.aId}, ${obj.aName}, ${obj.lang}: Well, life goes on ... </h2><p>(<%= num %>)</p>
  <%
    }
  %>
  <a href="<%= request.getRequestURI() %>"><h3>Try Again</h3></a>
</body>
</html>