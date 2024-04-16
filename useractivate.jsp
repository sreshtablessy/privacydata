<%@page import="Efficient.BlockchainDemo"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="attributebased.Dbconnection"%>
<%
String mail=request.getQueryString();

Connection con=Dbconnection.getConnection();
    
  System.out.println("Database connected");
  
  Statement st=con.createStatement();
  BlockchainDemo bdemo = new BlockchainDemo();
        int bk = bdemo.blockchainkey(mail);
         System.out.println("ddddddddddddddddddddddddddddddddddd" + bk);
  
  ResultSet rs=st.executeQuery("select * from user where email='"+mail+"'");
  if(rs.next()){
  int i=st.executeUpdate("update user set status='Activated',status1='"+bk+"' where email='"+mail+"'");
  if(i!=0){
  response.sendRedirect("viewusers.jsp?useracti=activated");
  }
    
   else{
      System.out.println("error");
   }}
    
%>