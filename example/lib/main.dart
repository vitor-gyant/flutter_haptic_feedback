import 'package:flutter/material.dart';
import 'package:flutter_haptic_feedback/flutter_haptic_feedback.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {
  bool _canVibrate = true;
  final Iterable<Duration> pauses = [
    const Duration(milliseconds: 500),
    const Duration(milliseconds: 1000),
    const Duration(milliseconds: 500),
  ];

  @override
  initState() {
    super.initState();
    init();
  }

  init() async {
    bool canVibrate = await FlutterHapticFeedback.canVibrate;
    setState(() {
      _canVibrate = canVibrate;
      _canVibrate
          ? print("This device can vibrate")
          : print("This device cannot vibrate");
    });
  }

  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        appBar: new AppBar(title: new Text('Haptic Feedback Example')),
        body: new Center(
          child: ListView(
              shrinkWrap: true,
              padding: EdgeInsets.all(15.0),
              children: <Widget>[
                new Column(children: <Widget>[
                  new ListTile(
                    title: new Text("Vibrate"),
                    leading: new Icon(Icons.vibration, color: Colors.teal),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.vibrate();
                          },
                  ),
                  new ListTile(
                    title: new Text("Vibrate with Pauses"),
                    leading: new Icon(Icons.vibration, color: Colors.brown),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.vibrateWithPauses(pauses);
                          },
                  ),
                  new Divider(height: 1.0),
                  new ListTile(
                    title: new Text("Impact"),
                    leading: new Icon(Icons.tap_and_play, color: Colors.orange),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(FeedbackType.impact);
                          },
                  ),
                  new ListTile(
                    title: new Text("Selection"),
                    leading: new Icon(Icons.select_all, color: Colors.blue),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(
                                FeedbackType.selection);
                          },
                  ),
                  new ListTile(
                    title: new Text("Success"),
                    leading: new Icon(Icons.check, color: Colors.green),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(
                                FeedbackType.success);
                          },
                  ),
                  new ListTile(
                    title: new Text("Warning"),
                    leading: new Icon(Icons.warning, color: Colors.red),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(
                                FeedbackType.warning);
                          },
                  ),
                  new ListTile(
                    title: new Text("Error"),
                    leading: new Icon(Icons.error, color: Colors.red),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(FeedbackType.error);
                          },
                  ),
                  new Divider(height: 1.0),
                  new ListTile(
                    title: new Text("Heavy"),
                    leading: new Icon(Icons.notification_important,
                        color: Colors.red),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(FeedbackType.heavy);
                          },
                  ),
                  new ListTile(
                    title: new Text("Medium"),
                    leading: new Icon(Icons.notification_important,
                        color: Colors.green),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(FeedbackType.medium);
                          },
                  ),
                  new ListTile(
                    title: new Text("Light"),
                    leading: new Icon(Icons.notification_important,
                        color: Colors.yellow[700]),
                    onTap: !_canVibrate
                        ? null
                        : () {
                            FlutterHapticFeedback.feedback(FeedbackType.light);
                          },
                  ),
                ])
              ]),
        ),
      ),
    );
  }
}
