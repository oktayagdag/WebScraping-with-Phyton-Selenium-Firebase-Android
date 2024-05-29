package software.nyxentech.searchtrendstr.adapters;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.Shapeable;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import software.nyxentech.searchtrendstr.R;
import software.nyxentech.searchtrendstr.models.Searchs;


public class SearchAdapter  extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(String url);
    }
    private List<Searchs> itemList;
    private OnItemClickListener listener;

    public SearchAdapter(List<Searchs> itemList,  OnItemClickListener listener) {
        this.itemList = itemList;
        this.listener = listener;
    }

    public void setItemList(List<Searchs> todoList) {
        this.itemList = itemList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_line, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Searchs item = itemList.get(position);
        holder.numberTextView.setText(String.valueOf(item.getNumber()));
        holder.titleTextView.setText(item.getTitle());
        holder.contentTextView.setText(item.getNew_details());
        holder.readCountTextView.setText(item.getSearch_count());

        String img_url = item.getImage_url();
        new DownloadImageTask(holder.news_imageView).execute(img_url);

        String new_url = item.getShare_url();
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(new_url);
            }
        });

    }

    private static class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

        private final ImageView imageView;

        public DownloadImageTask(ImageView imageView) {
            this.imageView = imageView;
        }

        protected Bitmap doInBackground(String... urls) {
            String imageUrl = urls[0];
            Bitmap bitmap = null;
            try {
                URL url = new URL(imageUrl);
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                bitmap = BitmapFactory.decodeStream(inputStream);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return bitmap;
        }

        protected void onPostExecute(Bitmap result) {
            if (result != null) {
                imageView.setImageBitmap(result);
            }
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public CardView cardView;
        public TextView numberTextView;
        public TextView titleTextView;
        public TextView contentTextView;
        public TextView readCountTextView;
        public ShapeableImageView news_imageView;


        public ViewHolder(View view) {
            super(view);
            numberTextView = view.findViewById(R.id.numberTextView);
            titleTextView = view.findViewById(R.id.titleTextView);
            contentTextView = view.findViewById(R.id.contentTextView);
            readCountTextView = view.findViewById(R.id.readCountTextView);
            news_imageView = view.findViewById(R.id.imageView);
            cardView = view.findViewById(R.id.card);
        }
    }


}
