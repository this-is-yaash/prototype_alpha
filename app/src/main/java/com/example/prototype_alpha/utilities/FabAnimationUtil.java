package com.example.prototype_alpha.utilities;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.prototype_alpha.R;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class FabAnimationUtil {
    private Animation fabOpen, fabOpen2, fabClose, fabClose2, rotateForward, rotateBackward;
    private FloatingActionButton fab;
    private ExtendedFloatingActionButton fab1, fab2;
    private boolean isOpen = false;

    public FabAnimationUtil(
            Context context,
            FloatingActionButton fab,
            ExtendedFloatingActionButton fab1,
            ExtendedFloatingActionButton fab2
    ) {
        this.fab = fab;
        this.fab1 = fab1;
        this.fab2 = fab2;

        // Initialize animations here...
        fabOpen = AnimationUtils.loadAnimation(context, R.anim.fab_open);
        fabClose = AnimationUtils.loadAnimation(context, R.anim.fab_close);
        fabOpen2 = AnimationUtils.loadAnimation(context, R.anim.fab_open_2);
        fabClose2 = AnimationUtils.loadAnimation(context, R.anim.fab_close_2);
        rotateForward = AnimationUtils.loadAnimation(context, R.anim.rotate_forward);
        rotateBackward = AnimationUtils.loadAnimation(context, R.anim.rotate_backward);
    }

    public void animateFab() {
        if (isOpen) {
            fab.startAnimation(rotateForward);
            fab1.startAnimation(fabClose);
            fab2.startAnimation(fabClose2);
            fab1.setClickable(false);
            fab2.setClickable(false);
            isOpen = false;
        } else {
            fab.startAnimation(rotateBackward);
            fab1.startAnimation(fabOpen);
            fab2.startAnimation(fabOpen2);
            fab1.setClickable(true);
            fab2.setClickable(true);
            isOpen = true;
        }
    }
}
