package com.example.jandy

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.example.jandy.databinding.ItemCalendarListBinding
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Locale

class CalendarAdaptor(private val cList: List<CalendarVO>) :
    RecyclerView.Adapter<CalendarAdaptor.CalendarViewHolder>() {

    class CalendarViewHolder(private val binding: ItemCalendarListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        fun bind(item: CalendarVO) {
            binding.date.text = item.cl_date
            binding.day.text = item.cl_day

            var today = binding.date.text

            // 오늘 날짜
            val now = LocalDate.now().format(
                DateTimeFormatter.ofPattern("dd").withLocale(
                    Locale.forLanguageTag("ko")
                )
            )
            if (today == now) {
                binding.weekCardview.setBackgroundResource(R.drawable.background_blue)
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CalendarAdaptor.CalendarViewHolder {
        val binding =
            ItemCalendarListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarAdaptor.CalendarViewHolder(binding)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: CalendarViewHolder, position: Int) {
        holder.bind(cList[position])
    }

    override fun getItemCount(): Int {
        return cList.size
    }
}