package professorangoti.com.interaocomousuario.dominio;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ComidaDTO implements Serializable {

    @SerializedName("produto")
    private String produto;

    @SerializedName("valor")
    private String valor;

    public ComidaDTO() { }

    public String getProduto() { return produto; }

    public void setProduto(String produto) { this.produto = produto; }

    public String getValor() { return valor; }

    public void setValor(String valor) { this.valor = valor;  }
}
