package com.example.myRecyclerViewUTS;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private String title = "Mode List";
    final String STATE_TITLE = "state_string";
    final String STATE_MODE = "state_mode";
    int mode;

    private ArrayList<String> NamaPemain = new ArrayList<>();
    private ArrayList<String> PosisiPemain = new ArrayList<>();
    private ArrayList<String> LinkGambar = new ArrayList<>();
    private ArrayList<String> NoPemain = new ArrayList<>();
    private ArrayList<String> UmurPemain = new ArrayList<>();
    private ArrayList<String> WargaNegaraPemain = new ArrayList<>();
    private ArrayList<String> DetailPemain = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate:started.");
        initImageBitmaps();

        if (savedInstanceState == null) {
            setActionBarTitle("Mode List");
            showListActivity();
            mode = R.id.action_list;
        } else {
            String stateTitle = savedInstanceState.getString(STATE_TITLE);
            int stateMode = savedInstanceState.getInt(STATE_MODE);
            setActionBarTitle(stateTitle);
            setMode(stateMode);
        }
    }

    private void initImageBitmaps() {
        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/bravo-col.ashx");
        NamaPemain.add("Claudio Bravo");
        PosisiPemain.add("Goalkeeper");
        UmurPemain.add("36 Tahun");
        WargaNegaraPemain.add("Chile");
        NoPemain.add("1");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 1. Lahir pada 13 April 1983, di Viluco, Chile. Bergabung dengan Manchester City sejak 25 August 2016");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/ederson-col.ashx");
        NamaPemain.add("Ederson Moraes");
        PosisiPemain.add("Goalkeeper");
        UmurPemain.add("25 Tahun");
        WargaNegaraPemain.add("Brazil");
        NoPemain.add("31");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 31. Lahir pada 17 August 1993, di Osasco, Brazil. Bergabung dengan Manchester City sejak 01 July 2017");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/muric-col.ashx");
        NamaPemain.add("Arijanet Muric");
        PosisiPemain.add("Goalkeeper");
        UmurPemain.add("20 Tahun");
        WargaNegaraPemain.add("Swiss");
        NoPemain.add("49");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 49. Lahir pada 07 November 1998, di Swiss. Merupakan kiper dari Akademi Sepak Bola Manchester City");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/grim-col.ashx");
        NamaPemain.add("Daniel Grimshaw");
        PosisiPemain.add("Goalkeeper");
        UmurPemain.add("21 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("32");
        DetailPemain.add("Kiper Manchester City, dengan nomor punggung 32. Lahir pada 16 January 1998, di Manchester. Merupakan kiper dari Akademi Sepak Bola Manchester City");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/danilo-col.ashx");
        NamaPemain.add("Danilo");
        PosisiPemain.add("Right-Back");
        UmurPemain.add("27 Tahun");
        WargaNegaraPemain.add("Brazil");
        NoPemain.add("3");
        DetailPemain.add("Bek Kanan Manchester City, dengan nomor punggung 3. Lahir pada 15 July 1991, di Bicas, Brazil. Bergabung dengan Manchester City sejak 23 July 2017");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/kyle.ashx");
        NamaPemain.add("Kyle Walker");
        PosisiPemain.add("Right-Back");
        UmurPemain.add("28 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("2");
        DetailPemain.add("Bek Kanan Manchester City, dengan nomor punggung 2. Lahir pada 28 May 1990, di Sheffield. Bergabung dengan Manchester City sejak 14 July 2017");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/mendy-col.ashx");
        NamaPemain.add("Benjamin Mendy");
        PosisiPemain.add("Left-Back");
        UmurPemain.add("24 Tahun");
        WargaNegaraPemain.add("France");
        NoPemain.add("22");
        DetailPemain.add("Bek Kiri Manchester City, dengan nomor punggung 22. Lahir pada 17 July 1994, di Longjumeau, France. Bergabung dengan Manchester City sejak 24 July 2017");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/laporte-col.ashx");
        NamaPemain.add("Aymeric Laporte");
        PosisiPemain.add("Defender");
        UmurPemain.add("24 Tahun");
        WargaNegaraPemain.add("France");
        NoPemain.add("14");
        DetailPemain.add("Bek Manchester City, dengan nomor punggung 14. Lahir pada 27 May 1994, di Agen, France. Bergabung dengan Manchester City sejak 30 January 2018");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/stones-col.ashx");
        NamaPemain.add("John Stones");
        PosisiPemain.add("Defender");
        UmurPemain.add("24 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("5");
        DetailPemain.add("Bek Manchester City, dengan nomor punggung 5. Lahir pada 28 May 1994, di Barnsley. Bergabung dengan Manchester City sejak 09 August 2016");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/otamendi-col.ashx");
        NamaPemain.add("Nicolas Otamendi");
        PosisiPemain.add("Defender");
        UmurPemain.add("31 Tahun");
        WargaNegaraPemain.add("Argentina");
        NoPemain.add("30");
        DetailPemain.add("Bek Manchester City, dengan nomor punggung 30. Lahir pada 12 February 1988, di Capital Federal (Buenos Aires). Bergabung dengan Manchester City sejak 20 August 2015");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/vincent-kompany-col.ashx");
        NamaPemain.add("Vincent Kompany");
        PosisiPemain.add("Defender");
        UmurPemain.add("33 Tahun");
        WargaNegaraPemain.add("Belgium");
        NoPemain.add("4");
        DetailPemain.add("Bek Manchester City sekaligus Kapten Manchester City, dengan nomor punggung 4. Lahir pada 10 April 1986, di Ukkle, Belgium. Bergabung dengan Manchester City sejak 22 August 2008");

        LinkGambar.add("https://premierleague-static-files.s3.amazonaws.com/premierleague/photos/players/250x250/p57112.png");
        NamaPemain.add("Eliaquim Mangala");
        PosisiPemain.add("Defender");
        UmurPemain.add("28 Tahun");
        WargaNegaraPemain.add("France");
        NoPemain.add("15");
        DetailPemain.add("Bek Manchester City, dengan nomor punggung 15. Lahir pada 13 February 1991, di Colombes, France. Bergabung dengan Manchester City sejak 11 August 2014");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/gundo-col.ashx");
        NamaPemain.add("Ilkay Gundogan");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("28 Tahun");
        WargaNegaraPemain.add("Germany");
        NoPemain.add("8");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 8. Lahir pada 24 October 1990, di Gelsenkirchen, Germany. Bergabung dengan Manchester City sejak 02 June 2016");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/kdb-col.ashx");
        NamaPemain.add("Kevin De Bruyne");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("27 Tahun");
        WargaNegaraPemain.add("Belgium");
        NoPemain.add("17");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 17. Lahir pada 28 June 1991, di Drongen. Bergabung dengan Manchester City sejak 30 August 2015");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/delph-col.ashx");
        NamaPemain.add("Fabian Delph");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("29 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("18");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 18. Lahir pada 21 November 1989, di Bradford. Bergabung dengan Manchester City sejak 17 July 2015");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/phil-foden-col.ashx");
        NamaPemain.add("Phil Foden");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("18 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("47");
        DetailPemain.add("Gelandang muda dari Akademi Manchester City, dengan nomor punggung 47. Lahir 28 May 2000, di Stockport, Manchester. Bergabung dengan Manchester City sejak 01 July 2016");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/b-silva-col.ashx");
        NamaPemain.add("Bernardo Silva");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("24 Tahun");
        WargaNegaraPemain.add("Portugal");
        NoPemain.add("20");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 20. Lahir pada 10 August 1994, di Lisbon, Portugal. Bergabung dengan Manchester City sejak 07 January 2017");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/ferna-col.ashx");
        NamaPemain.add("Fernandinho");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("33 Tahun");
        WargaNegaraPemain.add("Brazil");
        NoPemain.add("25");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 25. Lahir pada 04 May 1985, di Londrina, Brazil. Bergabung dengan Manchester City sejak 06 June 2013");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/silva.ashx");
        NamaPemain.add("David Silva");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("33 Tahun");
        WargaNegaraPemain.add("Spain");
        NoPemain.add("21");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 21. Lahir pada 08 January 1986, di Arguineguin, Spain. Bergabung dengan Manchester City sejak 01 July 2010");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/olexandre-zinchenko-col.ashx");
        NamaPemain.add("Oleksandr Zinchenko");
        PosisiPemain.add("Midfielder");
        UmurPemain.add("22 Tahun");
        WargaNegaraPemain.add("Ukraine");
        NoPemain.add("35");
        DetailPemain.add("Gelandang Manchester City, dengan nomor punggung 35. Lahir pada 15 December 1996, di Radomyshl Raion, Zhytomyr Oblast, Ukraine. Bergabung dengan Manchester City sejak 01 July 2016");

        LinkGambar.add("https://stadion-stage.mancity.com/-/media/images/shared/players/squad-profiles-images/first-team/profile-image/mahrez-colour-600_600-profile.ashx");
        NamaPemain.add("Riyad Mahrez");
        PosisiPemain.add("Attacking Midfield");
        UmurPemain.add("28 Tahun");
        WargaNegaraPemain.add("Algeria");
        NoPemain.add("26");
        DetailPemain.add("Gelandang Serang Manchester City, dengan nomor punggung 26. Lahir pada 21 February 1991, di Sarcelles, France. Bergabung dengan Manchester City sejak 10 July 2018");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/sane-col.ashx");
        NamaPemain.add("Leroy Sane");
        PosisiPemain.add("Attacking Midfield");
        UmurPemain.add("23 Tahun");
        WargaNegaraPemain.add("Germany");
        NoPemain.add("19");
        DetailPemain.add("Gelandang Serang Manchester City, dengan nomor punggung 19. Lahir pada 11 January 1996, di Essen, Germany. Bergabung dengan Manchester City sejak 01 August 2016");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/raheem-sterling-col.ashx");
        NamaPemain.add("Raheem Sterling");
        PosisiPemain.add("Attacking Midfield");
        UmurPemain.add("24 Tahun");
        WargaNegaraPemain.add("England");
        NoPemain.add("7");
        DetailPemain.add("Gelandang Serang Manchester City, dengan nomor punggung 7. Lahir pada 08 December 1994, di Kingston, Jamaica. Bergabung dengan Manchester City sejak 14 July 2015");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/sergio.ashx");
        NamaPemain.add("Sergio Aguero");
        PosisiPemain.add("Striker");
        UmurPemain.add("30 Tahun");
        WargaNegaraPemain.add("Argentina");
        NoPemain.add("10");
        DetailPemain.add("Striker Manchester City, dengan nomor punggung 10. Lahir pada 02 June 1988, di Quilma, Argentina. Bergabung dengan Manchester City sejak 28 July 2011");

        LinkGambar.add("https://mediacdn.mancity.com/-/media/images/shared/players/2018-19-images/gab-j-blue.ashx");
        NamaPemain.add("Gabriel Jesus");
        PosisiPemain.add("Striker");
        UmurPemain.add("22 Tahun");
        WargaNegaraPemain.add("Brazil");
        NoPemain.add("33");
        DetailPemain.add("Striker Manchester City, dengan nomor punggung 33. Lahir pada 03 April 1997, di São Paulo, Brazil. Bergabung dengan Manchester City sejak 19 January 2017");

        showListActivity();

    }

    private void showListActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ListActivity adapter = new ListActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);

    }

    private void showCardViewActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        CardViewActivity adapter = new CardViewActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);
    }

    private void showGridActivity() {
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        GridActivity adapter = new GridActivity(this, NamaPemain, LinkGambar, PosisiPemain, DetailPemain, NoPemain, UmurPemain, WargaNegaraPemain);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        setMode(item.getItemId());
        return super.onOptionsItemSelected(item);
    }

    public void setMode(int selectedMode) {
        String title = null;
        switch (selectedMode) {
            case R.id.action_list:
                title = "Mode List";
                showListActivity();
                break;

            case R.id.action_grid:
                title = "Mode Grid";
                showGridActivity();
                break;

            case R.id.action_cardview:
                title = "Mode CardView";
                showCardViewActivity();
                break;
        }
        mode = selectedMode;
        setActionBarTitle(title);
    }

    private void setActionBarTitle(String title) {
        getSupportActionBar().setTitle(title);

    }

    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_TITLE, getSupportActionBar().getTitle().toString());
        outState.putInt(STATE_MODE, mode);
    }
}