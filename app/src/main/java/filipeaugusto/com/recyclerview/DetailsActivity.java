package filipeaugusto.com.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

/**
 * Created by filipe on 18/03/18.
 */

public class DetailsActivity extends AppCompatActivity {

    private static final String TAG = "DetailsActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_details);
        Log.d(TAG, "onCreate: started");
    getIntentIncoming();
   }
   private void getIntentIncoming(){
        if(getIntent().hasExtra("image_url") && getIntent().hasExtra("image_name")){
            Log.d(TAG, "getIntentIncoming: found intent extras");

            String  imageUrl = getIntent().getStringExtra("image_url");
            String  imageName = getIntent().getStringExtra("image_name");

            //calling the method
            setImage(imageUrl, imageName);

        }
   }

   private void setImage(String imageURL, String imageName){
       Log.d(TAG, "setting the image and name to widgets");


       //setting the textview
       TextView name = findViewById(R.id.image_description);
       name.setText(imageName);

       //setting the imageview
       ImageView image = findViewById(R.id.image_detail);
       Glide.with(this)
               .asBitmap()
               .load(imageURL)
               .into(image);

   }
}
