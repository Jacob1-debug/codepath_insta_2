package com.safwan.parstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
package com.safwan.parstagram

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class PostAdapter(val context: Context, val posts: List<Post>) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.ViewHolder {

        val view = LayoutInflater.from(context).inflate(R.layout.item_post, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostAdapter.ViewHolder, position: Int) {
        val post = posts.get(position)
        holder.bind(post)
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        val tvUsername : TextView
        val ivImage : ImageView
        val tvDesription : TextView

        init {
            tvUsername = itemView.findViewById(R.id.tvUsername)
            ivImage = itemView.findViewById(R.id.ivImage)
            tvDesription = itemView.findViewById(R.id.tvDescription)
        }

        fun bind(post: Post) {
            //Set the description of the post to the TextView
            tvDesription.text = post.getDescription()
            
            //Set the username of the user to the TextView
            tvUsername.text = post.getUser()?.username

            //Load the image of the post into the ImageView
            Glide.with(itemView.context).load(post.getImage()?.url).into(ivImage)

        }

    }
}


"""
This code is a RecyclerView adapter for a social media app called Parstagram. 
The adapter is used to display a list of "Post" objects in the app's feed. 
The adapter takes in a context and a list of posts as arguments in its constructor.
The "onCreateViewHolder" function inflates the layout for each item in the RecyclerView, 
the "onBindViewHolder" function binds the data for each item in the RecyclerView, and the "getItemCount" 
function returns the number of items in the list of posts. The "ViewHolder" class within the adapter defines 
the layout elements for each item in the RecyclerView, and the "bind" function sets the text and image for each
item in the RecyclerView using data from the corresponding post object.
"""
