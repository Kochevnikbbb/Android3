package kg.geektech.android3.data.remote;

import java.util.List;

import kg.geektech.android3.data.models.Film;
import retrofit2.Call;
import retrofit2.http.GET;

public interface FilmApi {

    @GET("/films")
    Call<List<Film>> getFilms();

}
