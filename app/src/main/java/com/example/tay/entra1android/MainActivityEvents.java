package com.example.tay.entra1android;

import android.view.View;

/**
 * Created by tay on 11/11/17.
 */

public class MainActivityEvents implements View.OnClickListener{
    private MainActivity mainActivity; // atributo del MainActivity que usaremos para tratar el onClick

    //Constructor para inicializar el MainActivity

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    //Método de las llamadas OnClick
    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.btnEdit){
            this.mainActivity.getBtnEdit().setVisibility(View.GONE);// Con Gone a parte de ocultarlo quitamos de la vista para que no ocupe memoria. llamnamos a la clase View para ocultarlo pero en este caso serviría con especificar el parámetro "view"
            this.mainActivity.getBtnSave().setVisibility(View.VISIBLE);
            //Ahora los componentes del View deben de ser editables
            this.mainActivity.isComponentEditable(true);

        }

    }
}
