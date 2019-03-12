package com.ahmedazooz.tictactoe

import android.app.ActionBar
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.Button

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)

    }

    fun buClick(view:View){
        var btnOpenPopup= view as Button
        btnOpenPopup=findViewById(R.id.bustart)
        btnOpenPopup.setOnClickListener({this})
        LayoutInflater layoutInflater
        = (LayoutInflater) getBaseContext()
            .getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = layoutInflater.inflate(R.layout.popup_window, null);
        final PopupWindow popupWindow = new PopupWindow(
                popupView,
        ActionBar.LayoutParams.WRAP_CONTENT,
        ActionBar.LayoutParams.WRAP_CONTENT);

        Button btnDismiss = (Button) popupView.findViewById(R.id.dismiss);
        btnDismiss.setOnClickListener(new Button.OnClickListener() {

            @Override
            public void onClick(View v) {
                popupWindow.dismiss();
            }
        });

        popupWindow.showAsDropDown(btnOpenPopup, 20, 90);
    }
    }

}
