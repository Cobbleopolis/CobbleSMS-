package com.cobblesms

import android.support.v7.app.ActionBarActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem

class CobbleSMS extends ActionBarActivity {

    protected override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cobble_sms)
    }

    override def onCreateOptionsMenu(menu: Menu): Boolean = {
        getMenuInflater.inflate(R.menu.menu_cobble_sm, menu)
        true
    }

    override def onOptionsItemSelected(item: MenuItem): Boolean = {
        val id = item.getItemId
        if (id == R.id.action_settings) {
            return true
        }
        super.onOptionsItemSelected(item)
    }
}