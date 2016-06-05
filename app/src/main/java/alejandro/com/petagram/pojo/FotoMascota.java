package alejandro.com.petagram.pojo;

/**
 * Created by Alejandro on 04/06/2016.
 */
public class FotoMascota {

    private int imagen;
    private String cantidad;

    public FotoMascota(int imagen, String cantidad) {
        this.imagen = imagen;
        this.cantidad = cantidad;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
