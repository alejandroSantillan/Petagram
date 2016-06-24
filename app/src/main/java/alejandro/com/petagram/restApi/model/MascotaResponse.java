package alejandro.com.petagram.restApi.model;

import java.util.List;

import alejandro.com.petagram.pojo.Mascota;

/**
 * Created by Alejandro on 24/06/2016.
 */
public class MascotaResponse {


    private List<Mascota> mascotas;


    public List<Mascota> getMascotas() {
        return mascotas;
    }

    public void setMascotas(List<Mascota> mascotas) {
        this.mascotas = mascotas;
    }
}
