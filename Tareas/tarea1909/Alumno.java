
public class Alumno
{
    private String nombre;
    private String apellido;
    private String rut;
    private long matricula;

    public Alumno(String n,String a,String r,long m)
    {
        this.nombre=n;
        this.apellido=a;
        this.rut=r;
        this.matricula=m;
    }

    public void setNombre(String n)
    {
        nombre=n;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setnApellido(String a)
    {
        apellido=a;
    }
    
    public String getApellido()
    {
        return apellido;
    }
    
    public void setRut(String r)
    {
        rut=r;
    }
    
    public String getRut()
    {
        return rut;
    }
    
    public void setMatricula(long m)
    {
        matricula=m;
    }
    
    public long getMatricula()
    {
        return matricula;
    }
}
