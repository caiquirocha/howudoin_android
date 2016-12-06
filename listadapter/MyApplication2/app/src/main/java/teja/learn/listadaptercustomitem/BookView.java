package teja.learn.listadaptercustomitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import teja.learn.listadaptercustomitem.models.Book;

public class BookView extends AppCompatActivity {

    private Book book;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_view);

        Intent inComing = getIntent();
        book = (Book) inComing.getSerializableExtra("Book");

        TextView txtName = (TextView) findViewById(R.id.txtName);
        TextView txtAuthor = (TextView) findViewById(R.id.txtAuthor);
        txtName.setText(book.getName());
        txtAuthor.setText(book.getAuthor());
    }
}
