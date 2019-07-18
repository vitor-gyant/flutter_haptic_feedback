import 'package:flutter/services.dart';
import 'package:flutter_test/flutter_test.dart';
import 'package:flutter_haptic_feedback/flutter_haptic_feedback.dart';

void main() {
  const MethodChannel channel = MethodChannel('flutter_haptic_feedback');

  setUp(() {
    channel.setMockMethodCallHandler((MethodCall methodCall) async {
      return '42';
    });
  });

  tearDown(() {
    channel.setMockMethodCallHandler(null);
  });

  test('getPlatformVersion', () async {
    expect(await FlutterHapticFeedback.platformVersion, '42');
  });
}
