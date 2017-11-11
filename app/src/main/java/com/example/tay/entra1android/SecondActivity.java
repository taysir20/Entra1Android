package com.example.tay.entra1android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {
    //Declaración de arrays
    private String title[];
    private String text[];
    //Declaración de las variables
    private Button btnBack;
    private Button btnNext;
    private Button btnProfile;
    private EditText txtTitleText;
    private EditText txtText;

    //Variable aux
    public int pos;


    //Declaramos un atributo de tipo "SecondActivityEvents" para poder usarlo para setear los "Onclick" de los botones.
    private SeconActivityEvents event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
       this.setPos(0);

        // SETEAMOS EL TAMAÑO DE LOS ARRAYS y los inicializamos
        this.setTitle(new String[4]);
        this.setText(new String[4]);
        /*
        Al iniciar el onCreate se instancia el atributo events
        llamando al constructor de secondActivityEvents
        que recibe por parámetro el SeconActivity mediante la sentencia "this".
         */
        this.setEvent(new SeconActivityEvents(this));

        //Añadimos los strings a los arrays mediante el método creado infoCollect
        this.infoCollect();

        // REFERENCIAMOS LOS COMPONENTES CON LOS ATRIBUTOS

        //BUTTONS
        this.btnBack = (Button) this.findViewById(R.id.btnBack);
        this.btnNext = (Button) this.findViewById(R.id.btnNext);
        this.btnProfile = (Button) this.findViewById(R.id.btnProfile);

        //EDITABLE TEXT <----> MULTILINE TEXT
        this.txtTitleText = (EditText) this.findViewById(R.id.txtTitleText);
        this.txtText = (EditText) this.findViewById(R.id.mitxttext);

        //Seteamos el texto de los btn
        this.getBtnBack().setText(R.string.btnBack);
        this.getBtnNext().setText(R.string.btnNext);
        this.getBtnProfile().setText(R.string.btnProfile);


        //Seteamos los listener de los botones pasando por parámetro el atributo "event"
        this.getBtnBack().setOnClickListener(this.getEvent());
        this.getBtnNext().setOnClickListener(this.getEvent());
        this.getBtnProfile().setOnClickListener(this.getEvent());

        //Seteamos las posiciones de los arrays en los "Editable Text"

        this.setEditableText(this.getPos());

        //Establecemos a false que los campos sean editable
        this.isComponentEditable(false);


    }

    //Método para seterar un booleno que indique si es editable o no.
    public void isComponentEditable(Boolean isTrueOrFalse) {
        this.getTxtTitleText().setEnabled(isTrueOrFalse);
        this.getTxtText().setEnabled(isTrueOrFalse);

    }

    //Método para setear los strings en los arrays
    public void infoCollect() {
        this.getTitleText()[0]=this.getString(R.string.t1);
        this.getTitleText()[1]=this.getString(R.string.t2);
        this.getTitleText()[2]=this.getString(R.string.t3);
        this.getTitleText()[3]=this.getString(R.string.t4);

        this.getText()[0]=this.getString(R.string.info1);
        this.getText()[1]=this.getString(R.string.info2);
        this.getText()[2]=this.getString(R.string.info3);
        this.getText()[3]=this.getString(R.string.info4);

    }

    //Método para setear los arrays en los componentes "Editable Text"
    public void setEditableText(int pos) {
        this.getTxtTitleText().setText(this.getTitleText()[pos]);
        this.getTxtText().setText(this.getText()[pos]);
    }


    public SeconActivityEvents getEvent() {
        return event;
    }

    public void setEvent(SeconActivityEvents event) {
        this.event = event;
    }

    public int getPos() {
        return pos;
    }

    public void setPos(int pos) {
        this.pos = pos;
    }

    public Button getBtnProfile() {
        return btnProfile;
    }

    public void setBtnProfile(Button btnProfile) {
        this.btnProfile = btnProfile;
    }

    public Button getBtnBack() {
        return btnBack;
    }

    public void setBtnBack(Button btnBack) {
        this.btnBack = btnBack;
    }

    public Button getBtnNext() {
        return btnNext;
    }

    public void setBtnNext(Button btnNext) {
        this.btnNext = btnNext;
    }

    public EditText getTxtTitleText() {
        return txtTitleText;
    }

    public void setTxtTitleText(EditText txtTitleText) {
        this.txtTitleText = txtTitleText;
    }

    public EditText getTxtText() {
        return txtText;
    }

    public void setTxtText(EditText txtText) {
        this.txtText = txtText;
    }

    public String[] getTitleText() {
        return this.title;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String[] getText() {
        return text;
    }

    public void setText(String[] text) {
        this.text = text;
    }
}
