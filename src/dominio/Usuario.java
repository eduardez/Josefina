package dominio;

public class Usuario {
    private String User;
    private String Pass;
    private String Nombre;
    private String UltAcc;

    public Usuario(String user, String pass, String nom, String ult) {
	this.User = user;
	this.Pass = pass;
	this.Nombre = nom;
	this.UltAcc = ult;
    }

    public String getUser() {
	return User;
    }

    public void setUser(String user) {
	User = user;
    }

    public String getPass() {
	return Pass;
    }

    public void setPass(String pass) {
	Pass = pass;
    }

    public String getNombre() {
	return Nombre;
    }

    public void setNombre(String nombre) {
	Nombre = nombre;
    }

    public String getUltAcc() {
	return UltAcc;
    }

    public void setUltAcc(String ultAcc) {
	UltAcc = ultAcc;
    }

    @Override
    public String toString() {
	return "Usuario [User=" + User + ", Pass=" + Pass + ", Nombre=" + Nombre + ", UltAcc=" + UltAcc + "]";
    }

}
