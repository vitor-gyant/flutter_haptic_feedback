package com.gyant.flutter.plugins.flutter_haptic_feedback;

import android.app.Activity;
import android.view.HapticFeedbackConstants;
import android.view.View;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterHapticFeedbackPlugin
 */
public class FlutterHapticFeedbackPlugin implements MethodCallHandler {

  static Activity activity;

  private FlutterHapticFeedbackPlugin(Registrar registrar){

  }

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_haptic_feedback");
    activity = registrar.activity();
    channel.setMethodCallHandler(new FlutterHapticFeedbackPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {

    View rootView = activity.getWindow().getDecorView().getRootView();

    if (call.method.equals("vibrate")) {
      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
    }
    else if(call.method.equals("canVibrate")){
      result.success(true);
    } //Feedback
    else if(call.method.equals("impact")){

      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
    }
    else if(call.method.equals("selection")){

      rootView.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
      result.success(null);
    }
    else if(call.method.equals("success")){

      rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
      result.success(null);
    }
    else if(call.method.equals("warning")){

      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
    }
    else if(call.method.equals("error")){
      //The HapticFeedbackConstants is the same of impact but is handled a different way on dart
      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
    }
    else if(call.method.equals("heavy")){

      rootView.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
      result.success(null);
    }
    else if(call.method.equals("medium")){

      rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
      result.success(null);
    }
    else if(call.method.equals("light")){

      rootView.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
      result.success(null);
    }
    else {
      result.notImplemented();
    }
  }
}
