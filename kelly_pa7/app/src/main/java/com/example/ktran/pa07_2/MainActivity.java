/**
 *  Notes V2
 *  PA07
 *
 * @author Kevin Tran and Brandon Kelly
 * @version v1.0
 *
 * We sat down and worked on the project at the same time.
 * So the work was 50/50 because we split our ideas, or combined them into
 * one thing.
 *
 */

package com.example.ktran.pa07_2;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int CREATE_NOTE = 1;
    private static final int EDIT_NOTE = 2;

    SimpleCursorAdapter cursorAdapter;
    private ListView list_view;
    DBHelper cdbh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /**
         * Set up
         */
        list_view = new ListView(this);
        list_view.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        /**
         * Database
         */
        cdbh = new DBHelper(this);
        Cursor cursor = cdbh.getSelectAllContactsCursor();
        cursorAdapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_1,
                cursor,
                new String[] {cdbh.NAME}, //basically title
                new int[] {android.R.id.text1},
                0
        );

        list_view.setAdapter(cursorAdapter);
        list_view.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            @Override
            public void onItemCheckedStateChanged(ActionMode actionMode, int i, long l, boolean b) {
                int numSelected = list_view.getCheckedItemCount();
                actionMode.setTitle(numSelected + " selected");
            }

            @Override
            public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
                MenuInflater menuInflater = actionMode.getMenuInflater();
                menuInflater.inflate(R.menu.cam_menu, menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
                int menuId = menuItem.getItemId();

                if(menuId == R.id.deleteMenuAction){
                    SparseBooleanArray sp = list_view.getCheckedItemPositions();
                    for(int i = 0; i < list_view.getCheckedItemCount(); i++){
                        if(sp.valueAt(i)) {
                            Cursor cursor = (Cursor) list_view.getItemAtPosition(i);
                            String name = cursor.getString(cursor.getColumnIndex(cdbh.NAME));
                            Toast.makeText(MainActivity.this, name + " ", Toast.LENGTH_SHORT).show();
                            cdbh.delete(name);
                        }
                    }
                }
                cursorAdapter.changeCursor(cdbh.getSelectAllContactsCursor());
                actionMode.finish();
                return true;
            }

            @Override
            public void onDestroyActionMode(ActionMode actionMode) {

            }
        });


        /**
         * Layout
         */
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(1);
        GridLayout.LayoutParams lvLayoutParams = new GridLayout.LayoutParams();
        lvLayoutParams.width = GridLayout.LayoutParams.MATCH_PARENT;
        list_view.setLayoutParams(lvLayoutParams);
        gridLayout.addView(list_view);
        setContentView(gridLayout);

        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View arg1, int i, long arg3)
            {
                Cursor cursor = (Cursor) adapterView.getItemAtPosition(i);
                String name = cursor.getString(cursor.getColumnIndex(cdbh.NAME));
                int id = cursor.getInt(cursor.getColumnIndex(cdbh.ID));
                String type = cursor.getString(cursor.getColumnIndex(cdbh.TYPE));
                String cont = cursor.getString(cursor.getColumnIndex(cdbh.CONT));

                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("content", cont);
                intent.putExtra("title", name);
                intent.putExtra("type", type);
                intent.putExtra("position", id);

                startActivityForResult(intent, EDIT_NOTE);

            }
        });
    }

    /**
     * Mind for the option we picked.
     * @param item
     * @return
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int menuId = item.getItemId();
        switch(menuId) {
            case R.id.addNote:
                Intent intent = new Intent(this,
                        NoteActivity.class);
                intent.putExtra("content", "");
                intent.putExtra("title", "");
                intent.putExtra("type", "");
                intent.putExtra("position", -1);
                startActivityForResult(intent, CREATE_NOTE);
                return true;
            case R.id.deleteAll:
                AlertDialog.Builder builder1 = new AlertDialog.Builder(MainActivity.this);
                builder1.setTitle("Delete A Note");
                builder1.setMessage("You sure you want to delete all of the notes?");
                builder1.setCancelable(true);

                builder1.setPositiveButton(
                        "Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                cdbh.deleteAllNotes();
                                cursorAdapter.changeCursor(cdbh.getSelectAllContactsCursor());
                            }
                        });
                builder1.setNegativeButton(
                        "No",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alert11 = builder1.create();
                alert11.show();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }


    /**
     * Creates our menu bar
     * @param menu
     * @return
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mi  = getMenuInflater();
        mi.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Returns activity on result
     * @param int requestCode, int resultCode, Intent data
     * @return
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CREATE_NOTE) {
            if(resultCode == Activity.RESULT_OK){
                String title = data.getStringExtra("title");
                String type = data.getStringExtra("type");
                String content = data.getStringExtra("content");
                Note n = new Note(title, type, content);

                cdbh.insert(n);
                cursorAdapter.changeCursor(cdbh.getSelectAllContactsCursor());

            }
        }

        if(requestCode == EDIT_NOTE){
            if(resultCode == Activity.RESULT_OK){
                String title = data.getStringExtra("title");
                String type = data.getStringExtra("type");
                String content = data.getStringExtra("content");
                int pos = data.getIntExtra("position", 0);
                Note n = new Note(title, type, content);

                cdbh.update(pos, n);
                cursorAdapter.changeCursor(cdbh.getSelectAllContactsCursor());
            }

        }
    }


}
