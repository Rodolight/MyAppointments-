package com.rdpsoftware.myappointments.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.rdpsoftware.myappointments.Models.Appointment
import com.rdpsoftware.myappointments.R


class AppointmentAdapter : RecyclerView.Adapter<AppointmentAdapter.ViewHolder>() {
    var appointments = ArrayList<Appointment>()

    class ViewHolder(itemView:View) : RecyclerView.ViewHolder(itemView){
       fun bind(appointment:Appointment) = with(itemView){
               findViewById<TextView>(R.id.tvAppointment).text =
                        context.getString(R.string.item_appointnment_id,appointment.id)
               findViewById<TextView>(R.id.tvDoctor).text = appointment.doctor.name
               findViewById<TextView>(R.id.tvScheduledDate).text =
                        context.getString(R.string.item_appointnment_date,appointment.scheduledDate)
               findViewById<TextView>(R.id.tvScheduledTime).text =
                        context.getString(R.string.item_appointnment_time,appointment.scheduleTime)
            }
       }

    // Inflate XML items
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_appointment,parent,false))
    }
    // Binds Data
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val appointment =  appointments[position]

        holder.bind(appointment)

    }

    // Number of elements
    override fun getItemCount() = appointments.size

}
