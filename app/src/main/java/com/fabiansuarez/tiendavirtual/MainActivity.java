package com.fabiansuarez.tiendavirtual;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Product> listProducts = new ArrayList<>();
    private RecyclerView rvProductsMain;
    private Toolbar topAppBar;
    private User userSession = new User();
    private ImageView userImageProfil;
    private ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list
    private ImageSlider imageSlider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadFakeData();
        userImageProfil = findViewById(R.id.iv_profile_home_user);
        Picasso.get().load(userSession.getUrlImageProfil()).into(userImageProfil);
        rvProductsMain = findViewById(R.id.rv_products_main);
        topAppBar = findViewById(R.id.top_app_bar_list_product);
        ProductAdapter myAdapter = new ProductAdapter(listProducts);

        rvProductsMain.setAdapter(myAdapter);

        topAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.item_add_product) {
                    startActivity(new Intent(MainActivity.this, FormProductActivity.class));
                    return true;
                } else if (item.getItemId() == R.id.item_category) {
                    startActivity(new Intent(MainActivity.this, CategoryActivity.class));
                    return true;
                }
                return false;
            }
        });

        StaggeredGridLayoutManager myStagger = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        GridLayoutManager myGrid = new GridLayoutManager(getApplicationContext(), 2);
        LinearLayoutManager myLinear = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvProductsMain.setLayoutManager(myStagger);

        imageSlider= findViewById(R.id.image_slider_home);
        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.", ScaleTypes.FIT));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.FIT));

        imageSlider.setImageList(imageList);


    }


    private void loadFakeData() {
        Product product1 = new Product("Computador Asus", "El mejor computador gamer que puedes comprar", 11000000.0, "https://rampcrosario.com/wp-content/uploads/2019/03/pc-gamer.png");
        Product product2 = new Product("Teclado Asus", "El mejor teclado gamer que puedes comprar", 100000.0, "https://d22fxaf9t8d39k.cloudfront.net/f65ad7c8036f1e99b17e1e3fbcd89625026e26a0e81e4af34b1dc8b0cf7d235c169554.png");
        Product product3 = new Product("Celular Rog", "El mejor celular gamer que puedes comprar", 7000000.0, "https://dlcdnwebimgs.asus.com/gain/FB338DAC-B312-4D25-A7A3-DBDBDBC123CA");
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);
        listProducts.add(product1);
        listProducts.add(product2);
        listProducts.add(product3);

        //Cargue de informacion de session
        userSession.setName("Fabian");
        userSession.setEmail("fsuarez120@unab.edu.co");
        userSession.setPassword("qazwsx");
        userSession.setPhone("3229243184");
        userSession.setUrlImageProfil("https://www.dzoom.org.es/wp-content/uploads/2020/02/portada-foto-perfil-redes-sociales-consejos.jpg");
    }
}