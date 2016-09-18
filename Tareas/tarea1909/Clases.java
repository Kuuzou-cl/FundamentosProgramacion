import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Clases
{
    public Clase clase;
    public Alumnos alumnosDatos;
    ArrayList<Clase> clases = null;

    {
        clases= new ArrayList<Clase> ();
    }
    
    public void menu()
    {
        String resp;
        do
        {
            resp = JOptionPane.showInputDialog(null,"1.  Crear nueva clase"
                                              +"\n2.  Eliminar clase"
                                              +"\n3.  Agregar Alumno a Clase"
                                              +"\n4.  Eliminar Alumno de Clase"
                                              +"\n5.  Mostrar Clases"
                                              +"\n6.  Salir"); 
            switch(resp)
            {
                case "1":
                    String n=JOptionPane.showInputDialog(null, "Ingrese nombre de la Clase: ");
                    String p=JOptionPane.showInputDialog(null, "Ingrese nombre del profesor de la Clase: ");
                    int c=(Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese numero de codigo de la clase: ")));
                    clases.add(new Clase(n,p,c));
                    break;
                case "2":
                    String nElimina=JOptionPane.showInputDialog(null, "Ingrese numero de codigo de la clase: ");
                    if(patronN(nElimina)){
                            int nEliminar=Integer.parseInt(nElimina);
                            if(buscar(nEliminar)==-1){
                                JOptionPane.showMessageDialog(null, "Esta clase no existe o ya fue eliminada", "", JOptionPane.ERROR_MESSAGE);
                            }else{
                                clases.remove(buscar(nEliminar));
                                JOptionPane.showMessageDialog(null, "Clase eliminada");
                            }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingresar solo numeros para el codigo de la clase", "", JOptionPane.ERROR_MESSAGE);
                    }
   
                    break;
                case "3":
                    String nAd=JOptionPane.showInputDialog(null, "Ingrese numero de codigo de la clase: ");
                    if(patronN(nAd)){
                        int nAdd=Integer.parseInt(nAd);
                        if(buscar(nAdd)==-1){
                            JOptionPane.showMessageDialog(null, "Clase no encontrada", "", JOptionPane.ERROR_MESSAGE);
                        }else{
                            String nAlum=JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                            String aAlum=JOptionPane.showInputDialog(null, "Ingrese el apellido: ");
                            String rAlum;
                            do{
                                rAlum=JOptionPane.showInputDialog(null, "Ingrese rut (con puntos y con guion): ");
                                if(patron(rAlum)){
                                }else{
                                    JOptionPane.showMessageDialog(null, "El rut es incorrecto, recordar puntos y guion", "", JOptionPane.ERROR_MESSAGE);
                                }  
                            }while(patron(rAlum)==false);
                            long mAlum=Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese numero de matricula: "));
                            clases.get(buscar(nAdd)).alumnos.add(new Alumno(nAlum,aAlum,rAlum,mAlum));                                                
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingresar solo numeros para el codigo de la clase", "", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
                case "4":
                    String nDrp=JOptionPane.showInputDialog(null, "Ingrese numero de codigo de la clase: ");
                    if(patronN(nDrp)){
                        int nDrop=Integer.parseInt(nDrp);
                        if(buscar(nDrop)==-1){
                            JOptionPane.showMessageDialog(null, "Clase no encontrada", "", JOptionPane.ERROR_MESSAGE);
                        }else{
                            long mAlumDrop=Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese numero de matricula: "));
                            clases.get(buscar(nDrop)).alumnos.remove(clase.eliminar(mAlumDrop));
                            JOptionPane.showMessageDialog(null, "Alumno eliminado de la clase");
                        }
                    }else{
                        JOptionPane.showMessageDialog(null, "Ingresar solo numeros para el codigo de la clase", "", JOptionPane.ERROR_MESSAGE);
                    }                    
                    break;
                case "5":
                    JOptionPane.showMessageDialog(null, toString());
                    break;
                case "6":
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion invalida");
            }
        }while(!resp.equals("6"));
        
    }
    
    public int buscar(int r)
    {
        int buscado=-1;
        for( int i = 0 ; i  < clases.size(); i++){
            if(clases.get(i).getCodigo()==r)
            {
                buscado=i;
            }                        
        }
        return buscado;
    } 
        
    public String toString()
    {
        String message="";
        for( int i = 0 ; i  < clases.size(); i++)
        {
            message +="Clase: "+clases.get(i).getNombre()+"  Profesor: "+clases.get(i).getProfesor()+"  Codigo:"+clases.get(i).getCodigo()+"\n";
            for(int j=0;j< clases.get(i).alumnos.size();j++ )
            {
                message +="Alumno: "+clases.get(i).alumnos.get(j).getNombre()+" "+clases.get(i).alumnos.get(j).getApellido();
            }
            message +="\n-------------------------------------";
        }
        return message;
    }
        
    private static boolean patron(String r) {
        String patron = "^(\\d){2}+(.)+(\\d){3}+(.)+(\\d){3}+([\\-]{1})+((\\d){1}||k)+$";
        Pattern pat = Pattern.compile(patron);
        Matcher m = pat.matcher(r);
        return m.matches();   
    }
    
    private static boolean patronN(String n) {
        String patron = "^(\\d)+$";
        Pattern pat = Pattern.compile(patron);
        Matcher m = pat.matcher(n);
        return m.matches();   
    }
}
