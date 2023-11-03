/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dpm.dbapp;
import java.sql.*;

/**
 *
 * @author sspmcoe
 */
public class Mydb {
    Connection connection;
    PreparedStatement st;
    ResultSet rs1,rs2;
    
    Mydb()
    {
        try {       
             Class.forName("com.mysql.jdbc.Driver");
                    connection = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/desktopmanagement",
                        "root", "1234");
               System.out.println("Connect");
            } catch (Exception e) {
                    System.out.println(e);
                }
            
    }
    public void insert(int Id, String Type, String Location, int Price, String Name, int Identification, int Purchase)
    {
        try {
            st = (PreparedStatement) connection
                        .prepareStatement("INSERT INTO `user` (`Id`, `Name`, `Type`, `Identification no.`, `Location`, `Purchase Date`, `Price`) VALUES ('"+ Id + "', '" + Name + "','"+ Type + "',"
                                + "'"+ Identification + "','"+ Location + "','"+ Purchase + "','"+ Price + "',)");
            System.out.println(st.execute());
            if(st.execute())
            {
                System.out.print("Insert");
                //JOptionPane.showMessageDialog(Mydb, "You have successfully inserted");
            } else {
                        //JOptionPane.showMessageDialog(Mydb, "Wrong input");
                        System.out.print("Insert failed");
                    }
        }
        catch (SQLException sqlException) {
                    sqlException.printStackTrace();
                }
    }
    public static void main(String args[])
    {
        Mydb d =new Mydb();
        d.insert(1, "Test", "kankavli", 200, "Sanket", 3456, 20102023);
    }
    
}
