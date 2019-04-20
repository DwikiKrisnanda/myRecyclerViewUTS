package com.example.myRecyclerViewUTS;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class GridActivity extends RecyclerView.Adapter<GridActivity.GridViewHolder> {

    private static final String TAG = "GridView";
    private ArrayList<String> NamaPemain = new ArrayList<>();
    private ArrayList<String> PosisiPemain = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailPemain = new ArrayList<>();
    private ArrayList<String> NoPemain = new ArrayList<>();
    private ArrayList<String> UmurPemain = new ArrayList<>();
    private ArrayList<String> WargaNegaraPemain = new ArrayList<>();
    private Context context;

    public GridActivity(Context context, ArrayList<String> NamaPemain, ArrayList<String> LinkGambar, ArrayList<String> PosisiPemain, ArrayList<String> DetailPemain, ArrayList<String> NoPemain, ArrayList<String> UmurPemain, ArrayList<String> WargaNegaraPemain){
        this.NamaPemain = NamaPemain;
        this.LinkGambar = LinkGambar;
        this.PosisiPemain = PosisiPemain;
        this.DetailPemain = DetailPemain;
        this.NoPemain = NoPemain;
        this.UmurPemain = UmurPemain;
        this.WargaNegaraPemain = WargaNegaraPemain;
        this.context = context;
    }

    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_grid, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, final int i) {
        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.imgPhoto);
        holder.imgPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaPemain.get(i));
                Toast.makeText(context, "Detail "+NamaPemain.get(i),Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("link",LinkGambar.get(i));
                intent.putExtra("nama",NamaPemain.get(i));
                intent.putExtra("posisi",PosisiPemain.get(i));
                intent.putExtra("umur",UmurPemain.get(i));
                intent.putExtra("warganegara",WargaNegaraPemain.get(i));
                intent.putExtra("no",NoPemain.get(i));
                intent.putExtra("detail",DetailPemain.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return LinkGambar.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        GridViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
        }
    }
}

