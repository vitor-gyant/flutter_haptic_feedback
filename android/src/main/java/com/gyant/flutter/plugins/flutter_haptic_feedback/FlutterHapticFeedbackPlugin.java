package com.gyant.flutter.plugins.flutter_haptic_feedback;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
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

  private FlutterHapticFeedbackPlugin(Registrar registrar){
    this._vibrator = (Vibrator)registrar.context().getSystemService(Context.VIBRATOR_SERVICE);
  }

  private Vibrator _vibrator;
  static Activity activity;

  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_haptic_feedback");
    activity = registrar.activity();
    channel.setMethodCallHandler(new FlutterHapticFeedbackPlugin(registrar));
  }

  @Override
  public void onMethodCall(MethodCall call, Result result) {

    View rootView = activity.getWindow().getDecorView().getRootView();

    if (call.method.equals("vibrate")) {
      if(_vibrator.hasVibrator()){
        int duration = call.argument("duration");
        _vibrator.vibrate(duration);
      }
      result.success(null);
    }
    else if(call.method.equals("canVibrate")){
      result.success(_vibrator.hasVibrator());
    } //Feedback
    else if(call.method.equals("impact")){
      if(_vibrator.hasVibrator()){
        _vibrator.vibrate(HapticFeedbackConstants.VIRTUAL_KEY);
      }
      result.success(null);
    }
    else if(call.method.equals("success")){
      if(_vibrator.hasVibrator()){
        rootView.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
      }
      result.success(null);
    }
    else if(call.method.equals("warning")){
      if(_vibrator.hasVibrator()){
        rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      }
      result.success(null);
    }
    else if(call.method.equals("error")){
      if(_vibrator.hasVibrator()){
          int duration = 500;
          _vibrator.vibrate(duration);
      }
      result.success(null);
    }
    else if(call.method.equals("heavy")){
      if(_vibrator.hasVibrator()){
        rootView.performHapticFeedback(HapticFeedbackConstants.FLAG_IGNORE_VIEW_SETTING);
      }
      result.success(null);
    }
    else if(call.method.equals("medium")){
      if(_vibrator.hasVibrator()){
          int duration = 40;
          _vibrator.vibrate(duration);
      }
      result.success(null);
    }
    else if(call.method.equals("light")){
      if(_vibrator.hasVibrator()){
          int duration = 10;
          _vibrator.vibrate(duration);
      }
      result.success(null);
    }
    else {
      result.notImplemented();
    }
  }
}
