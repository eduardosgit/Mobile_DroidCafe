package professorangoti.com.interaocomousuario.dao;

import android.support.annotation.NonNull;

import java.util.List;

import professorangoti.com.interaocomousuario.ComidaApp;
import professorangoti.com.interaocomousuario.endpoint.Apiendpoint;
import professorangoti.com.interaocomousuario.dominio.ComidaDTO;
import professorangoti.com.interaocomousuario.service.IComidaService;
import professorangoti.com.interaocomousuario.service.ComidaService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ComidaDAO implements IComidaService {

    private ComidaServiceListener comidaServiceListener;
    private Apiendpoint apiendpoint;

    public ComidaDAO(ComidaServiceListener comidaServiceListener) {
        this.comidaServiceListener = comidaServiceListener;
        this.apiendpoint = ComidaApp.getInstance().getApiendpoint();
    }

    @Override
    public void getPrecoComida() {
        ComidaService comidaService = this.apiendpoint.getRetrofit().create(ComidaService.class);
        Call<List<ComidaDTO>> comidaResponse = comidaService.getPrecoComida();

        comidaResponse.enqueue(new Callback<List<ComidaDTO>>() {
            @Override
            public void onResponse(@NonNull Call<List<ComidaDTO>> call,@NonNull Response<List<ComidaDTO>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    comidaServiceListener.response(response.body());
                } else if (response.code() == 500) {
                    comidaServiceListener.serverError("Conexão não encontrada");
                } else if (response.code() != 200) {
                    comidaServiceListener.serverError("Erro do servidor");
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<ComidaDTO>> call, @NonNull Throwable t) {
                comidaServiceListener.serverError("Conexão não encontrada");
            }
        });
    }

    public interface ComidaServiceListener {
        void response(List<ComidaDTO> comidaDTO);

        void serverError(String message);
    }
}
