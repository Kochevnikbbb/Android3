package kg.geektech.android3;

import android.app.Application;

import kg.geektech.android3.data.remote.FilmApi;
import kg.geektech.android3.data.remote.RetrofitClient;

public class App extends Application {
    private RetrofitClient retrofitClient;
    public static FilmApi api;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.createFilmApi();
    }
}
