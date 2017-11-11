package com.example.tay.entra1android;

import android.view.View;

/**
 * Created by tay on 11/11/17.
 */

public class MainActivityEvents implements View.OnClickListener {
    private MainActivity mainActivity; // atributo del MainActivity que usaremos para tratar el onClick

    //Constructor para inicializar el MainActivity

    public MainActivityEvents(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    //Método de las llamadas OnClick
    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.btnEdit) {
            this.mainActivity.getBtnEdit().setVisibility(View.GONE);// Con Gone a parte de ocultarlo quitamos de la vista para que no ocupe memoria. llamnamos a la clase View para ocultarlo pero en este caso serviría con especificar el parámetro "view"
            this.mainActivity.getBtnSave().setVisibility(View.VISIBLE);
            //Ahora los componentes del View deben de ser editables
            this.mainActivity.isComponentEditable(true);

        } else if (view.getId() == R.id.btnSave) {
            /*
            Ahora cuando pinchemos sobre el botón "Guardar" se debe de recoger la información de los campos
            y guardarse de forma estática en variables auxiliares de tipo atómicas.
            Para ello llamamos a un método creado en la clase "MainActivity" que se encarga de recoger
            esta información
             */
            this.mainActivity.infoCollect();
            /*
            Se realiza el proceso inverso. AL pulsar save se guardan los cambios, se ocutla el botón "Guardar" y se muestra
            el botón "Editar" de nuevo. Además todos los campos dejan de ser editables.
             */
            this.mainActivity.getBtnSave().setVisibility(View.GONE);
            this.mainActivity.getBtnEdit().setVisibility(View.VISIBLE);
            this.mainActivity.isComponentEditable(false);
            /*
            Por último, se llama a un método creado por nosotros para setear la información que se guardó en las variables locales
             y de este modo setearselas a los componentes en los campos correspondientes.
            */
            this.mainActivity.setInfoCollect();

        }

    }
}
