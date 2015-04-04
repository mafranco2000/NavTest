package smw.apps;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class Navigator extends Activity {
	int destinationCode;
	String destinationName;
	boolean textMode;
	String filename;
	File f;
	BufferedWriter writer;
	
    public void onCreate(Bundle savedInstanceState) {
    	Bundle b = this.getIntent().getExtras();
    	destinationCode = b.getInt("destCode");
    	destinationName = b.getString("destName");
    	textMode = b.getBoolean("textMode", false);
    	filename = b.getString("filename");
    	f = new File(Environment.getExternalStorageDirectory(), "navlog/" + filename);
    	try {
			writer = new BufferedWriter(new FileWriter(f));
		} catch (IOException e) {
			e.printStackTrace();
		}
        super.onCreate(savedInstanceState);
        setContentView(R.layout.navigator);
        TextView dest = (TextView)findViewById(R.id.destinationlabel);
        dest.setText("NavIndoor");
        // TextView destName = (TextView)findViewById(R.id.destinationnamelabel);
        // destName.setText(destinationName);
        try {
			writer.write("Navigator started at: " + System.currentTimeMillis() + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
        final ImageButton read = (ImageButton)findViewById(R.id.eyeicon);
        read.setOnClickListener(new OnClickListener(){
        	public void onClick(View v){
                try {
					writer.write("Camera called at: " + System.currentTimeMillis() + "\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
        		Intent intent = new Intent("com.google.zxing.client.android.SCAN");
        		intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
        		startActivityForResult(intent, 0);
        	}
        });
    }
    
    public void onClose(){
    	try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
    	if (requestCode == 0) {
    		if (resultCode == RESULT_OK) {
    			String contents = intent.getStringExtra("SCAN_RESULT");
         		getDirection(contents);
    	    } else if (resultCode == RESULT_CANCELED) {
          		Toast.makeText(getBaseContext(), R.string.scan_canceled, Toast.LENGTH_LONG).show();
    	      }
    	}
    }
    
    public void getDirection(String codeRead){
    	int i = 0;
    	String way = "";
    	while (Character.isDigit(((Character)codeRead.charAt(i)))) i++;
    	int currentCode = Integer.parseInt(codeRead.substring(0, i));
    	XMLParser xp = new XMLParser(getResources());
    	int nextCode = xp.getNextHop(currentCode, destinationCode);
        try {
			writer.write("Current position: " + currentCode + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	while ((codeRead.length() > Integer.toString(nextCode).length() + 1) && (!((codeRead.startsWith(Integer.toString(nextCode)) && !(Character.isDigit(((Character)codeRead.charAt(Integer.toString(nextCode).length())))))))){
    		codeRead = codeRead.substring(1);
    	}
    	if (codeRead.startsWith(Integer.toString(nextCode))){
    		way = codeRead.substring(Integer.toString(nextCode).length(), Integer.toString(nextCode).length() + 1);
    	}
 		displayDirection(way.toLowerCase(), (destinationCode == currentCode));
    }
    
    private void displayDirection(String way, boolean isLast){
    	final Dialog popup = new Dialog(this);
    	popup.setContentView(R.layout.direction);
    	ImageView img = (ImageView)popup.findViewById(R.id.direction);
    	TextView txt = (TextView)popup.findViewById(R.id.textdirection);
    	if (textMode){
    		popup.setTitle(R.string.follow_instruction);
    		txt.setPadding(8, 64, 8, 68);
    	} else {
    		popup.setTitle(R.string.follow_direction);
    	}
    	Button closeButton = (Button)popup.findViewById(R.id.discardbutton);
    	closeButton.setOnClickListener(new OnClickListener(){
    		public void onClick(View v){
    	        try {
					writer.write("Direction closed at: " + System.currentTimeMillis() + "\n");
					writer.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
    			popup.dismiss();
    		}
    	});
        try {
			writer.write("Direction shown at: " + System.currentTimeMillis() + "\n");
			writer.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	if (way.equals("a")){
    		if (textMode) txt.setText(R.string.hour12); else img.setImageResource(R.drawable.a);
    	} else if (way.equals("b")){
    		if (textMode) txt.setText(R.string.hour1); else img.setImageResource(R.drawable.b);
    	} else if (way.equals("c")){
    		if (textMode) txt.setText(R.string.hour2); else img.setImageResource(R.drawable.c);
        } else if (way.equals("d")){
    		if (textMode) txt.setText(R.string.hour3); else img.setImageResource(R.drawable.d);
    	} else if (way.equals("e")){
    		if (textMode) txt.setText(R.string.hour4); else img.setImageResource(R.drawable.e);
    	} else if (way.equals("f")){
    		if (textMode) txt.setText(R.string.hour5); else img.setImageResource(R.drawable.f);
    	} else if (way.equals("g")){
    		if (textMode) txt.setText(R.string.hour6); else img.setImageResource(R.drawable.g);
    	} else if (way.equals("h")){
    		if (textMode) txt.setText(R.string.hour7); else img.setImageResource(R.drawable.h);
    	} else if (way.equals("i")){
    		if (textMode) txt.setText(R.string.hour8); else img.setImageResource(R.drawable.i);
    	} else if (way.equals("j")){
    		if (textMode) txt.setText(R.string.hour9); else img.setImageResource(R.drawable.j);
    	} else if (way.equals("k")){
    		if (textMode) txt.setText(R.string.hour10); else img.setImageResource(R.drawable.k);
    	} else if (way.equals("l")){
    		if (textMode) txt.setText(R.string.hour11); else img.setImageResource(R.drawable.l);
    	} else if (way.equals("u")){
        	if (textMode) txt.setText(R.string.upstairs); else img.setImageResource(R.drawable.upstairs);
    	} else if (way.equals("v")){
        	if (textMode) txt.setText(R.string.downstairs); else img.setImageResource(R.drawable.downstairs);
    	} else {
    		if (isLast){
    			if (textMode) txt.setText(R.string.destination_reached_long); else img.setImageResource(R.drawable.arrival);
    			popup.setTitle(R.string.destination_reached);
    		} else {
    			if (textMode) txt.setText(R.string.no_direction_long); else img.setImageResource(R.drawable.error);
    			popup.setTitle(R.string.no_direction);
    		}

    	}
    	popup.show();
    }

}
