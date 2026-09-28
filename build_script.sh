#!/bin/bash
# ANIMATRIX Build Verification Script
# This script verifies the project structure and attempts to build if Android SDK is available

set -e

PROJECT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"

echo "========================================="
echo "ANIMATRIX Build Verification Script"
echo "========================================="
echo ""

# Check project directory exists
if [ ! -d "$PROJECT_DIR" ]; then
    echo "ERROR: Project directory not found at $PROJECT_DIR"
    exit 1
fi

echo "[✓] Project directory found: $PROJECT_DIR"
echo ""

# Check essential files
ESSENTIAL_FILES=(
    "settings.gradle"
    "build.gradle"
    "gradle/wrapper/gradle-wrapper.properties"
    "app/build.gradle"
    "app/src/main/AndroidManifest.xml"
    "app/src/main/java/com/anematrix/MainActivity.kt"
    "app/src/main/res/layout/activity_main.xml"
    "app/src/main/res/values/strings.xml"
    "app/src/main/res/values/styles.xml"
    "app/src/main/res/raw/placeholder_animation"
)

echo "[Checking essential files:]"
ALL_EXIST=true
for file in "${ESSENTIAL_FILES[@]}"; do
    if [ -f "$PROJECT_DIR/$file" ]; then
        echo "  [✓] $file"
    else
        echo "  [✗] $file - MISSING"
        ALL_EXIST=false
    fi
done

if [ "$ALL_EXIST" = false ]; then
    echo ""
    echo "ERROR: Some essential files are missing!"
    exit 1
fi

echo ""

# Check Gradle wrapper
echo "[Checking Gradle wrapper:]"
if [ -f "$PROJECT_DIR/gradlew" ] || [ -f "$PROJECT_DIR/gradlew.bat" ]; then
    echo "  [✓] Gradle wrapper script found"
else
    echo "  [✗] Gradle wrapper script not found"
    echo "      Will use Gradle wrapper from properties"
fi

echo ""

# Check build tools availability
echo "[Checking build environment:]"
JAVA_VERSION=$(java -version 2>&1 | head -1 | awk '{print $3}')
echo "  [✓] Java version: $JAVA_VERSION"

# Try to detect Android SDK
ANDROID_SDK="/opt/android-sdk"
if [ -d "$ANDROID_SDK" ]; then
    echo "  [✓] Android SDK found at $ANDROID_SDK"
    ANDROID_HOME="$ANDROID_SDK"
elif [ -n "$ANDROID_HOME" ]; then
    echo "  [✓] ANDROID_HOME set to $ANDROID_HOME"
else
    echo "  [⚠] Android SDK not found - APK cannot be built without Android Studio"
    echo "      Download from: https://developer.android.com/studio"
    echo "      OR install via: termux-setup-storage && pkg install android-sdk"
fi

echo ""

# Verify Gradle wrapper properties
if [ -f "$PROJECT_DIR/gradle/wrapper/gradle-wrapper.properties" ]; then
    echo "[Gradle Wrapper Properties:]"
    grep -E "distributionUrl|zipStore" "$PROJECT_DIR/gradle/wrapper/gradle-wrapper.properties" | while read -r line; do
        echo "  $line"
    done
fi

echo ""
echo "========================================="
if [ -n "$ANDROID_HOME" ] && [ -d "$ANDROID_HOME" ]; then
    echo "Build environment looks complete!"
    echo "Run: cd $PROJECT_DIR && ./gradlew assembleDebug"
else
    echo "Project structure is valid."
    echo "To build the APK:"
    echo "1. Install Android Studio: https://developer.android.com/studio"
    echo "2. Or install Android SDK: termux-setup-storage && pkg install android-sdk"
    echo "3. Run: cd $PROJECT_DIR && ./gradlew assembleDebug"
    echo "4. APK will be at: app/build/outputs/debug/app-debug.apk"
fi
echo "========================================="