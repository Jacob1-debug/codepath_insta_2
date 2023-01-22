"""
The code is a Kotlin class representing a "Post" object for the Parstagram application. 
It is using the Parse library to interact with a backend server and store/retrieve post data. 
The class defines properties for a post such as a description, image, and user who created the post.
It also defines getter and setter methods for these properties, as well as a companion object that contains 
the keys for these properties as constants. Additionally, the class is annotated with @ParseClassName to specify
that it is a ParseObject subclass.

"""

package com.safwan.parstagram

import com.parse.ParseClassName
import com.parse.ParseFile
import com.parse.ParseObject
import com.parse.ParseUser
import java.io.File

// Description : String
// Image : File
// User : User

@ParseClassName("Post")
class Post : ParseObject() {

    /**
     * Get the description of the post
     *
     * @return String - Description of the post
     */
    fun getDescription(): String? {
        return getString(KEY_DESCRIPTION)
    }

    /**
     * Set the description of the post
     *
     * @param descrption - Description of the post
     */
    fun setDescription(descrption: String){
        put(KEY_DESCRIPTION,descrption)
    }

    /**
     * Set the image of the post
     *
     * @param parsefile - File containing the image of the post
     */
    fun setImage(parsefile: ParseFile) {
        put(KEY_IMAGE,parsefile)
    }

    /**
     * Get the image of the post
     *
     * @return ParseFile - File containing the image of the post
     */
    fun getImage(): ParseFile? {
        return getParseFile(KEY_IMAGE)
    }

    /**
     * Get the user who made the post
     *
     * @return ParseUser - User who made the post
     */
    fun getUser() : ParseUser? {
        return getParseUser(KEY_USER)
    }

    /**
     * Set the user who made the post
     *
     * @param user - User who made the post
     */
    fun setUser(user: ParseUser) {
        put(KEY_USER, user)
    }

    companion object{
        const val KEY_DESCRIPTION = "description"
        const val KEY_IMAGE = "Image"
        const val KEY_USER = "user"
    }

}

