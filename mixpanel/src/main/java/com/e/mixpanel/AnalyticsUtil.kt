package com.e.mixpanel

import android.content.Context


object AnalyticsUtil {
    var REF = MixPanelConstants.VALUE_DIRECT

    /**
     * Method to be used to initialise MixPanel
     */
    fun initMixPanel(context: Context, token: String){
        MixPanelService.initMixpanel(context,token)
    }

    fun logEvent(eventName: String, eventProps: Properties? = null) {
        MixPanelService.logEvent(eventName, eventProps?.getJsonObject())
    }

    fun setSuperProperties(superProps: Properties) {
        MixPanelService.setSuperProperties(superProps.getJsonObject())
    }

    fun setUserProperties(superProps: Properties) {
        MixPanelService.setUserProperties(superProps.getJsonObject())
    }

    fun setUserIdentity(userId: String?, isSignUp: Boolean) {
        MixPanelService.setUserIdentity(userId ?: MixPanelConstants.VALUE_UNKNOWN, isSignUp)
    }

    fun resetUser() {
        MixPanelService.resetUser()
    }

    fun sendFcmToken(fcmToken: String?) {
        MixPanelService.sendFcmToken(fcmToken)
    }

    fun setTimeEvent(eventName: String?) {
        MixPanelService.timeEvent(eventName)
    }

    fun getDeviceId(): String? {
        return MixPanelService.getDeviceId()
    }

    fun flushMixPanelEvents(){
        MixPanelService.pushAllBatchedEvents()
    }
}