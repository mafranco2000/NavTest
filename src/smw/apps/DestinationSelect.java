package smw.apps;

import java.util.ArrayList;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class DestinationSelect extends ListActivity {
	ArrayList<Destination> destinations;
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.destselect);
        XMLParser xp = new XMLParser(getResources());
        destinations = xp.getTerminalNodes();
        CustomAdapter adapter = new CustomAdapter(this, R.layout.listitems, this.destinations);
        setListAdapter(adapter);
        ListView lv = getListView();
        lv.setTextFilterEnabled(true);
        lv.setOnItemClickListener(new OnItemClickListener(){
        	public void onItemClick(AdapterView<?> parent, View view, int position, long id){
        		int selectedDest = ((Destination)(parent.getItemAtPosition(position))).getCode();
        		String destinationName = ((Destination)(parent.getItemAtPosition(position))).getName();
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", selectedDest);
        		b.putString("destName", destinationName);
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
    }

}
