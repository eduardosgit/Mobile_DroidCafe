package professorangoti.com.interaocomousuario.service;

import professorangoti.com.interaocomousuario.dominio.ComidaDTO;
import retrofit2.Call;
import retrofit2.http.GET;
import java.util.List;

public interface ComidaService {

    @GET("precos")
    Call<List<ComidaDTO>> getPrecoComida();
}
