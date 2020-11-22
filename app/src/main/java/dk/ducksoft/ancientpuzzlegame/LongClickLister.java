package dk.ducksoft.ancientpuzzlegame;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.view.View;

public class LongClickLister implements View.OnLongClickListener {

    @Override
    public boolean onLongClick(View v) {
        // Defines the one method for the interface, which is called when the View is long-clicked

        // Create a new ClipData.
        // This is done in two steps to provide clarity. The convenience method
        // ClipData.newPlainText() can create a plain text ClipData in one step.

        // Create a new ClipData.Item from the ImageView object's tag
        ClipData.Item item = new ClipData.Item(String.valueOf(v.getSourceLayoutResId()));

        // Create a new ClipData using the tag as a label, the plain text MIME type, and
        // the already-created item. This will create a new ClipDescription object within the
        // ClipData, and set its MIME type entry to "text/plain"
        ClipData dragData = new ClipData(
                (CharSequence) v.getTag(),
                new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
                item);

        // Instantiates the drag shadow builder.
        View.DragShadowBuilder myShadow = new MyDragShadowBuilder(v);

        // Starts the drag

        v.startDragAndDrop(dragData,  // the data to be dragged
                myShadow,  // the drag shadow builder
                null,      // no need to use local data
                0          // flags (not currently used, set to 0)
        );
        return false;
    }
}
