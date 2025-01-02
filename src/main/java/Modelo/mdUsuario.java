package Modelo;

public class mdUsuario {
    private String nombre;
    private String apellido;
    private String id;
    private String correo;
    private String telefono;
    private String contrasena;
    private boolean admin;

    public mdUsuario(String nombre, String apellido, String id, String correo, String telefono, String contrasena, boolean admin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.id = id;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasena = contrasena;
        this.admin = admin;
    }
    
    public mdUsuario(String id, String contrasena) {
        this.id = id;
        this.contrasena = contrasena;
    }

    // se crean los getter y setters

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean getAdmin() {
        return admin;
    }
}
