package com.example.pulkit.tindercards;

import android.content.res.Resources;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;

import com.andtinder.model.CardModel;
import com.andtinder.view.CardContainer;
import com.andtinder.view.SimpleCardStackAdapter;


public class MainActivity extends AppCompatActivity {

    private CardContainer mCardContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.main);
        mCardContainer = (CardContainer) findViewById(R.id.layoutview);
//        Resources r = getResources();

        SimpleCardStackAdapter adapter = new SimpleCardStackAdapter(this);
        adapter.add(new CardModel("Picture1", "Hello1", ContextCompat.getDrawable(this, R.drawable.picture1)));
        adapter.add(new CardModel("Picture2", "Hello2", ContextCompat.getDrawable(this, R.drawable.picture2)));
        adapter.add(new CardModel("Picture3", "Hello3", ContextCompat.getDrawable(this, R.drawable.picture3)));
        adapter.add(new CardModel("Picture4", "Hello4", ContextCompat.getDrawable(this, R.drawable.picture2)));
        adapter.add(new CardModel("Picture5", "Hello5", ContextCompat.getDrawable(this, R.drawable.picture3)));
        adapter.add(new CardModel("Picture6", "Hello6", ContextCompat.getDrawable(this, R.drawable.picture1)));

        CardModel cardModel = new CardModel("Picture1", "Hello1", ContextCompat.getDrawable(this, R.drawable.picture1));
        cardModel.setOnClickListener(new CardModel.OnClickListener() {
            @Override
            public void OnClickListener() {
                Log.i("Swapping Card", "I am pressing the card");
            }
        });

        cardModel.setOnCardDimissedListener(new CardModel.OnCardDimissedListener() {
            @Override
            public void onLike() {
                Log.i("Swipeable Cards","I like the card");
            }

            @Override
            public void onDislike() {
                Log.i("Swipeable Cards","I dislike the card");
            }
        });

        adapter.add(cardModel);
        mCardContainer.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
