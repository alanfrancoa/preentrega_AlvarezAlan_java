package models.usuarios;
import interfaces.IUsuario;

public abstract class UsuarioBase implements IUsuario {
    protected String nombreUsuario;
    protected String claveUsuario;
    

    public UsuarioBase(String nombreUsuario, String claveUsuario) {
        this.nombreUsuario = nombreUsuario;
        this.claveUsuario = claveUsuario;

    }

    //Getters y Setters
    @Override
    public String getNombreUsuario() {
        return nombreUsuario;
    }

    @Override
    public String getClaveUsuario() {
        return claveUsuario;
    }

    @Override
    public abstract String getRolUsuario();

    public void setClaveUsuario(String nuevaClave) {
        this.claveUsuario = nuevaClave;
    }

    public void setNombreUsuario(String nuevoNombre) {
        this.nombreUsuario = nuevoNombre;
    }

    @Override
    public String toString() {
        return "UsuarioBase{" +
                "nombreUsuario='" + nombreUsuario + '\'' +
                ", rolUsuario='" + getRolUsuario() + '\'' +
                '}';
    }
}
