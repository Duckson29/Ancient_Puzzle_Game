package dk.ducksoft.ancientpuzzlegame;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.ImageView;

import java.lang.reflect.Array;
import java.util.ArrayList;

import dk.ducksoft.ancientpuzzlegame.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private MainPresenter mainPresetner;
    private LongClickLister clickLister;
    private ImageView imageView;
    // Creates a new drag event listener
    myDragEventListener dragListen = new myDragEventListener();

// Sets the drag event listener for the View

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainPresetner = new MainPresenter();
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setPreset(mainPresetner);

        clickLister = new LongClickLister();
        imageView = findViewById(R.id.imageView1);
        imageView.setOnDragListener(dragListen);
        imageView.setOnLongClickListener(clickLister);

        ArrayList<ImageView> allTheViews = new ArrayList<>();

        GridLayout gridView = this.findViewById(R.id.gridView);

        for(int i = 0; i < gridView.getChildCount(); i++){
            gridView.getChildAt(i).setOnDragListener(dragListen);
            gridView.getChildAt(i).setOnLongClickListener(clickLister);
            gridView.getChildAt(i).setBackground(R.drawable.);
        }

//        imageView.setOnLongClickListener(new View.OnLongClickListener() {
//
//            // Defines the one method for the interface, which is called when the View is long-clicked
//            public boolean onLongClick(View v) {
//
//                // Create a new ClipData.
//                // This is done in two steps to provide clarity. The convenience method
//                // ClipData.newPlainText() can create a plain text ClipData in one step.
//
//                // Create a new ClipData.Item from the ImageView object's tag
//                ClipData.Item item = new ClipData.Item((Intent) v.getTag());
//
//                // Create a new ClipData using the tag as a label, the plain text MIME type, and
//                // the already-created item. This will create a new ClipDescription object within the
//                // ClipData, and set its MIME type entry to "text/plain"
//                ClipData dragData = new ClipData(
//                        (CharSequence) v.getTag(),
//                        new String[]{ClipDescription.MIMETYPE_TEXT_PLAIN},
//                        item);
//
//                // Instantiates the drag shadow builder.
//                View.DragShadowBuilder myShadow = new MyDragShadowBuilder(imageView);
//
//                // Starts the drag
//
//                v.startDragAndDrop(dragData,  // the data to be dragged
//                        myShadow,  // the drag shadow builder
//                        null,      // no need to use local data
//                        0          // flags (not currently used, set to 0)
//                );
//                return true;
//            }
//        });

    }


}