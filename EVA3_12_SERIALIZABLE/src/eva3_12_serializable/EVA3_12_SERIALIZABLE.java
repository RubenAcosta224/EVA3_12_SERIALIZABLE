/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eva3_12_serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author invitado
 */
public class EVA3_12_SERIALIZABLE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //GUARDAR OBJETOS
        
        Persona perso1=new Persona("Ruben","Acosta",18);
        
        try {
//            guardarObjetos(perso1);
            
            
            //solo se guardan datos atributos
            Persona resu=leerObjetos();
            
            System.out.println(resu.getNombre());
            System.out.println(resu.getApellido());
            System.out.println(resu.getEdad());
            
            
            
        } catch (IOException ex) {
            Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(EVA3_12_SERIALIZABLE.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void guardarObjetos(Persona perso) throws FileNotFoundException, IOException{
        //abrir archivo
        //guarda en binario??
        FileOutputStream abrirArc=new FileOutputStream("C:\\apps\\personas.per");
        ObjectOutputStream outputStream=new ObjectOutputStream(abrirArc);
        
        outputStream.writeObject(perso);
        outputStream.close();
    }
    
    public static Persona leerObjetos() throws FileNotFoundException, IOException, ClassNotFoundException{
        
        Persona perso=null;
        
        FileInputStream abrirArc=new FileInputStream("C:\\apps\\personas.per");
        ObjectInputStream oiStream=new ObjectInputStream(abrirArc);
        
        //casting: de object a persona
        perso=(Persona)oiStream.readObject();
        
        return perso;
    }
    
}


//para guardar objetos el serializable, solo permite guardarlos en formato binario
class Persona implements Serializable{
    private String nombre;
    private String apellido;
    private int edad;
    
    
    
    

    public Persona(String nombre, String apellido, int edad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }
    
        public Persona() {
        this.nombre = "Juan";
        this.apellido = "Garcia";
        this.edad = 20;
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
}