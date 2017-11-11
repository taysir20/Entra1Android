package com.example.tay.entra1android;

import android.content.Intent;
import android.view.View;

/**
 * Created by tay on 11/11/17.
 */

public class SeconActivityEvents implements View.OnClickListener {
    private SecondActivity secondActivity;

    public SeconActivityEvents(SecondActivity secondActivity) {
        this.secondActivity = secondActivity;
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.btnProfile) {
            Intent intent = new Intent(this.secondActivity, MainActivity.class);
            this.secondActivity.startActivity(intent);
            this.secondActivity.finish();

        } else if (view.getId() == R.id.btnBack) {
            this.secondActivity.setPos(--this.secondActivity.pos);
            if (this.secondActivity.getPos() < 0) {
                this.secondActivity.setPos(1);
            }
            this.secondActivity.setEditableText(this.secondActivity.getPos());


        } else if (view.getId() == R.id.btnNext) {
            this.secondActivity.setPos(++this.secondActivity.pos);
            if (this.secondActivity.getPos() > 3) {
                this.secondActivity.setPos(1);
            }

            this.secondActivity.setEditableText(this.secondActivity.getPos());

        }

    }
}
