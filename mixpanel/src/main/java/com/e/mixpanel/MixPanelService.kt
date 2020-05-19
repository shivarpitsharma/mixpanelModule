package com.e.mixpanel

import android.annotation.SuppressLint
import android.content.Context
import com.mixpanel.android.mpmetrics.MixpanelAPI
import org.json.JSONObject

/**
 * Access to object restricted outside module
 */
internal object MixPanelService {
    @SuppressLint("StaticFieldLeak")
    var mixpanelApi: MixpanelAPI? = null

    fun initMixpanel(context: Context, token: String) {
        if (mixpanelApi == null) {
            mixpanelApi = MixpanelAPI.getInstance(context, token)
        }
    }

    fun logEvent(eventName: String, eventProps: JSONObject? = null) {
        mixpanelApi?.track(eventName, eventProps)
    }

    fun setSuperProperties(superProps: JSONObject) {
        if (mixpanelApi?.superProperties == null) {
            mixpanelApi?.registerSuperProperties(superProps)
        } else {
            updateSuperProperties(superProps)
        }
    }

    fun updateSuperProperties(superProps: JSONObject) {
        mixpanelApi?.updateSuperProperties {
            for (key in superProps.keys()) {
                it.put(key, superProps.get(key))
            }
            it
        }
    }

    fun setUserIdentity(userId: String, isSignUp: Boolean) {
        if (isSignUp) {
            setUserAlias(userId)
        } else {
            identifyUser(userId)
        }
        mixpanelApi?.people?.identify(userId)
    }

    fun setUserAlias(userId: String) {
        mixpanelApi?.alias(userId, mixpanelApi?.distinctId)
    }

    fun identifyUser(userId: String) {
        mixpanelApi?.identify(userId)
    }

    fun resetUser() {
        mixpanelApi?.reset()
    }

    fun pushAllBatchedEvents() {
        mixpanelApi?.flush()
    }

    fun setUserProperties(userProps: JSONObject) {
        mixpanelApi?.people?.set(userProps)
    }

    fun sendFcmToken(fcmToken: String?) {
        mixpanelApi?.people?.pushRegistrationId = fcmToken
    }

    fun timeEvent(eventName: String?) {
        mixpanelApi?.timeEvent(eventName)
    }

    fun getDeviceId(): String? {
        return try {
            val method = mixpanelApi?.javaClass?.getDeclaredMethod("getAnonymousId")
            if (method?.isAccessible == false) {
                method.isAccessible = true
            }
            method?.invoke(mixpanelApi) as String

        } catch (e: Exception) {
            null
        }
    }
}