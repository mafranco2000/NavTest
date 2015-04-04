package smw.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class NavTest extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        final ImageButton start = (ImageButton)findViewById(R.id.flagicon);
        start.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), DestinationSelect.class);
        		startActivity(intent);
        	}
        });
        final ImageButton guide = (ImageButton)findViewById(R.id.infoicon);
        guide.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Help.class);
        		startActivity(intent);
        	}
        });
        final ImageButton settings = (ImageButton)findViewById(R.id.engineicon);
        settings.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
         		Toast.makeText(getBaseContext(), R.string.missing_feature, Toast.LENGTH_LONG).show();
        	}
        });
        final ImageButton close = (ImageButton)findViewById(R.id.closeicon);
        close.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		finish();
        	}
        });
    }
}