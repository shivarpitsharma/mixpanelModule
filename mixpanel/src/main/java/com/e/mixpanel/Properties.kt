package com.e.mixpanel

import android.os.Bundle
import org.json.JSONArray
import org.json.JSONObject


class Properties {
    private val props = Bundle()

    fun putString(key: String, value: String?) = apply {
        props.putString(key, value ?: MixPanelConstants.VALUE_UNKNOWN)
    }

    fun putInt(key: String, value: Int?) = apply {
        props.putInt(key, value ?: 0)
    }

    fun putDouble(key: String, value: Double) = apply {
        props.putDouble(key, value)
    }

    fun putLong(key: String, value: Long) = apply {
        props.putLong(key, value)
    }

    fun putBoolean(key: String, value: Boolean) = apply {
        props.putBoolean(key, value)
    }

    fun putStringArrayList(key: String, value: ArrayList<String>) = apply {
        props.putStringArrayList(key, value)
    }

    fun clear() = apply {
        props.clear()
    }

    fun getJsonObject(): JSONObject {
        val data = JSONObject()
        for (key in props.keySet()) {
            if (props[key] is ArrayList<*>) {
                data.put(key, JSONArray(props[key] as ArrayList<*>))
            } else {
                data.put(key, props[key])
            }
        }
        return data
    }

    fun getBundle() = props

    fun getHashMap(): HashMap<String, Any> {
        val data = HashMap<String, Any>()
        for (key in props.keySet()) {
            data[key] = props[key] ?: ""
        }
        return data
    }
}