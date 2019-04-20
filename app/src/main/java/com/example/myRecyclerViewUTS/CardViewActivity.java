package com.example.myRecyclerViewUTS;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.util.ArrayList;

public class CardViewActivity extends RecyclerView.Adapter<CardViewActivity.ViewHolder> {

    private static final String TAG = "CardView";
    private ArrayList<String> NamaPemain = new ArrayList<>();
    private ArrayList<String> PosisiPemain = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> DetailPemain = new ArrayList<>();
    private ArrayList<String> NoPemain = new ArrayList<>();
    private ArrayList<String> UmurPemain = new ArrayList<>();
    private ArrayList<String> WargaNegaraPemain = new ArrayList<>();
    private Context context;

    public CardViewActivity(Context context, ArrayList<String> NamaPemain, ArrayList<String> LinkGambar, ArrayList<String> PosisiPemain, ArrayList<String> DetailPemain, ArrayList<String> NoPemain, ArrayList<String> UmurPemain, ArrayList<String> WargaNegaraPemain){
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
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card_view,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int i) {
        Log.d(TAG,"onBindViewHolder: called.");

        Glide.with(context)
                .asBitmap()
                .load(LinkGambar.get(i))
                .into(holder.gambarCardView);
        holder.namaPemainCardView.setText(NamaPemain.get(i));
        holder.posisiPemainCardView.setText(PosisiPemain.get(i));

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
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
        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaPemain.get(i));
                Toast.makeText(context, "Favorite "+NamaPemain.get(i),Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG,"onClick: clicked on: "+ NamaPemain.get(i));
                Toast.makeText(context, "Share "+ NamaPemain.get(i),Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return NamaPemain.size();
    }

    @Override
    public int getItemViewType(int position){
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        Button btnFavorite;
        Button btnShare;
        ImageView gambarCardView;
        TextView namaPemainCardView;
        TextView posisiPemainCardView;
        CardView parentLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            gambarCardView = itemView.findViewById(R.id.imageCardView);
            namaPemainCardView = itemView.findViewById(R.id.namaCardView);
            posisiPemainCardView = itemView.findViewById(R.id.posisiCardView);
            parentLayout = itemView.findViewById(R.id.parent_layout);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
        }
    }
}
