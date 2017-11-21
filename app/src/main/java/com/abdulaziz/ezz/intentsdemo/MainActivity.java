package com.abdulaziz.ezz.intentsdemo;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

	private EditText mMessage;
	private Button mOpenSecondActivity;
	private Button mOpenWebPage;
	private Button mOpenMap;
	private Button mShare;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mMessage = findViewById(R.id.etMessage);
		mOpenSecondActivity = findViewById(R.id.btnOpenSecondActivity);
		mOpenWebPage = findViewById(R.id.btnOpenWebPage);
		mOpenMap = findViewById(R.id.btnOpenMap);
		mShare = findViewById(R.id.btnShare);

		mOpenSecondActivity.setOnClickListener(this);
		mOpenWebPage.setOnClickListener(this);
		mOpenMap.setOnClickListener(this);
		mShare.setOnClickListener(this);

	}

	@Override
	public void onClick(View view)
	{
		switch (view.getId())
		{
		case R.id.btnOpenSecondActivity:
			Intent secondActivityIntent = new Intent(this, SecondActivity.class);
			secondActivityIntent.putExtra(Intent.EXTRA_TEXT, mMessage.getText().toString());
			startActivity(secondActivityIntent);
			break;
		case R.id.btnOpenWebPage:
			Intent webPageIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.facebook.com"));
			if (webPageIntent.resolveActivity(getPackageManager()) != null)
				startActivity(webPageIntent);
			break;
		case R.id.btnOpenMap:
			String addressString = "1600 Amphitheatre Parkway, CA";

			Uri.Builder builder = new Uri.Builder();
			builder.scheme("geo").path("0,0").query(addressString);
			Uri addressUri = builder.build();

			Intent intent = new Intent(Intent.ACTION_VIEW);
			intent.setData(addressUri);
			if (intent.resolveActivity(getPackageManager()) != null)
				startActivity(intent);
			break;
		case R.id.btnShare:
			ShareCompat.IntentBuilder.from(this).setType("text/plain").setChooserTitle("Share To..").setText(mMessage.getText().toString())
					.startChooser();
			break;
		}
	}
}
