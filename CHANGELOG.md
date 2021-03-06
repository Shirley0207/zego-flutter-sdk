# Change log

## 1.2.5

1. update ios/android native sdk to version `200309_200607_release-new-0-g54f488a0c_video_mediaplayer_bn3549_12`

2. fix bug of external filter module on Android

## 1.2.4

- add external video filter interface and corresponding sample code.

## 1.2.3

- add `setSharpenFactor` to set the sharpening factor for beauty.

## 1.2.2

- add `sendRoomMessage`, `onRecvRoomMessage` to send and receive room messages.

## 1.2.1

- update android native sdk.

## 1.2.0

1. add `seekTo` `getTotalDuration` `getCurrentDuration` in AudioPlayer
2. add `enableLoopback` `setLoopbackVolume` to listen captured voice

## 1.1.9

- update iOS/Android native sdk (2020.2.9 hotfix)

## 1.1.8

- update iOS/Android native sdk (2020.2.9)

## 1.1.7

- fix bug of init page in example.

## 1.1.6

1. this new version is compatible with AndroidX.
2. fix the Android example crash in release mode because of the obfuscation.

## 1.1.5

- fix iOS: use platform view render failed.

## 1.1.4

- fix AudioPlayer bug.

## 1.1.3

- add Audio Precessing API: `VirtualStereo`, `Reverb`, `VoiceChanger`

## 1.1.2

1. fix iOS callback doesn’t work when call `initSDK` failed
2. iOS native framework uses cocoapods dependency instead

## 1.1.1

1. Add audio player module
2. Update texture's API comment

## 1.0.12

- update iOS/Android native sdk (12.9)

## 1.0.11

1. add onInnerError
2. update iOS/Android native sdk

## 1.0.10

1. add relay CDN methods: `setPublishConfig`, `addPublishTarget`, `deletePublishTarget`, and callback: `onRelayCDNStateUpdate`
2. fix bug that xcode11 can't run in debug mode
3. update iOS/Android native sdk

## 1.0.9

- fix the problem that Android can't receive media sideinfo callback

## 1.0.8

1. add setVideoMirrorMode API
2. update iOS/Android native sdk

## 1.0.7

1. fix android texture render crash into background
2. fix android startPlayingStream bugs
3. update android native sdk

## 1.0.6

1. fix some bug and crash
2. add log system

## 1.0.5

1. add peer to peer delay/package lost rate.
2. add remote user's device state notification(on/off)
3. add remote user's first frame notification
4. update native sdk
5. promote stability

## 1.0.4

1. add sound-level module
2. add error-code module
3. update native sdk

## 1.0.3

- add Platform View API

## 1.0.2

1. update native sdk
2. fix crash
3. refactor api structure

## 1.0.1

- add format interface

## 1.0.0

- initial release
