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

    //Declaración de variables auxiliares que recogen la información de los camposd del formulario.
    String name, email, adress;
    int tlf, day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Al iniciar el onCreate se instancia el atributo events
        llamando al constructor de mainActivityEvents
        que recibe por parámetro el MainActivity mediante la sentencia "this".
        */
        event = new MainActivityEvents(this);
        //Fijamos las variables con los elementos visuales (IBOutlet)

        //BTN
        this.btnReturn = (Button) this.findViewById(R.id.btnReturn);
        this.btnEdit = (Button) this.findViewById(R.id.btnEdit);
        this.btnSave = (Button) this.findViewById(R.id.btnSave);

        //EDIT TEXT
        this.txtName = (EditText) this.findViewById(R.id.txtName);
        this.txtEmail = (EditText) this.findViewById(R.id.txtEmail);
        this.txtTlf = (EditText) this.findViewById(R.id.txtTlf);
        this.txtAddress = (EditText) this.findViewById(R.id.txtAddress);

        //DATEPICKER
        this.datePicker = (DatePicker) this.findViewById(R.id.datePicker);

        /*
        Para fijar el texto de un btn o cualquier View,
        desde el editor visual podemos establecerle un texto, o haciendo setText y
        escribiendo directamente el string. Pero lo mejor es llamar al xml "strings"
        y ahí especficar el texto del elemento.
        */
        this.getBtnReturn().setText(R.string.btnReturn);
        this.getBtnEdit().setText(R.string.btnEdit);
        this.getBtnSave().setText(R.string.btnSave);

        /*
        Llamámos al método creado por nosotros mismos para establecer que por defecto los componentes
        "TextEditable" y "DatePicker" no puedan ser editables.
        Lo serán cuando hagamos un "onclick" sobre el botón "Editar".
         */
        this.isComponentEditable(false);
        //Ahora establecemos el listener del "onclick" para el botón "Editar", "Guardar" y "Volver"
        this.getBtnEdit().setOnClickListener(this.getEvent());
        this.getBtnSave().setOnClickListener(this.getEvent());
        this.getBtnReturn().setOnClickListener(this.getEvent());

    }


    public void isComponentEditable(Boolean isTrueOrFalse) {
        this.getTxtName().setEnabled(isTrueOrFalse);
        this.getTxtEmail().setEnabled(isTrueOrFalse);
        this.getTxtTlf().setEnabled(isTrueOrFalse);
        this.getTxtAddress().setEnabled(isTrueOrFalse);
        this.getDatePicker().setCalendarViewShown(isTrueOrFalse);
        this.getDatePicker().setEnabled(isTrueOrFalse);
        this.getDatePicker().setActivated(isTrueOrFalse);
        this.getDatePicker().setClickable(isTrueOrFalse);
        this.getDatePicker().setSelected(isTrueOrFalse);

    }

    //Método para recoger la información de los campos del formulario

    public void infoCollect() {
        //Se hacen uso de los atributos auxiliares creados que recogen la información de los campos
        this.setName(this.getTxtName().getText().toString());
        this.setEmail(this.getTxtEmail().getText().toString());
        this.setTlf(Integer.parseInt(this.getTxtTlf().getText().toString()));
        this.setAdress(this.getTxtAddress().getText().toString());
        this.setDay(this.getDatePicker().getDayOfMonth());
        this.setMonth(this.getDatePicker().getMonth());
        this.setYear(this.getDatePicker().getYear());
    }

    public void setInfoCollect() {
        this.getTxtName().setText(this.getName());
        this.getTxtEmail().setText(this.getEmail());
        this.getTxtTlf().setText(String.valueOf(this.getTlf()));
        this.getTxtAddress().setText(this.getAdress());
        this.getDatePicker().init(this.getYear(), this.getMonth(), this.getDay(), null);
    }


    //GETTER Y SETTER

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

    public MainActivityEvents getEvent() {
        return event;
    }

    public void setEvent(MainActivityEvents event) {
        this.event = event;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public int getTlf() {
        return tlf;
    }

    public void setTlf(int tlf) {
        this.tlf = tlf;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
