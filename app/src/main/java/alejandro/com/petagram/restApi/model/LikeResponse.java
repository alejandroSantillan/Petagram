package alejandro.com.petagram.restApi.model;

/**
 * Created by Alejandro on 11/07/2016.
 */
public class LikeResponse {


    private Meta meta;



    public boolean isSuccessfull(){
        return meta.code == 200;
    }

    public void setMeta(Meta meta) {
        this.meta = meta;
    }

    public static class Meta{
        private Integer code;

        public void setCode(Integer code) {
            this.code = code;
        }
    }
}
