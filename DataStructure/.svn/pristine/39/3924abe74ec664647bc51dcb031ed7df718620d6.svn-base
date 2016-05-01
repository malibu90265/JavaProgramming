package com.example.gram_android;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button mainBtn01 = (Button) findViewById(R.id.button1); //무게 측정 버튼
		Button mainBtn02 = (Button) findViewById(R.id.button2); //레시피 만들기 버튼
		Button mainBtn03 = (Button) findViewById(R.id.button3); //사용법
		Button mainBtn04 = (Button) findViewById(R.id.button4); //앱 종료
		
		
		//무게 측정 버튼
		mainBtn01.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent Intent01 = new Intent(getApplicationContext(), playGram.class);
				startActivity(Intent01);
			}
		});
		
		
		//레시피 만들기 버튼
		mainBtn02.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent Intent02 = new Intent(getApplicationContext(), makeNewRecipe.class);
				startActivity(Intent02);
			}
		});
		
		
		//사용법
		mainBtn03.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				Intent Intent03 = new Intent(getApplicationContext(), howtoUse.class);
				startActivity(Intent03);
			}
		});
		
		
		//앱 종료
		mainBtn04.setOnClickListener(new OnClickListener(){
			public void onClick(View v){
				finish();
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
