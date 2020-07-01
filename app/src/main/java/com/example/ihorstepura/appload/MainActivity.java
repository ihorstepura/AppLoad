package com.example.ihorstepura.appload;
/*
Для решения даной задачи, мною был использован рекурсивный метод, который так же используется для
решения задачи про Ханойские башни. Так как максимальное количество плит 8 шт, алгоритм выполняется
за приемлимое количество времени.
 */
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText editText;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (editText.getText().toString().isEmpty()) {
            Toast.makeText(this, "поле ввода не заполнено", Toast.LENGTH_LONG).show();
        } else {
            Intent intent = new Intent(this, SecondActivity.class);
            intent.putExtra("number", Integer.parseInt(editText.getText().toString()));
            startActivity(intent);
        }
    }
}
