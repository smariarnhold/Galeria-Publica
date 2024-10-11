package arnhold.maria.galeriapublica;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

public class MainViewModel extends AndroidViewModel {
    //estamos guardando um dado, é a opcao escolhida pelo usuario
    int navigationOpSelected = R.id.gridViewOp;
    //estamos usando uma extensao do ViewModel, parametro de entrada = solicitacao do usuario
    public MainViewModel(@NonNull Application application) {
        super(application);
    }
    //pegando esse dado
    public int getNavigationOpSelected() {
        return navigationOpSelected;
    }
    //setando esse dado
    public void setNavigationOpSelected(int navigationOpSelected) {
        this.navigationOpSelected = navigationOpSelected;
    }
}
