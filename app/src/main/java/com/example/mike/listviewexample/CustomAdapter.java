package com.example.mike.listviewexample;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

//using this to adapt the custom view to the lsit
class CustomAdapter extends ArrayAdapter{
    //this is the constructor
    public CustomAdapter(Context context, String[] resource) {
        super(context, R.layout.custom_row, resource);
    }

    //telling where you want the strings to go in the layout
    //inflate = prepare get ready for rendering
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //creates an inflater objcet and gives it context
        LayoutInflater layoutInflater = LayoutInflater.from((getContext()));
        //creates a view and points it to the xml
        View customView = layoutInflater.inflate(R.layout.custom_row, parent, false);

        //creates a reference to a string in the string[] in the main activity
        String singleItem = String.valueOf(getItem(position));
        //creates a textView object
        TextView myText = (TextView)customView.findViewById(R.id.textView);
        //creates an imageView object
        ImageView myImage = (ImageView)customView.findViewById(R.id.albert_imageView);

        //chagnes the text to each of the items in the list view
        myText.setText(singleItem);
        //continues to have the same image from the drawable folder
        myImage.setImageResource(R.drawable.albert);

        //returns the view just created
        return customView;
    }
}
