package com.example.nyc_schools_test.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.nyc_schools_test.common.OnSchoolClicked
import com.example.nyc_schools_test.databinding.SchoolItemLayoutBinding
import com.example.nyc_schools_test.domain.SchoolDomain
import com.example.nyc_schools_test.model.remote.SchoolListResponse

class NYCAdapter(
    private val onSchoolClicked: OnSchoolClicked,
    private val items: MutableList<SchoolDomain> = mutableListOf()
) : RecyclerView.Adapter<NYCAdapter.NYCViewHolder>() {

    class NYCViewHolder(val binding: SchoolItemLayoutBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun updateData(newSchools: List<SchoolDomain>) {
        items.addAll(newSchools)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NYCViewHolder {
        return NYCViewHolder(
            SchoolItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: NYCViewHolder, position: Int) {
        holder.binding.tvSchoolName.text = items[position].school_name
        holder.binding.tvSchoolLocation.text = items[position].neighborhood
        holder.binding.tvSchoolPhone.text = items[position].phone_number


        holder.binding.cardView.setOnClickListener {
            onSchoolClicked.schoolClicked(items[position])
        }
    }

    override fun getItemCount(): Int = items.size
}