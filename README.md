# HeadVR

**[HeadVR](https://github.com/traksharp/HeadVR)** is an open source VR video player
for android based on VLC.

Features:
- Support touch control, bluetooth controller and head control
- Controlled by head motion, e.g., nod to play/pause. (Gyroscope sensor is
necessary)
- Support playlist, viewing all the video's without taking off headset.
- Support most multimedia files with underlying libvlc.
- Local and network resources.
- Rich settings to make video comfortable to eyes.
- Force2D mode for stressful 3D video's.
- Support audio and subtitle selection.

## Build

Requires openjdk 11 for gradle.

```shell
brew install openjdk@11
```

Clone the [VLC fork](https://github.com/traksharp/vlc-android) using:

```shell
git clone --recurse-submodules git@github.com:traksharp/vlc-android.git
```

Download `gvr-android-sdk` as [per instructions](./gvr-android-sdk/README.md) (TODO automate this).
