import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Alumnos
{
    ArrayList<Alumno> grupoAlum = null;
    
    {
        grupoAlum=new ArrayList<Alumno>();
    }
            
    public void menu ()
    {   
        String resp;
        do
        {
            resp = JOptionPane.showInputDialog(null,"1.  Agregar Alumno"
                                              +"\n2.  Eliminar Alumno"
                                              +"\n3.  Buscar Alumno"
                                              +"\n4.  Mostrar Alumnos inscritos"
                                              +"\n5.  Salir");  
            switch(resp)
            {
             case "1":   
                String n=JOptionPane.showInputDialog(null, "Ingrese el nombre: ");
                String a=JOptionPane.showInputDialog(null, "Ingrese el apellido: ");
                String r;
                do{
                    r=JOptionPane.showInputDialog(null, "Ingrese rut (con puntos y con guion): ");
                    if(patron(r)){
                    }else{
                        JOptionPane.showMessageDialog(null, "El rut es incorrecto, recordar puntos y guion", "", JOptionPane.ERROR_MESSAGE);
                    }  
                }while(patron(r)==false);
                long m=Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese numero de matricula: "));
                grupoAlum.add(new Alumno(n,a,r,m));
                break;
             case "2":
                long mEliminar=Long.parseLong(JOptionPane.showInputDialog(null, "Ingrese el numero de matricula a eliminar: "));
                if(eliminar(mEliminar)==-1){
                    JOptionPane.showMessageDialog(null, "El numero de matricula no se encuentra", "", JOptionPane.ERROR_MESSAGE);
                }else{
                    grupoAlum.remove(eliminar(mEliminar));
                }
                break;
             case "3":
                String rBuscar=JOptionPane.showInputDialog(null, "Ingrese el Rut del alumno a buscar: ");
                if(buscar(rBuscar)==-1){
                    JOptionPane.showMessageDialog(null, "El Rut del alumno no se encontro en la base de datos", "", JOptionPane.ERROR_MESSAGE);
                }else{
                    JOptionPane.showMessageDialog(null, toString(buscar(rBuscar)));
                }    
                break;
             case "4":
                JOptionPane.showMessageDialog(null, toString2());
                break;
             case "5":
                break;
             default:
                JOptionPane.showMessageDialog(null, "Opcion invalida");
                break;   
            }
        }while(!resp.equals("5"));
        }
        
    public int eliminar(long m)
    {   
        int eliminado=-1;
        for(int i=0; i<grupoAlum.size(); i++)
        {
            if(grupoAlum.get(i).getMatricula()==m)
            {
                eliminado=i;
            }
        }
        return eliminado;
    }
    
    public int buscar(String r)
    {
        int buscado=-1;
        for( int i = 0 ; i  < grupoAlum.size(); i++){
            if(grupoAlum.get(i).getRut().equals(r))
            {
                buscado=i;
            }                        
        }
        return buscado;
    }
   
    public String toString (int i)
    {
        String message="Alumno: "+grupoAlum.get(i).getNombre()+" "+grupoAlum.get(i).getApellido()+"\nRut: "+grupoAlum.get(i).getRut()+"\nMatricula: "+grupoAlum.get(i).getMatricula();
        return message;
    }
    
    public String toString2 ()
    {
        String message="";
        for( int i = 0 ; i  < grupoAlum.size(); i++)
        {
            message +="Alumno: "+grupoAlum.get(i).getNombre()+" "+grupoAlum.get(i).getApellido()+"    Rut: "+grupoAlum.get(i).getRut()+"    Matricula: "+grupoAlum.get(i).getMatricula()+"\n";
        }
        return message;
    }
    
    private static boolean patron(String r) {
        String patron = "^(\\d){2}+(.)+(\\d){3}+(.)+(\\d){3}+([\\-]{1})+((\\d){1}||k)+$";
        Pattern pat = Pattern.compile(patron);
        Matcher m = pat.matcher(r);
        return m.matches();   
    }
}
