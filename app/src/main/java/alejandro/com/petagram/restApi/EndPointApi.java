package alejandro.com.petagram.restApi;

import alejandro.com.petagram.restApi.model.MascotaResponse;
import alejandro.com.petagram.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Alejandro on 24/06/2016.
 */
public interface EndPointApi {

    @GET(ConstantesRestApi.URL_RECENT_MEDIA_USER)
    public Call<MascotaResponse> getUserRecentMedia(@Path("user_id") String userId,
                                                    @Query("access_token") String accessToken);

    @GET(ConstantesRestApi.URL_SEARCH_USERS)
    public Call<MascotaResponse> search(@Query("q") String query, @Query("access_token") String accessToken);

    @FormUrlEncoded
    @POST(ConstantesRestApi.POST_ID_TOKEN)
    public Call<UsuarioResponse>  registrarDispositivo(@Field("id_dispositivo") String idDispositivo,
                                                       @Field("usuario_instagram") String usuarioInstagram,
                                                       @Field("id_usuario_instagram") String idUsuarioInstagram);

}
