package com.cobblesms

import java.io.IOException

import android.app.AlertDialog
import android.os.Bundle
import android.support.v7.app.ActionBarActivity
import android.util.Log
import android.view.{Menu, MenuItem}

class CobbleSMS extends ActionBarActivity {

    private var server: WebServer = _

    override def onCreate(savedInstanceState: Bundle) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cobble_sms)
        server = new WebServer()
        try {
            server.start()
        } catch {
            case ioe: IOException => Log.w("Httpd", "The server could not start.")
        }
        Log.w("Httpd", "Web server initialized.")
    }

    override def onDestroy() {
        super.onDestroy()
        if (server != null) server.stop()
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

    override def onBackPressed() {

    }
}