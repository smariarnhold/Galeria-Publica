package arnhold.maria.galeriapublica;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    //definicao do botao
    BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

            //obtendo a referencia do MainViewMode
            final MainViewModel vm = new ViewModelProvider(this).get(MainViewModel.class);

            //obtendo a referencia do BottonNavigationView
            bottomNavigationView = findViewById(R.id.btNav);
            //escutador de cliques no btn
            bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
                //apos clicar, essa funcao sera chamada e indicar a opcao que o usuario escolheu
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    //guardamos a opcao indicada
                    vm.setNavigationOpSelected(item.getItemId());
                    //aqui é um if/else que muda de acordo com a opcao
                    switch (item.getItemId()) {
                        case R.id.gridViewOp:
                            GridViewFragment gridViewFragment = GridViewFragment.newInstance();
                            setFragment(gridViewFragment);
                            break;
                        case R.id.listViewOp:
                            ListViewFragment listViewFragment = ListViewFragment.newInstance();
                            setFragment(listViewFragment);
                            break;
                    }
                    return true;
                }
            });

        });
    }
}




