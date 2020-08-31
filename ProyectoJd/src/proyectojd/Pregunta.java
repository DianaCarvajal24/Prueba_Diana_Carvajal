/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package proyectojd;

import java.sql.Connection;

/**
 *
 * @author usuario
 */
public class Pregunta {
  
    private String nombre;
    private String tipo;
    private String respuesta;
    private String valorInsertado;
    
    public Pregunta(String nombre, String tipo, String respuesta){
        this.nombre = nombre;
        this.tipo= tipo;
        this.respuesta = respuesta;
        
        
    
        
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(String respuesta) {
        this.respuesta = respuesta;
    }

    public String getValorInsertado() {
        return valorInsertado;
    }

    public void setValorInsertado(String valorInsertado) {
        this.valorInsertado = valorInsertado;
    }

   
    
    
    
}
