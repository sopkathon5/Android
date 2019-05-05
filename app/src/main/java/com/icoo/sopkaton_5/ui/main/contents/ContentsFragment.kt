package com.icoo.sopkaton_5.ui.main.contents

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.icoo.sopkaton_5.R

class ContentsFragment : Fragment() {
    private lateinit var rootView: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.fragment_contents, container, false)
        return rootView

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    companion object {
        private val TAG = "ContentsFragment"

        fun newInstance(): ContentsFragment {
            return ContentsFragment()
        }
    }

}
