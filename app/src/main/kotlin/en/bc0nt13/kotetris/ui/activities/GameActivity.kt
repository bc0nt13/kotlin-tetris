package en.bc0nt13.kotetris.ui.activities

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import en.bc0nt13.kotetris.R

public class GameActivity : ActionBarActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        ActionBarActivity.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.container, PlaceholderFragment()).commit()
        }
    }


}
