# Assignment 2 - s8082665

## Overview

This is an Android application built using Jetpack Compose, Retrofit, and Dagger Hilt. The app features a login screen, a dashboard, and detailed views.

Features

- **Jetpack Compose** for building UI
- **View Binding** for efficient view management
- **Navigation Components** for fragment transitions
- **Retrofit** for network requests
- **Dagger Hilt** for dependency injection
- **Kotlin Coroutines** for asynchronous operations
- **Material Design** for consistent UI
- **Unit and UI Testing** with JUnit and MockK

## Architecture

The app follows the MVVM architecture to ensure a clean separation of concerns and facilitate testing.

## Installation

1. Clone the repository: git clone https://github.com/DuckMillet0445/assignment_25_complete
2. Open the project in Android Studio.
3. Sync the project with Gradle files.

## Running the App
1. Connect an Android device or use an emulator.
2. Click the 'Run' button in Android Studio.

## Architecture
This app follows the MVVM (Model-View-ViewModel) architecture pattern and uses the following components:
- Model: Represents the data and business logic
- View: XML layouts and Fragment classes
- ViewModel: Manages UI-related data and business logic

## API
This app uses https://nit3213-api-h2b3-latest.onrender.com/ for the display data.

## Testing

Currently, the project includes basic unit tests for core functionality. These can be run using the standard Android Studio test runner.

### Unit Tests

Unit tests are located in the `src/test/java` directory. These tests cover the core logic of the application, including ViewModels, Repositories, and utility classes.

To run unit tests:

1. In Android Studio, right-click on the `src/test/java` folder
2. Select "Run Tests in 'app'"

Future testing plans include:
- Expanding unit test coverage to all ViewModels and Repositories
- Adding instrumented tests for UI interactions
- Implementing integration tests for API communication
- Setting up continuous integration for automated testing on each pull request

## Future Improvements
- Implement offline caching
- Adding a navigation bar
- Sorting options
- More error handling
- Cleaner UI

## Contact
Jared Alonto - s8082665@live.vu.edu.au

Project Link: https://github.com/DuckMillet0445/s8082665_assignment_2
