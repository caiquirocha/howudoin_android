package teja.learn.listadaptercustomitem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import teja.learn.listadaptercustomitem.models.Book;

public class MainActivity extends AppCompatActivity {
    public static final int kRequestCodeAdd = 1;

    private ArrayList<Book> books = new ArrayList<>();

    private ArrayAdapter<Book> booksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener((View v) -> {
            Intent intent = new Intent(MainActivity.this, AddActivity.class);
            startActivityForResult(intent, kRequestCodeAdd);
        });
        ListView lstBooks = (ListView) findViewById(R.id.lstBooks);

        booksAdapter = new BookArrayAdapter(MainActivity.this, books);
        lstBooks.setAdapter(booksAdapter);

        lstBooks.setOnItemClickListener((AdapterView<?> parent, View view, int position, long id) -> {
            Intent intent = new Intent(MainActivity.this, BookView.class);
            intent.putExtra("Book", booksAdapter.getItem(position));
            startActivity(intent);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == kRequestCodeAdd) {
            if (resultCode == RESULT_CANCELED) {
                return;
            }

            Book book = (Book) data.getSerializableExtra("Book");
            booksAdapter.add(book);
        }
    }
}
