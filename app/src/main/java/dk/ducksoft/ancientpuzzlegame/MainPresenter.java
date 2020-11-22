package dk.ducksoft.ancientpuzzlegame;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.HardwareRenderer;
import android.graphics.Point;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.View;
import android.widget.GridLayout;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Random;

public class MainPresenter implements MainActivityContract.MVPView {
    /**
     * This handles the restart btn as in this resulffus the "Game bord"
     */
    public void BtnHandler(View v) {
        Random random = new Random();
        ArrayList<Integer> usedNumbers = new ArrayList<>();

        GridLayout layout = ((ConstraintLayout) v.getParent()).findViewById(R.id.gridView);

        int randomInt;
        int index = 0;

        while (index != 9) {

            randomInt = random.nextInt(9);

            while (!usedNumbers.contains(randomInt)) {

                layout.getChildAt(index).setTag(randomInt);
                layout.getChildAt(index).setBackground(v.getContext().getDrawable(R.drawable.ic_0 + randomInt));

                index++;
                usedNumbers.add(randomInt);
            }
        }
        for (int s : usedNumbers) {

            Log.e("BtnHandler", ""+s);
        }
    }

}

class MyDragShadowBuilder extends View.DragShadowBuilder {

    // The drag shadow image, defined as a drawable thing
    private static Drawable shadow;

    // Defines the constructor for myDragShadowBuilder
    public MyDragShadowBuilder(View v) {

        // Stores the View parameter passed to myDragShadowBuilder.
        super(v);

        // Creates a draggable image that will fill the Canvas provided by the system.
        shadow = new ColorDrawable(Color.LTGRAY);
    }

    // Defines a callback that sends the drag shadow dimensions and touch point back to the
    // system.
    @Override
    public void onProvideShadowMetrics(Point size, Point touch) {
        // Defines local variables
        int width, height;

        // Sets the width of the shadow to half the width of the original View
        width = getView().getWidth() / 2;

        // Sets the height of the shadow to half the height of the original View
        height = getView().getHeight() / 2;

        // The drag shadow is a ColorDrawable. This sets its dimensions to be the same as the
        // Canvas that the system will provide. As a result, the drag shadow will fill the
        // Canvas.
        shadow.setBounds(0, 0, width, height);

        // Sets the size parameter's width and height values. These get back to the system
        // through the size parameter.
        size.set(width, height);

        // Sets the touch point's position to be in the middle of the drag shadow
        touch.set(width / 2, height / 2);
    }

    // Defines a callback that draws the drag shadow in a Canvas that the system constructs
    // from the dimensions passed in onProvideShadowMetrics().
    public void onDrawShadow(Canvas canvas) {

        // Draws the ColorDrawable in the Canvas passed in from the system.
        shadow.draw(canvas);
    }
}
