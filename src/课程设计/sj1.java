package 课程设计;
import java.sql.*;
public class sj1{
    public static void main (String[]args) throws ClassNotFoundException{                              // ClassNotFoundException : 抛出声明，确保驱动程序
//    	Statement sm=null;
    			
    	String RL = "jdbc:sqlserver://localhost:1433;"+"databasename = 郑烁彬8_db";
//演示1    	String sqlStr = "select * from Student";
    	
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("驱动程序连接成功！");
             
//           Connection con = 
            		 DriverManager.getConnection(RL,"sa","5436.......");
             System.out.println("数据库连接成功！！");
             
//           sm=con.createStatement();
//--------------------------------------------------------------------------------------------------------------------------------------//                          
             /* 演示1 ：查看 表Student             
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlStr);
             System.out.println("操作数据库成功！！！");

             System.out.println(" ----------------------------------------------------------------------------------------------------------------");
             
             while(rs.next()) {
            	 System.out.println(" | " + "\t" + rs.getString("Sno") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Ssex") + "\t" + " | " + "\t" + rs.getInt("Sage") + "\t" + " | " + "\t" + rs.getString("Sdept")  + " | ");
                 System.out.println(" ----------------------------------------------------------------------------------------------------------------");
             }
             
             rs.close();
             */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* 演示2 ： 添加数据
             int i = sm.executeUpdate("insert into Student values('201835149','UnseeR','男','22','IS')");
             
             if(i==1){
 				System.out.println("数据添加成功！！！！");
 			 }
             else{
 				System.out.println("数据添加失败！！！！！");
 			 }
 			 
             sm.close();
 			 */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* 演示3 ： 更新Student表中数据
             int i = sm.executeUpdate("update Student set Sno = '201835555' where Sname = 'UnseeR'");
             if(i==1){
 				System.out.println("数据更新成功！！！！");
 			 }
             else{
 				System.out.println("数据更新失败！！！！！");
 			 }

             sm.close();
             */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* 演示4 ： 删除Student表中数据 
             int i = sm.executeUpdate("delete from Student where Sno = '201835555'");
             if(i==1){
 				System.out.println("数据删除成功！！！！");
 			 }
             else{
 				System.out.println("数据删除失败！！！！！");
 			 }

             sm.close();
             con.close();
             */
//--------------------------------------------------------------------------------------------------------------------------------------//                         
             
        }
        catch(SQLException err){
        	err.printStackTrace(System.out);
        	
        }
        }
}
