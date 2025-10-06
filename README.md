# opencv_canny_edge_detection

OpenCV Canny Edge Detection on Android with Camera2 and OpenGL ES 2.0
A sample Android application demonstrating real-time Canny edge detection using OpenCV, Camera2 API, and OpenGL ES 2.0.

## 📸 Overview
This Android application captures live camera frames using the Camera2 API, processes them with OpenCV to perform Canny edge detection, and renders the processed frames using OpenGL ES 2.0. The app also provides an option to display the processed frames in an `ImageView`.        

## ✅ Features

- Live camera preview using Camera2 API
- Real-time Canny edge detection (OpenCV via JNI)
- Processed frames rendered with OpenGL ES 2.0

## 🧑🏼‍💻 Working App

<img src="./Demo.gif" alt="demo video" width="400" height="400"/>
![demo video](./Demo.gif)

## ⚙ Setup Instructions

1. **Install Android Studio & NDK**
    - Enable NDK in SDK Manager
2. **OpenCV Dependency**
    - Download [OpenCV Android SDK](https://opencv.org/releases/)
    - Set `OpenCV_DIR` in `app/src/main/cpp/CMakeLists.txt` to your OpenCV SDK path
3. **Build & Run**
    - Open project in Android Studio
    - Connect device/emulator
    - Build and run

## 🧠 Architecture Overview

- Camera2 API streams frames to a `TextureView`
- Each frame is converted to a `Bitmap`
- JNI bridges to C++: `edgeDetection(bitmap, dstBitmap)`
    - C++ uses OpenCV for Canny edge detection
    - Results copied back to `Bitmap`
- Processed frame rendered as OpenGL texture in `GLSurfaceView`
