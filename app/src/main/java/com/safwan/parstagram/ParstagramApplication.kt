package com.safwan.parstagram

import android.app.Application
import com.parse.Parse
import com.parse.ParseObject

// This class extends the Application class and is used to initialize 
// the Parse SDK when the app starts. 
class ParstagramApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // Register the Post class as a subclass of ParseObject
        ParseObject.registerSubclass(Post::class.java)

        // Initialize the Parse SDK with the application ID, client key, and server URL
        // obtained from the back4app website.
        Parse.initialize(
            Parse.Configuration.Builder(this)
                .applicationId(getString(R.string.back4app_app_id))
                .clientKey(getString(R.string.back4app_client_key))
                .server(getString(R.string.back4app_server_url))
                .build());
    }
}


"""
This is the main application class that sets up the Parse server for the Parstagram app.
It uses the Parse SDK to initialize the Parse server with the provided application id, client 
key and server url. It also registers the custom Post class for use with Parse. The class is
called when the app starts and it sets up the connection with the parse server.
"""
