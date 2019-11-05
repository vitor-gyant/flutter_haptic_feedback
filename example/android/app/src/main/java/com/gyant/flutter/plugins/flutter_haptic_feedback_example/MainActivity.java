package com.gyant.flutter.plugins.flutter_haptic_feedback_example;

import com.gyant.flutter.plugins.flutter_haptic_feedback;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;

public class MainActivity extends FlutterActivity {
    // TODO(vitor-gyant): Remove this once v2 of GeneratedPluginRegistrant rolls to stable. https://github.com/flutter/flutter/issues/42694
    @Override
    public void configureFlutterEngine(FlutterEngine flutterEngine) {
        flutterEngine.getPlugins().add(new FlutterHapticFeedbackPlugin());
    }
}