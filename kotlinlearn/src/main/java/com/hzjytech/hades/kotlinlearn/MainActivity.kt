package com.hzjytech.hades.kotlinlearn

import android.content.Context
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AlertDialog
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.support.v7.widget.helper.ItemTouchHelper
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import com.google.gson.Gson

class MainActivity : AppCompatActivity(), TextWatcher {
    private var mEntryValid=false

    override fun afterTextChanged(s: Editable?) {
        val notEmpty:TextView.()->Boolean={text.isNotEmpty()}
        val isEmail:TextView.()->Boolean={Patterns.EMAIL_ADDRESS.matcher(text).matches()}

        mEntryValid=etFirstName.validateWith(validator=notEmpty) and
                etLastName.validateWith(validator=notEmpty) and
                etEmail.validateWith(validator=isEmail)
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private lateinit var mPrefs: SharedPreferences

    private lateinit var mContacts: ArrayList<Contact>

    private lateinit var etFirstName: EditText

    private lateinit var  etLastName: EditText

    private lateinit var etEmail: EditText


    private lateinit var mAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPrefs=getPreferences(Context.MODE_PRIVATE)

        mContacts=loadContacts()

        mAdapter=ContactsAdapter(mContacts)

//        val toolBar = findViewById<Toolbar>(R.id.toolBar)
//        setSupportActionBar(toolBar)

        setupRecyclerView()


        val fab=findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener{showAddContactDialog(-1)}




    }

    private fun setupRecyclerView() {

        val rcView=findViewById<RecyclerView>(R.id.rcView)

        rcView.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        rcView.adapter=mAdapter

        val helper=ItemTouchHelper(
                object:ItemTouchHelper.SimpleCallback(0,
                        ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT){
                    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?, target: RecyclerView.ViewHolder?): Boolean {
                        return false
                    }

                    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
                        val position= viewHolder!!.adapterPosition
                        mContacts.removeAt(position)
                        mAdapter.notifyItemRemoved(position)
                        saveContacts()

                    }
                })

        helper.attachToRecyclerView(rcView)

    }

    private fun loadContacts():ArrayList<Contact>{
        val contactSet=mPrefs.getStringSet(CONTACT,HashSet())
        return contactSet.mapTo(ArrayList()) {
            Gson().fromJson(it, Contact::class.java)
        }

    }

    private inner class ContactsAdapter internal constructor(
            private val mContacts:ArrayList<Contact>):RecyclerView.Adapter<ContactsAdapter.ViewHolder>(){

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            val (firstName,lastName, email)=mContacts[position]
            val fullName="$firstName$lastName"
            holder.tvItemName.text=fullName
            holder.tvItemEmail.text=email
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder{
            val view=LayoutInflater.from(parent.context).inflate(R.layout.content_main_item,parent,false)
            return ViewHolder(view)
        }

        override fun getItemCount(): Int {
            return mContacts.size
        }

        inner class ViewHolder(itemView:View): RecyclerView.ViewHolder(itemView) {
            init {
                itemView.setOnClickListener { showAddContactDialog(adapterPosition) }
            }

            val tvItemName: TextView = itemView.findViewById(R.id.tvItemName)


            val tvItemEmail:TextView=itemView.findViewById(R.id.tvItemEmail)


        }

    }

    private fun showAddContactDialog(position: Int) {

        val dialogView=LayoutInflater.from(this).inflate(R.layout.input_contact_dialog,null)

        etFirstName =dialogView.findViewById(R.id.etFirstName)
        etLastName=dialogView.findViewById<EditText>(R.id.etLastName)
        etEmail=dialogView.findViewById<EditText>(R.id.etEmail)


        etFirstName.addTextChangedListener(this)
        etLastName.addTextChangedListener(this)
        etEmail.addTextChangedListener(this)

        val editing=position>-1

        val dialogTitle=
                if(editing) {
                    getString(R.string.edit_contact)
                }else{
                    getString(R.string.new_contact)
                }

        val builder=AlertDialog.Builder(this)
                .setView(dialogView)
                .setTitle(dialogTitle)
                .setPositiveButton(R.string.save,null)
                .setNegativeButton(R.string.cancel,null)

        val dialog=builder.show()
        if (editing) {
            val (firstName,lastName,email)=mContacts[position]
            etFirstName.setText(firstName)
            etFirstName.isEnabled=false
            etLastName.setText(lastName)
            etLastName.isEnabled=false
            etEmail.setText(email)
        }

        dialog.getButton(AlertDialog.BUTTON_POSITIVE)
                .setOnClickListener {
                    if(mEntryValid){

                        if(editing) {
                            val editedContact = mContacts[position]
                            editedContact.email = etEmail.text.toString()
                            mContacts[position] = editedContact
                            mAdapter.notifyItemChanged(position)
                        }else{
                            val newContact=Contact(
                                    etFirstName.text.toString(),
                                    etLastName.text.toString(),
                                    etEmail.text.toString()
                            )

                            mContacts.add(newContact)
                            mAdapter.notifyItemInserted(mContacts.size)
                        }
                        saveContacts()
                        dialog.dismiss()
                    }
                }




    }

    private fun saveContacts() {

        val editor=mPrefs.edit();
        editor.clear()
        val contactSet=mContacts.map { Gson().toJson(it) }.toSet()
        editor.putStringSet(CONTACT,contactSet)
    }

    companion object {
        private val CONTACT="contact_key"
        private val TAG=MainActivity::class.java.simpleName
    }
}


internal data class Contact(var firstName:String, var lastName:String, var email:String?)
