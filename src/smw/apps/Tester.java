package smw.apps;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Tester extends Activity {
	
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tester);
        final Button u1t1 = (Button)findViewById(R.id.u1t1);
        u1t1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 5);
        		b.putString("destName", "Meta training 1");
        		b.putBoolean("textMode", true);
        		b.putString("filename", "A_T1_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u1t2 = (Button)findViewById(R.id.u1t2);
        u1t2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 10);
        		b.putString("destName", "Meta training 2");
        		b.putBoolean("textMode", false);
        		b.putString("filename", "A_T2_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u1p1 = (Button)findViewById(R.id.u1p1);
        u1p1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 30);
        		b.putString("destName", "Meta percorso 1");
        		b.putBoolean("textMode", true);
        		b.putString("filename", "A_P1_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u1p2 = (Button)findViewById(R.id.u1p2);
        u1p2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 50);
        		b.putString("destName", "Meta percorso 2");
        		b.putBoolean("textMode", false);
        		b.putString("filename", "A_P2_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        
        final Button u2t1 = (Button)findViewById(R.id.u2t1);
        u2t1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 5);
        		b.putString("destName", "Meta training 1");
        		b.putBoolean("textMode", true);
        		b.putString("filename", "B_T1_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u2t2 = (Button)findViewById(R.id.u2t2);
        u2t2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 10);
        		b.putString("destName", "Meta training 2");
        		b.putBoolean("textMode", false);
        		b.putString("filename", "B_T2_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u2p1 = (Button)findViewById(R.id.u2p1);
        u2p1.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 30);
        		b.putString("destName", "Meta percorso 1");
        		b.putBoolean("textMode", false);
        		b.putString("filename", "B_P1_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
        final Button u2p2 = (Button)findViewById(R.id.u2p2);
        u2p2.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
        		Intent intent = new Intent(getBaseContext(), Navigator.class);
        		Bundle b = new Bundle();
        		b.putInt("destCode", 50);
        		b.putString("destName", "Meta percorso 2");
        		b.putBoolean("textMode", true);
        		b.putString("filename", "B_P2_" + System.currentTimeMillis() + ".log");
        		intent.putExtras(b);
        		startActivity(intent);
        	}
        });
    }
}
