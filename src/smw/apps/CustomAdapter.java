package smw.apps;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {
	private LayoutInflater inflater;
	private int res;
	private ArrayList<Destination> destinations;
	
	@SuppressWarnings("static-access")
	public CustomAdapter(Context context, int resource, ArrayList<Destination> destinations) {
		this.inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
		this.res = resource;
		this.destinations = destinations;
	}

	public int getCount() {
		return this.destinations.size();
	}

	public Object getItem(int index) {
		return this.destinations.get(index);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		View view;
		if (convertView == null){
			view = this.inflater.inflate(res, parent, false);                
		} else {
			view = convertView;
		}
		return this.bindData(view, position);
	}
	
	private View bindData(View view, int position){
		if (this.destinations.get(position) == null){
			return view;
		}
		Destination dest = this.destinations.get(position);
		View viewElement = view.findViewById(R.id.destinationname);
		TextView textView = (TextView)viewElement;
		textView.setText(dest.getName());
		return view;
	}

}
