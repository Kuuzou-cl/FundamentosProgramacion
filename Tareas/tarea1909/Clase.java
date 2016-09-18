import java.util.ArrayList;

public class Clase
{
    private String nombre;
    private String profesor;
    private int codigo;
    public ArrayList<Alumno> alumnos = new ArrayList<>();
    
    public Clase(String n,String p, int c)
    {
        this.nombre=n;
        this.profesor=p;
        this.codigo=c;
    }
            
    public int eliminar(long m)
    {   
        int eliminado=-1;
        for(int i=0; i<alumnos.size(); i++)
        {
            if(alumnos.get(i).getMatricula()==m)
            {
                eliminado=i;
            }
        }
        return eliminado;
    }
                
    public void setNombre(String n)
    {
        nombre=n;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setProfesor(String p)
    {
        profesor=p;
    }
    
    public String getProfesor()
    {
        return profesor;
    }
    
    public void setCodigo(int c)
    {
        codigo=c;
    }
    
    public int getCodigo()
    {
        return codigo;
    }
    
    public ArrayList getAlumnos()
    {
        return alumnos;
    }
}
