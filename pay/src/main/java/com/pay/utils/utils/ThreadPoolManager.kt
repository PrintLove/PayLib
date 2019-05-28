package com.pay.utils.utils


class ThreadPoolManager {


    companion object {
        fun getInstance() = Manager.manager
    }

    private object Manager {
        val manager = ThreadPoolManager()
    }

    init {

    }

    fun addTask() {

    }

}