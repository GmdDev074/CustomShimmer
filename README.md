# CustomShimmer Library ✨

[![](https://jitpack.io/v/GmdDev074/CustomShimmer.svg)](https://jitpack.io/#GmdDev074/CustomShimmer)

![GitHub stars](https://img.shields.io/github/stars/GmdDev074/CustomShimmer?style=social)
![GitHub forks](https://img.shields.io/github/forks/GmdDev074/CustomShimmer?style=social)
![GitHub watchers](https://img.shields.io/github/watchers/GmdDev074/CustomShimmer?style=social)

![License](https://img.shields.io/github/license/GmdDev074/CustomShimmer)
![GitHub release](https://img.shields.io/github/v/release/GmdDev074/CustomShimmer)
![Release Date](https://img.shields.io/github/release-date/GmdDev074/CustomShimmer)
![Issues](https://img.shields.io/github/issues/GmdDev074/CustomShimmer)
![Pull Requests](https://img.shields.io/github/issues-pr/GmdDev074/CustomShimmer)
![Top Language](https://img.shields.io/github/languages/top/GmdDev074/CustomShimmer)
![Contributors](https://img.shields.io/github/contributors/GmdDev074/CustomShimmer)

![Last Commit](https://img.shields.io/github/last-commit/GmdDev074/CustomShimmer)
![GitHub all releases](https://img.shields.io/github/downloads/GmdDev074/CustomShimmer/total)
![Commit Activity](https://img.shields.io/github/commit-activity/m/GmdDev074/CustomShimmer)
![Maintenance](https://img.shields.io/maintenance/yes/2025)
[![codecov](https://codecov.io/gh/GmdDev074/CustomShimmer/branch/main/graph/badge.svg)](https://codecov.io/gh/GmdDev074/CustomShimmer)
![Dependabot Status](https://img.shields.io/badge/dependabot-enabled-brightgreen?logo=dependabot)
![GitHub Discussions](https://img.shields.io/github/discussions/GmdDev074/CustomShimmer)
![GitHub Wiki](https://img.shields.io/badge/wiki-available-brightgreen)

![Min SDK](https://img.shields.io/badge/minSdk-21%2B-blue)
![API](https://img.shields.io/badge/API-21%2B-green.svg?style=flat)
![Lint](https://img.shields.io/badge/lint-passing-brightgreen)
![Open Source Love](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)
[![Sponsor](https://img.shields.io/badge/sponsor-%E2%9D%A4-red)](https://github.com/sponsors/GmdDev074)

---

## Contributors

[![Contributors](https://contrib.rocks/image?repo=GmdDev074/CustomShimmer)](https://github.com/GmdDev074/CustomShimmer/graphs/contributors)

---

## Repo Stats

[![Repo Stats](https://github-readme-stats.vercel.app/api/pin/?username=GmdDev074&repo=CustomShimmer)](https://github.com/GmdDev074/CustomShimmer)  
[![Activity Graph](https://github-readme-activity-graph.vercel.app/graph?username=GmdDev074&repo=CustomShimmer)](https://github.com/GmdDev074/CustomShimmer)

---

## Overview

**CustomShimmer** is a lightweight Android library for creating **custom loading animations** without external dependencies.  
It supports multiple loading styles such as:  

- 🔵 **Animated dots shimmer** (horizontal / bouncing dots).  
- 🔄 **Circular progress shimmer**.  
- 📄 **View overlays** (replace any `TextView`, `ImageView`, or custom view with shimmer while loading).  

This helps improve **user experience** by showing elegant loading placeholders while data or images are fetched.

---

## Features

- 🚀 No third-party dependencies – built purely in **Kotlin + Android Views**.  
- 🔵 Horizontal dot animation (like chat typing indicator).  
- 🔄 Smooth circular shimmer loading.  
- 🎨 Customizable size, color, speed.  
- 🖼 Works with `TextView`, `ImageView`, or any `View`.  
- 📦 Easy to integrate in existing layouts.  

---

## Use Cases

- Show **loading states** for `TextView`, `ImageView`, or lists.  
- Replace placeholders with **animated shimmer effects**.  
- Typing indicators, chat UIs, or **skeleton loading screens**.  

---

## Screenshots

| Horizontal Dots (GIF) | Circular Shimmer (Screenshot) |
|------------------------|-------------------------------|
| ![Dots Loading](https://github.com/user-attachments/assets/cac527cf-0ec7-443f-9d53-2c8134b700a5) | <img width="300" alt="Screenshot_20250902_175404" src="https://github.com/user-attachments/assets/b9020fa0-6072-4f52-b5d7-4cafd4a84bfd" /> |

---

## Installation

### Step 1: Add JitPack repository

In your **project-level** `build.gradle`:

```gradle
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}

dependencies {
    implementation("com.github.GmdDev074:CustomShimmer:v1.0.0")
}

val shimmer = CustomShimmer(this)
shimmer.showDots(textView) // replaces textView with shimmer dots


val shimmer = CustomShimmer(this)
shimmer.showCircular(imageView) // replaces imageView with circular shimmer


 CustomShimmer.showHorizontal(textView, imageView, docContainer)
 CustomShimmer.showCircular(textView, imageView, docContainer)
 CustomShimmer.showAngle270(textView, imageView, docContainer)
 CustomShimmer.showDots(textView, imageView, docContainer)

shimmer.hide(textView)

