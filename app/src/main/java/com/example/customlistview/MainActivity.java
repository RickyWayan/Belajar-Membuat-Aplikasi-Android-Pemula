package com.example.customlistview;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Toolbar toolbar;

    String mTitle[] = {"Aramba", "Angklung", "Bende", "Cengceng", "Serunai",  "Ganda", "Gendang Melayu", "Katambung", "Kolintang", "Pare'e"};
    String mDescription[] = {"Aramba merupakan alat musik tradisional yang berasal dari Nias, Sumatera Utara. Aramba terbuat terbuat dari tembaga, kuningan atau logam. Alat musik ini termasuk dalam jenis idiofon dan cara memainkannya cukup dipukul dengan menggunakan stik kayu. Dahulu, ketika Aramba membunyikan nadanya, itu merupakan pertanda bahwa sedang digelarnya sebuah pesta di tempat tersebut. Namun, pada saat ini Fungsi Aramba tidak sekedar untuk memeriahkan pesta saja. Aramba juga digunakan sebagai pengiring tari, seperti Tari Ya’ahowu, Tari Moyo dan Tari Tuwu.",
            "Angklung adalah Alat musik tradisional yang berasal Jawa Barat ini terbuat dari bambu yang dipotong bagian ujungnya. Cara memainkannya pun cukup mudah, yakni dengan digoyangkan sampai mengeluarkan suara. Angklung digolongkan dalam jenis idiofon, karena mengeluarkan suara yang bersumber pada bahan dasarnya.",
            "Bende merupakan alat musik tradisional yang berasal dari Lampung. Jika dilihat, alat musik ini sama dengan Aramba dan yang membedakan hanyalah warnanya saja. Cara memainkannya yakni dipukul dengan alat pemukul khusus. Pada zaman dahulu, Bende berfungsi sebagai pertanda untuk berkumpul di alun-alun bahwa raja hendak mengumumkan sesuatu. Sekarang, fungsi Bende bergeser menjadi pengiring di acara kesenian lokal.",
            "Cengceng merupakan alat musik tradisional yang berasal dari Bali. Cengceng termasuk ke dalam alat musik berjenis idiofon. Cara memainkan alat musik ini cukup mudah, hanya meletakkan Cengceng di kedua telapak tangan, lalu dibenturkan keduanya hingga mengeluarkan suara.",
            "Serunai merupakan alat musik tradisional tiup yang berasal dari Minangkabau, Sumatera Barat. Serunai atau yang biasa disebut Puput Serunai terbuat dari batang padi, kayu atau bambu dan bisa juga menggunakan tanduk kerbau dengan campuran daun kelapa. Serunai mempunyai ujung yang mengembang, berfungsi sebagai pengeras volume suara. Di setiap daerah, Serunai mempunyai spesifikasi yang beragam. Bahkan, ada juga Serunai yang pengaturan nadanya dilakukan dengan cara membuka dan menutup permukaan corong. Alat musik tradisional ini biasa dimainkan dalam berbagai acara adat, seperti penghulu.",
            "Ganda merupakan alat musik tradisional yang berasal dari Sulawesi Tengah. Alat musik ini terbuat dari kayu yang dilubangi bagian tengahnya, lalu kedua ujung lubang dibalut dengan kulit binatang yang dikeringkan. Bentuk Ganda sendiri sangat mirip dengan gendang, perbedaannya hanya dalam segi ukuran saja. Cara memainkan-nya sama dengan gendang, cukup memukulnya dengan telapak tangan di bagian kulit.",
            "Gendang Melayu merupakan alat musik tradisional yang berasal dari Bangka Belitung. Gendang Melayu terbilang unik karena akulturasi dari budaya Melayu, Muslim dan Tiongkok. Alat musik ini terbuat dari kayu mahoni yang dilubangi bagian tengahnya. Pada bagian ujung dibuat lebih tipis agar memudahkan untuk dipasang dengan kulit kambing atau kerbau yang sudah dikeringkan dengan menggunakan anyaman rotan. Gendang Melayu banyak digunakan untuk mengiringi tari-tarian, pertunjukan pencak silat dan upacara pernikahan. Cara memainkan-nya mirip seperti umumnya gendang yang sudah kita kenal.",
            "Katambung merupakan alat musik tradisional sejenis perkusi yang berasal dari Kalimantan Tengah. Bentuk alat musik ini terbilang unik karena menyerupai labu siam. Katambung biasa digunakan oleh masyarakat suku Dayak Ngayu dalam berbagai upacara besar, diantara upacara Ngawi Belom dan Ngawi Matey. Pada saat upacara Ngawi Belom, Katambung dimainkan untuk menyambut tamu, sedangkan upacara Ngawi Matey Katambung dimainkan saat upacara kematian, upcara pengangkatan tulang, penguburan dan acara syukuran setelah penguburan.",
            "Kolintang merupakan alat musik tradisional yang berasal dari Minahasa, Sulawesi Utara. Alat musik ini terbuat dari potongan kayu lokal yang disusun diatas kayu yang berfungsi sebagi resenator. Jika dilihat sepintas Kolintang mirip dengan alat musik Gambang dari Jawa. Pada awalnya Kolintang digunakan untuk pemujaan roh leluhur, namun seiring perkembangan zaman fungsi tersebut bergeser menjadi pengiring tari, pertunjukan musik dan berbagai upacara adat. Cara memainkan alat musik ini yaitu dipukul dengan mengguanakan stik kayu yang ujungnya dibalut kain. Biasanya para pemain Kolintang menggunakan tiga stik sekaligus.",
            "Pare’e merupakan alat musik tradisional yang berasal dari Sulawesi Tengah, alat musik ini mempunyai bentuk seperti garpu tala. Pare’e berungsi sebagai alat perkenalan antar anggota kelompok masyarakat dan juga sekedar sebagai alat hiburan dikala santai saja. Cara memainkan alat musik tradisional ini dengan dipukul-pukulkan pada telapak tangan. Kamu bisa memainkannya dengan duduk ataupun berdiri. Pare’e terbuat dari rotan dan buluh tui dan biasanya berwarna kecoklatan sesuai dengan warna bahan dasarnya."};
    int images[] = {R.drawable.aramba, R.drawable.angklung, R.drawable.bende, R.drawable.cengceng, R.drawable.serunai, R.drawable.ganda, R.drawable.gendangmelayu, R.drawable.katambung, R.drawable.kolintang, R.drawable.pare};
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
     public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.about:
                startActivity(new Intent(this, about.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == 0) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[0]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[0]);
                    intent.putExtra("description", mDescription[0]);
                    // also put your position
                    intent.putExtra("position", ""+0);
                    startActivity(intent);


                }
                if (position == 1) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[1]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[1]);
                    intent.putExtra("description", mDescription[1]);
                    // also put your position
                    intent.putExtra("position", ""+1);
                    startActivity(intent);
                }
                if (position == 2) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[2]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[2]);
                    intent.putExtra("description", mDescription[2]);
                    // also put your position
                    intent.putExtra("position", ""+2);
                    startActivity(intent);
                }
                if (position == 3) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[3]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[3]);
                    intent.putExtra("description", mDescription[3]);
                    // also put your position
                    intent.putExtra("position", ""+3);
                    startActivity(intent);
                }
                if (position == 4) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[4]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[4]);
                    intent.putExtra("description", mDescription[4]);
                    // also put your position
                    intent.putExtra("position", ""+4);
                    startActivity(intent);
                }
                if (position == 5) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[5]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[5]);
                    intent.putExtra("description", mDescription[5]);
                    // also put your position
                    intent.putExtra("position", ""+5);
                    startActivity(intent);
                }
                if (position == 6) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[6]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[6]);
                    intent.putExtra("description", mDescription[6]);
                    // also put your position
                    intent.putExtra("position", ""+6);
                    startActivity(intent);
                }
                if (position == 7) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[7]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[7]);
                    intent.putExtra("description", mDescription[7]);
                    // also put your position
                    intent.putExtra("position", ""+7);
                    startActivity(intent);
                }
                if (position == 8) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[8]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[8]);
                    intent.putExtra("description", mDescription[8]);
                    // also put your position
                    intent.putExtra("position", ""+8);
                    startActivity(intent);
                }
                if (position == 9) {
                    Intent intent = new Intent(getApplicationContext(), AnotherActivity.class);
                    // this intent put our 0 index image to another activity
                    Bundle bundle = new Bundle();
                    bundle.putInt("image", images[9]);
                    intent.putExtras(bundle);
                    // now put title and description to another activity
                    intent.putExtra("title", mTitle[9]);
                    intent.putExtra("description", mDescription[9]);
                    // also put your position
                    intent.putExtra("position", ""+9);
                    startActivity(intent);
                }

            }
        });
    }



    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImages[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImages = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View row = layoutInflater.inflate(R.layout.row, parent, false);

            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            images.setImageResource(rImages[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);

            return row;
        }
    }
}
