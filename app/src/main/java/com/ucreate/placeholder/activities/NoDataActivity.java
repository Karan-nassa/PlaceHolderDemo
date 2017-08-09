package com.ucreate.placeholder.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.jetradar.desertplaceholder.DesertPlaceholder;
import com.ucreate.placeholder.R;
import com.ucreate.placeholder.utils.AppUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NoDataActivity extends AppCompatActivity {


    @Bind(R.id.PlaceHolder)
    DesertPlaceholder PlaceHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_data);

        ButterKnife.bind(this);

        PlaceHolder.setOnButtonClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (AppUtils.isOnline(NoDataActivity.this)) {
                    onBackPressed();
                }
                PlaceHolder.setMessage(getString(R.string.error_check_internet));
            }
        });
    }
}
