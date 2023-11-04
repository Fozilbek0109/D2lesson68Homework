package uz.coder.d2lesson68homework;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.app.backup.BackupAgent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import uz.coder.d2lesson68homework.databinding.ActivityMainBinding;
import uz.coder.d2lesson68homework.fragments.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;

    private List<MahsulotModel> list;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager().findFragmentById(R.id.fragmentContainerView);
        NavController navController = navHostFragment.getNavController();
        NavigationUI.setupWithNavController(binding.bottomView, navController);

        list = new ArrayList<>();
        list.add(new MahsulotModel("olma",45));
        list.add(new MahsulotModel("olcha",45));
        list.add(new MahsulotModel("olxo'ri",45));
        sharedPreferences = getSharedPreferences("mahsulot",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson =new Gson();
        String s = gson.toJson(list);
        editor.putString("list",s);
        editor.commit();


        //--------------------
        Type type = new TypeToken<List<MahsulotModel>>() {
        }.getType();
        String list1 = sharedPreferences.getString("list", "");
        List<MahsulotModel> list2 = gson.fromJson(list1, type);
        list2.add(new MahsulotModel("Olma",8000));
        Log.d(TAG, "onCreate: "+list2.toString());
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onSupportNavigateUp() {
        return super.onSupportNavigateUp();
    }
}