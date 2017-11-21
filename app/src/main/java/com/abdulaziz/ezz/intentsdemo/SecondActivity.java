package com.abdulaziz.ezz.intentsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{

	private TextView mTitle;
	private TextView mMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);

		mTitle = findViewById(R.id.tvTitle);
		mMessage = findViewById(R.id.tvMessage);

		Intent intent = getIntent();
		if (intent != null)
			if (intent.hasExtra(Intent.EXTRA_TEXT))
				mMessage.setText(intent.getStringExtra(Intent.EXTRA_TEXT));
	}
}
