# ANIMATRIX

## Overview
ANIMATRIX is an all-in-one Android animation studio that combines features from FlipaClip and Stick Nodes Pro. Create stick figure animations, frame-by-frame animations, edit videos, and save characters with an integrated database system.

## Features

### Animation Features
- **Frame-by-frame animation** - Create animations frame by frame like FlipaClip
- **Stick figure animation** - Draw and animate stick figures like Stick Nodes Pro
- **Timeline-based editor** - Control animation frames with seek bar
- **Onion skinning** - View previous/next frames for reference
- **Layer support** - Multiple layers for complex animations

### Video Editing
- **Export to MP4/GIF** - Export animations as video files
- **Frame-by-frame navigation** - Seek through individual frames
- **Play/pause control** - Control animation playback
- **Real-time preview** - See changes instantly

### Character Management
- **Save characters** - Persist your created characters using Room database
- **Character library** - Browse and manage saved characters
- **Image data storage** - Store character images and animation data
- **UUID-based identification** - Unique IDs for each character

### AI Integration
- **TensorFlow Lite** - Tiny AI model support for frame generation
- **Assisted animation** - AI-powered frame suggestions and generation
- **Model lightweight** - Optimized for mobile devices

## Technical Details

### Built With
- **AndroidX** - Modern Android development tools
- **Room Database** - SQLite ORM for character persistence
- **H2 Database** - Embedded database backend
- **Lottie** - Animation rendering library
- **TensorFlow Lite** - Tiny AI model support
- **Material Design** - UI components and theming

### Minimum Requirements
- **minSdk**: 21 (Android 5.0 Lollipop)
- **targetSdk**: 33 (Android 13)
- **Compile SDK**: 33

### Open Source Libraries
All libraries used are free and open source:
- Lottie (MIT License)
- TensorFlow Lite (Apache 2.0)
- Room + H2 (Apache 2.0)
- Material Components (Apache 2.0)

## Installation

### From Source
```bash
# Clone the repository
git clone https://github.com/agastyatomar/ANIMATRIX.git

# Open in Android Studio
cd ANIMATRIX

# Build the debug APK
./gradlew assembleDebug

# Find the APK
app/build/outputs/debug/app-debug.apk
```

### Pre-built APK
Download the latest release APK from the GitHub repository.

## Usage

### Main Screen
1. Tap **"Create Animation"** to start a new animation
2. Tap **"Save Character"** to save your character to the database
3. Tap **"Video Editor"** to open the video editing suite

### Video Editor
- Use the **seek bar** to navigate frames
- Tap **"Play"** to preview your animation
- Tap **"Export"** to save as MP4/GIF

### Character Saving
- Characters are automatically saved to the local Room database
- View and manage characters from the save/load menu
- Characters include animation data and image information

## Development

### Project Structure
```
ANIMATRIX/
├── app/
│   ├── src/main/java/com/anematrix/    # Kotlin source files
│   ├── src/main/res/                     # Resources and layouts
│   ├── build.gradle                      # App-level dependencies
│   └── ...
├── build.gradle                          # Project-level build config
├── settings.gradle                       # Project settings
└── gradle/                               # Gradle wrapper
```

### Adding New Features
1. Add new Java/Kotlin files to `app/src/main/java/com/anematrix/`
2. Create corresponding layouts in `app/src/main/res/layout/`
3. Add dependencies to `app/build.gradle` if needed
4. Run `./gradlew assembleDebug` to build

## Contributing
1. Fork the repository
2. Create a feature branch (`git checkout -b feature/AmazingFeature`)
3. Commit your changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

## License
This project is licensed under the Apache License 2.0 - see the LICENSE file for details.

## Contact
- GitHub: @agastyatomar
- Repository: https://github.com/agastyatomar/ANIMATRIX