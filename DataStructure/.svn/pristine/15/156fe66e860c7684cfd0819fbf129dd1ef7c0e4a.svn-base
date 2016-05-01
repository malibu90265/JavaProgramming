package com.example.gram_android;
import android.app.Activity;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class makeNewRecipe extends Activity {
	ArrayAdapter<CharSequence> adspin;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity2);
		
		Spinner s1 = (Spinner) findViewById(R.id.checkMeasure1);
		Spinner s2 = (Spinner) findViewById(R.id.checkMeasure2);
		Spinner s3 = (Spinner) findViewById(R.id.checkMeasure3);
		Spinner s4 = (Spinner) findViewById(R.id.checkMeasure4);
		Spinner s5 = (Spinner) findViewById(R.id.checkMeasure5);
		Spinner s6 = (Spinner) findViewById(R.id.checkMeasure6);
		Spinner s7 = (Spinner) findViewById(R.id.checkMeasure7);
		Spinner s8 = (Spinner) findViewById(R.id.checkMeasure8);
		Spinner s9 = (Spinner) findViewById(R.id.checkMeasure9);
		Spinner s10 = (Spinner) findViewById(R.id.checkMeasure10);
		
		s1.setPrompt("재료의 단위를 선택하세요.");
		adspin = ArrayAdapter.createFromResource(this,R.array.selected,android.R.layout.simple_spinner_item	);
		
		adspin.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
	    s1.setAdapter(adspin);
	    s2.setAdapter(adspin);
	    s3.setAdapter(adspin);
	    s4.setAdapter(adspin);
	    s5.setAdapter(adspin);
	    s6.setAdapter(adspin);
	    s7.setAdapter(adspin);
	    s8.setAdapter(adspin);
	    s9.setAdapter(adspin);
	    s10.setAdapter(adspin);
	    
	        
		
		
	}
	
	
	
}
