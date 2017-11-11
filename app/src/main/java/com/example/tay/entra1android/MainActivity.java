package com.example.tay.entra1android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //Declaración de las variables
    private Button btnReturn, btnEdit, btnSave;
    private EditText txtName, txtEmail, txtTlf, txtAddress;
    private DatePicker datePicker;

    //Variable aux para hacer llamadas a la clase MainActivityEvents que contiene el método OnClick
    private MainActivityEvents event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Al iniciar el onCreate se instancia el atributo events
        llamando al constructor de mainActivityEvents
        que recibe por parámetro el MainActivity mediante la sentencia "this".
        */
        event= new MainActivityEvents(this);
        //Fijamos las variables con los elementos visuales (IBOutlet)

        //BTN
        this.btnReturn=(Button) this.findViewById(R.id.btnReturn);
        this.btnEdit=(Button) this.findViewById(R.id.btnEdit);
        this.btnSave=(Button) this.findViewById(R.id.btnSave);

        //EDIT TEXT
        this.txtName=(EditText) this.findViewById(R.id.txtName);
        this.txtEmail=(EditText) this.findViewById(R.id.txtEmail);
        this.txtTlf=(EditText) this.findViewById(R.id.txtTlf);
        this.txtAddress=(EditText) this.findViewById(R.id.txtAddress);

        //DATEPICKER
        this.datePicker=(DatePicker) this.findViewById(R.id.datePicker);

        /*
        Para fijar el texto de un btn o cualquier View,
        desde el editor visual podemos establecerle un texto, o haciendo setText y
        escribiendo directamente el string. Pero lo mejor es llamar al xml "strings"
        y ahí especficar el texto del elemento.
        */
        this.btnReturn.setText(R.string.btnReturn);
        this.btnReturn.setText(R.string.btnReturn);
        this.btnSave.setText(R.string.btnSave);

        /*
        Llamámos al método creado por nosotros mismos para establecer que por defecto los componentes
        "TextEditable" y "DatePicker" no puedan ser editables.
        Lo serán cuando hagamos un "onclick" sobre el botón "Editar".
         */
        this.isComponentEditable(false);
        //Ahora establecemos el listener del "onclick" para el botón "Editar"
        this.btnEdit.setOnClickListener(this.event);

    }


    public void isComponentEditable(Boolean isTrueOrFalse){
        this.txtName.setEnabled(isTrueOrFalse);
        this.txtEmail.setEnabled(isTrueOrFalse);
        this.txtTlf.setEnabled(isTrueOrFalse);
        this.txtAddress.setEnabled(isTrueOrFalse);
        this.datePicker.setEnabled(isTrueOrFalse);
    }

    public Button getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(Button btnSave) {
        this.btnSave = btnSave;
    }

    public Button getBtnReturn() {
        return btnReturn;
    }

    public void setBtnReturn(Button btnReturn) {
        this.btnReturn = btnReturn;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public EditText getTxtName() {
        return txtName;
    }

    public void setTxtName(EditText txtName) {
        this.txtName = txtName;
    }

    public EditText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(EditText txtEmail) {
        this.txtEmail = txtEmail;
    }

    public EditText getTxtTlf() {
        return txtTlf;
    }

    public void setTxtTlf(EditText txtTlf) {
        this.txtTlf = txtTlf;
    }

    public EditText getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(EditText txtAddress) {
        this.txtAddress = txtAddress;
    }

    public DatePicker getDatePicker() {
        return datePicker;
    }

    public void setDatePicker(DatePicker datePicker) {
        this.datePicker = datePicker;
    }


}
