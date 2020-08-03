package com.developer.allef.picpay.ui.contact

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developer.allef.picpay.data.model.Contact
import com.developer.allef.picpay.databinding.ItemContactBinding
import com.developer.allef.picpay.extensions.loadImgCircle

/**
 * @author allef.santos on 31/07/20
 */
class ContactAdapter(private val itemClick: (Contact) -> Unit) :
    RecyclerView.Adapter<ContactAdapter.ContactAdapterViewHolder>() {
    private lateinit var context: Context
    private var listContact = mutableListOf<Contact>()

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ContactAdapterViewHolder {
        context = parent.context
        return ContactAdapterViewHolder(
            ItemContactBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ),itemClick
        )
    }

    fun addItems(newList:List<Contact>){
        listContact.clear()
        listContact.addAll(newList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int  = listContact.size

    override fun onBindViewHolder(holder: ContactAdapterViewHolder, position: Int) {
        val contact = listContact[position]
        holder.bind(contact)

    }

    inner class ContactAdapterViewHolder(
        private val itemBinding: ItemContactBinding,
        val itemClick: (Contact) -> Unit
    ) : RecyclerView.ViewHolder(itemBinding.root) {

        fun bind(contact: Contact) {

            with(contact){
                itemBinding.root.setOnClickListener { itemClick(this) }
            }

            itemBinding.tvNameContact.text = contact.name
            itemBinding.tvIdContact.text = contact.username
            itemBinding.ivContact.loadImgCircle(contact.img)
        }
    }

}