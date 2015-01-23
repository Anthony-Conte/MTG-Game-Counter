package hello.mtggc.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;


public class PlayerSelection extends ActionBarActivity {
    TextView p1_life;
    EditText p1_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_selection);
        p1_life = (TextView)findViewById(R.id.player1_life);
        p1_name = (EditText)findViewById(R.id.player1_name);

        //Changing the focus change listener to hide the keyboard when the user taps somewhere that isn't the textfield or keyboard.
        /*p1_name.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }
        });*/

    }
    int start_health = 20;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_selection, menu);
        return true;
    }



    /*public void resetFocus(View v){
        p1_name.clearFocus();
        p1_name.setCursorVisible(false);

    }*/

    public void subtract_p1_Health(View v){
        p1_name.setCursorVisible(false);
        start_health -= 1;
        p1_life.setText(Integer.toString(start_health));

    }
    public void hide_cursor(){
        p1_name.setCursorVisible(false);
    }
    public void show_cursor(View v){
        p1_name.setCursorVisible(true);
    }
    public void add_p1_Health(View v){
        p1_name.setCursorVisible(false);
        start_health += 1;
        p1_life.setText(Integer.toString(start_health));

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
//commit test
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
        hide_cursor();
    }

}
