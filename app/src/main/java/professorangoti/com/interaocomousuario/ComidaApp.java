package professorangoti.com.interaocomousuario;

import android.app.Application;
import android.support.v7.app.AppCompatDelegate;

import professorangoti.com.interaocomousuario.endpoint.Apiendpoint;

public class ComidaApp extends Application {

    private static ComidaApp comidaApp;
    private Apiendpoint apiendpoint;

    @Override
    public void onCreate() {
        super.onCreate();

        comidaApp = this;
        setApiClient();
    }

    private void setApiClient() {
        apiendpoint = new Apiendpoint("http://provaddm2018.atwebpages.com/");
    }

    public synchronized static ComidaApp getInstance() {return comidaApp;}

    static { AppCompatDelegate.setCompatVectorFromResourcesEnabled(true); }

    public Apiendpoint getApiendpoint() { return apiendpoint; }

}