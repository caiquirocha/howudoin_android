package teja.learn.listadaptercustomitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import teja.learn.listadaptercustomitem.models.Book;

public class AddActivity extends AppCompatActivity {

    private EditText txtName;

    private EditText txtAuthor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        setupBtnAdd();
        setupBtnCancel();

        txtName = (EditText) findViewById(R.id.txtName);
        txtAuthor = (EditText) findViewById(R.id.txtAuthor);
    }

    private void setupBtnAdd() {
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((View v) -> {
            Book book = new Book(txtName.getText().toString(), txtAuthor.getText().toString());
            Intent intent = new Intent(AddActivity.this, MainActivity.class);
            intent.putExtra("Book", book);
            setResult(RESULT_OK, intent);
            finish();
        });
    }

    private void setupBtnCancel() {
        Button btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener((View v) -> {
            Intent intent = this.getIntent();
            setResult(RESULT_CANCELED, intent);
            finish();
        });
    }
}
