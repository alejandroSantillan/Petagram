package alejandro.com.petagram.pojo;

/**
 * Created by Alejandro on 28/05/2016.
 */
public class Mascota {

    private int idMascota;
    private int imagen;
    private String nombre;
    private int rating;
    private boolean like;

    public Mascota( int imagen, String nombre, int rating, boolean like) {
        this.imagen = imagen;
        this.nombre = nombre;
        this.rating = rating;
        this.like = like;
    }

    public Mascota() {

    }


    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public int getIdMascota() {
        return idMascota;
    }

    public void setIdMascota(int idMascota) {
        this.idMascota = idMascota;
    }
}
