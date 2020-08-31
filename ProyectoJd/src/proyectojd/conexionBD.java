/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectojd;
import com.microsoft.sqlserver.jdbc.SQLServerDa­taSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;
import java.awt.Frame;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class conexionBD {
    public static String mensajeError = null; 
    public Connection conexion = null;
    public PreparedStatement sentencia;
    
    public  conexionBD() {
          
       
        
        try { 
            SQLServerDataSource ds = new SQLServerDataSource(); 
            ds.setUser("sa"); 
            ds.setPassword("123456789"); 
            ds.setServerName("localhost"); 
            ds.setPortNumber(1433); 
            ds.setDatabaseName("proyectojd"); 
            conexion = ds.getConnection(); 
        } catch(SQLServerException e) { 
            mensajeError = e.getMessage(); 
        } 
        
        
        try {
            
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conexion= DriverManager.getConnection("jdbc:sqlserver://localhost\\USUARIO-PC\\PROYECTO:1433;databaseName=proyectojd"); 
            
        }
        catch(ClassNotFoundException e){
            mensajeError = e.getMessage(); 
        }catch(SQLException e){
           mensajeError = e.getMessage();    
        }
        
            
            
            
     }          

    public Connection getconexion() {
        return conexion;
    }

    public void setconexion(Connection conexion) {
        this.conexion = conexion;
       
        
    }
    
    /**
     * Este metodo se encarga de generar el reporte de los estudiantes en
     * Jasper Reports
     */
    public void generarReporte(){
       
         try {
           JasperReport reporte= JasperCompileManager.compileReport("reporte.jrxml");
           JasperPrint p= JasperFillManager.fillReport(reporte,null,conexion);
           JasperViewer view= new JasperViewer(p,false);
           view.setTitle("Reporte de Usuario");
           view.setExtendedState(Frame.MAXIMIZED_BOTH);
           view.setVisible(true);           
           
       } catch (Exception e) {
           e.printStackTrace();
       }
       
   
}


}



/**
 *
 * @author usuario
 */
