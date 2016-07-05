package alejandro.com.petagram.restApi.model;

/**
 * Created by Alejandro on 05/07/2016.
 */
public class UsuarioResponse {

    private String id;
    private String idDispositivo;
    private String usuarioInstagram;
    private String idUsuarioInstagram;


    public UsuarioResponse(String id, String idDispositivo, String usuarioInstagram, String idUsuarioInstagram) {
        this.id = id;
        this.idDispositivo = idDispositivo;
        this.usuarioInstagram = usuarioInstagram;
        this.idUsuarioInstagram = idUsuarioInstagram;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UsuarioResponse() {
    }

    public String getIdDispositivo() {
        return idDispositivo;
    }

    public void setIdDispositivo(String idDispositivo) {
        this.idDispositivo = idDispositivo;
    }

    public String getUsuarioInstagram() {
        return usuarioInstagram;
    }

    public void setUsuarioInstagram(String usuarioInstagram) {
        this.usuarioInstagram = usuarioInstagram;
    }

    public String getIdUsuarioInstagram() {
        return idUsuarioInstagram;
    }

    public void setIdUsuarioInstagram(String idUsuarioInstagram) {
        this.idUsuarioInstagram = idUsuarioInstagram;
    }
}
