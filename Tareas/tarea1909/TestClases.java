import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TestClases
{
    public Alumnos alumnosDatos;
    public Clases clasesDatos;
    ArrayList<Alumno> grupoAlum = null;
    ArrayList<Clase> clases = null;
    
    public void main()
    {
        TestClases test=new TestClases();
        test.inicio();
    }

    private void inicio()
    {
        alumnosDatos=new Alumnos();
        clasesDatos=new Clases();
        String resp;
        do
        {
            resp = JOptionPane.showInputDialog(null,"1.  Datos Alumno"
                                              +"\n2.  Datos Cursos"
                                              +"\n3.  Salir");  
                                              switch(resp){
                                                case "1":alumnosDatos.menu();
                                                break;
                                                case "2":clasesDatos.menu();
                                                break;
                                                case "3":System.exit(0);
                                                default:
                                                JOptionPane.showMessageDialog(null, "Opcion invalida");
                                                }
        }while(!resp.equals("3"));
    }
    
}
