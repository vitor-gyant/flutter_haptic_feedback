#import "FlutterHapticFeedbackPlugin.h"

#import <UIKit/UIKit.h>
#import <AudioToolbox/AudioToolbox.h>

#if defined(TARGET_OS_SIMULATOR)
static const BOOL isDevice = NO;
#else
static const BOOL isDevice = YES;
#endif

@implementation FlutterHapticFeedbackPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    FlutterMethodChannel* channel = [FlutterMethodChannel
                                     methodChannelWithName:@"flutter_haptic_feedback"
                                     binaryMessenger:[registrar messenger]];
    FlutterHapticFeedbackPlugin* instance = [[FlutterHapticFeedbackPlugin alloc] init];
    [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {

    
    if ([@"canVibrate" isEqualToString:call.method]) {
        if (isDevice) {
            result(@(YES));
        } else {
            result(@(NO));
        }
    } else if ([@"vibrate" isEqualToString:call.method]) {
        AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
    } else if ([@"impact" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UIImpactFeedbackGenerator *generator = [UIImpactFeedbackGenerator new];
            [generator prepare];
            [generator impactOccurred];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"selection" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UISelectionFeedbackGenerator *generator = [UISelectionFeedbackGenerator new];
            [generator prepare];
            [generator selectionChanged];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"success" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UINotificationFeedbackGenerator *generator = [UINotificationFeedbackGenerator new];
            [generator prepare];
            [generator notificationOccurred:UINotificationFeedbackTypeSuccess];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"warning" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UINotificationFeedbackGenerator *generator = [UINotificationFeedbackGenerator new];
            [generator prepare];
            [generator notificationOccurred:UINotificationFeedbackTypeWarning];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"error" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UINotificationFeedbackGenerator *generator = [UINotificationFeedbackGenerator new];
            [generator prepare];
            [generator notificationOccurred:UINotificationFeedbackTypeError];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"heavy" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UIImpactFeedbackGenerator *generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleHeavy];
            [generator prepare];
            [generator impactOccurred];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"medium" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UIImpactFeedbackGenerator *generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleMedium];
            [generator prepare];
            [generator impactOccurred];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else if ([@"light" isEqualToString:call.method]) {
        if (@available(iOS 10.0, *)) {
            UIImpactFeedbackGenerator *generator = [[UIImpactFeedbackGenerator alloc] initWithStyle:UIImpactFeedbackStyleLight];
            [generator prepare];
            [generator impactOccurred];
        } else {
            // Fallback on earlier versions
            AudioServicesPlaySystemSound(kSystemSoundID_Vibrate);
        }
    } else {
        result(FlutterMethodNotImplemented);
    }
}

@end
