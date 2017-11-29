package com.rhino.socialfeed.ui.main

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.ActionBarDrawerToggle
import android.util.Log
import android.view.MenuItem
import com.rhino.socialfeed.R
import com.rhino.socialfeed.app.SocialFeedApplication
import com.rhino.socialfeed.common.RxActivity
import com.rhino.socialfeed.ui.main.di.DaggerMainComponent
import com.rhino.socialfeed.ui.main.di.MainModule
import com.rhino.socialfeed.ui.main.mvp.MainContract
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*
import kotlinx.android.synthetic.main.main_content.*
import javax.inject.Inject


class MainActivity : RxActivity() {

    @Inject lateinit var view: MainContract.View
    @Inject lateinit var presenter: MainContract.Presenter

    private lateinit var drawerToggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initComponent()
        setContentView(view.inflateLayout())
        setSupportActionBar(toolbar)

        drawerToggle = object : ActionBarDrawerToggle(
                this, /* host Activity */
                drawerLayout, /* DrawerLayout object */
                R.string.drawer_open, /* "open drawer" description */
                R.string.drawer_close  /* "close drawer" description */
        ) {}

        drawerLayout.addDrawerListener(drawerToggle)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setHomeButtonEnabled(true)
        presenter.onCreate()
    }

    override fun onDestroy() {
        presenter.onDestroy()
        super.onDestroy()
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        val fragment = supportFragmentManager.findFragmentById(R.id.flContent)
            fragment?.onActivityResult(requestCode, resultCode, data)
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        drawerToggle.onConfigurationChanged(newConfig)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        return if (drawerToggle.onOptionsItemSelected(item)) {
            true
        } else super.onOptionsItemSelected(item)
        // Handle your other action bar items...

    }

    private fun initComponent() {
        DaggerMainComponent.builder()
                .appComponent(SocialFeedApplication[this].component())
                .mainModule(MainModule(this))
                .build()
                .inject(this)
    }

}
