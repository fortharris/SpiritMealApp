package com.sabonzy.spiritmealbible;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class FeedBack extends ActionBarActivity {

	EditText etSubject, emailMessages, emailTo;
	Button send;
	private String myEmail;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.feedback);
		etSubject = (EditText) findViewById(R.id.etsubject);
		emailMessages = (EditText) findViewById(R.id.etmessage);
		emailTo = (EditText) findViewById(R.id.etto);
		myEmail = "tmselorm@gmail.com";
		emailTo.setText(myEmail);
		send = (Button) findViewById(R.id.button1);
		//int currentapiVersion = android.os.Build.VERSION.SDK_INT;
		
		ActionBar bar = getSupportActionBar();
		bar.setDisplayHomeAsUpEnabled(true);
		bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#63B8E8")));
		
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				String emailSubject = etSubject.getText().toString();
				String mailMessage = emailMessages.getText().toString();

				String[] mails = { myEmail };
				Intent emailIntent = new Intent(Intent.ACTION_SEND);
				emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, mails);
				emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT,
						emailSubject);
				emailIntent.setType("plain/text");
				emailIntent.putExtra(android.content.Intent.EXTRA_TEXT,
						mailMessage);
				startActivity(emailIntent);
			}
		});

	}

	

}
