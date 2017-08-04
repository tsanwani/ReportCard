package com.example.codetribe.reportcard;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Student_Entry extends Activity {

    TextView idView;
    EditText firstname;
    EditText surname;
    EditText subjectone;
    EditText subjecttwo;
    EditText subjectthree;
    EditText student_Id;
    EditText marks_one;
    EditText marks_two;
    EditText marks_three;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student__entry);

        idView = (TextView) findViewById(R.id.Id_Display);
        firstname = (EditText) findViewById(R.id.Name_Input_);
        surname = (EditText) findViewById(R.id.Surname_Input_);
        subjectone = (EditText) findViewById(R.id.Subject_One_);
        subjecttwo = (EditText) findViewById(R.id.Subject_Two_);
        subjectthree = (EditText) findViewById(R.id.Subject_Three_);
        student_Id = (EditText) findViewById(R.id.Student_ID_Input_);
        marks_one = (EditText) findViewById(R.id.Marks_One_);
        marks_two = (EditText) findViewById(R.id.Marks_Two_);
        marks_three = (EditText) findViewById(R.id.Marks_Three_);
    }

    public void newProduct(View view) {



            MYDBHandler dbHandler = new MYDBHandler(this);
            int quantity = Integer.parseInt(student_Id.getText().toString());
            int quantity2 = Integer.parseInt(marks_one.getText().toString());
            int quantity3 = Integer.parseInt(marks_two.getText().toString());
            int quantity4 = Integer.parseInt(marks_three.getText().toString());

            Product product = new Product(firstname.getText().toString(), surname.getText().toString(),
                    subjectone.getText().toString(), subjecttwo.getText().toString(), subjectthree.getText().toString(), quantity, quantity2, quantity3, quantity4);
            dbHandler.addProduct(product);
            firstname.setText("");
            surname.setText("");
            student_Id.setText("");
            subjectone.setText("");
            subjecttwo.setText("");
            subjectthree.setText("");
            marks_one.setText("");
            marks_two.setText("");
            marks_three.setText("");


        }

    public void lookupStutent(View view) {
        MYDBHandler dbHandler = new MYDBHandler(this);
        Product product = dbHandler.findProduct(firstname.getText().toString());
        if (product != null) {
            idView.setText(String.valueOf(product.getID()));
            student_Id.setText(String.valueOf(product.getQuantity()));
            marks_one.setText(String.valueOf(product.getQuantity2()));
            marks_two.setText(String.valueOf(product.getQuantity3()));
            marks_three.setText(String.valueOf(product.getQuantity4()));
            firstname.setText(String.valueOf(product.getProductname()));
            surname.setText(String.valueOf(product.getSurname()));
            subjectone.setText(String.valueOf(product.getSubjectone()));
            subjecttwo.setText(String.valueOf(product.getSubjecttwo()));
            subjectthree.setText(String.valueOf(product.getSubjectthree()));

        } else {
            idView.setText("No Match Found");
        }
    }

    public void removeProduct(View view) {
        MYDBHandler dbHandler = new MYDBHandler(this);
        dbHandler.deleteProduct(firstname.getText().toString());
        idView.setText("Record Deleted");
        firstname.setText("");
        surname.setText("");
        student_Id.setText("");
        subjectone.setText("");
        subjecttwo.setText("");
        subjectthree.setText("");
        marks_one.setText("");
        marks_two.setText("");
        marks_three.setText("");
       //

    }

    public void update(View view) {

        MYDBHandler dbHandler = new MYDBHandler(this);
        int quantity = Integer.parseInt(student_Id.getText().toString());
        int quantity2 = Integer.parseInt(marks_one.getText().toString());
        int quantity3 = Integer.parseInt(marks_two.getText().toString());
        int quantity4 = Integer.parseInt(marks_three.getText().toString());

        Product product = new Product(firstname.getText().toString(), surname.getText().toString(),
                subjectone.getText().toString(), subjecttwo.getText().toString(), subjectthree.getText().toString(),quantity,quantity2,quantity3,quantity4);
        dbHandler.Update(product);
        firstname.setText("");
        surname.setText("");
        student_Id.setText("");
        subjectone.setText("");
        subjecttwo.setText("");
        subjectthree.setText("");
        marks_one.setText("");
        marks_two.setText("");
        marks_three.setText("");



    }

}
