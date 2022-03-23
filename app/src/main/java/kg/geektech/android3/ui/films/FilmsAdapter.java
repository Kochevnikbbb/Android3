package kg.geektech.android3.ui.films;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import kg.geektech.android3.data.models.Film;
import kg.geektech.android3.databinding.ItemFilmBinding;

public class FilmsAdapter extends RecyclerView.Adapter<FilmsAdapter.FilmsViewHolder> {
    private List<Film> films = new ArrayList<>();
    private ItemClick click;
    private ImageView image;

    public FilmsAdapter(ItemClick click) {
        this.click = click;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FilmsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemFilmBinding binding = ItemFilmBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent, false);

        return new FilmsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull FilmsViewHolder holder, int position) {
        holder.onBind(films.get(position));
    }

    @Override
    public int getItemCount() {
        return films.size();
    }

    protected class FilmsViewHolder extends RecyclerView.ViewHolder {

        private ItemFilmBinding binding;

        public FilmsViewHolder(@NonNull ItemFilmBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void onBind(Film film) {
            binding.tvTitle.setText(film.getTitle());
            binding.tvDescription.setText(film.getDescription());

           // Glide.with(binding.image.getContext()).load(film.getImage()).into(binding.image);
            itemView.setOnClickListener(view -> {
                click.click(film);
            });

        }
    }
}
