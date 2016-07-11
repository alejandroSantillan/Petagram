package alejandro.com.petagram.restApi.deserializador;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import alejandro.com.petagram.restApi.JsonKeys;
import alejandro.com.petagram.restApi.model.LikeResponse;

/**
 * Created by Alejandro on 11/07/2016.
 */
public class LikeDeserializador implements JsonDeserializer<LikeResponse> {

    private static final String TAG = LikeDeserializador.class.getName();

    @Override
    public LikeResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

        Gson gson = new Gson();

        Log.i(TAG,"Deserializando");

        LikeResponse likeResponse = gson.fromJson(json,LikeResponse.class);

        JsonObject likeResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_META);


        likeResponse.setMeta(deserializarLikeDeJson(likeResponseData));

        return likeResponse;


    }

    private LikeResponse.Meta deserializarLikeDeJson(JsonObject likeResponseData){

        LikeResponse.Meta meta = new LikeResponse.Meta();

        Integer code = likeResponseData.get("code").getAsInt();

        meta.setCode(code);

        return meta;

    }
}
