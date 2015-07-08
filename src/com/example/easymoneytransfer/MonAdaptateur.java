/**
 * Adaptateur de la liste qui affichera le texte et les images
 * */

package com.example.easymoneytransfer;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonAdaptateur extends ArrayAdapter<String>{

	private ArrayList<Integer> images;
	
	public MonAdaptateur(Context context, ArrayList<String> values, ArrayList<Integer> images){
		super(context, R.layout.rowlayout, values);
		this.images = images;
	}
	
	public View getView(int position, View convertView, ViewGroup parent){
		
		LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.rowlayout, parent, false);
		
		TextView textView = (TextView)rowView.findViewById(R.id.label);
		ImageView imageView = (ImageView)rowView.findViewById(R.id.icon);
		
		textView.setText(getItem(position));
		
		if(convertView == null){
			imageView.setImageResource(images.get(position));
		}else{
			rowView = (View)convertView;
		}
		return rowView;
	}
}








