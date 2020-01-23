package com.gyant.flutter.plugins.flutter_haptic_feedback;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.HapticFeedbackConstants;
import android.view.View;

import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;


/**
 * FlutterHapticFeedbackPlugin
 */
public class FlutterHapticFeedbackPlugin implements MethodChannel.MethodCallHandler, FlutterPlugin, ActivityAware {
  private Activity activity;
  private MethodChannel methodChannel;

  @Override
  public void onAttachedToEngine(FlutterPluginBinding flutterPluginBinding) {
    tearUpChannel(flutterPluginBinding.getBinaryMessenger());
  }

  @Override
  public void onDetachedFromEngine(FlutterPluginBinding flutterPluginBinding) {
    tearDownChannel();
  }

  @Override
  public void onAttachedToActivity(ActivityPluginBinding activityPluginBinding) {
    this.activity = activityPluginBinding.getActivity();
  }

  @Override
  public void onDetachedFromActivityForConfigChanges() {
    this.activity = null;
  }

  @Override
  public void onReattachedToActivityForConfigChanges(ActivityPluginBinding activityPluginBinding) {
    this.activity = activityPluginBinding.getActivity();
  }

  @Override
  public void onDetachedFromActivity() {
    this.activity = null;
  }

  @SuppressLint("NewApi")
  @Override
  public void onMethodCall(MethodCall call, MethodChannel.Result result) {

    // Ignore any invocation if not attached to an activity.
    if (activity == null) {
      return;
    }

    View rootView = activity.getWindow().getDecorView().getRootView();

    switch (call.method) {
    case "vibrate":
      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
      break;

    case "canVibrate":
      result.success(true);
      break;

    case "selection":
    case "light":
      rootView.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_TAP);
      result.success(null);
      break;

    case "success":
    case "medium":
      rootView.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
      result.success(null);
    break;

    case "impact":
    case "warning":
    case "error":
      // The HapticFeedbackConstants is the same of impact but is handled a different
      // way on dart
      rootView.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
      result.success(null);
      break;
    case "heavy":

      rootView.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
      result.success(null);
      break;

    default:
      result.notImplemented();
      break;
    }
  }

  private void tearUpChannel(BinaryMessenger messenger) {
    methodChannel = new MethodChannel(messenger, "flutter_haptic_feedback");
    methodChannel.setMethodCallHandler(this);
  }

  private void tearDownChannel() {
    methodChannel.setMethodCallHandler(null);
    methodChannel = null;
  }

}
