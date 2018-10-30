package professorangoti.com.interaocomousuario.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import professorangoti.com.interaocomousuario.R;
import professorangoti.com.interaocomousuario.dominio.ComidaDTO;

public class activity_resultado extends AppCompatActivity {

    @BindView(R.id.valor_pedido)
    TextView mValorPedidoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ButterKnife.bind(this);

        Bundle bundle = getIntent().getExtras();
        ComidaDTO comidaDTO = null;

        if (bundle != null) {
            comidaDTO = (ComidaDTO) bundle.getSerializable("pedido");
        }

        if (comidaDTO != null) {
            mValorPedidoTextView.setText(comidaDTO.getValor());
        }
    }
}