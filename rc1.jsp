 <%@page import="attributebased.encryption"%>
<%@page import="com.sun.org.apache.xerces.internal.impl.dv.util.Base64"%>
<%@page import="javax.crypto.SecretKey"%>
<%@page import="javax.crypto.KeyGenerator"%>
<%@page import="java.sql.*"%>
<%@page import="attributebased.Dbconnection"%>
<%@ page session="true" %>
<%
   
    
    String filename = request.getParameter("filename");
       String owner = request.getParameter("owner");
         String status = null;
         
        String data = "";
        
       
       
       try{
       
       // String user=null;
        //String password=null;
	Class.forName("com.mysql.jdbc.Driver");	
        Connection co = DriverManager.getConnection("jdbc:mysql://localhost:3306/att","root","root");
        
        
         Statement st=co.createStatement();
 ResultSet rs=st.executeQuery("select * from file where filename='"+filename+"' and owner='"+owner+"' ");
  while(rs.next()){
      
      data =rs.getString(4);
      
  }
        
 KeyGenerator keyGen = KeyGenerator.getInstance("AES");
    keyGen.init(128);
    SecretKey secretKey = keyGen.generateKey();
    System.out.println("secret key:" + secretKey);
    
    byte[] be = secretKey.getEncoded();//encoding secretkey
     String skey = Base64.encode(be);
  String cipher = new encryption().encrypt(data, secretKey);
  
    PreparedStatement ps = co.prepareStatement("update uploadcloud set data='"+cipher+"', skey='"+skey+"' where filename='"+filename+"' and owner='"+owner+"' ");

        ps.executeUpdate();


response.sendRedirect("rc.jsp?userreg=success");
out.println("User Registered Successfully");
}
catch(Exception e1)
{
    response.sendRedirect("rc.jsp?userreg1=Email Id you Entered already in Use");
out.println(e1.getMessage());
}


%>
