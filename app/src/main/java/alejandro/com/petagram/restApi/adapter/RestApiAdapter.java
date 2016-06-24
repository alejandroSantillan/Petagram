package alejandro.com.petagram.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import alejandro.com.petagram.restApi.ConstantesRestApi;
import alejandro.com.petagram.restApi.EndPointApi;
import alejandro.com.petagram.restApi.deserializador.MascotaRecentMediaDeserializador;
import alejandro.com.petagram.restApi.deserializador.MascotaSearchDeserializador;
import alejandro.com.petagram.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Alejandro on 24/06/2016.
 */
public class RestApiAdapter {

    public EndPointApi establecerConexionRestApiInstagram(Gson gson) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(EndPointApi.class);

    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaRecentMediaDeserializador());

        return   gsonBuilder.create();
    }


    public Gson construyeGsonDeserializadorSearch(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class,new MascotaSearchDeserializador());

        return   gsonBuilder.create();
    }
}
