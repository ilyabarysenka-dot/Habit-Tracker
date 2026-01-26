## Habit Tracker — Android Project

This repository contains a Android project created to explore modern Android development in depth.
The project focuses on architecture, modularization, and real-world features, rather than being a minimal demo.

The application will be a habit tracker that demonstrates how to build a scalable Android app using:

Jetpack Compose
Multi-module architecture
Dependency Injection
Offline-first data handling
Modern navigation patterns

🎯 Project goals

Practice building a real application from scratch
Explore multi-module project structure
Learn how features interact through clean boundaries
Experiment with modern Android APIs and libraries
Serve as a reference project for future Android development

## Modulization

[📄 Architecture PNG](docs/modulization.png)

🧱 Core modules
:core:common

This module contains shared, platform-independent utilities used throughout the project.
It acts as a foundation for the rest of the codebase and avoids any Android-specific APIs.

Typical content:
Result and error wrappers
Logging abstractions
String providers
Common exceptions
Coroutine helpers and utilities
Because this module is pure Kotlin, it can be reused across different layers without introducing Android dependencies.

:core:ui
This module represents the design system of the application.
It centralizes all UI-related building blocks so that features remain visually consistent and easy to maintain.

Typical content:
Application theme
Color palettes and typography
Reusable Compose UI components
Common UI states and helpers
Feature modules consume this module to build screens without duplicating UI logic.

:core:navigation
This module contains navigation infrastructure shared across the app.

It provides:
Navigation 3 setup
Type-safe route definitions
Shared navigation helpers and abstractions
Actual navigation destinations (screens) are implemented inside feature modules, while this module focuses on providing the tools needed to connect them.

:core:notification
This module encapsulates notification-related logic.

Typical content:
Notification channel definitions
Notification builders
Scheduling helpers for reminders
Abstractions for local and push notifications
By isolating this logic, features can trigger notifications without dealing with low-level Android APIs.

📦 Data module
:data
The data module is responsible for providing application data from various sources.

It contains:
Repository implementations
Backendless API integration
Room database setup
Data transfer objects (DTOs)
Mappers between network, database, and domain models
This module focuses on data access and persistence and does not contain UI or presentation logic.

🧩 Feature modules
:feature:*
Each feature module represents a vertical slice of functionality.

Typical content:
ViewModels
Compose screens
Feature-specific domain logic
Navigation entries related to the feature

By keeping features isolated, the project remains scalable and easier to reason about as new functionality is added.

🔌 Wiring module
:wiring
The wiring module acts as the composition layer of the application.

It is responsible for:
Providing Dependency Injection bindings
Connecting interfaces with their concrete implementations
Linking data layer implementations to feature modules
This module contains no UI and no business logic — its only purpose is wiring.

📱 App module
:app
The app module is the entry point of the application.

It contains:
Application and activity setup
App-level navigation composition
Startup and initialization logic
Most high-level configuration happens here, while actual functionality lives in other modules.