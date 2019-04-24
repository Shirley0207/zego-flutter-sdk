# zegoliveroom_plugin

即构科技（Zego）音视频Flutter SDK，提供视频直播以及实施音视频服务。

了解更多解决方案：[https://www.zego.im](https://www.zego.im)

## 一、下载 Flutter SDK

参考：[Flutter SDK 下载](https://flutter.dev/docs/get-started/install)

## 二、配置开发环境

1. Android Studio：`Preferences`->`Plugins`，搜索`Flutter`插件进行下载，在插件中配置第一步下载好的Flutter SDK路径

2. Visual Code: 在应用商店中搜索`Flutter`扩展并下载

以上任一开发环境配置好flutter环境之后，命令行执行`flutter doctor`，根据提示内容补全相关未下载的依赖项。

## 三、申请Zego App ID

登录[官网](https://www.zego.im)注册账号，根据自身实际业务需求选择场景，获取AppID与App Sign，用于初始化SDK。

## 四、导入 zegoliveroom_plugin

打开待导入工程中的`pubspec.yaml`，添加`zegoliveroom_plugin`依赖（以git依赖形式）：

```
dependencies:
  flutter:
	sdk: flutter

  zegoliveroom_plugin:
    git:
      url: git://github.com/zegoim/zego-flutter-sdk.git
```

## 五、初始化 SDK

```Dart
import 'package:flutter/material.dart';
import 'package:zegoliveroom_plugin/zego_liveroom.dart';

void main() => runApp(new MyApp());

class MyApp extends StatefulWidget {
@override
_MyAppState createState() => new _MyAppState();
}

class _MyAppState extends State<MyApp> {

// 填入实际从即构官网获取到的AppID
final int appID = 00000000;
// 填入实际从即构官网获取到的AppSign
final String appSign = '0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,'
'0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,'
'0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00,'
'0x00,0x00,0x00,0x00,0x00,0x00,0x00,0x00';

String version = '';

@override
void initState() {
super.initState();

// 获取SDK版本号
ZegoLiveRoomPlugin.getSdkVersion().then((ver) {

setState({
version = ver;
});

});

// 初始化SDK
ZegoLiveRoomPlugin.initSDK(appID, appSign);
}

@override
Widget build(BuildContext context) {
return new MaterialApp(
home: new Scaffold(
appBar: new AppBar(
title: const Text('Zego Plugin example app'),
),
body: new Center(
child: new Text('Version: $version'),
),
),
);
}
}
```

更多功能请参考API用法。

## 六、常见问题

#### 1. 解决 iOS 平台下 `ZegoLiveRoomApi-AudioIO`、`audio_in_output` 模块编译错误问题：

打开 iOS 工程文件 `Runner. xcworkspace ` -> `Build Settings`，将 `Compile Sources As` 改为 `Objective-C++`，重新编译

