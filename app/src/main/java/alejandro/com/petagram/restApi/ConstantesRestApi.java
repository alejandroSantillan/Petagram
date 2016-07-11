package alejandro.com.petagram.restApi;

/**
 * Created by Alejandro on 24/06/2016.
 */
public class ConstantesRestApi {


    public static final String VERSION = "/v1/";
    public static final String ROOT_URL = "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN= "3435808795.adc7217.cf4e508eacab445bba989dfb877d0c6f";

    public static final String URL_SEARCH_USERS = "users/search";
    public static final String URL_RECENT_MEDIA_USER = "users/{user_id}/media/recent";
    public static final String URL_MEDIA_LIKE = "media/{media_id}/likes";

    public static final String ROOT_URL_FIREBASE ="https://bagged-keener-57746.herokuapp.com/";
    public static final String POST_ID_TOKEN ="registrar-usuario/";
    public static final String POST_MEDIA_LIKE = "registrar-like/";
    public static final String NOTIFICACION_LIKE = "like-animal/{id}/{nombre}";

}
