package �γ����;
import java.sql.*;
public class sj1{
    public static void main (String[]args) throws ClassNotFoundException{                              // ClassNotFoundException : �׳�������ȷ����������
//    	Statement sm=null;
    			
    	String RL = "jdbc:sqlserver://localhost:1433;"+"databasename = ֣˸��8_db";
//��ʾ1    	String sqlStr = "select * from Student";
    	
        try{ 
        	 Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             System.out.println("�����������ӳɹ���");
             
//           Connection con = 
            		 DriverManager.getConnection(RL,"sa","5436.......");
             System.out.println("���ݿ����ӳɹ�����");
             
//           sm=con.createStatement();
//--------------------------------------------------------------------------------------------------------------------------------------//                          
             /* ��ʾ1 ���鿴 ��Student             
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sqlStr);
             System.out.println("�������ݿ�ɹ�������");

             System.out.println(" ----------------------------------------------------------------------------------------------------------------");
             
             while(rs.next()) {
            	 System.out.println(" | " + "\t" + rs.getString("Sno") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Sname") + "\t" + " | " + "\t" + rs.getString("Ssex") + "\t" + " | " + "\t" + rs.getInt("Sage") + "\t" + " | " + "\t" + rs.getString("Sdept")  + " | ");
                 System.out.println(" ----------------------------------------------------------------------------------------------------------------");
             }
             
             rs.close();
             */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* ��ʾ2 �� �������
             int i = sm.executeUpdate("insert into Student values('201835149','UnseeR','��','22','IS')");
             
             if(i==1){
 				System.out.println("������ӳɹ���������");
 			 }
             else{
 				System.out.println("�������ʧ�ܣ���������");
 			 }
 			 
             sm.close();
 			 */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* ��ʾ3 �� ����Student��������
             int i = sm.executeUpdate("update Student set Sno = '201835555' where Sname = 'UnseeR'");
             if(i==1){
 				System.out.println("���ݸ��³ɹ���������");
 			 }
             else{
 				System.out.println("���ݸ���ʧ�ܣ���������");
 			 }

             sm.close();
             */
//--------------------------------------------------------------------------------------------------------------------------------------//             
             /* ��ʾ4 �� ɾ��Student�������� 
             int i = sm.executeUpdate("delete from Student where Sno = '201835555'");
             if(i==1){
 				System.out.println("����ɾ���ɹ���������");
 			 }
             else{
 				System.out.println("����ɾ��ʧ�ܣ���������");
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
