package teja.learn.listadaptercustomitem;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import teja.learn.listadaptercustomitem.models.Book;

/**
 * Created by SERAGUD on 2016-12-06.
 */

public class BookArrayAdapter extends ArrayAdapter<Book> {
    public BookArrayAdapter(Context context, ArrayList<Book> content) {
        super(context, R.layout.book_item, content);
    }

    @NonNull
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        // Get the data item for this position
        Book book = getItem(position);

        if (convertView == null) {
            // If there's no view to re-use, inflate a brand new view for row
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.book_item, parent, false);
        }

        TextView name = (TextView) convertView.findViewById(R.id.txtName);
        TextView author = (TextView) convertView.findViewById(R.id.txtAuthor);

        if(book != null) {
            name.setText(book.getName());
            author.setText(book.getAuthor());
        } else {
            name.setText("");
            author.setText("");
        }

        // Return the completed view to render on screen
        return convertView;
    }

}
