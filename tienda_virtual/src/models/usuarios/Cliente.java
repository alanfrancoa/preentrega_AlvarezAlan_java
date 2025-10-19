package models.usuarios;

public class Cliente extends UsuarioBase {
    public Cliente(String nombreUsuario, String claveUsuario) {
        super(nombreUsuario, claveUsuario);
    }

    @Override
    public String getRolUsuario() {
        return "Cliente";
    }

}
