package com.example.vuzapp.ui.notifications.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.vuzapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class PaymentNotificationBottomSheet: BottomSheetDialogFragment() {

    companion object {

        const val TAG = "Payment notification bottom sheet"
        // put your arguments here
        fun newInstance(): PaymentNotificationBottomSheet {
            val bottomSheet = PaymentNotificationBottomSheet()
            return bottomSheet
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(DialogFragment.STYLE_NORMAL, R.style.CustomBottomSheetDialogTheme)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.message_open, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // put your code here
    }

}