package dk.ducksoft.ancientpuzzlegame;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.util.Log;
import android.view.DragEvent;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;


public class myDragEventListener implements View.OnDragListener {

    private ClipData.Item item;

    /**
     * This is the method that the system calls when it dispatches a drag event to the
     * listener.
     **/
    public boolean onDrag(View v, DragEvent event) {

        // Defines a variable to store the action type for the incoming event
        final int action = event.getAction();

        // Handles each of the expected events
        switch (action) {
            case DragEvent.ACTION_DRAG_STARTED:
                if (event.getClipDescription().hasMimeType(ClipDescription.MIMETYPE_TEXT_PLAIN)) {
                    // We don't understand WHY this has to be here....
                    // it just wont work with out
                    v.invalidate();

                    // returns true to indicate that the View can accept the dragged data.
                    return true;

                }

                // Returns false. During the current drag and drop operation, this View will
                // not receive events again until ACTION_DRAG_ENDED is sent.
                return false;

            case DragEvent.ACTION_DRAG_ENTERED:

                //TODO: make a if clicked item is next to the box that contains "0" in either row or column then allow drag.

                //Applies a green tint to the View. Return true; the return value is ignored.
                if ((v.getTag() != null) && (int) v.getTag() == 0)
                    v.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
                // Invalidate the view to force a redraw in the new tint
                v.invalidate();
                return true;

            case DragEvent.ACTION_DRAG_EXITED:

                /*
                * Resets the "Game Bord" to the default black color
                * */
                v.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));

                // Invalidate the view to force a redraw in the new tint
                v.invalidate();

                return true;

            case DragEvent.ACTION_DRAG_LOCATION:
                return true;

            case DragEvent.ACTION_DROP:

                // Gets the item containing the dragged data
                item = event.getClipData().getItemAt(0);

                CharSequence data = item.getText();

                // Turns off any color tints
                if ((int) v.getTag() == 0) {
                    int tagZero = 0;
                    View iv = ((GridLayout) v.getParent()).findViewWithTag(Integer.parseInt(data.toString()));
                    iv.setBackground(v.getContext().getDrawable(R.drawable.ic_0));
                    iv.setTag(tagZero);

                    int tagNew = Integer.parseInt(data.toString());
                    v.setBackground(v.getContext().getDrawable(R.drawable.ic_0 + Integer.parseInt(data.toString())));
                    v.setTag(tagNew);
                }

                v.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));

                // Invalidates the view to force a redraw
                v.invalidate();

                // Returns true. DragEvent.getResult() will return true.
                return true;

            case DragEvent.ACTION_DRAG_ENDED:

                /*
                 * Resets the "Game Bord" to the default black color
                 * */
                v.setBackgroundTintList(ColorStateList.valueOf(Color.BLACK));
                // Invalidates the view to force a redraw
                v.invalidate();
                Log.e("","");
                return true;

            // An unknown action type was received.
            default:
                Log.e("DragDrop Example", "Unknown action type received by OnDragListener.");
                break;
        }

        return false;
    }
};