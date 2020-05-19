# Mixpanel Integration Utility
Utility module for MixPanel integration

## Mixpanel Analytics
Mixpanel helps you analyze user behavior across your sites with Real-Time Cohort Analysis. The integration of the Mixpanel API in android required to post events on the mixpanel project. The current project provides utilities that one would require to integrate this analytics tool into android project.

## To include this in your project 

**Step 1** : First add the JitPack repository to your build file :

```
repositories {
    ...
    maven { url 'https://jitpack.io' }
}
    
```
**Step 2** : Add the dependency : 
```
dependencies {
	 implementation 'com.github.shivarpitsharma:mixpanelModule:v1.0'
}
```  
**Step 3** : Setup Mixpanel project and generate token from [here](https://mixpanel.com/login/):

**Step 4** : Initialize Mixpanel in your application class :

```
 override fun onCreate() {
   super.onCreate()
   ...
   MixPanelService.initMixpanel(applicationContext, ~token~ )
}

```
You are all set to use the methods to log events on mixpanel.

## Contributors
[Ashutosh Gupta](https://www.linkedin.com/in/ashutosh15/)

[Shivarpit Sharma](https://www.linkedin.com/in/shivarpit-sharma-67541014b/)

## Feedback

Feel free to share the feeback
you can file issue [here](https://github.com/shivarpitsharma/mixpanelModule/issues)
